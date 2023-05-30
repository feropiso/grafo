package grafos.buscas;

public class Dijkstra {
	
	private static final int INFINITO = Integer.MAX_VALUE;
	
	public static void dijkstra(int[][] grafo, int verticeInicial) {
		
		int numVertices = grafo.length;
		boolean[] vistado = new boolean[numVertices];
		int[] distancia = new int[numVertices];
		
		// Inicializa as distâncias com infinito e marca todos os vértices como não visitados
		for (int i = 0; i < numVertices; i++) {
			distancia[i] = INFINITO;
		    vistado[i] = false;
		 }
		
		 // A distância do vértice de início para ele mesmo é sempre 0
		 distancia[verticeInicial] = 0;
		
		 // Encontra o caminho mais curto para todos os vértices
		 for (int count = 0; count < numVertices - 1; count++) {
			 int currentVertex = encontraMenorDistancia(distancia, vistado);
			 vistado[currentVertex] = true;
			 
			 // Atualiza as distâncias dos vértices adjacentes ao vértice atual
			 for (int v = 0; v < numVertices; v++) {
				 if (!vistado[v] && grafo[currentVertex][v] != 0 && distancia[currentVertex] != INFINITO
		                    && distancia[currentVertex] + grafo[currentVertex][v] < distancia[v]) {
		                distancia[v] = distancia[currentVertex] + grafo[currentVertex][v];
		         }
		     }
		 }
		 
		 // Imprime as distâncias mínimas de todos os vértices
		 
		 mostraSolucao(distancia);
	}

	private static int encontraMenorDistancia(int[] distancia, boolean[] visitado) {
	    int minDistancia = INFINITO;
	    int minVertex = -1;
	    int numVertices = distancia.length;
	
	    for (int v = 0; v < numVertices; v++) {
	        if (!visitado[v] && distancia[v] <= minDistancia) {
	            minDistancia = distancia[v];
	            minVertex = v;
	        }
	    }
	
	    return minVertex;
	}

	private static void mostraSolucao(int[] distancia) {
	    
		int numVertices = distancia.length;
	    System.out.println("Distância mínima de cada vértice a partir do vértice inicial:");
	
	    for (int i = 0; i < numVertices; i++) {
	        System.out.println(i + ": " + distancia[i]);
	    }
	}

	public static void main(String[] args) {
	    // Exemplo de grafo ponderado representado por uma matriz de adjacência
	    int[][] grafo = {
	        {0, 4, 0, 0, 0, 0, 0, 8, 0},
	        {4, 0, 8, 0, 0, 0, 0, 11, 0},
	        {0, 8, 0, 7, 0, 4, 0, 0, 2},
	        {0, 0, 7, 0, 9, 14, 0, 0, 0},
	        {0, 0, 0, 9, 0, 10, 0, 0, 0},
	        {0, 0, 4, 14, 10, 0, 2, 0, 0},
	        {0, 0, 0, 0, 0, 2, 0, 1, 6},
	        {8, 11, 0, 0, 0, 0, 1, 0, 7},
	        {0, 0, 2, 0, 0, 0, 6, 7, 0}
	    };
	    
	    dijkstra(grafo, 0);
	}
	
}