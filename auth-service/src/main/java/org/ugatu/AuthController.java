package org.ugatu;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.ugatu.client.StudentServiceClient;
import org.ugatu.client.TeacherServiceClient;
import org.ugatu.security.JwtUtil;

import java.util.UUID;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
@Slf4j
public class AuthController {
    private final JwtUtil jwtUtil;
    private final StudentServiceClient studentClient;
    private final TeacherServiceClient teacherClient;

    @PostMapping("/login")
    public ResponseEntity<AuthResponse> login(@RequestBody LoginRequest request) {
        log.info("Login attempt for user: {}", request.getUsername());

        String username = request.getUsername();
        String password = request.getPassword();

        // Упрощённая проверка пароля
        if (!"pass".equals(password)) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        }

        // Случай 1: менеджер
        if ("manager".equals(username)) {
            String token = jwtUtil.generateToken(UUID.randomUUID(), "MANAGER");
            return ResponseEntity.ok(new AuthResponse(token, "MANAGER"));
        }

        // Случай 2: студент
        try {
            UUID studentId = UUID.fromString(username);
            studentClient.checkStudentExists(studentId);
            String token = jwtUtil.generateToken(studentId, "STUDENT");
            return ResponseEntity.ok(new AuthResponse(token, "STUDENT"));
        } catch (Exception ignored) {
        }

        // Случай 3: преподаватель
        try {
            UUID teacherId = UUID.fromString(username);
            teacherClient.checkTeacherExists(teacherId);
            String token = jwtUtil.generateToken(teacherId, "TEACHER");
            return ResponseEntity.ok(new AuthResponse(token, "TEACHER"));
        } catch (Exception ignored) {
        }

        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
    }
}
