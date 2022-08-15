package com.group.ApiRest.dao;

import com.group.ApiRest.bean.factura;

public interface facturaDao {
	
	public int crearFactura(factura factura);
	public factura obtenerFactura(String codigo);
}
