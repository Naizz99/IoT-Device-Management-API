# IoT Device Management API

## Description
RESTful API built with Spring Boot to manage IoT devices using in-memory storage.

## Features
- CRUD operations
- Thread-safe in-memory store
- RESTful endpoints
- Unit tests with JUnit

## Run the Application

### Prerequisites
- Java 17+
- Maven

## Getting Started

### Clone the repository
```bash
git clone https://github.com/Naizz99/IoT-Device-Management-API.git
cd IoT-Device-Management-API
```

### Build and Run
```bash
mvn clean install
mvn spring-boot:run
```

## Sample Endpoints

### Create Device
POST -> /devices
```json
{
  "id": "101",
  "name": "Temp Sensor",
  "type": "Temperature",
  "active": true,
  "lastCommunication": "2025-04-22T10:00:00"
}
```

### Get All Devices
GET -> /devices

### Update Device
PUT -> /devices/101
```json
{
  "id": "101",
  "name": "Smart Thermostat",
  "type": "Temperature",
  "status": true,
  "lastCommunication": "2025-04-22T16:00:00"
}

```

### Delete Device
DELETE -> /devices/101

### Test
```bash
mvn test
```
