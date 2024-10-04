package com.zab.easy_sankhya_api.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class LoginResponse {

    @JsonProperty("serviceName")
    private String serviceName;

    @JsonProperty("status")
    private String status;

    @JsonProperty("pendingPrinting")
    private boolean pendingPrinting;

    @JsonProperty("transactionId")
    private String transactionId;

    @JsonProperty("responseBody")
    private ResponseBody responseBody;

    @Data
    public static class ResponseBody {

        @JsonProperty("callID")
        private CallID callID;

        @JsonProperty("jsessionid")
        private JSessionID jsessionid;

        @JsonProperty("idusu")
        private IDUsu idusu;

        @Data
        public static class CallID {
            @JsonProperty("$")
            private String value;
        }

        @Data
        public static class JSessionID {
            @JsonProperty("$")
            private String value;
        }

        @Data
        public static class IDUsu {
            @JsonProperty("$")
            private String value;
        }
    }
}
