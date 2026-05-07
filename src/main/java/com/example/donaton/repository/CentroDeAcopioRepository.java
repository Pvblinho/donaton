package com.example.donaton.repository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.example.donaton.model.CentroDeAcopio;


@Repository
public class CentroDeAcopioRepository {
   private List<CentroDeAcopio> centrosDeAcopio = new ArrayList<>();

   public List<CentroDeAcopio> listarTodos(){
       return this.centrosDeAcopio;
    }
    public CentroDeAcopio buscarPorId(Long id){
         return this.centrosDeAcopio.stream().filter(centro -> centro.getId().equals(id)).findFirst().orElse(null);
    }
    public CentroDeAcopio guardarCentroDeAcopio(CentroDeAcopio centroDeAcopio){
         this.centrosDeAcopio.add(centroDeAcopio);
         return centroDeAcopio;
    }
    public CentroDeAcopio editarCentroDeAcopio(CentroDeAcopio centroDeAcopio){
         int index = this.centrosDeAcopio.indexOf(buscarPorId(centroDeAcopio.getId()));
         if(index != -1){
              this.centrosDeAcopio.set(index, centroDeAcopio);
              return centroDeAcopio;
         }
         return null;
    }
    public boolean eliminarPorId(Long id){
         return this.centrosDeAcopio.removeIf(centro -> centro.getId().equals(id));
    }
}
