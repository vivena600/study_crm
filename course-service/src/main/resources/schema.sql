-- таблица с информацией о курсах образовательной платформы --
CREATE TABLE IF NOT EXISTS courses
(
    id            UUID PRIMARY KEY,
    title         VARCHAR(100) NOT NULL,
    description   TEXT NOT NULL,
    status        VARCHAR(20) NOT NULL DEFAULT 'ACTIVE',
    photo_url     VARCHAR(512), -- Ссылка на фото
    start_time    TIMESTAMP,
    end_time      TIMESTAMP,
    max_students  INTEGER,
    created_at    TIMESTAMP    NOT NULL DEFAULT CURRENT_TIMESTAMP
    );

-- таблица с записью студентов на курс --
CREATE TABLE IF NOT EXISTS course_students
(
    id            UUID PRIMARY KEY,
    course_id     UUID NOT NULL REFERENCES courses(id) ON DELETE CASCADE,
    student_id    UUID NOT NULL,
    UNIQUE(course_id, student_id)
    );

-- таблица с преподавательским составом --
CREATE TABLE IF NOT EXISTS course_teachers
(
    id            UUID PRIMARY KEY,
    course_id     UUID NOT NULL REFERENCES courses(id) ON DELETE CASCADE,
    teacher_id    UUID NOT NULL
    UNIQUE(course_id, teacher_id)
    );

CREATE TABLE IF NOT EXISTS lessons
(
    id UUID PRIMARY KEY,
    course_id UUID NOT NULL REFERENCES courses(id) ON DELETE CASCADE,
    title VARCHAR(255) NOT NULL,
    text_lesson TEXT,
    start_time TIMESTAMP,
    end_time TIMESTAMP,
    lesson_type VARCHAR(50),
    teacher_id UUID,
    created_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP
    );



