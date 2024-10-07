package com.zab.easy_sankhya_api.client;

import com.zab.easy_sankhya_api.model.ConsultaRequest;
import com.zab.easy_sankhya_api.model.ConsultaResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "consultaClient", url = "https://snkbrt01777.ativy.com/mge/service.sbr")
public interface ConsultaClient {

    @GetMapping("?serviceName=DbExplorerSP.executeQuery&outputType=json")
    ConsultaResponse executeQuery(
            @RequestHeader("Cookie") String jsessionId,  // JSESSIONID no cabeçalho
            @RequestParam("mgeSession") String mgeSession, // mgeSession na URL
            @RequestParam("sql") String sqlQuery, // SQL como parâmetro de consulta
            @RequestBody ConsultaRequest consultaRequest
            );
}
