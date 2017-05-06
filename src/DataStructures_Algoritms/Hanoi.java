package DataStructures_Algoritms;

public class Hanoi {

	public static void main(String[] args) {		
		
		CalculaHanoi('A','B','C',3);		

	}
	
	static void CalculaHanoi(char varInicial, char varCentral, char varFinal, int n){
		
		if (n==1){
			System.out.println("Mover disco " + n + " desde varilla " + varInicial + " a varilla " + varFinal);
		}
		else{
			CalculaHanoi(varInicial, varFinal, varCentral, n-1);
			System.out.println("Mover disco " + n + " desde varilla " + varInicial + " a varilla " + varFinal);
			
			CalculaHanoi(varCentral, varInicial, varFinal, n-1);
		}
	}

}
