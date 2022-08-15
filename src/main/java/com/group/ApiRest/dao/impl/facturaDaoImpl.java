package com.group.ApiRest.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.group.ApiRest.bean.factura;
import com.group.ApiRest.dao.facturaDao;


@Repository
public class facturaDaoImpl implements facturaDao {
	
	@Autowired 
	JdbcTemplate jdbcTemplate;

	@Override
	public int crearFactura(factura f) {
		
		if (createFactura(f)==1 && createDetallefactura(f)==1) {
			return 1;
		} else {
			return 0;
		}

	}

	public int createFactura(factura f) {
		String query="call RFactura (?,?,?)";
		int rest = jdbcTemplate.update(query,f.getRuc(),f.getNombreCliente(),f.getDireccionCliente());
		return rest;
	}
	
	public int createDetallefactura(factura f) {
		String query="call RDetalle (?,?,?)";
		int rest = jdbcTemplate.update(query,f.getNombreProducto(),f.getCantidad(),f.getPrecioUnidad());
		return rest;
	}
	
	
	@Override
	public factura obtenerFactura(String codigo) {
		String sql="call FBusquedaRuc (?)";
		
		factura myfactura =new factura();
		
		myfactura = jdbcTemplate.queryForObject(sql,new Object[]{codigo},
				new RowMapper<factura>() {
					public factura mapRow(ResultSet result, int row) throws SQLException {
						factura fact=new factura();


						fact.setCodigo(result.getInt("codigo"));

						fact.setRuc(result.getString("ruc"));
						
						fact.setNombreCliente(result.getString("nombreCliente"));

						fact.setDireccionCliente(result.getString("direccionCliente"));
						
						
						fact.setNombreProducto(result.getString("nombreProducto"));

						fact.setCantidad(result.getInt("cantidad"));

						fact.setPrecioUnidad(result.getInt("precioUnidad"));

						return fact;
					}
				});
		

		return myfactura;
	}

}
