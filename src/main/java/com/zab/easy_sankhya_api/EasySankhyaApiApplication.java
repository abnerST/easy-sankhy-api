package com.zab.easy_sankhya_api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients(basePackages = "com.zab.easy_sankhya_api.client")  // Pacote onde seu LoginClient está definido
public class EasySankhyaApiApplication {
	public static void main(String[] args) {
		SpringApplication.run(EasySankhyaApiApplication.class, args);
	}
}
