package paquetead_Ej1;

import java.io.Serializable;

public class C_Compra implements Serializable {

	private int Codigo_producto, cantidad_comprada;
	private double precio_compra;

	public C_Compra(int codigo_producto, int cantidad_comprada, double precio_compra) {

		this.Codigo_producto = codigo_producto;
		this.cantidad_comprada = cantidad_comprada;
		this.precio_compra = precio_compra;
	}

	public int getCodigo_productoc() {
		return Codigo_producto;
	}

	public int getCantidad_comprada() {
		return cantidad_comprada;
	}

	public double getPrecio_compra() {
		return precio_compra;
	}

}
