package com.zab.easy_sankhya_api.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;
import java.util.Map;

@Data
public class ConsultaResponse {

    @JsonProperty("serviceName")
    private String serviceName;

    @JsonProperty("status")
    private String status;

    @JsonProperty("responseBody")
    private ResponseBody responseBody;

    @JsonProperty("statusMessage")
    private String statusMessage;

    @Data
    public static class ResponseBody {

        @JsonProperty("fieldsMetadata")
        private List<Map<String, Object>> fieldsMetadata;

        @JsonProperty("rows")
        private List<List<Object>> rows;
    }
}
