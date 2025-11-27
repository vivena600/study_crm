-- ==========================================
-- 3. Таблица пользователей (users)
-- ==========================================
-- Хранит основную информацию для личного кабинета и профиля:
--  - ФИО
--  - Дата рождения
--  - Телефон
--  - Email
--  - Ссылка на фото/аватар (при необходимости)
-- ------------------------------------------
CREATE TABLE IF NOT EXISTS users
(
    id            UUID PRIMARY KEY,
    first_name    VARCHAR(100) NOT NULL,
    last_name     VARCHAR(100) NOT NULL,
    middle_name   VARCHAR(100), -- Отчество, может быть NULL
    date_of_birth DATE,
    phone_number  VARCHAR(20),  -- Может быть NULL, если регистрация по email
    email         VARCHAR(255), -- Может быть NULL, если регистрация по телефону
    photo_url     VARCHAR(512), -- Ссылка на фото
    created_at    TIMESTAMP    NOT NULL DEFAULT CURRENT_TIMESTAMP
    );




