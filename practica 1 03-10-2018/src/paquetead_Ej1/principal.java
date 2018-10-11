package paquetead_Ej1;

import java.io.*;
import java.util.*;

public class principal implements Serializable {

	transient static Scanner cin = new Scanner(System.in);

	public static void main(String[] args) throws IOException, ClassNotFoundException {
		// TODO Auto-generated method stub

		C_Compra c1 = new C_Compra(1, 10, 1.45);
		C_Compra c2 = new C_Compra(3, 10, 1.5);
		C_Compra c3 = new C_Compra(4, 10, 2.60);
		C_Compra c4 = new C_Compra(5, 10, 1);
		C_Compra c5 = new C_Compra(10, 10, 12);

		C_Ventas v1 = new C_Ventas(1, 5, 2.5);
		C_Ventas v2 = new C_Ventas(3, 2, 3.5);
		C_Ventas v3 = new C_Ventas(6, 7, 2.5);
		C_Ventas v4 = new C_Ventas(7, 5, 2.5);
		C_Ventas v5 = new C_Ventas(10, 5, 25);

		ArrayList<C_Compra> lista_compra = new ArrayList<C_Compra>();
		lista_compra.add(c1);
		lista_compra.add(c2);
		lista_compra.add(c3);
		lista_compra.add(c4);
		lista_compra.add(c5);

		ArrayList<C_Ventas> lista_venta = new ArrayList<C_Ventas>();
		lista_venta.add(v1);
		lista_venta.add(v2);
		lista_venta.add(v3);
		lista_venta.add(v4);
		lista_venta.add(v5);

		int opc;

		do {
			System.out.println(
					" 1.- Guardar C_compra en fccero  “compras.dat” .\n 2.- Guardar C_ventas  en fccero “ventas.dat”. \n 3.- Crear el fccero “benefcio.dat”. \n 4.- Mostrar el fccero “benefcio.dat”.\n 5.- salir");
			opc = cin.nextInt();

			switch (opc) {

			default:
				System.out.println("mete un numero entre 1-5");

			case 1:

				FileOutputStream compras = new FileOutputStream("compras.dat");
				ObjectOutputStream camino1 = new ObjectOutputStream(compras);
				for (int i = 0; i < lista_compra.size(); i++) {
					camino1.writeObject(lista_compra.get(i));

				}
				camino1.close();

				break;

			case 2:
				FileOutputStream ventas = new FileOutputStream("ventas.dat");
				ObjectOutputStream camino2 = new ObjectOutputStream(ventas);
				for (int i = 0; i < lista_venta.size(); i++) {
					camino2.writeObject(lista_venta.get(i));

				}
				camino2.close();

				break;

			case 3:

				FileOutputStream benefi = new FileOutputStream("beneficio.dat");
				ObjectOutputStream escribirbenefi = new ObjectOutputStream(benefi);

				try {

					FileInputStream compr = new FileInputStream("compras.dat");
					ObjectInputStream leerc = new ObjectInputStream(compr);

					FileInputStream vent = new FileInputStream("ventas.dat");
					ObjectInputStream leerv = new ObjectInputStream(vent);
					C_Compra benec = (C_Compra) leerc.readObject();
					C_Ventas benev = (C_Ventas) leerv.readObject();
					while (true) {
						

						if (benec.getCodigo_productoc() == benev.getCodigo_productov()) {

							C_Beneficio ben = new C_Beneficio(benec.getCodigo_productoc(),
									(benec.getCantidad_comprada() - benev.getCantidad_vendida()),
									(benev.getPrecio_venta() - benec.getPrecio_compra()));
							escribirbenefi.writeObject(ben);
							benec = (C_Compra) leerc.readObject();
							benev = (C_Ventas) leerv.readObject();
							
						} else if (benec.getCodigo_productoc() < benev.getCodigo_productov()) {
							C_Beneficio ben = new C_Beneficio(benec.getCodigo_productoc(), benec.getCantidad_comprada(),
									benec.getPrecio_compra());
							escribirbenefi.writeObject(ben);
							 benec = (C_Compra) leerc.readObject();
							
							
						}

						else if (benec.getCodigo_productoc() > benev.getCodigo_productov()) {
							C_Beneficio ben = new C_Beneficio(benev.getCodigo_productov(), benev.getCantidad_vendida(),
									benev.getPrecio_venta());
							escribirbenefi.writeObject(ben);
							benev = (C_Ventas) leerv.readObject();
						}

					} // while
				} catch (EOFException e) {
					System.out.println("Lectura del fichero finalizada");
				}

				break;
			case 4:

				FileInputStream datos = new FileInputStream("beneficio.dat");
				ObjectInputStream leer = new ObjectInputStream(datos);
				try {
					while (true) {

						C_Beneficio benef = (C_Beneficio) leer.readObject();
						System.out.println(benef.toString());

					}
				} catch (EOFException e) {
					System.out.println("Lectura del fichero finalizada");
				}

				break;
			case 5:
				break;

			}// fin switch

		} while (opc != 5);

	}

}