package com.group.ApiRest.service;


import com.group.ApiRest.bean.factura;

public interface facturaService {

	public int crearFactura(factura factura);
	public factura obtenerFactura(String codigo);
	
}
