package com.zab.easy_sankhya_api.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ConsultaRequest {
    private RequestBody requestBody;

    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    public static class RequestBody {
        private String sql;
    }
}