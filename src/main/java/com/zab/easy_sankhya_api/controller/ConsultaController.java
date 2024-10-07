package com.zab.easy_sankhya_api.controller;

import com.zab.easy_sankhya_api.service.ConsultaService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
public class ConsultaController {

    private final ConsultaService consultaService;

    public ConsultaController(ConsultaService consultaService) {
        this.consultaService = consultaService;
    }

    @GetMapping("/consultar")
    public Map<String, Object> consultar(
            @RequestParam String sqlQuery,
            @RequestParam String usuario,
            @RequestParam String senha,
            @RequestParam String keepConnected) {

        // Chama o serviço de consulta que faz login e executa a consulta
        return consultaService.realizarConsulta(sqlQuery, usuario, senha, keepConnected);
    }
}
