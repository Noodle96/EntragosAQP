package com.entragos.springboot.app.controllers;

import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import com.entragos.springboot.app.models.dao.IProductDao;
import com.entragos.springboot.app.models.entity.Producto;
import com.entragos.springboot.app.models.service.IProductoService;

@Controller
@SessionAttributes("producto")
public class ProductController {
	
	@Autowired
	private IProductoService serviceDao;
	
	
	@RequestMapping(value="/listarProductos",method = RequestMethod.GET)
	public String listar(Model model) {
		model.addAttribute("titulo","Listado de productos");
		model.addAttribute("productos",serviceDao.findAll());
		return "listarProductos";
	}
	
	@RequestMapping(value="/formProductos",method = RequestMethod.GET)
	public String  crear( Map<String,Object> model) {
		Producto producto = new Producto();
		model.put("titulo", "Formulario de Productos");
		model.put("producto", producto);
		return "formProductos";
	}
	
	
	
	
	@RequestMapping(value="/formProductos/{id}")
	public String editar(@PathVariable(value="id") Long id, Model model) {
		Producto producto = null;
		if(id > 0) {
			producto = serviceDao.findOne(id);
		}else {
			return "redirect:/listProductos";
		}
		model.addAttribute("producto", producto);
		model.addAttribute("titulo", "Editar Producto");
		return "formProductos";
	}
	

	
	@RequestMapping(value="/formProductos",method = RequestMethod.POST)
	public String guardar(@Valid Producto producto, BindingResult result,Model model,SessionStatus status) {
		if(result.hasErrors()) {
			model.addAttribute("titulo","formulario de clientes de nuevo");
			return "formProductos";
		}else {
			
			serviceDao.save(producto);
			status.setComplete();
//			Log.info("No entro a has errors");
			return "redirect:/listarProductos";
		}
	}
	
	@RequestMapping(value="/eliminarProductos/{id}")
	public String eliminar(@PathVariable(value="id") Long id) {
		if(id > 0){
			serviceDao.delete(id);
		}
		return "redirect:/listarProductos";
	}
	

}
