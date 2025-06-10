# Информационная система "Кинотеатр"

Веб-приложение для учета сеансов в кинотеатре, разработанное на Spring Boot.

## Технологический стек

*   Java 17, Spring Boot, Spring Security, Spring Data JPA
*   MySQL, Thymeleaf, HTML/CSS/JavaScript

## Как запустить проект

### 1. Подготовка базы данных

1.  Убедитесь, что у вас установлен и запущен сервер MySQL.
2.  Выполните SQL-скрипт из файла `setup.sql`. Он создаст базу данных `cinema_db` и таблицу `movie_sessions`.

### 2. Настройка подключения

1.  Откройте файл `cinema-app/src/main/resources/application.properties`.
2.  Измените строки `spring.datasource.username` и `spring.datasource.password`, указав свои данные для подключения к MySQL.

### 3. Сборка и запуск

1.  Перейдите в директорию `cd cinema-app`.
2.  Запустите приложение командой `./mvnw spring-boot:run`.
3.  Приложение будет доступно по адресу `http://localhost:8080`.

### Данные для входа

*   **Логин:** `user`
*   **Пароль:** `password`
