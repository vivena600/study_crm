-- таблица с информацией о курсах образовательной платформы --
CREATE TABLE IF NOT EXISTS courses
(
    id            UUID PRIMARY KEY,
    name          VARCHAR(100) NOT NULL,
    description   TEXT NOT NULL,
    status        VARCHAR(20) NOT NULL DEFAULT 'ACTIVE'
    photo_url     VARCHAR(512), -- Ссылка на фото
    start_time    TIMESTAMP,
    end_time      TIMESTAMP,
    created_at    TIMESTAMP    NOT NULL DEFAULT CURRENT_TIMESTAMP
    );

-- таблица с записью студентов на курс --
CREATE TABLE IF NOT EXISTS courses
(
    id            UUID PRIMARY KEY,
    course_id     INT NOT NULL REFERENCES courses(id) ON DELETE CASCADE,
    student_id    INT NOT NULL,
    UNIQUE(course_id, student_id)
    );

-- таблица с преподавательским составом --
CREATE TABLE IF NOT EXISTS courses
(
    id            UUID PRIMARY KEY,
    course_id     INT NOT NULL REFERENCES courses(id) ON DELETE CASCADE,
    teacher_id    INT NOT NULL,
    UNIQUE(course_id, teacher_id)
    );



