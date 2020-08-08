package com.entragos.springboot.app.models.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PrePersist;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotEmpty;

@Entity
@Table(name="productos")
public class Producto implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotEmpty
	private String nombre;
	
	private String foto;
	
	@NotEmpty
	private String marca;
	
	@Temporal(TemporalType.DATE)
	@Column(name="create_at")
	private Date createAt;
	
//	@NotEmpty
	private  Integer valoracion;
	

	@PrePersist
	void prePersist() {
		createAt = new Date();
		valoracion = 1;
	}
	
	private Double descuento;

	private Integer stock;
	
	@NotEmpty
	private String descripcion;
	
	
	private Double precio;

	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getFoto() {
		return foto;
	}
	public void setFoto(String foto) {
		this.foto = foto;
	}
	public String getMarca() {
		return marca;
	}
	public void setMarca(String marca) {
		this.marca = marca;
	}
	public Date getCreateAt() {
		return createAt;
	}
	public void setCreateAt(Date createAt) {
		this.createAt = createAt;
	}
	public Integer getValoracion() {
		return valoracion;
	}
	public void setValoracion(Integer valoracion) {
		this.valoracion = valoracion;
	}
	public Double getDescuento() {
		return descuento;
	}
	public void setDescuento(Double descuento) {
		this.descuento = descuento;
	}
	public Integer getStock() {
		return stock;
	}
	public void setStock(Integer stock) {
		this.stock = stock;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public Double getPrecio() {
		return precio;
	}
	public void setPrecio(Double precio) {
		this.precio = precio;
	}
	@Override
	public String toString() {
		return "Producto [id=" + id + ", nombre=" + nombre + ", foto=" + foto + ", marca=" + marca + ", createAt="
				+ createAt + ", valoracion=" + valoracion + ", descuento=" + descuento + ", stock=" + stock
				+ ", descripcion=" + descripcion + ", precio=" + precio + "]";
	}
}
