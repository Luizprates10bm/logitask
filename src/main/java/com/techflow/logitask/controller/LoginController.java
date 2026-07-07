package com.techflow.logitask.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/api/auth")
public class LoginController {

    // Endpoint simples para simular o login do operador ou gestor no LogiTask
    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody Map<String, String> credenciais) {
        String email = credenciais.get("email");
        String senha = credenciais.get("senha");

        // Simulação simples de credenciais para validação acadêmica
        if ("admin@techflow.com".equals(email) && "admin123".equals(senha)) {
            return ResponseEntity.ok("Login efetuado com sucesso! Usuário: Administrador.");
        } else if ("operador@techflow.com".equals(email) && "op123".equals(senha)) {
            return ResponseEntity.ok("Login efetuado com sucesso! Usuário: Operador de Pátio.");
        }

        return ResponseEntity.status(401).body("Credenciais inválidas. Acesso negado.");
    }
}
