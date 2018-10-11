package paquetead_Ej1;

import java.io.Serializable;

public class C_Ventas implements Serializable {
				
	
	private int Codigo_producto, cantidad_vendida;
	private double precio_venta;

	public C_Ventas(int codigo_producto, int cantidad_vendida, double precio_venta) {
		
		this.Codigo_producto = codigo_producto;
		this.cantidad_vendida = cantidad_vendida;
		this.precio_venta = precio_venta;

	}

	public int getCodigo_productov() {
		return Codigo_producto;
	}


	public int getCantidad_vendida() {
		return cantidad_vendida;
	}

	

	public double getPrecio_venta() {
		return precio_venta;
	}

	
	
	
}
