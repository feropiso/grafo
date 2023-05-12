package grafo;
/**********************************
 * Aluno: Fernando Rodrigo Pinheiro de Sousa
 * Descrição:
 * Representações de Grafos por meio de Listas e Matrizes de Adjacências;
 * retorna o número de vértices; 
 * retorna o número de arestas; 
 * Adiciona arestas;
 * retorna arestas adjacentes.
 **********************************/
import java.util.ArrayList;
import java.util.HashMap;

import javax.swing.JOptionPane;

public class GrafoRepresentacao {
	
	private HashMap<Vertice, ArrayList<Vertice>> mapa_adj;
	private ArrayList<Aresta> listaAresta;
	private ArrayList<Vertice> listaVertice;
	private int matriz_adj[][];
	private boolean ehDirecioanado;
	
	
	public GrafoRepresentacao() {
		
		this.mapa_adj = new HashMap<Vertice, ArrayList<Vertice>>();
		this.listaAresta = new ArrayList<Aresta>();
		this.listaVertice = new ArrayList<Vertice>();
		this.matriz_adj = new int [10][10];
		this.ehDirecioanado = false;
		
		for(int i = 0; i < 10; i++)
			for(int j = 0; j < 10; j++)
				matriz_adj[i][j] = 0;
	}
	
	public void direcao() {
		
		int resp = JOptionPane.showConfirmDialog(null,
				"O grafo e direcionado?", "Grafos", JOptionPane.YES_NO_OPTION);
		
		if (resp == 0)
			ehDirecioanado = true; 
			
	}

	public void recebeVertices() {
		
		int rotulo = 0;
		int num_vertices = 0;
		
		num_vertices = Integer.parseInt(JOptionPane.showInputDialog(null, "Informe o numero de vertices do grafo:", 
                "Grafos", JOptionPane.INFORMATION_MESSAGE));
		
		for (int i = 1; i <= num_vertices; i++) {
			
			rotulo = Integer.parseInt(JOptionPane.showInputDialog(null, "Informe o rotulo do vertice "+i+":", 
	                "Grafos", JOptionPane.INFORMATION_MESSAGE));
			Vertice v = new Vertice(rotulo);
			
			listaVertice.add(v);			
		}
		
	}
	
	public void criaArestas() {
		
		if(ehDirecioanado) {
			
			int rotulo_origem = 0;
			int rotulo_fim = 0;
			int num_arestas = 0;
			int peso = 0;
			int cont = 1;
			
			num_arestas = Integer.parseInt(JOptionPane.showInputDialog(null, "Informe o numero de arestas do grafo:", 
	                "Grafos", JOptionPane.INFORMATION_MESSAGE));
			
			while(num_arestas <= 0) {
				num_arestas = Integer.parseInt(JOptionPane.showInputDialog(null, "Valor inválido.\nInforme novamente numero de arestas do grafo:", 
		                "Grafos", JOptionPane.INFORMATION_MESSAGE));
			}
			
			while(num_arestas > 0) {
				
				rotulo_origem = Integer.parseInt(JOptionPane.showInputDialog(null, "Informe o vertice origem da aresta "+cont+" :", 
		                "Grafos", JOptionPane.INFORMATION_MESSAGE));
				
				Vertice v1 = encontraVertice(rotulo_origem);
				
				while(v1 == null) {
					rotulo_origem = Integer.parseInt(JOptionPane.showInputDialog(null, "Vertice nao exitse.\nInforme o rotulo do vertice origem da aresta novamente:", 
			                "Grafos", JOptionPane.INFORMATION_MESSAGE));
					v1 = encontraVertice(rotulo_origem);
				}
				
				rotulo_fim = Integer.parseInt(JOptionPane.showInputDialog(null, "Informe o vertice destino da aresta "+cont+" :", 
		                "Grafos", JOptionPane.INFORMATION_MESSAGE));
				
				Vertice v2 = encontraVertice(rotulo_fim);
				
				while(v2 == null) {
					rotulo_fim = Integer.parseInt(JOptionPane.showInputDialog(null, "Vertice nao existe.\nInforme o rotulo do vertice destino da aresta novamente:", 
			                "Grafos", JOptionPane.INFORMATION_MESSAGE));
					v2 = encontraVertice(rotulo_fim);
				}
				
				peso = Integer.parseInt(JOptionPane.showInputDialog(null, "Informe o peso da aresta "+cont+" :", 
		                "Grafos", JOptionPane.INFORMATION_MESSAGE));
				
				Aresta a = new Aresta(v1, v2, peso);
				
				listaAresta.add(a);
				
				num_arestas--;
				
				cont++;
			}						
			
		}
		else {
			
		}
	}
	
	private Vertice encontraVertice(int rotulo) {
		
		for (Vertice v: listaVertice) {
			
			if(v.getRotulo() == rotulo) {
				return v;
			}
			
		}
		
		return null;
	}
	
	public void mostraListaAdj() {
		
		criaListaAdj();
		
		System.out.println("   ");
		
		for(Vertice v: mapa_adj.keySet()) {
			
			System.out.print(v.getRotulo()+" => ");
			
			for(Vertice vertice: mapa_adj.get(v)) {
				System.out.print(vertice.getRotulo()+" => ");				
			}
			System.out.print("o");
			
			System.out.println("");
		}
	}
	
	public void mostraMatrizAdj() {
		
		criaMatrizAdj();
		
		System.out.println("   ");
		
		System.out.print("****");
		
		for(Vertice v: listaVertice) {
			System.out.print(v.getRotulo()+"    ");
		}
		
		System.out.println();
		
		for(int i = 0; i < listaVertice.size(); i++){
		    
		    System.out.print(listaVertice.get(i).getRotulo()+"   ");
		    
		    for(int j = 0; j < listaVertice.size(); j++)
		    	System.out.print(matriz_adj[listaVertice.get(i).getRotulo()][listaVertice.get(j).getRotulo()]+"    ");
		          
		    System.out.println();
		  }
	}
	
	private void criaListaAdj() {
		
		for(Vertice v: listaVertice) {
			ArrayList<Vertice> arestasAdj = listaAdj(v.getRotulo());
			
			mapa_adj.put(v, arestasAdj);
		}
	}
	
	private void criaMatrizAdj() {
		
		for(Aresta a: listaAresta) 			
			matriz_adj[a.getVerticeOrigem().getRotulo()][a.getVerticeDestino().getRotulo()] = 1;
		
	}
		
	public ArrayList<Vertice> listaAdj(int vertice){
		
		ArrayList<Vertice> listaAdj = new ArrayList<Vertice>();
		
		for(Aresta a: listaAresta) {
			
			if(a.getVerticeOrigem().getRotulo() == vertice) {
				listaAdj.add(a.getVerticeDestino());
			}
		}
		
		return listaAdj;		
	}
	
}
