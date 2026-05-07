package com.example.donaton.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.donaton.model.Envio;
import com.example.donaton.repository.EnvioRepository;

@Service
public class EnvioService {

   private EnvioRepository envioRepository;

   public EnvioService(EnvioRepository envioRepository) {
       this.envioRepository = envioRepository;
   }

   public List<Envio> getEnvios(){
       return envioRepository.listarTodos();
   }

   public Envio getEnvioById(Long id){
       if(id != null){
           return envioRepository.buscarPorId(id);
       }
       return null;
   }

   public Envio saveEnvio(Envio envio){
       if(envioRepository.buscarPorId(envio.getId()) == null){
           return envioRepository.guardarEnvio(envio);
       }
       return null;
   }

   public Envio updateEnvio(Envio envio){
       if(envio != null){
           return envioRepository.editarEnvio(envio);
       }
       return null;
   }

   public String deleteEnvio(Long id){
       if(envioRepository.eliminarPorId(id)){
           return "Envío eliminado";
       }
       return "Error al eliminar el envío";
   }
}
