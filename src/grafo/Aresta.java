package grafo;

public class Aresta {
	
	private Vertice verticeOrigem;
	private Vertice verticeDestino;
	private int peso;	
	
	public Aresta(Vertice verticeOrigem, Vertice verticeDestino, int peso) {
		this.verticeOrigem = verticeOrigem;
		this.verticeDestino = verticeDestino;
		this.peso = peso;
	}

	public Vertice getVerticeOrigem() {
		return verticeOrigem;
	}
	
	public void setVerticeOrigem(Vertice verticeOrigem) {
		this.verticeOrigem = verticeOrigem;
	}
	
	public Vertice getVerticeDestino() {
		return verticeDestino;
	}
	
	public void setVerticeDestino(Vertice verticeDestino) {
		this.verticeDestino = verticeDestino;
	}
	
	public int getPeso() {
		return peso;
	}
	
	public void setPeso(int peso) {
		this.peso = peso;
	}
	
	

}
