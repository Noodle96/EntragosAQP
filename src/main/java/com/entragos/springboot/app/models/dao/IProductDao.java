package com.entragos.springboot.app.models.dao;

import java.util.List;

import com.entragos.springboot.app.models.entity.Producto;

public interface IProductDao {
	public List<Producto> findAll();
	public void save(Producto producto);
	public Producto findOne(Long id);
	public void delete(Long id);
}
