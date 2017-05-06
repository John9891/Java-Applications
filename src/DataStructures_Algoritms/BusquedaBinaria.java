package DataStructures_Algoritms;

public class BusquedaBinaria {

	public static void main(String[] args) {
		
		int a[] = {0,1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20};
		int clave = 13;
		int inferior = 0;
		int superior = 20;
		buscar(a, clave, inferior, superior);

	}
	
	static void buscar(int a[], int clave, int inferior, int superior){		
				
		int central;
		
		if(inferior>superior){			
			System.out.println("No se encontró el número");
		}
		else{
			central = ((inferior + superior) / 2);
			System.out.println("El centro de " + inferior + " y " + superior + " es " + central);
			
			if(a[central]==clave){
				System.out.println("El número es " + a[central]);
			}
			else if(a[central]<clave){
				buscar(a, clave, a[central]+1, superior);
			}
			else if(a[central]>clave){
				buscar(a, clave, inferior, a[central]-1);
			}
			
		}		
		
	}	

}
