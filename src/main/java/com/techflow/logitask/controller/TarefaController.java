package com.techflow.logitask.controller;

import com.techflow.logitask.model.Tarefa;
import com.techflow.logitask.repository.TarefaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/tarefas")
public class TarefaController {

    @Autowired
    private TarefaRepository tarefaRepository;

    // Rota para criar uma nova tarefa (Create)
    @PostMapping
    public Tarefa criarTarefa(@RequestBody Tarefa tarefa) {
        return tarefaRepository.save(tarefa);
    }

    // Rota para listar todas as tarefas (Read)
    @GetMapping
    public List<Tarefa> listarTodas() {
        return tarefaRepository.findAll();
    }

    // Rota para buscar uma tarefa específica pelo ID (Read)
    @GetMapping("/{id}")
    public ResponseEntity<Tarefa> buscarPorId(@PathVariable Long id) {
        return tarefaRepository.findById(id)
                .map(tarefa -> ResponseEntity.ok().body(tarefa))
                .orElse(ResponseEntity.notFound().build());
    }

    // Rota para buscar tarefas por placa de veículo (Filtro da mudança de escopo)
    @GetMapping("/veiculo/{placa}")
    public List<Tarefa> buscarPorPlaca(@PathVariable String placa) {
        return tarefaRepository.findByPlacaVeiculo(placa);
    }

    // Rota para atualizar os dados de uma tarefa existente (Update)
    @PutMapping("/{id}")
    public ResponseEntity<Tarefa> atualizarTarefa(@PathVariable Long id, @RequestBody Tarefa tarefaDetalhes) {
        return tarefaRepository.findById(id)
                .map(tarefa -> {
                    tarefa.setTitulo(tarefaDetalhes.getTitulo());
                    tarefa.setDescricao(tarefaDetalhes.getDescricao());
                    tarefa.setPrioridade(tarefaDetalhes.getPrioridade());
                    tarefa.setStatus(tarefaDetalhes.getStatus());
                    tarefa.setPlacaVeiculo(tarefaDetalhes.getPlacaVeiculo());
                    Tarefa atualizada = tarefaRepository.save(tarefa);
                    return ResponseEntity.ok().body(atualizada);
                }).orElse(ResponseEntity.notFound().build());
    }

    // Rota para deletar uma tarefa do sistema (Delete)
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarTarefa(@PathVariable Long id) {
        return tarefaRepository.findById(id)
                .map(tarefa -> {
                    tarefaRepository.delete(tarefa);
                    return ResponseEntity.ok().<Void>build();
                }).orElse(ResponseEntity.notFound().build());
    }
}
