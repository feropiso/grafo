package grafos.buscas;

public class Dijkstra {
	
	private static final int INFINITY = Integer.MAX_VALUE;
	
	public static void dijkstra(int[][] graph, int startVertex) {
		
		int numVertices = graph.length;
		boolean[] visited = new boolean[numVertices];
		int[] distance = new int[numVertices];
		
		// Inicializa as distâncias com infinito e marca todos os vértices como não visitados
		for (int i = 0; i < numVertices; i++) {
			distance[i] = INFINITY;
		    visited[i] = false;
		 }
		
		 // A distância do vértice de início para ele mesmo é sempre 0
		 distance[startVertex] = 0;
		
		 // Encontra o caminho mais curto para todos os vértices
		 for (int count = 0; count < numVertices - 1; count++) {
			 int currentVertex = findMinDistance(distance, visited);
			 visited[currentVertex] = true;
			 
			 // Atualiza as distâncias dos vértices adjacentes ao vértice atual
			 for (int v = 0; v < numVertices; v++) {
				 if (!visited[v] && graph[currentVertex][v] != 0 && distance[currentVertex] != INFINITY
		                    && distance[currentVertex] + graph[currentVertex][v] < distance[v]) {
		                distance[v] = distance[currentVertex] + graph[currentVertex][v];
		         }
		     }
		 }
		 
		 // Imprime as distâncias mínimas de todos os vértices
		 
		 printSolution(distance);
	}

	private static int findMinDistance(int[] distance, boolean[] visited) {
	    int minDistance = INFINITY;
	    int minVertex = -1;
	    int numVertices = distance.length;
	
	    for (int v = 0; v < numVertices; v++) {
	        if (!visited[v] && distance[v] <= minDistance) {
	            minDistance = distance[v];
	            minVertex = v;
	        }
	    }
	
	    return minVertex;
	}

	private static void printSolution(int[] distance) {
	    int numVertices = distance.length;
	    System.out.println("Distância mínima de cada vértice a partir do vértice inicial:");
	
	    for (int i = 0; i < numVertices; i++) {
	        System.out.println(i + ": " + distance[i]);
	    }
	}

	public static void main(String[] args) {
	    // Exemplo de grafo ponderado representado por uma matriz de adjacência
	    int[][] graph = {
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
	    
	    dijkstra(graph, 0);
	}
	
}