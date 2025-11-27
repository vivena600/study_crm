package org.ugatu;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.ugatu.dto.CreateStudentDto;
import org.ugatu.dto.FullStudentDto;
import org.ugatu.dto.ShortStudentDto;
import org.ugatu.exception.NotFoundException;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Transactional
@Slf4j
public class StudentServiceImpl implements StudentService {
    private final StudentRepository studentRepository;
    private final StudentMapper studentMapper;

    @Override
    public FullStudentDto createdStudent(CreateStudentDto dto) {
        log.info("Created student:{}", dto.toString());
        Student entity = studentMapper.toCreatedEntity(dto);
        return studentMapper.toFullStudentDto(studentRepository.save(entity));
    }

    @Transactional(readOnly = true)
    @Override
    public List<ShortStudentDto> getAllStudents() {
        log.info("Get all students");
        return studentRepository.findAll().stream()
                .map(studentMapper::toShortStudentDto)
                .collect(Collectors.toList());
    }

    @Transactional(readOnly = true)
    @Override
    public FullStudentDto getStudentById(UUID id) {
        log.info("Get student by id {}", id);
        Student entity = findStudentById(id);
        return studentMapper.toFullStudentDto(entity);
    }

    @Override
    public FullStudentDto updateStudyDto(UUID id, CreateStudentDto dto) {
        log.info("Update student by id {}", id);
        Student student = findStudentById(id);

        Optional.ofNullable(dto.getDateOfBirth()).ifPresent(student::setDateOfBirth);
        Optional.ofNullable(dto.getEmail()).ifPresent(student::setEmail);
        Optional.ofNullable(dto.getFirstName()).ifPresent(student::setFirstName);
        Optional.ofNullable(dto.getLastName()).ifPresent(student::setLastName);
        Optional.ofNullable(dto.getMiddleName()).ifPresent(student::setMiddleName);
        Optional.ofNullable(dto.getPhoneNumber()).ifPresent(student::setPhoneNumber);
        Optional.ofNullable(dto.getPhotoUrl()).ifPresent(student::setPhotoUrl);

        return studentMapper.toFullStudentDto(studentRepository.save(student));
    }

    private Student findStudentById(UUID id) {
        return studentRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Student with id " + id + " does not exist"));
    }
}
