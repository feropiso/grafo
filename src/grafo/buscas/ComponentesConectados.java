package grafos.buscas;

import java.util.LinkedList;

public class ComponentesConectados {
	
	private int numVertices;
    private LinkedList<Integer>[] listaAdj;

    public ComponentesConectados(int numVertices) {
        
    	this.numVertices = numVertices;
    	
        listaAdj = new LinkedList[numVertices];
        
        for (int i = 0; i < numVertices; ++i) {
            listaAdj[i] = new LinkedList<>();
        }
    }

    public void addAresta(int vertice1, int vertice2) {
        listaAdj[vertice1].add(vertice2);
        listaAdj[vertice2].add(vertice1);
    }

    public void encontraComponesntesConectados() {
        
    	boolean[] vistado = new boolean[numVertices];

        for (int i = 0; i < numVertices; ++i) {
            if (!vistado[i]) {
                System.out.print("Componente Conectado: ");
                dfs(i, vistado);
                System.out.println();
            }
        }
    }

    private void dfs(int vertice, boolean[] visitado) {
        
    	visitado[vertice] = true;
        System.out.print(vertice + " ");

        for (int neighbor : listaAdj[vertice]) {
            if (!visitado[neighbor]) {
                dfs(neighbor, visitado);
            }
        }
    }

    public static void main(String[] args) {
        int numVertices = 7;
        ComponentesConectados grafo = new ComponentesConectados(numVertices);

        grafo.addAresta(0, 1);
        grafo.addAresta(0, 2);
        grafo.addAresta(1, 3);
        grafo.addAresta(2, 3);
        grafo.addAresta(4, 5);
        grafo.addAresta(4, 6);

        grafo.encontraComponesntesConectados();
    }

}
