package com.example.demo.Services;



import java.util.ArrayList;


import com.example.demo.models.EstadoModel;
import com.example.demo.repositories.EstadoRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class EstadoService {
    @Autowired
	EstadoRepository estadoRepository;
    
    public EstadoModel guardarEstado(EstadoModel estado){
		return estadoRepository.save(estado);
	}

    public ArrayList<EstadoModel> obtenerEstados(EstadoModel estado){
        return (ArrayList<EstadoModel>) estadoRepository.findAll();
    }


}
