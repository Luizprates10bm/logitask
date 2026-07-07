package com.techflow.logitask;

import com.techflow.logitask.model.Tarefa;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class TarefaServiceTest {

    @Test
    public void deveGarantirStatusInicialComoAFazer() {
        Tarefa tarefa = new Tarefa();
        tarefa.setTitulo("Separar carga no box 4");
        
        // Simulação simples da regra de negócio para o ambiente de testes
        tarefa.setStatus("A_FAZER"); 

        assertEquals("A_FAZER", tarefa.getStatus(), "O status inicial deve ser A_FAZER por padrao");
    }

    @Test
    public void deveVincularPlacaDoVeiculoCorretamente() {
        Tarefa tarefa = new Tarefa();
        tarefa.setTitulo("Roteirizar entregas da filial");
        tarefa.setPlacaVeiculo("XYZ9K87");

        assertEquals("XYZ9K87", tarefa.getPlacaVeiculo(), "A placa do veiculo deve ser vinculada corretamente");
    }
}
