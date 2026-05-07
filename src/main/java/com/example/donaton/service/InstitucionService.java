package com.example.donaton.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.donaton.model.Institucion;
import com.example.donaton.repository.InstitucionRepository;

@Service
public class InstitucionService {

   private InstitucionRepository institucionRepository;

   public InstitucionService(InstitucionRepository institucionRepository) {
       this.institucionRepository = institucionRepository;
   }

   public List<Institucion> getInstituciones(){
       return institucionRepository.listarTodos();
   }

   public Institucion getInstitucionById(Long id){
       if(id != null){
           return institucionRepository.buscarPorId(id);
       }
       return null;
   }

   public Institucion saveInstitucion(Institucion institucion){
       if(institucionRepository.buscarPorId(institucion.getId()) == null){
           return institucionRepository.guardarInstitucion(institucion);
       }
       return null;
   }

   public Institucion updateInstitucion(Institucion institucion){
       if(institucion != null){
           return institucionRepository.editarInstitucion(institucion);
       }
       return null;
   }

   public String deleteInstitucion(Long id){
       if(institucionRepository.eliminarPorId(id)){
           return "Institución eliminada";
       }
       return "Error al eliminar la institución";
   }
}
