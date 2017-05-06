package DataStructures_Algoritms;

public class MagicSquare {

	public static void main(String[] args) {
		
		int n = 5;
		int[][] res;
		res = (LlenarCuadrado(n));
		for(int i=0; i<n; i++){
			for(int j=0; j<n; j++){
				System.out.print(res[i][j] + " ");
			}
			System.out.println();
		}

	}
	
	static int[][] LlenarCuadrado(int n){
		
		int num = 1;
		int col_sig= n/2;
		int fil_sig = 0;
		int col_ult = 0;
		int fil_ult = 0;
		int [][] cuadrado;
		cuadrado = new int[n][n];
		cuadrado[fil_sig][col_sig] = num;
		int longitud = cuadrado.length*cuadrado.length;
		
		while(num<longitud){
			
			col_ult=col_sig;
			fil_ult=fil_sig;
			//Se desplaza para ingresar el siguiente número
			fil_sig=fil_ult-1;
			col_sig=col_ult+1;			
			//Si es la primera fila se desplaza a la última fila
			if(fil_sig<0){
				fil_sig=n-1;
				col_sig=col_ult+1;
				}
			//Si es la última columna va a la primera columna
			if(col_sig>=n){
				fil_sig=fil_ult-1;
				col_sig=0;}
						
			//Verifica si la casilla ya tiene un número
			if(fil_sig==-1 || cuadrado[fil_sig][col_sig]!=0){
				fil_sig=fil_ult+1;
				col_sig=col_ult;}
			num++;			
			cuadrado[fil_sig][col_sig] = num;
		}		
		
		return cuadrado;
	}

}
