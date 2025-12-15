package org.ugatu.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.UUID;

@FeignClient(name = "student-service", url = "http://localhost:8081/students")
public interface StudentClient {

    @GetMapping("{id}")
    ResponseEntity<Void> checkStudentExists(@PathVariable("id") UUID teacherId);
}
