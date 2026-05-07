package com.example.donaton.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.donaton.model.Inventario;
import com.example.donaton.repository.InventarioRepository;

@Service
public class InventarioService {

   private InventarioRepository inventarioRepository;

   public InventarioService(InventarioRepository inventarioRepository) {
       this.inventarioRepository = inventarioRepository;
   }

   public List<Inventario> getInventarios(){
       return inventarioRepository.listarTodos();
   }

   public Inventario getInventarioById(Long id){
       if(id != null){
           return inventarioRepository.buscarPorId(id);
       }
       return null;
   }

   public Inventario saveInventario(Inventario inventario){
       if(inventarioRepository.buscarPorId(inventario.getId()) == null){
           return inventarioRepository.guardarInventario(inventario);
       }
       return null;
   }

   public Inventario updateInventario(Inventario inventario){
       if(inventario != null){
           return inventarioRepository.editarInventario(inventario);
       }
       return null;
   }

   public String deleteInventario(Long id){
       if(inventarioRepository.eliminarPorId(id)){
           return "Inventario eliminado";
       }
       return "Error al eliminar el inventario";
   }
}
