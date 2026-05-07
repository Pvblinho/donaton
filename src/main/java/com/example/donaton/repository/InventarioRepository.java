package com.example.donaton.repository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.example.donaton.model.Inventario;


@Repository
public class InventarioRepository {
   private List<Inventario> inventarios = new ArrayList<>();

   public List<Inventario> listarTodos(){
       return this.inventarios;
    }
    public Inventario buscarPorId(Long id){
         return this.inventarios.stream().filter(inventario -> inventario.getId().equals(id)).findFirst().orElse(null);
    }
    public Inventario guardarInventario(Inventario inventario){
         this.inventarios.add(inventario);
         return inventario;
    }
    public Inventario editarInventario(Inventario inventario){
         int index = this.inventarios.indexOf(buscarPorId(inventario.getId()));
         if(index != -1){
              this.inventarios.set(index, inventario);
              return inventario;
         }
         return null;
    }
    public boolean eliminarPorId(Long id){
         return this.inventarios.removeIf(inventario -> inventario.getId().equals(id));
    }
}
