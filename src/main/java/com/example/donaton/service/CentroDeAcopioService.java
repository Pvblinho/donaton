package com.example.donaton.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.donaton.model.CentroDeAcopio;
import com.example.donaton.repository.CentroDeAcopioRepository;

@Service
public class CentroDeAcopioService {

   private CentroDeAcopioRepository centroDeAcopioRepository;

   public CentroDeAcopioService(CentroDeAcopioRepository centroDeAcopioRepository) {
       this.centroDeAcopioRepository = centroDeAcopioRepository;
   }

   public List<CentroDeAcopio> getCentrosDeAcopio(){
       return centroDeAcopioRepository.listarTodos();
   }

   public CentroDeAcopio getCentroDeAcopioById(Long id){
       if(id != null){
           return centroDeAcopioRepository.buscarPorId(id);
       }
       return null;
   }

   public CentroDeAcopio saveCentroDeAcopio(CentroDeAcopio centroDeAcopio){
       if(centroDeAcopioRepository.buscarPorId(centroDeAcopio.getId()) == null){
           return centroDeAcopioRepository.guardarCentroDeAcopio(centroDeAcopio);
       }
       return null;
   }

   public CentroDeAcopio updateCentroDeAcopio(CentroDeAcopio centroDeAcopio){
       if(centroDeAcopio != null){
           return centroDeAcopioRepository.editarCentroDeAcopio(centroDeAcopio);
       }
       return null;
   }

   public String deleteCentroDeAcopio(Long id){
       if(centroDeAcopioRepository.eliminarPorId(id)){
           return "Centro de acopio eliminado";
       }
       return "Error al eliminar el centro de acopio";
   }
}
