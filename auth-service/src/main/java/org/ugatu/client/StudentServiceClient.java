package org.ugatu.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.UUID;

@FeignClient(name = "study-service", url = "http://localhost:8081")
public interface StudentServiceClient {
    @GetMapping("/students/{id}")
    ResponseEntity<Void> checkStudentExists(@PathVariable UUID id);
}