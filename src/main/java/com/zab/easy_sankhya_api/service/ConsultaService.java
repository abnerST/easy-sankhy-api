package com.zab.easy_sankhya_api.service;

import com.zab.easy_sankhya_api.client.ConsultaClient;
import com.zab.easy_sankhya_api.model.ConsultaRequest;
import com.zab.easy_sankhya_api.model.ConsultaResponse;
import com.zab.easy_sankhya_api.model.LoginResponse;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class ConsultaService {

    private final ConsultaClient consultaClient;
    private final LoginService loginService;

    public ConsultaService(ConsultaClient consultaClient, LoginService loginService) {
        this.consultaClient = consultaClient;
        this.loginService = loginService;
    }

    public Map<String, Object> realizarConsulta(String sqlQuery, String usuario, String senha, String keepConnected) {
        // Realiza o login e obtém o JSESSIONID e o mgeSession
        LoginResponse loginResponse = loginService.realizarLogin(usuario, senha, keepConnected);
        String jsessionId = loginResponse.getResponseBody().getJsessionid().getValue() + ".master";
        String mgeSession = loginResponse.getResponseBody().getJsessionid().getValue();

        System.out.println(jsessionId);

        ConsultaRequest consultaRequest = new ConsultaRequest(new ConsultaRequest.RequestBody(sqlQuery));

        // Faz a requisição de consulta usando o JSESSIONID no Cookie e mgeSession na URL
        ConsultaResponse consultaResponse = consultaClient.executeQuery("JSESSIONID=" + jsessionId, mgeSession,sqlQuery, consultaRequest);
        System.out.println(consultaResponse+"");
        // Verifica se a resposta e o corpo da resposta são nulos
        if (consultaResponse == null || consultaResponse.getResponseBody() == null) {
            throw new IllegalStateException("A resposta da consulta está vazia ou inválida.");
        }

        // Processa a resposta para o formato desejado
        Map<String, Object> result = new HashMap<>();
        result.put("data", processarResposta(consultaResponse.getResponseBody().getFieldsMetadata(), consultaResponse.getResponseBody().getRows()));

        return result;
    }

    // Método para gerar o comando cURL
    private void gerarCurlComando(String jsessionId, String mgeSession, String sqlQuery) {
        String curlCommand = "curl --request GET \\\n" +
                "  --url 'https://snkbrt01777.ativy.com/mge/service.sbr?serviceName=DbExplorerSP.executeQuery&outputType=json&mgeSession=" + mgeSession + "' \\\n" +
                "  --header 'Cookie: JSESSIONID=" + jsessionId + "' \\\n" +
                "  --data '{\"requestBody\": {\"sql\": \"" + sqlQuery + "\"}}'";

        System.out.println("Comando cURL gerado:\n" + curlCommand);
    }

    // Método que transforma os metadados e os valores das colunas em um mapa
    private List<Map<String, Object>> processarResposta(List<Map<String, Object>> fields, List<List<Object>> rows) {
        return rows.stream().map(row -> {
            Map<String, Object> rowMap = new HashMap<>();
            for (int i = 0; i < fields.size(); i++) {
                rowMap.put(fields.get(i).get("name").toString(), row.get(i));
            }
            return rowMap;
        }).toList();
    }
}
