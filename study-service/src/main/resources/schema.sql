CREATE TABLE IF NOT EXISTS student
(
    id            UUID PRIMARY KEY,
    first_name    VARCHAR(100) NOT NULL,
    last_name     VARCHAR(100) NOT NULL,
    middle_name   VARCHAR(100), -- Отчество, может быть NULL
    date_of_birth DATE,
    phone_number  VARCHAR(20),  -- Номер телефона для связи со студентом
    email         VARCHAR(200) UNIQUE NOT NULL,
    photo_url     VARCHAR(512), -- Ссылка на фото
    created_at    TIMESTAMP    NOT NULL DEFAULT CURRENT_TIMESTAMP
    );




