package grafo;

import grafos.buscas.BuscaEmLargura;
import grafos.buscas.BuscaEmProfundidade;

public class GrafoApp {

	public static void main(String[] args) {
		
		GrafoRepresentacao rep = new GrafoRepresentacao();
		
		
		rep.mostraListaAdj();
		rep.mostraMatrizAdj();
		
		BuscaEmProfundidade dfs = new BuscaEmProfundidade(rep.getGrafo(), 0);
		BuscaEmLargura  bfs = new BuscaEmLargura(rep.getGrafo(), 0);
	}

}
