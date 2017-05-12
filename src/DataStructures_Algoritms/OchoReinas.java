/*
 * _______________________________________________EIGHT QUEENS_______________________________________
 * This program consists of placing the n queens on the board in such a way that none can kill another,
 * complying with the rules of the movement of the Chess queens
 */
package DataStructures_Algoritms;

public class OchoReinas {
	
	final int N = 8;
	final int n = (N+1);
	int[] reinas = new int[n];
	boolean solucion;

	public static void main(String[] args) {
		
		boolean respuesta;
		OchoReinas prueba = new OchoReinas();
		respuesta = prueba.solucionReinas();
		if(respuesta){
			prueba.ImprimirTablero();
		}

	}
	
	void ImprimirTablero(){
		int tablero[][]= new int[n][n];		
		for(int i=0;i<=N;i++){			
			tablero[i][reinas[i]]=reinas[i];			
		}
		for(int j=0;j<=N;j++){
			for(int k=0;k<N; k++){				
				System.out.print(tablero[j][k] + "  ");
			}
			System.out.println();
		}
	}
	
	public boolean solucionReinas(){
		solucion = false;
		ponerReina(1);
		return solucion;
	}
	
	private void ponerReina(int i){
		
		int j;
		j = 0; // inicializa posibles movimientos
		do {			
			j++;
			reinas[i] = j; // prueba a colocar reina i en fila j,
			// a la vez queda anotado el movimiento
			if (valido(i)){
				if (i < N){					
					ponerReina(i+1);// no completado el problema					
					if (!solucion){reinas[i] = 0;}// vuelta atrás				
				}
				else{solucion = true;}			
					
			}			
			
		} while (!solucion && (j < 8));
	}
	
	private boolean valido(int i){
		
		int r;
		boolean libre;
		libre = true;
		for (r = 1; r <= i-1; r++){			
			libre = libre && (reinas[i] != reinas[r]);	// no esté en la misma fila			
			libre = libre && ((i + reinas[i]) != (r + reinas[r]));	// no esté en alguna de las dos diagonales
			libre = libre && ((i - reinas[i]) != (r - reinas[r]));
		}
		return libre;
	}

}


