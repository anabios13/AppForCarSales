Задание  - Сайт продажи автомобилей.

Функциональный контекст:
1.  Список автомобилей доступных для покупки. Необходимо наличие фильтрации по критериям, сортировки, постраничного просмотра (Pagination).
2.  Краткий и детальный просмотр объявления продажи.
3.  CRUD операции объявлений. Необходимо наличие валидации вводимых данных. Ответ api должен содержать информацию почему реквест не валиден. 

Технологии:
Java 17, Spring Boot, Spring MVC (REST), Swagger/OpenAPI, Spring Data\Spring JDBC, Spring Security, PostgreSQL, Flyway/Liquibase, Gradle.
Архитектура - n-уровневая с разделением по слоям - Controller, Service, Repository и т.д. Общие вещи не дублировать - применять принципы ООП, использовать Generics.
Авторизация и 2 вида пользователей: администратор и простой пользователь. Админ видит все объявления и всех пользователей может блокировать объявления.


1.	Использовать индекс в БД на любой таблице (выбор индекса аргументировать).
2.	Покрыть серверную приложения тестами (интеграционными и модульными).
3.	Создать .dockerfile для сборки приложения в Docker образ.
4.	Создать docker-compose конфиг для запуска приложения в контейнере, также поднимать базу в Docker контейнере.
