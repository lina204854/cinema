-- 1. Создание базы данных
CREATE DATABASE IF NOT EXISTS cinema_db
CHARACTER SET utf8mb4
COLLATE utf8mb4_unicode_ci;

-- 2. Переключение на созданную базу данных
USE cinema_db;

-- 3. Создание таблицы для сеансов
CREATE TABLE IF NOT EXISTS movie_sessions (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    movie_title VARCHAR(255) NOT NULL,
    studio VARCHAR(255),
    session_date_time DATETIME NOT NULL,
    ticket_count INT NOT NULL
);

-- 4. Добавление тестовых данных
INSERT INTO movie_sessions (movie_title, studio, session_date_time, ticket_count) VALUES
('Дюна: Часть вторая', 'Warner Bros.', '2024-03-15 18:00:00', 120),
('Оппенгеймер', 'Universal Pictures', '2024-03-15 21:00:00', 95),
('Барби', 'Warner Bros.', '2024-03-16 15:30:00', 150),
('Дюна: Часть вторая', 'Warner Bros.', '2024-03-16 20:00:00', 110),
('Мастер и Маргарита', 'Марс Медиа', '2024-03-17 19:00:00', 80);
