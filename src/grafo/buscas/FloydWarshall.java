package grafos.buscas;

public class FloydWarshall {
	
	private static final int INFINITO = Integer.MAX_VALUE;

    public static void floydWarshall(int[][] grafo) {
    	
        int numVertices = grafo.length;
        int[][] distancia = new int[numVertices][numVertices];

        // Inicializa a matriz de distâncias com os pesos das arestas do grafo
        for (int i = 0; i < numVertices; i++) {
            for (int j = 0; j < numVertices; j++) {
                distancia[i][j] = grafo[i][j];
            }
        }

        // Executa o algoritmo de Floyd-Warshall
        for (int k = 0; k < numVertices; k++) {
            for (int i = 0; i < numVertices; i++) {
                for (int j = 0; j < numVertices; j++) {
                    if (distancia[i][k] != INFINITO && distancia[k][j] != INFINITO
                            && distancia[i][k] + distancia[k][j] < distancia[i][j]) {
                        distancia[i][j] = distancia[i][k] + distancia[k][j];
                    }
                }
            }
        }

        // Imprime a matriz de distâncias mínimas
        mostraSolucao(distancia);
    }

    private static void mostraSolucao(int[][] distance) {
        
    	int numVertices = distance.length;
        System.out.println("Matriz de distâncias mínimas:");

        for (int i = 0; i < numVertices; i++) {
            for (int j = 0; j < numVertices; j++) {
                if (distance[i][j] == INFINITO) {
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
        int[][] grafo = {
            {0, 4, INFINITO, INFINITO, INFINITO, INFINITO, INFINITO, 8, INFINITO},
            {4, 0, 8, INFINITO, INFINITO, INFINITO, INFINITO, 11, INFINITO},
            {INFINITO, 8, 0, 7, INFINITO, 4, INFINITO, INFINITO, 2},
            {INFINITO, INFINITO, 7, 0, 9, 14, INFINITO, INFINITO, INFINITO},
            {INFINITO, INFINITO, INFINITO, 9, 0, 10, INFINITO, INFINITO, INFINITO},
            {INFINITO, INFINITO, 4, 14, 10, 0, 2, INFINITO, INFINITO},
            {INFINITO, INFINITO, INFINITO, INFINITO, INFINITO, 2, 0, 1, 6},
            {8, 11, INFINITO, INFINITO, INFINITO, INFINITO, 1, 0, 7},
            {INFINITO, INFINITO, 2, INFINITO, INFINITO, INFINITO, 6, 7, 0}
        };

        floydWarshall(grafo);
    }

}
