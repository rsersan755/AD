package tm1;
import java.io.*;

public class UD1_B1_T4_RubenSerralbo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		File f = new File("NUEVODIR");
		f.mkdir();
		
		
		try {
			File n2 = new File(f,"ficheroren");
			File txt1 = new File(f,"ficheros1.txt");
			txt1.createNewFile();
			File txt2 = new File(f,"ficheros2.txt");
			txt2.createNewFile();
			
			txt1.renameTo(n2);
			System.out.println("Fichero uno renombrado");
			
			txt2.delete();
			System.out.println("fichero eliminado");
			
		} catch (IOException ioe) {
			System.err.println("Error: " + ioe.getMessage());
			ioe.getStackTrace();	
			
		}
			
		//el directorio se ha creado en el workspace donde se trabaja.
		
		
		
	}

}
