package com.example.donaton.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.donaton.model.Transporte;
import com.example.donaton.repository.TransporteRepository;

@Service
public class TransporteService {

   private TransporteRepository transporteRepository;

   public TransporteService(TransporteRepository transporteRepository) {
       this.transporteRepository = transporteRepository;
   }

   public List<Transporte> getTransportes(){
       return transporteRepository.listarTodos();
   }

   public Transporte getTransporteById(Long id){
       if(id != null){
           return transporteRepository.buscarPorId(id);
       }
       return null;
   }

   public Transporte saveTransporte(Transporte transporte){
       if(transporteRepository.buscarPorId(transporte.getId()) == null){
           return transporteRepository.guardarTransporte(transporte);
       }
       return null;
   }

   public Transporte updateTransporte(Transporte transporte){
       if(transporte != null){
           return transporteRepository.editarTransporte(transporte);
       }
       return null;
   }

   public String deleteTransporte(Long id){
       if(transporteRepository.eliminarPorId(id)){
           return "Transporte eliminado";
       }
       return "Error al eliminar el transporte";
   }
}
