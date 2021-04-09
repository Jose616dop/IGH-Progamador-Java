package com.example.demo.Services;

import java.util.ArrayList;
import java.util.Optional;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.models.EstadoModel;
import com.example.demo.models.ProductoModel;
import com.example.demo.repositories.ProductoRepository;




@Service //convertir en una clase de tipo servicio
public class ProductoService {
	@Autowired //inyeccion de dependencias (ya no es necesario instanciar, spring sabe que instancia utilizar)
	ProductoRepository productoRepository;

	
	public ArrayList<ProductoModel> obtenerProductos(){
		return (ArrayList<ProductoModel>) productoRepository.findAll(); //se castea para poder regresarlo en json
	}
	
	public ProductoModel guardarProducto(ProductoModel producto){
		return productoRepository.save(producto);
	}


	public ProductoModel actualizarProducto(int id, ProductoModel producto){
		producto.setId(id);
		return productoRepository.save(producto);
	}

	public ProductoModel actualizarEstado(int id, ProductoModel producto){
		producto=obtenerPorIdnotNull(id);
		
			if(producto.getEstado().getIdEstado()==1){
				EstadoModel estado = new EstadoModel();
				estado.setIdEstado(2);
				producto.setEstado(estado);
			}else if(producto.getEstado().getIdEstado()==2){
				EstadoModel estado = new EstadoModel();
				estado.setIdEstado(1);
				producto.setEstado(estado);
			}
		return productoRepository.save(producto);
	}

	public Optional<ProductoModel> obtenerPorId(Integer id){ //Optional siempre va con PK, si existe o no, no dará error
		return productoRepository.findById(id); //Método JPA de librería
	}

	public ArrayList<ProductoModel> obtenerPorEstado(String descripcion){
		return productoRepository.filtrarPorEstado(descripcion);
	}

	public ProductoModel obtenerPorIdnotNull(Integer id){
		return productoRepository.filtrarPorId(id);
	}

	public ArrayList<ProductoModel> obtenerPorCodigo(long codigo){
		return productoRepository.findByCodigo(codigo);
	}
	

public boolean eliminarProducto(Integer id){
	try {
		productoRepository.deleteById(id); //como no retorna nada, solo 
										   //una excepción si falla, se ingresa dentro de un trycatch
	 	return true;
	 	} catch (Exception e) {
 		return false;
	 	}

}



	
}
	
