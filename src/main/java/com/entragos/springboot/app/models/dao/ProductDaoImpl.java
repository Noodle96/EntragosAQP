package com.entragos.springboot.app.models.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import com.entragos.springboot.app.models.entity.Producto;


@Repository
public class ProductDaoImpl implements IProductDao {
	@PersistenceContext
	EntityManager em; 
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Producto> findAll() {
		return em.createQuery("from Producto").getResultList();
	}

	@Override
	public void save(Producto producto) {
		if(producto.getId() != null &&  producto.getId() >  0) {
			em.merge(producto);
		}
		else {
			em.persist(producto);
		}
	}

	@Override
	public Producto findOne(Long id) {
		return em.find(Producto.class, id);
	}

	@Override
	public void delete(Long id) {
		em.remove(findOne(id));
	}

}
