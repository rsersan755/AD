package tm2_2;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Scanner;

public class UD1_B2_T3_RubenSerralbo {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String ruta = "src" + System.getProperty("file.separator") + "tm2" + System.getProperty("file.separator");
		String nomarch = "datosmatriz.dat";

		double[][] matriz = pedirdatos(sc);
		
		escribirmatri(ruta, nomarch, matriz);
		
		double[][] matrizleida = leerMatriz(ruta, nomarch);
		mostrarMatriz(matrizleida); 
		sc.close();

	}

	public static double[][] pedirdatos(Scanner sc) {

		double[][] ma = new double[2][2];
		for (int i = 0; i < ma.length; i++) {
			for (int j = 0; j < ma[i].length; j++) {
				System.out.println("Introduce el numero en la posicion " + " (" + i + ")(" + j + "):");
				ma[i][j] = sc.nextDouble();
			}
		}
		return ma;
	}

	public static void escribirmatri(String ruta, String nomarch, double[][] ma) {
		File f = new File(ruta, nomarch);

		try {
			DataOutputStream dos = new DataOutputStream(new FileOutputStream(f));
			
			dos.writeInt(ma.length);       // Número de filas
            dos.writeInt(ma[0].length);		//Numero de columnas
			
			for (int i = 0; i < ma.length; i++) {
				for (int j = 0; j < ma[i].length; j++) {
					dos.writeDouble(ma[i][j]);
				
				}

			}
			System.out.println("Matriz guardada");

		} catch (IOException e) {
			System.out.println("Error: " + e.getMessage());
		}

	}

	public static double[][] leerMatriz(String ruta, String nomarch) {
		File archivo = new File(ruta, nomarch);

        double[][] matriz = null;

        try (DataInputStream dis = new DataInputStream(new FileInputStream(archivo))) {
            int filas = dis.readInt();
            int columnas = dis.readInt();

            matriz = new double[filas][columnas];

            for (int i = 0; i < filas; i++) {
                for (int j = 0; j < columnas; j++) {
                    matriz[i][j] = dis.readDouble();
                }
            }

        } catch (IOException e) {
            System.err.println("Error al leer el archivo: " + e.getMessage());
        }

        return matriz;
	}

	public static void mostrarMatriz(double[][] ma) {
		
		for (int i = 0; i < ma.length; i++) {
			for (int j = 0; j < ma[i].length; j++) {
				System.out.print(ma[i][j] + "\t");
				
			}
			System.out.println();

		}
		
	}

}
