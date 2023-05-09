package grafos.buscas;

import grafos.Grafo;
import grafos.Vertice;

public class BuscaEmProfundidade {
	
	private int [] descoberta;
	private int [] fim;
	private String [] cor;
	private int tempo;
	
	public BuscaEmProfundidade(Grafo g, int v) {
		
		tempo = 0;
		descoberta = new int[g.numVertices()];
		fim = new int[g.numVertices()];
		cor = new String [g.numVertices()];
		dfs(g, v);
	}

	private void dfs(Grafo g, int v) {
		
		cor[v] = "CINZA";
		tempo++;
		descoberta[v] = tempo;
		
		for(Vertice w: g.listaAdj(v)) {
			if(cor[w.getRotulo()] == "BRANCO") dfs(g, w.getRotulo());
		}
		
		cor[v] = "PRETO";
		tempo += tempo;
		fim[v] = tempo;
	}
	
	public String marcado(int w) {
		return cor[w];
	}
	

}
