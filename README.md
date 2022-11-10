# Дипломный проект по профессии «Тестировщик»

## Документация по проекту
1. [Задание по дипломному проекту.](https://github.com/netology-code/qa-diploma)
2. [План автоматизации тестирования.](https://github.com/Mozly76/QA-Diploma/blob/main/docs/Plan.md)
3. [Отчёт по итогам автоматизированного тестирования.](https://github.com/Mozly76/QA-Diploma/blob/main/docs/Report.md)
4. [Отчёт по итогам автоматизации.](https://github.com/Mozly76/QA-Diploma/blob/main/docs/Summary.md)

## Инструкция по запуску приложения и подготовке отчетов

**Примечание.** Для запуска приложения необходимы установленные [JDK 11.](https://www.oracle.com/java/technologies/downloads/#java11),  [IntelliJ IDEA.](https://www.jetbrains.com/idea/) и [Docker.](https://www.docker.com)
- Убедится, что порты 8080, 9999 и 5432 или 3306 (в зависимости от выбранной базы данных) свободны;
- Клонировать репозиторий `git clone https://github.com/Mozly76/QA-Diploma.git` с проектом;
- Запустить **Docker**;
- Открыть проект в **IntelliJ IDEA**;
- Запустить контейнеры, выполнив в Terminal **IntelliJ IDEA** команду: `docker-compose up -d`. Дождаться пока образы скачаются и контейнеры запустятся;
- Запустить SUT, выполнив в Terminal **IntelliJ IDEA** команду:
  - с использованием БД MySQL: `java "-Dspring.datasource.url=jdbc:mysql://localhost:3306/app" -jar artifacts/aqa-shop.jar`;
  - с использованием БД PostgreSQL: `java "-Dspring.datasource.url=jdbc:postgresql://localhost:5432/app" -jar artifacts/aqa-shop.jar`;
- Запустить автотесты, открыв в Terminal **IntelliJ IDEA** ноаую сессию и выполнив команду:
  - для конфигурации БД MySql: `./gradlew clean test "-Ddatasource.url=jdbc:mysql://localhost:3306/app"`;
  - для конфигурации БД PostgreSQL: `./gradlew clean test "-Ddatasource.url=jdbc:postgresql://localhost:5432/app"`;
- Запустить отчеты,выполнив в Terminal **IntelliJ IDEA** команду:`./gradlew allureServe` (запуск и открытие отчетов в браузере по уолчанию);
- Остановить SUT, перейдя в сессию Terminal **IntelliJ IDEA** с запущенным SUT и нажав комбинацией клавиш: `CTRL+C`;
- Остановить и удалить контейнеры,выполнив в Terminal **IntelliJ IDEA** команду:`docker-compose down`.