package grafos.buscas;

public class BellmanFord {
	
	private static final int INFINITO = Integer.MAX_VALUE;

    public static void bellmanFord(int[][] grafo, int verticeInicial) {
        
    	int numVertices = grafo.length;
        int[] distancia = new int[numVertices];

        // Inicializa as distâncias com infinito
        for (int i = 0; i < numVertices; i++) {
            distancia[i] = INFINITO;
        }

        // A distância do vértice de início para ele mesmo é sempre 0
        distancia[verticeInicial] = 0;

        // Relaxa as arestas repetidamente para encontrar as distâncias mínimas
        for (int i = 0; i < numVertices - 1; i++) {
            for (int u = 0; u < numVertices; u++) {
                for (int v = 0; v < numVertices; v++) {
                    if (grafo[u][v] != 0 && distancia[u] != INFINITO
                            && distancia[u] + grafo[u][v] < distancia[v]) {
                        distancia[v] = distancia[u] + grafo[u][v];
                    }
                }
            }
        }

        // Verifica se há ciclos negativos
        for (int u = 0; u < numVertices; u++) {
            for (int v = 0; v < numVertices; v++) {
                if (grafo[u][v] != 0 && distancia[u] != INFINITO
                        && distancia[u] + grafo[u][v] < distancia[v]) {
                    System.out.println("O grafo contém um ciclo negativo!");
                    return;
                }
            }
        }

        // Imprime as distâncias mínimas de todos os vértices
        mostraSolucao(distancia);
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

        bellmanFord(grafo, 0);
    }

}
