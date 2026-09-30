package tm1;
import java.io.*;


public class UD1_B1_T1_RubenSerralbo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		// DEL SISTEMA OPERATIVO
		
	System.out.println("El Sistema operativo es: " + System.getProperty("os.name") );
	System.out.println("La version del SO es: " + System.getProperty("os.version"));
	System.out.println("Su tipo de arquitectura es: " + System.getProperty("os.arch"));
	
		//DEL USUARIO
	System.out.println();
	System.out.println("El usuario actual es: " + System.getProperty("user.name"));
	System.out.println("Su directorio HOMES es: " + System.getProperty("user.home"));
	System.out.println("El directorio donde me ejecuto es: " + System.getProperty("user.dir"));
	
		//DE JAVA
	System.out.println();
	System.out.println("Java se encuentra instalado en: " + System.getProperty("java.home"));
	System.out.println("Su version es: " + System.getProperty("java.version"));
	System.out.println("El nombre del vendedor es: " + System.getProperty("java.vendor"));
	System.out.println("Se puede encontrar en: " + System.getProperty("java.vendor.url"));
	
		//DEL SISTEMA DE ARCHIVOS
	System.out.println();
	System.out.println("Para las rutas se usa el caracter separador: " + System.getProperty("file.separator"));
	System.out.println("Y dentro de los ficheros se usa el separador de lineas: " + System.getProperty("line.separator") + " Nota: Hay un salto de linea de mas, porque la consola muestra un salto de linea");
	
	
	}

}
