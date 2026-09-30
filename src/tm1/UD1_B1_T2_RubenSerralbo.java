package tm1;
import java.io.*;
import java.util.Iterator;

public class UD1_B1_T2_RubenSerralbo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		File f;
		
		if (args.length > 0) {
			System.out.println("Listar el contenido de: " + args[0]);
			f = new File(args[0]);
		}else {
			System.out.println("Listar el contenido de: " + System.getProperty("user.home")+ System.getProperty("file.separator")+"AD");
			f = new File(System.getProperty("user.home")+ System.getProperty("file.separator")+ "AD");
		}
		
		if (f.exists() && f.isDirectory()) {
			File[] list = f.listFiles();
			System.out.println("Ficheros en el directorio actual: " + list.length);
			
			for (int i = 0; i < list.length; i++) {
			if (list[i].isFile()) {
				System.out.println("Nombre: " + list[i].getName() + " Archivo");
			}else if (list[i].isDirectory()) {
				System.out.println("Nombre: " + list[i].getName() + " Directorio");
			}	
			}
			
			
		}
		
		
		
	}
}

