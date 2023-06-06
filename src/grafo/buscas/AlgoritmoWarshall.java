package grafo.buscas;

public class AlgoritmoWarshall {
	
	public static int[][] encontraFechoTransitivo(int[][] grafo) {
		
		int n = grafo.length;
	    int[][] fechamento = new int[n][n];
	        
	    for (int i = 0; i < n; i++) {
	            for (int j = 0; j < n; j++) {
	                fechamento[i][j] = grafo[i][j];
	            }
	    }
	        
	    for (int k = 0; k < n; k++) {
	       for (int i = 0; i < n; i++) {
	    	   for (int j = 0; j < n; j++) {
	    		   fechamento[i][j] = (fechamento[i][j] != 0) || ((fechamento[i][k] != 0) && (fechamento[k][j] != 0)) ? 1 : 0;
	           }
	        }
	    }
	    return fechamento;
	}
	
	 public static void main(String[] args) {
	        
		 int[][] grafo = {
	                {0, 1, 0, 0},
	                {0, 0, 0, 1},
	                {1, 0, 0, 0},
	                {0, 0, 1, 0}
	        };
	        
	        int[][] fechoTransitivo = encontraFechoTransitivo(grafo);
	        
	        System.out.println("Fecho Transitivo:");
	        for (int i = 0; i < grafo.length; i++) {
	            for (int j = 0; j < grafo[i].length; j++) {
	                System.out.print(fechoTransitivo[i][j] + " ");
	            }
	            System.out.println();
	        }
	  } 

}
