package grafo;

public class Grafo {

	public static void main(String[] args) {
		
		GrafoRepresentacao rep = new GrafoRepresentacao();
		
		rep.direcao();
		rep.recebeVertices();
		rep.criaArestas();
		rep.mostraListaAdj();
	}

}
