package com.example.donaton.repository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.example.donaton.model.Envio;


@Repository
public class EnvioRepository {
   private List<Envio> envios = new ArrayList<>();

   public List<Envio> listarTodos(){
       return this.envios;
    }
    public Envio buscarPorId(Long id){
         return this.envios.stream().filter(envio -> envio.getId().equals(id)).findFirst().orElse(null);
    }
    public Envio guardarEnvio(Envio envio){
         this.envios.add(envio);
         return envio;
    }
    public Envio editarEnvio(Envio envio){
         int index = this.envios.indexOf(buscarPorId(envio.getId()));
         if(index != -1){
              this.envios.set(index, envio);
              return envio;
         }
         return null;
    }
    public boolean eliminarPorId(Long id){
         return this.envios.removeIf(envio -> envio.getId().equals(id));
    }
}
