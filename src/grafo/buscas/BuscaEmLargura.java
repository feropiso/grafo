package grafos.buscas;

import java.util.LinkedList;
import java.util.Queue;
import grafos.Grafo;
import grafos.Vertice;


public class BuscaEmLargura {
	
	private String [] cor;
	private Vertice [] antecessor;
	private int [] distancia;

	public BuscaEmLargura(Grafo g, int v) {
		
		this.cor = new String[g.numVertices()];
		this.antecessor = new Vertice[g.numVertices()];
		this.distancia = new int[g.numVertices()];
		
		for(int i = 0; i < cor.length; i++) {
			distancia[i] = Integer.MAX_VALUE;
			antecessor[i] = null;
			cor[i] = "BRANCO";
		}
		
		bfs(g, v);
		exibeDistancias(g);
	}

	private void bfs(Grafo g, int v) {
		
		Queue<Integer> fila = new LinkedList<Integer>();
		
		cor[v] = "CINZA";
		distancia[v] = 0;
		antecessor[v] = null;
		fila.add(v);
		
		
		while(!fila.isEmpty()) {			
			
			//retira do topo da fila
			int u = fila.poll();
			
			
			for(Vertice vertice: g.listaAdj(u)) {
				
				if(cor[vertice.getRotulo()] == "BRANCO" ) {
					
					cor[vertice.getRotulo()] = "CINZA";
					antecessor[vertice.getRotulo()] = vertice;
					fila.add(vertice.getRotulo());
					distancia[vertice.getRotulo()] = distancia[u] + 1;					
				}
			}
			
			cor[u] = "PRETO";
		}		
	}
	
	public String marcado(int w) {
		return cor[w];
	}
	

	private void exibeDistancias(Grafo g) {
		
		int cont = 0;
		
		System.out.println("");
		
		for(Vertice v: g.getVertices()) {
			System.out.println(v.getRotulo()+" => Distancia: "+distancia[cont]);
			cont++;
		}
	}
	
	
}
