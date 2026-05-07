package com.example.donaton.repository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.example.donaton.model.Transporte;


@Repository
public class TransporteRepository {
   private List<Transporte> transportes = new ArrayList<>();

   public List<Transporte> listarTodos(){
       return this.transportes;
    }
    public Transporte buscarPorId(Long id){
         return this.transportes.stream().filter(transporte -> transporte.getId().equals(id)).findFirst().orElse(null);
    }
    public Transporte guardarTransporte(Transporte transporte){
         this.transportes.add(transporte);
         return transporte;
    }
    public Transporte editarTransporte(Transporte transporte){
         int index = this.transportes.indexOf(buscarPorId(transporte.getId()));
         if(index != -1){
              this.transportes.set(index, transporte);
              return transporte;
         }
         return null;
    }
    public boolean eliminarPorId(Long id){
         return this.transportes.removeIf(transporte -> transporte.getId().equals(id));
    }
}
