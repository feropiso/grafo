package grafo;

public class GrafoApp {

	public static void main(String[] args) {
				
		GrafoRepresentacao rep = new GrafoRepresentacao();
		
		rep.direcao();
		rep.recebeVertices();
		rep.criaArestas();
		rep.mostraListaAdj();
		rep.mostraMatrizAdj();
	}

}
