package com.zab.easy_sankhya_api.client;

import com.zab.easy_sankhya_api.model.Login;
import com.zab.easy_sankhya_api.model.LoginResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name = "loginClient", url = "https://snkbrt01777.ativy.com/mge/service.sbr")
public interface LoginClient {

    @PostMapping("?serviceName=MobileLoginSP.login&outputType=json")
    LoginResponse fazerLogin(@RequestBody Login loginRequest);
}
