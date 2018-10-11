package paquetead_Ej1;

import java.io.Serializable;

public class C_Beneficio implements Serializable {
	
	private int Codigo_producto,cantidad_almacen;
	private double precio_beneficio;

	public C_Beneficio(int codigo_producto, int cantidad_almacen, double precio_beneficio) {
	
		this.Codigo_producto = codigo_producto;
		this.cantidad_almacen = cantidad_almacen;
		this.precio_beneficio = precio_beneficio;
	}


	@Override
	public String toString() {
		return "C_Beneficio [Codigo_producto=" + Codigo_producto + ", cantidad_almacen=" + cantidad_almacen
				+ ", precio_beneficio=" + precio_beneficio + "]";
	}

}
