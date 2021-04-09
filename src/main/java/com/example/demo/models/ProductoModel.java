package com.example.demo.models;


import javax.persistence.*;


@Entity //creación de un modelo de entidades
@Table(name= "producto") //nombrar la table
public class ProductoModel {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY) //propiedad auto generado
	@Column(unique = true, nullable=false) //es unico (PK) y not null
	private int id;
	private String nombre;
	private double precio;


	@ManyToOne
	@JoinColumn(name = "idEstado")
	EstadoModel estado;

	private long codigo;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public double getPrecio() {
		return precio;
	}
	public void setPrecio(double precio) {
		this.precio = precio;
	}

	public long getCodigo() {
		return codigo;
	}
	public void setCodigo(long codigo) {
		this.codigo = codigo;
	}
	public EstadoModel getEstado() {
		return estado;
	}
	public void setEstado(EstadoModel estado) {
		this.estado = estado;
	}
	
	
	
}

