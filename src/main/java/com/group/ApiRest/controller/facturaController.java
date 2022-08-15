package com.group.ApiRest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.group.ApiRest.bean.factura;
import com.group.ApiRest.service.facturaService;
@RequestMapping("/")
@RestController
public class facturaController {

	
	@Autowired
	facturaService service;
	
	@PostMapping("/")
	public int crearFactura(@RequestBody factura factura ) 
	{
		return service.crearFactura(factura);
	} 
	
	@GetMapping("/{codigo}")
	public factura obtenerFactura(@PathVariable String codigo ) 
	{
		return service.obtenerFactura(codigo);
	} 
	
}
