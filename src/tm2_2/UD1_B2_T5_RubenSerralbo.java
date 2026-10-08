package tm2_2;

import java.io.BufferedInputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.RandomAccessFile;

public class UD1_B2_T5_RubenSerralbo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		File f = new File("src" + System.getProperty("file.separator") + "tm2_2" + System.getProperty("file.separator")
				+ "pedidos.dat");

		Pedido p1 = new Pedido("Coche", 1, 19.999);
		Pedido p2 = new Pedido("pepinillo", 3, 2.99);
		Pedido p3 = new Pedido("raton", 1, 50.98);

		Pedido[] pedidos = { p1, p2, p3 };
		Pedido[] pedidos2 = new Pedido("teclado",2,2.33);

		escribirPedidos(pedidos, f);
		leerPedidos(f);
		System.out.println("--------------------");
		annadePedidos(pedidos, f);

	}

	public static void escribirPedidos(Pedido[] pedido, File f) {

		try {
			DataOutputStream dos = new DataOutputStream(new FileOutputStream(f));

			for (int i = 0; i < pedido.length; i++) {
				dos.writeUTF(pedido[i].getDescripcion());
				dos.writeInt(pedido[i].getNumUnidades());
				dos.writeDouble(pedido[i].getPrecio());

			}

		} catch (Exception e) {
			// TODO: handle exception
		}

	}

	public static void leerPedidos(File f) {

		try {
			DataInputStream das = new DataInputStream(new FileInputStream(f));

			while (true) {
				String desc = das.readUTF();
				int unidades = das.readInt();
				double precio = das.readDouble();

				Pedido p = new Pedido(desc, unidades, precio);
				System.out.println(p);
			}
		} catch (EOFException e) {
			System.out.println("Fin de lecura");
		}catch (IOException ie) {
		System.out.println("error: " + ie.getMessage());
		}

	}
	
	public static void annadePedidos(Pedido[] pedidos, File f) {
			
		Pedido[] p2 = pedidos;
			
			p2 = new Pedido("pera",1,2.3);
			pedidos[5] = new Pedido("castaña",4,6.11);

		
		try {
			RandomAccessFile raf = new RandomAccessFile(f, "rw");
			
			long tam = f.length()-1;
			raf.seek(tam);
			
			raf.writeUTF(pedidos[4].getDescripcion());
			raf.writeInt(pedidos[4].getNumUnidades());
			raf.writeDouble(pedidos[4].getPrecio());
				
			long tam2 = f.length()-1;
			raf.seek(tam2);
			
			raf.writeUTF(pedidos[5].getDescripcion());
			raf.writeInt(pedidos[5].getNumUnidades());
			raf.writeDouble(pedidos[5].getPrecio());
			
			
			
			
			
		} catch (IOException e) {
			System.out.println("Error: " + e.getMessage());
		}
		
		
	}

}
