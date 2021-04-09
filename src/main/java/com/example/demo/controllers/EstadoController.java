package com.example.demo.controllers;

import java.util.ArrayList;


import com.example.demo.Services.EstadoService;
import com.example.demo.models.EstadoModel;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

@RestController 
@RequestMapping("/estado")
public class EstadoController {
    
	@Autowired
	EstadoService estadoService;

    @GetMapping() 
	public ArrayList<EstadoModel> obtenerEstados(){
		return estadoService.obtenerEstados(null);
	}

	@PostMapping()
	public EstadoModel guardarEstado(@RequestBody EstadoModel estado){
		return this.estadoService.guardarEstado(estado); //Al ser datos delicados se sugiere implementar restricciones 
														//de usuario mediante SpringBoot Security
	}

}