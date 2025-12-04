CREATE TABLE IF NOT EXISTS teachers
(
    id            UUID PRIMARY KEY,
    first_name    VARCHAR(100) NOT NULL,
    last_name     VARCHAR(100) NOT NULL,
    middle_name   VARCHAR(100), -- Отчество, может быть NULL
    date_of_birth DATE,
    phone_number  VARCHAR(20),
    email         VARCHAR(255) UNIQUE NOT NULL,
    photo_url     VARCHAR(512), -- Ссылка на фото
    description   VARCHAR(512), --Описание страницы преподавателя
    job_experience INTEGER,
    created_at    TIMESTAMP    NOT NULL DEFAULT CURRENT_TIMESTAMP
    );

CREATE TABLE IF NOT EXISTS teacher_skills
(
    id            UUID PRIMARY KEY,
    teacher_id    UUID NOT NULL REFERENCES teachers(id) ON DELETE CASCADE,
    title         VARCHAR(100) NOT NULL,
    description    VARCHAR(255) NOT NULL,
    document      VARCHAR(100)
    );




