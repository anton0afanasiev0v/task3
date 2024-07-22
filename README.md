Task3
=====

Spring boot application

## Start up

```
docker-compose up --build
```

or

```
docker build
docker-compose up
```

Created two profiles local and dev

### Swagger

Consumer
http://localhost:8081/api/swagger-ui/index.html

Producer
http://localhost:8082/api/swagger-ui/index.html

## Задание:

Тема: Реализация системы мониторинга с использованием Spring Kafka

## Цель:

Создать систему мониторинга, которая будет отслеживать работу различных компонентов вашего приложения с помощью Spring Kafka. Эта система будет включать в себя Producer для отправки метрик, Consumer
для их обработки и анализа, а также REST API для просмотра метрик.

## Общая архитектура системы:

### Producer Service:

Создать микросервис "Metrics Producer", который будет отслеживать и собирать метрики работы приложения и отправлять их в Kafka топик "metrics-topic".

### Реализовать следующие API для взаимодействия с микросервисом:

POST /metrics: Отправка метрик работы приложения в формате JSON. Метрики могут включать информацию о производительности, использовании ресурсов, ошибках и т. д.

### Consumer Service:

Создать микросервис "Metrics Consumer", который будет принимать метрики из Kafka топика "metrics-topic" и анализировать их для выявления проблем и трендов.

Реализовать обработку метрик и вывод статистики в логи или базу данных для последующего анализа.

#### REST API:

Реализовать REST API в микросервисе "Metrics Consumer" для просмотра метрик.
GET /metrics: Получение списка всех метрик.
GET /metrics/{id}: Получение конкретной метрики по ее идентификатору.

### Критерии успешного выполнения:

Микросервисы должны успешно обмениваться данными через Kafka и обеспечивать сбор и анализ метрик работы приложения.
API должно быть хорошо спроектировано, документировано и соответствовать принципам RESTful.
Система должна быть масштабируемой, надежной и обладать высокой производительностью.
Должна быть предоставлена документация, объясняющая архитектуру системы, конфигурацию Kafka, а также инструкции по запуску и использованию системы.