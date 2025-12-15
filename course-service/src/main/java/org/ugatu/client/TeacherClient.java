package org.ugatu.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.UUID;

@FeignClient(name = "teacher-service", url = "http://localhost:8082/teacher")
public interface TeacherClient {

    @GetMapping("{id}")
    ResponseEntity<Void> checkTeacherExists(@PathVariable("id") UUID teacherId);
}
