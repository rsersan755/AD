package tm1_3;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class UD1_B3_T1_RubenSerralbo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		File f = new File(File.separator + "Users" + File.separator + "alumnado" + File.separator + "AD"
				+ File.separator + "refranes.txt");
		System.err.println("FILEREADER----------------");
		leerFileReader(f);
		System.out.println();
		System.err.println("BUFFEREDREADER------------");
		leerBufferedReader(f);

	}

	public static void leerFileReader(File f) {

		FileReader fr = null;
			try {
				fr = new FileReader(f);
				int i;
				while ((i = fr.read()) != -1) {
				System.out.print((char) i);
				}
			} catch (IOException e) {
				e.printStackTrace();
			} finally {
				System.out.println();
				System.out.println("Lectura completada con exito");
				try {
					fr.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	
	//La diferencia entre los dos es que FileReader lee por int y habria que parsearlo a char para el
	//codigo ASCI , y bufferreader por string de linea.

	public static void leerBufferedReader(File f) {

		BufferedReader br = null;
		
		try {
			br = new BufferedReader(new FileReader(f));

			String linea;
			while ((linea = br.readLine()) != null) {
				System.out.println(linea);
			}

		} catch (IOException e) {
			System.out.println("Error: " + e.getMessage());
		} finally {
			System.out.println("Fin de lectura.");
			try {
				br.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

}
