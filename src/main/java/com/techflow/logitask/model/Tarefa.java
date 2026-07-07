package com.techflow.logitask.model;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "tarefas")
public class Tarefa {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String titulo;

    private String descricao;
    
    @Column(nullable = false)
    private String prioridade; // Baixa, Média ou Alta

    @Column(nullable = false)
    private String status; // A_FAZER, EM_PROGRESSO, CONCLUIDO

    private String placaVeiculo; // Atributo adicionado para atender a mudança de escopo da frota

    private LocalDate dataCriacao;

    // Método que roda automaticamente antes de salvar no banco para preencher a data e o status padrão
    @PrePersist
    protected void onCreate() {
        this.dataCriacao = LocalDate.now();
        if (this.status == null) {
            this.status = "A_FAZER";
        }
    }

    // Métodos Getters e Setters para a manipulação dos dados
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getTitulo() { return titulo; }
    public void setTitulo(String titulo) { this.titulo = titulo; }

    public String getDescricao() { return descricao; }
    public void setDescricao(String descricao) { this.descricao = descricao; }

    public String getPrioridade() { return prioridade; }
    public void setPrioridade(String prioridade) { this.prioridade = prioridade; }

    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }

    public String getPlacaVeiculo() { return placaVeiculo; }
    public void setPlacaVeiculo(String placaVeiculo) { this.placaVeiculo = placaVeiculo; }

    public LocalDate getDataCriacao() { return dataCriacao; }
    public void setDataCriacao(LocalDate dataCriacao) { this.dataCriacao = dataCriacao; }
}
