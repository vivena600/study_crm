package org.ugatu;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.ugatu.dto.CreateTeacherDto;
import org.ugatu.dto.FullTeacherDto;
import org.ugatu.dto.ShortTeacherDto;
import org.ugatu.dto.SkillDto;
import org.ugatu.exception.NotFoundException;
import org.ugatu.exception.ValidationRequestException;
import org.ugatu.repository.TeacherRepository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Transactional
@Slf4j
public class TeacherServiceImpl implements TeacherService {
    private final TeacherRepository teacherRepository;
    private final TeacherMapper teacherMapper;
    private final SkillService skillService;

    @Override
    public FullTeacherDto createdTeacher(CreateTeacherDto dto) {
        log.info("Created teacher:{}", dto.toString());
        checkEmail(dto);

        Teacher teacher = teacherMapper.toEntity(dto);
        teacher.setCreatedAt(LocalDateTime.now());
        return teacherMapper.toFullTeacherDto(teacherRepository.save(teacher), null);
    }

    @Transactional(readOnly = true)
    @Override
    public List<ShortTeacherDto> getAllTeachers() {
        log.info("Get all teachers");
        return teacherRepository.findAll().stream()
                .map(teacherMapper::toShortTeacherDto)
                .collect(Collectors.toList());
    }

    @Transactional(readOnly = true)
    @Override
    public FullTeacherDto getTeacherById(UUID id) {
        log.info("Get teacher by id {}", id);
        Teacher teacher = findTeacherById(id);
        teacher.setCreatedAt(LocalDateTime.now());
        return teacherMapper.toFullTeacherDto(teacher, findSkillsByTeacher(id));
    }

    @Override
    public FullTeacherDto updateTeacher(UUID id, CreateTeacherDto dto) {
        log.info("Update teacher by id {}", id);
        Teacher teacher = findTeacherById(id);
        checkEmail(dto);

        Optional.ofNullable(dto.getDateOfBirth()).ifPresent(teacher::setDateOfBirth);
        Optional.ofNullable(dto.getEmail()).ifPresent(teacher::setEmail);
        Optional.ofNullable(dto.getFirstName()).ifPresent(teacher::setFirstName);
        Optional.ofNullable(dto.getLastName()).ifPresent(teacher::setLastName);
        Optional.ofNullable(dto.getPhoneNumber()).ifPresent(teacher::setPhoneNumber);
        Optional.ofNullable(dto.getMiddleName()).ifPresent(teacher::setMiddleName);
        Optional.ofNullable(dto.getPhotoUrl()).ifPresent(teacher::setPhotoUrl);
        Optional.ofNullable(dto.getDescription()).ifPresent(teacher::setDescription);
        Optional.ofNullable(dto.getExperience()).ifPresent(teacher::setExperience);

        return teacherMapper.toFullTeacherDto(teacher, findSkillsByTeacher(id));
    }

    private Teacher findTeacherById(UUID id) {
        return teacherRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Teacher with id " + id + " does not exist"));
    }

    private List<SkillDto> findSkillsByTeacher(UUID teacherId) {
        return skillService.listSkills(teacherId);
    }

    private void checkEmail(CreateTeacherDto dto) {
        if (teacherRepository.existsTeacherByEmail(dto.getEmail())) {
            throw new ValidationRequestException("Преподаватель с таким аккаунтом уже существует");
        }
    }
}
