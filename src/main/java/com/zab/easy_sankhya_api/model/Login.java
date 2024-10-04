package com.zab.easy_sankhya_api.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Login {

    @JsonProperty("serviceName")
    private String serviceName;

    @JsonProperty("requestBody")
    private RequestBody requestBody;

    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    public static class RequestBody {

        @JsonProperty("NOMUSU")
        private NomeUsuario nomeUsuario;

        @JsonProperty("INTERNO")
        private Interno interno;

        @JsonProperty("KEEPCONNECTED")
        private KeepConnected keepConnected;

        @Data
        @NoArgsConstructor
        @AllArgsConstructor
        public static class NomeUsuario {
            @JsonProperty("$")
            private String value;
        }

        @Data
        @NoArgsConstructor
        @AllArgsConstructor
        public static class Interno {
            @JsonProperty("$")
            private String value;
        }

        @Data
        @NoArgsConstructor
        @AllArgsConstructor
        public static class KeepConnected {
            @JsonProperty("$")
            private String value;
        }
    }
}
