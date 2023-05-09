package grafos;

import java.util.ArrayList;

public class Grafo {
	
	private ArrayList<Vertice> vertices;
	private ArrayList<Aresta> arestas;
	
	public Grafo(ArrayList<Vertice> vertices, ArrayList<Aresta> arestas) {
		
		this.vertices = vertices;
		this.arestas = arestas;
	}

	public ArrayList<Vertice> listaAdj(int vertice){
		
		ArrayList<Vertice> verticeAdj = null;
		
		for(Aresta a: arestas) {
			
			if(a.getVerticeOrigem().getRotulo() == vertice) {
				verticeAdj.add(a.getVerticeDestino());
			}
		}
		
		return verticeAdj;
		
	}
	
	public int numVertices() {
		return vertices.size();
		
	}
	

	
	

}
