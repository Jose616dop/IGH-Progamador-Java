	package com.example.demo.controllers;


import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


import com.example.demo.Services.ProductoService;

import com.example.demo.models.ProductoModel;


@RestController //indica que es un controller
@RequestMapping("/producto") //asigna la direccion url del servidor
public class ProductoController {
	@Autowired 
	ProductoService productoService;


	
	@GetMapping() //para cuando llegue una petición de tipo get sin parámetros en url
	public ArrayList<ProductoModel> obtenerProductos(){
		return productoService.obtenerProductos();
	}
	 
	@PostMapping() //para cuando llegue una solicitud de tipo post sin parámetros en url
	public ProductoModel guardarProducto(@RequestBody ProductoModel producto){//toma la información json y la guarda en un objeto
		return this.productoService.guardarProducto(producto);//añade el objeto a la tabla
	}


	@PutMapping(path = "/{id}")
	public ProductoModel actualizarProducto(@PathVariable("id") Integer id,@RequestBody ProductoModel producto){
		return this.productoService.actualizarProducto(id,producto);
	}

	@PutMapping(path = "/actEstado/{id}")
	public ProductoModel actualizarEstado(@PathVariable("id") Integer id,ProductoModel producto){
		return this.productoService.actualizarEstado(id,producto);
	}


	@GetMapping(path = "/{id}")
	public Optional<ProductoModel> obtenerProductoPorId(@PathVariable("id") Integer id){ 
		return this.productoService.obtenerPorId(id);
	}

	@GetMapping("/busquedaEstado")
	public ArrayList<ProductoModel> obtenerProductopPorEstado(@RequestParam("estado") String descripcion){
		return this.productoService.obtenerPorEstado(descripcion);
		}

	@GetMapping("/busquedaCodigo")
	public ArrayList<ProductoModel> obtenerProductoPorCodigo(@RequestParam("codigo") long codigo){
		return this.productoService.obtenerPorCodigo(codigo);
		}


	@DeleteMapping(path="/{id}")
	public String eliminarPorId(@PathVariable("id") Integer id){
		boolean ok = this.productoService.eliminarProducto(id);
		if (ok){
			return "Se eliminó el producto con id = " + id;
		}else{
			return "No pudo eliminar el usuario con id = " + id;
		}
	}
	
}
