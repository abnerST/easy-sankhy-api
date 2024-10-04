package com.zab.easy_sankhya_api.service;

import com.zab.easy_sankhya_api.model.Login;
import com.zab.easy_sankhya_api.client.LoginClient;
import com.zab.easy_sankhya_api.model.LoginResponse;
import org.springframework.stereotype.Service;

@Service
public class LoginService {

    private final LoginClient loginClient;

    public LoginService(LoginClient loginClient) {
        this.loginClient = loginClient;
    }

    public LoginResponse realizarLogin(String usuario, String senha, String keepConnected) {
        // Criação do objeto Login com os dados do usuário
        Login loginRequest = new Login(
                "MobileLoginSP.login",
                new Login.RequestBody(
                        new Login.RequestBody.NomeUsuario(usuario),
                        new Login.RequestBody.Interno(senha),
                        new Login.RequestBody.KeepConnected(keepConnected)
                )
        );

        // Faz a requisição de login e retorna a resposta
        return loginClient.fazerLogin(loginRequest);
    }
}
