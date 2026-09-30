package tm1;
import java.io.*;

public class UD1_B1_T3_RubenSerralbo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		//NOMBRE DEL FICHERO
		File f = new File(System.getProperty("user.home") + System.getProperty("file.separator") + "AD" + System.getProperty("file.separator") + "captura");
		System.out.println("Nombre: " + f.getName());
		
		//SU RUTA
		System.out.println("Su ruta: " + f.getPath());
		
		//SU RUTA ABSOLUTA
		System.out.println("Su ruta absoluta: " + f.getAbsolutePath());
		
		//SI ES UN FICHERO O UN DIRECTORIO
		if (f.isDirectory()) {
			System.out.println("Es un directorio");
		}else {
			System.out.println("Es un archivo");
		}
		
		//SI SE PUEDE LEER O ESCRIBIR EN EL
		if (f.canRead()||f.canWrite()) {
			System.out.println("El archivo si se puede leer o escribir");
		}else {
			System.out.println("No se puede ni escribir ni leer");
		}
		
		//SU TAMAÑO
		System.out.println("Tamaño: " + f.getTotalSpace());
		
		//NOMBRE DEL DIRECTORIO PADRE
		if (f.getParent() == null) {
			System.out.println("No tiene directorio padre");
		}else {
			System.out.println("Nombre del directorio padre: " + f.getParent());
		}
		
		
	}

}
