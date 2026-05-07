package com.example.donaton.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.donaton.service.InstitucionService;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.example.donaton.model.Institucion;
import org.springframework.web.bind.annotation.PutMapping;



@RestController
@RequestMapping("/api/v1/instituciones")
public class InstitucionController {
    
    private InstitucionService institucionService;

    public InstitucionController(InstitucionService institucionService) {
        this.institucionService = institucionService;
    }
    
    @GetMapping
    public java.util.List<Institucion> listarTodas(){
        return institucionService.getInstituciones();
    }
    
    @GetMapping("/{id}")
    public Institucion buscarPorId(@PathVariable Long id){
        return institucionService.getInstitucionById(id);
    }
    
    @PostMapping
    public Institucion agregarInstitucion (@RequestBody Institucion institucion)
    {
        return institucionService.saveInstitucion(institucion);
    }
    
    @PutMapping("/{id}")
    public Institucion editarInstitucion(@RequestBody Institucion institucion) {
        return institucionService.updateInstitucion(institucion);
    }
    
    @DeleteMapping("/{id}")
    public String eliminarInstitucion(@PathVariable Long id) {
        return institucionService.deleteInstitucion(id);
    }
}
