package com.example.demo.repositories;

import java.util.ArrayList;

import com.example.demo.models.ProductoModel;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository //indica que la clase es de tipo repositorio de data
public interface ProductoRepository extends CrudRepository<ProductoModel, Integer>{ //CrudRepositroy es la lib. que implementa los métodos 
                                                        //se define el tipo de dato (entidad) y el tipo de identificador(PK)
    //Métodos querys (JPA)
    public abstract ArrayList<ProductoModel> findByCodigo(long codigo);  
    @Query(value = "select * from estado as e join producto as p on e.id_estado=p.id_estado where e.descripcion=:PARAM", nativeQuery=true)
    public abstract ArrayList<ProductoModel> filtrarPorEstado(@Param("PARAM") String PARAM) ;

    @Query(value = "select * from estado as e join producto as p on e.id_estado=p.id_estado where p.id=:PARAM", nativeQuery=true)
    public abstract ProductoModel filtrarPorId(@Param("PARAM") Integer PARAM) ;

}



