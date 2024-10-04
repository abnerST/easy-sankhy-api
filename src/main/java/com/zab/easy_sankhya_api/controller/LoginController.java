package com.zab.easy_sankhya_api.controller;

import com.zab.easy_sankhya_api.model.LoginResponse;
import com.zab.easy_sankhya_api.service.LoginService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/login")
public class LoginController {

    private final LoginService loginService;

    public LoginController(LoginService loginService) {
        this.loginService = loginService;
    }

    /**
     * Endpoint para fazer login.
     * @param username Nome do usuário.
     * @param password Senha do usuário.
     * @param keepConnected Indica se a conexão deve ser mantida.
     * @return Retorna a resposta do serviço de login.
     */
    @PostMapping
    public ResponseEntity<LoginResponse> login(
            @RequestParam(value = "username") String username,
            @RequestParam(value = "password") String password,
            @RequestParam(defaultValue = "N") String keepConnected) {

        // Chama o serviço de login
        LoginResponse response = loginService.realizarLogin(username, password, keepConnected);

        // Verifica o status da resposta e retorna o status HTTP adequado
        if (response.getStatus().equals("1")) {
            return ResponseEntity.ok(response);  // HTTP 200 OK
        } else {
            return ResponseEntity.status(401).body(response);  // HTTP 401 Unauthorized
        }
    }
}
