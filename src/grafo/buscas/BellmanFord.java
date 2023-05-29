package grafos.buscas;

public class BellmanFord {
	
	private static final int INFINITY = Integer.MAX_VALUE;

    public static void bellmanFord(int[][] graph, int startVertex) {
        
    	int numVertices = graph.length;
        int[] distance = new int[numVertices];

        // Inicializa as distâncias com infinito
        for (int i = 0; i < numVertices; i++) {
            distance[i] = INFINITY;
        }

        // A distância do vértice de início para ele mesmo é sempre 0
        distance[startVertex] = 0;

        // Relaxa as arestas repetidamente para encontrar as distâncias mínimas
        for (int i = 0; i < numVertices - 1; i++) {
            for (int u = 0; u < numVertices; u++) {
                for (int v = 0; v < numVertices; v++) {
                    if (graph[u][v] != 0 && distance[u] != INFINITY
                            && distance[u] + graph[u][v] < distance[v]) {
                        distance[v] = distance[u] + graph[u][v];
                    }
                }
            }
        }

        // Verifica se há ciclos negativos
        for (int u = 0; u < numVertices; u++) {
            for (int v = 0; v < numVertices; v++) {
                if (graph[u][v] != 0 && distance[u] != INFINITY
                        && distance[u] + graph[u][v] < distance[v]) {
                    System.out.println("O grafo contém um ciclo negativo!");
                    return;
                }
            }
        }

        // Imprime as distâncias mínimas de todos os vértices
        printSolution(distance);
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

        bellmanFord(graph, 0);
    }

}
