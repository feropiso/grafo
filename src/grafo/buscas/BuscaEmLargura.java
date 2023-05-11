package grafos.buscas;

import java.util.LinkedList;
import java.util.Queue;
import grafos.Grafo;
import grafos.Vertice;


public class BuscaEmLargura {
		
	private String [] cor;
	private int [] antecessor;

	public BuscaEmLargura(Grafo g, int v) {
		
		this.cor = new String[g.numVertices()];
		this.antecessor = new int[g.numVertices()];
		
		for(int i = 0; i < cor.length; i++) {
			antecessor[i] = 0;
			cor[i] = "BRANCO";
		}
		
		bfs(g, v);
	}

	private void bfs(Grafo g, int v) {
		
		Queue<Integer> fila = new LinkedList<Integer>();
		
		cor[v] = "CINZA";
		
		fila.add(v);
		
		while(!fila.isEmpty()) {
			
			//retira do topo da fila
			int ver = fila.poll();
			
			for(Vertice vertice: g.listaAdj(ver)) {
				
				if(cor[vertice.getRotulo()] == "BRANCO" ) {
					cor[vertice.getRotulo()] = "CINZA";
					antecessor[vertice.getRotulo()] = ver;
					fila.add(vertice.getRotulo());
					
				}
			}
			
			cor[ver] = "PRETO";
		}		
	}
	
	public String marcado(int w) {
		return cor[w];
	}
	
	

}
