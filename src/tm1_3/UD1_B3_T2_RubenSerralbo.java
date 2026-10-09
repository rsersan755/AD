package tm1_3;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class UD1_B3_T2_RubenSerralbo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);

		boolean p = true;

		File f = new File(File.separator + "Users" + File.separator + "alumnado" + File.separator + "AD"
				+ File.separator + "refranes.txt");

		char c = '.';
		do {

			System.out.println("INTRODUCE UNA VOCAL: ");
			c = sc.next().charAt(0);
			if (esVocal(c)) {
				p = true;
				File f2 = new File(System.getProperty("user.home") + File.separator + "AD" + File.separator
						+ "refranes_CON_" + c + ".txt");
				copiaConVocal(f, f2, c);
			} else {
				System.out.println("Eso no es una vocal.");
				p = false;
			}

		} while (!p);

	}

	public static boolean esVocal(char c) {
		if (c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u') {
			return true;
		} else {
			return false;
		}
	}

	public static void copiaConVocal(File f1, File f2, char c) {

		FileReader fr = null;
		FileWriter fw2 = null;

		try {
			fr = new FileReader(f1);
			fw2 = new FileWriter(f2);

			int n;
			while ((n = fr.read()) != -1) {
				if (n == 97 || n == 101 || n == 105 || n == 111 || n == 117 || n == 65 || n == 69 || n == 73 || n == 79 || n == 85 || n == 161 || n == 160 || n == 162 || n == 163 || n == 130) {
					fw2.write(c);
				}else {
					fw2.write((char)n);
				}
			}
			fr.close();
			fw2.close();
			System.out.println("Escritura completada");

		} catch (IOException e) {
			System.out.println("Error: " + e.getMessage());
		}

	}

}
