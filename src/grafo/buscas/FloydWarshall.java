package grafos.buscas;

public class FloydWarshall {
	
	private static final int INFINITY = Integer.MAX_VALUE;

    public static void floydWarshall(int[][] graph) {
    	
        int numVertices = graph.length;
        int[][] distance = new int[numVertices][numVertices];

        // Inicializa a matriz de distâncias com os pesos das arestas do grafo
        for (int i = 0; i < numVertices; i++) {
            for (int j = 0; j < numVertices; j++) {
                distance[i][j] = graph[i][j];
            }
        }

        // Executa o algoritmo de Floyd-Warshall
        for (int k = 0; k < numVertices; k++) {
            for (int i = 0; i < numVertices; i++) {
                for (int j = 0; j < numVertices; j++) {
                    if (distance[i][k] != INFINITY && distance[k][j] != INFINITY
                            && distance[i][k] + distance[k][j] < distance[i][j]) {
                        distance[i][j] = distance[i][k] + distance[k][j];
                    }
                }
            }
        }

        // Imprime a matriz de distâncias mínimas
        printSolution(distance);
    }

    private static void printSolution(int[][] distance) {
        int numVertices = distance.length;
        System.out.println("Matriz de distâncias mínimas:");

        for (int i = 0; i < numVertices; i++) {
            for (int j = 0; j < numVertices; j++) {
                if (distance[i][j] == INFINITY) {
                    System.out.print("INF\t");
                } else {
                    System.out.print(distance[i][j] + "\t");
                }
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        // Exemplo de grafo ponderado representado por uma matriz de adjacência
        int[][] graph = {
            {0, 4, INFINITY, INFINITY, INFINITY, INFINITY, INFINITY, 8, INFINITY},
            {4, 0, 8, INFINITY, INFINITY, INFINITY, INFINITY, 11, INFINITY},
            {INFINITY, 8, 0, 7, INFINITY, 4, INFINITY, INFINITY, 2},
            {INFINITY, INFINITY, 7, 0, 9, 14, INFINITY, INFINITY, INFINITY},
            {INFINITY, INFINITY, INFINITY, 9, 0, 10, INFINITY, INFINITY, INFINITY},
            {INFINITY, INFINITY, 4, 14, 10, 0, 2, INFINITY, INFINITY},
            {INFINITY, INFINITY, INFINITY, INFINITY, INFINITY, 2, 0, 1, 6},
            {8, 11, INFINITY, INFINITY, INFINITY, INFINITY, 1, 0, 7},
            {INFINITY, INFINITY, 2, INFINITY, INFINITY, INFINITY, 6, 7, 0}
        };

        floydWarshall(graph);
    }

}
