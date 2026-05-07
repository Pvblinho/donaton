package com.example.donaton.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.donaton.service.NecesidadService;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.example.donaton.model.Necesidad;
import org.springframework.web.bind.annotation.PutMapping;



@RestController
@RequestMapping("/api/v1/necesidades")
public class NecesidadController {
    
    private NecesidadService necesidadService;

    public NecesidadController(NecesidadService necesidadService) {
        this.necesidadService = necesidadService;
    }
    
    @GetMapping
    public java.util.List<Necesidad> listarTodas(){
        return necesidadService.getNecesidades();
    }
    
    @GetMapping("/{id}")
    public Necesidad buscarPorId(@PathVariable Long id){
        return necesidadService.getNecesidadById(id);
    }
    
    @PostMapping
    public Necesidad agregarNecesidad (@RequestBody Necesidad necesidad)
    {
        return necesidadService.saveNecesidad(necesidad);
    }
    
    @PutMapping("/{id}")
    public Necesidad editarNecesidad(@RequestBody Necesidad necesidad) {
        return necesidadService.updateNecesidad(necesidad);
    }
    
    @DeleteMapping("/{id}")
    public String eliminarNecesidad(@PathVariable Long id) {
        return necesidadService.deleteNecesidad(id);
    }
}
