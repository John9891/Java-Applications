package DataStructures_Algoritms;
/*
 * Problema del caballo:
 * En un tablero de ajedrez de n x n casillas, se tiene un caballo situado en la posición inicial de
coordenadas (x0,y0). El problema consiste en encontrar, si existe, un circuito que permita al
caballo pasar exactamente una vez por cada una de las casillas de tablero, teniendo en cuenta los
movimientos (saltos) permitidos a un caballo de ajedrez.
 */
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Caballo {

	public static void main(String[] args) {
		
		int x, y;
		boolean solucion;
		BufferedReader entrada = new BufferedReader(new InputStreamReader(System.in));
		try {
			System.out.println("Posicion inicial del caballo. ");
			System.out.print(" x = ");
			x = Integer.parseInt(entrada.readLine());
			System.out.print(" y = ");
			y = Integer.parseInt(entrada.readLine());
			CaballoSaltador miCaballo = new CaballoSaltador(x,y);
			solucion = miCaballo.resolverProblema();
			if(solucion){
				miCaballo.escribirTablero();
			}
			
		}
		catch (Exception m) {
			System.out.println("No se pudo probar el algoritmo, " + m);
		}		

	}

}

class CaballoSaltador{
	
	static final int N = 8;
	static final int n = (N+1);
	private int x0;
	private int [][] tablero = new int[n][n];
	private boolean exito;
	private int [][]SALTO = {{2,1}, {1,2}, {-1,2}, {-2,1},	{-2,-1}, {-1,-2}, {1,-2}, {2,-1}};
	private int y0;
	
	
	//Constructor define los parámetros de la matriz
	public CaballoSaltador(int x, int y) throws Exception{
		
		if ((x < 1) || (x > N) ||(y < 1) || (y > N)){
			throw new Exception("Coordenadas fuera de rango");			
		}				
		x0 = x;
		y0 = y;
		for(int i = 1; i<= N; i++){			
			for(int j = 1; j<= N; j++){
				tablero[i][j] = 0;}			
			tablero[x0][y0] = 1;
			exito = false;}		
	}
	
	//Método que llama a SaltoCaballo con las coordenadas iniciales y valida si la variable éxito cambia a true
	public boolean resolverProblema(){
		
		saltoCaballo(x0, y0, 2);
		return exito;
	}
	
	private void saltoCaballo(int x, int y, int i){
		
		int nx, ny;
		int k;
		k = 0; // inicializa el conjunto de posibles movimientos
		do{
			k++;
			nx = x + SALTO[k-1][0];
			ny = y + SALTO[k-1][1];
			// determina si nuevas coordenadas son aceptables
			if((nx >= 1) && (nx <= N) && (ny >= 1) && (ny <= N)	&&	(tablero[nx][ny] == 0)){
				
				tablero[nx][ny]= i; // anota movimiento
				if (i < N*N){
					saltoCaballo(nx, ny, i+1);//Se repite rutina para nu nuevo salto
					
					if (!exito){// no se alcanzó la solución										
						tablero[nx][ny] = 0; // se borra anotación
						}
					}
				else{
					exito = true; // tablero cubierto. Se alcanzó la solución
				}
				
			}
		}
		while ((k < 8) && !exito);
	}
	
	void escribirTablero(){
		
		for(int i = 1; i <= N; i++){
			for(int j = 1; j <= N; j++)
		System.out.print(tablero[i][j] + " ");
		System.out.println();
		}
	}
}










