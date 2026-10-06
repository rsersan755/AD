package tm1;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;



public class UD1_B2_T1_RubenSerralbo {

	public static void main(String[] args) throws FileNotFoundException, IOException{
		// TODO Auto-generated method stub
		
		int x = 0, cont=0;
		
		String ruta = System.getProperty("user.home") +System.getProperty("file.separator")+"AD"+System.getProperty("file.separator")+"EstoDefinitivamenteNoEsUnVirus.jar";
		
		File f = new File(ruta);
		
		FileOutputStream FOS_f = null;
		FileInputStream FIS_F = new FileInputStream(f);
		
		try {
			
			byte[] bytes = FIS_F.readAllBytes();
			
			while (cont <=3) {
				if (!new File(System.getProperty("user.home") + System.getProperty("file.separator") + "AD" + System.getProperty("file.separator") + "_COPIA" +x+  ".txt").exists()) {
					new FileOutputStream(System.getProperty("user.home") + System.getProperty("file.separator") + "AD" + System.getProperty("file.separator") + "_COPIA" +x+  ".txt").write(bytes);
				
					cont++;
				}
				x++;
			}
			
			
			
		} catch (FileNotFoundException ie) {
			System.out.println("Error: " + ie.getMessage());
		} finally {
			try {
				FIS_F.close();
			} catch (IOException e) {
				System.out.println("Error: " + e.getMessage());
			}
		}
		
		
		
		
	}
	
	
	

}
