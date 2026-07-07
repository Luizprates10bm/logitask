package com.techflow.logitask.repository;

import com.techflow.logitask.model.Tarefa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface TarefaRepository extends JpaRepository<Tarefa, Long> {
    
    // Método customizado para buscar tarefas vinculadas a uma placa específica (Mecanismo da mudança de escopo)
    List<Tarefa> findByPlacaVeiculo(String placaVeiculo);
}
