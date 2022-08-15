package com.group.ApiRest.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.group.ApiRest.bean.factura;
import com.group.ApiRest.dao.facturaDao;
import com.group.ApiRest.service.facturaService;

@Service
public class facturaServiceImpl implements facturaService {

	@Autowired
	facturaDao facturaDao;

	@Override
	public int crearFactura(factura factura) {
		try {
			return facturaDao.crearFactura(factura);
		} catch (Exception e) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Foo Not Found", e);
		}

	}

	@Override
	public factura obtenerFactura(String codigo) {
		try {
			factura factura = facturaDao.obtenerFactura(codigo);
			return factura;
		} catch (Exception e) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Foo Not Found", e);
		}
	}

}
