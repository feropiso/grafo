package grafos.buscas;

import grafos.Grafo;
import grafos.Vertice;

public class BuscaEmProfundidade {

	private int [] descoberta;
	private int [] finalizacao;
	private String [] cor;
	private int tempo;
	
	public BuscaEmProfundidade(Grafo g, int v) {
		
		tempo = 0;
		descoberta = new int[g.numVertices()];
		finalizacao = new int[g.numVertices()];
		cor = new String [g.numVertices()];
		
		for(int i = 0; i < cor.length; i++) {
			cor[i] = "BRANCO";
		}
		
		dfs(g, v);
		exibeTempos(g);
	}

	private void dfs(Grafo g, int v) {
		
		cor[v] = "CINZA";
		tempo++;
		descoberta[v] = tempo;
		
		for(Vertice w: g.listaAdj(v)) {
			if(cor[w.getRotulo()] == "BRANCO") dfs(g, w.getRotulo());
		}
		
		cor[v] = "PRETO";
		tempo++;
		finalizacao[v] = tempo;
	}
	
	public String marcado(int w) {
		return cor[w];
	}
	
	private void exibeTempos(Grafo g) {
		
		int cont = 0;
		
		System.out.println("");
		
		for(Vertice v: g.getVertices()) {
			System.out.println(v.getRotulo()+" => Descoberta: "+descoberta[cont]+" => Finalizacao: "+finalizacao[cont]);
			cont++;
		}
	}


}
