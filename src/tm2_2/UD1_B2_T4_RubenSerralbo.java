package tm2_2;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.Scanner;

public class UD1_B2_T4_RubenSerralbo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int opc = 0;

		File f = new File("src" + System.getProperty("file.separator") + "tm2_2" + System.getProperty("file.separator")
				+ "datosFibonacci.dat");

			

		do {
			System.out.println("Actualmente hay " + contarNumeros() + " numeros guardados");
			System.out.println("----------Menu---------");
			System.out.println("1. Escribir 10 numeros");
			System.out.println("2. Mostrar con salto X");
			System.out.println("3. Salir");
			System.out.println("------------------------");
			System.out.println("Introduce una opcion: ");
			opc = sc.nextInt();

			switch (opc) {
			case 1:
				escribir10();
				System.out.println("Números escritos.");
				break;
				case 2:
					if (contarNumeros()!=0) {
						MostrarConSalto(sc);
					}else {
						System.out.println("No hay ningun numero escrito.");
					}
						
				
				break;
			
			case 3:
				System.out.println("Saliendo del programa...");
				break;

			default:
				break;
			}

		} while (opc != 3);

	}
	
	/**
	 * Accede de forma manual a cierta posicion de manera libre, rw, se evalua si hay numeros y si no
	 * en caso de que no haya, se podran los dos primeros predeterminado y se posicionara en el penultimo
	 * en este caso el 0 y el 1 ultimo, y a partid de la siguiente posicion, el largo, empezara a sumar los numeros.
	 * En el caso de que si haya, hara lo mismo.
	 */
	public static void escribir10() {

		File f = new File("src" + System.getProperty("file.separator") + "tm2_2" + System.getProperty("file.separator")
				+ "datosFibonacci.dat");

		try {
			RandomAccessFile raf = new RandomAccessFile(f, "rw");
			long largo = raf.length();
			
			if (contarNumeros() == 0) {
				raf.writeLong(0L);
				raf.writeLong(1L);
				
				for (int i = 0; i < 8; i++) {
					
					long tam = raf.length();
					
					raf.seek(tam - 16);
					long n1 = raf.readLong();
					
					raf.seek(tam - 8);
					long n2 = raf.readLong();
					
					raf.seek(tam);
					raf.writeLong(n1+n2);
					
				}
				
			} else {
				
				for (int i = 0; i < 10; i++) {
					long tam = raf.length();
					
					raf.seek(tam - 16);
					long n1 = raf.readLong();
					raf.seek(tam-8);
					long n2 = raf.readLong();
					
					raf.seek(tam);
					raf.writeLong(n1+n2);
				}
				
				
			}
			
			
		} catch (IOException e) {
			System.out.println("Error: " + e.getMessage());
		}

	}

	public static void MostrarConSalto(Scanner sc) {
		
		File f = new File("src" + System.getProperty("file.separator") + "tm2_2" + System.getProperty("file.separator")
				+ "datosFibonacci.dat");
		
		try {
			RandomAccessFile raf = new RandomAccessFile(f, "rw");
			int n = (int) raf.length()/8;
			
			System.out.println("Introduce un numero: ");
			int n2 = sc.nextInt();
			
			for (int i = 0; i < n2; i++) {
				System.out.println(raf.readLong());
				
			}
			
		} catch (IOException e) {
			System.out.println("Error: " + e.getMessage());
		}
		
		
		
		
	}

	/**
	 * Para saner si hay numeros en el archivo vemos el largo del archivo y lo
	 * dividimos entre los 8 bytes para que nos de el numero de digitos que hay
	 * 
	 * @return n
	 */
	public static long contarNumeros() {
		File f = new File("src" + System.getProperty("file.separator") + "tm2" + System.getProperty("file.separator")
				+ "datosFibonacci.dat");
		int n = (int) (f.length() / 8);
		if (!f.exists()) {
			return 0;
		}
		return n;
	}

}
