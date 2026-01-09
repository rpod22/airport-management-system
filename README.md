# Airport Management System (AMS)

Projekt zaliczeniowy z przedmiotu **Inżynieria Oprogramowania**  
Kierunek: Informatyka  
Technologia: Java + Spring Boot

Autorzy:
- Radosław Podgórski
- Kacper Putyra
- Szymon Kaletka

---

## 1. Opis projektu

Airport Management System (AMS) to backendowy system informatyczny wspierający podstawowe procesy operacyjne lotniska, takie jak:
- zarządzanie lotami,
- obsługa pasażerów,
- zarządzanie personelem,
- planowanie grafików pracy,
- zarządzanie infrastrukturą (bramki).

Projekt stanowi **częściową implementację produktu komercyjnego**, zgodnie z założeniami raportu końcowego. Celem projektu nie było stworzenie pełnego systemu produkcyjnego, lecz wykonanie działającego **proof-of-concept** pokazującego architekturę, strukturę i kluczowe funkcjonalności systemu.

---

## 2. Zakres funkcjonalny

### Zaimplementowane funkcjonalności:
- REST API
- zarządzanie lotami (Flight)
- zarządzanie bramkami (Gate)
- obsługa pasażerów (Passenger)
- zarządzanie personelem (Staff)
- planowanie zmian (Shift)
- podstawowa autoryzacja
- walidacja danych
- globalna obsługa błędów
- relacyjna baza danych MySQL
- JPA / Hibernate

### Poza zakresem implementacji:
- interfejs użytkownika (UI)
- rzeczywisty podział na mikroserwisy (osobne aplikacje)
- API Gateway
- Docker / Kubernetes
- zaawansowane raportowanie
- pełne mechanizmy bezpieczeństwa (JWT, OAuth2)

---

## 3. Architektura systemu

System został zrealizowany jako **jedna aplikacja Spring Boot**, która **symuluje architekturę mikroserwisową** poprzez logiczny podział na moduły:

- passengerService
- flight
- gate
- staff
- shift
- authorization

Każdy moduł posiada własne:
- kontrolery (`controller`)
- serwisy (`service`)
- repozytoria (`repository`)
- modele (`model`)
- DTO (`dto`)

Takie podejście pozwala w przyszłości łatwo wydzielić każdy moduł jako osobny mikroserwis.

---

## 4. Struktura projektu

├── AirportManagmentApplication.java
├── passengerService
│ ├── controller
│ ├── service
│ ├── repository
│ ├── model
│ ├── dto
│ └── exception
├── flight
├── gate
├── staff
├── shift
└── authorization

---

## 5. Wykorzystane technologie

- Java 17
- Spring Boot 4.x
- Spring Web
- Spring Data JPA
- Hibernate
- MySQL
- Maven

---

## 6. Konfiguracja i uruchomienie

### Wymagania:
- Java 17+
- MySQL
- Maven

### Baza danych:
Utworzyć bazę danych w MySQL, np.:

```sql
CREATE DATABASE ams_passengers;
```

Konfiguracja:

Plik application.yml zawiera konfigurację połączenia z bazą danych.

Uruchomienie:
mvn clean install
mvn spring-boot:run


Aplikacja uruchamia się domyślnie na porcie:

http://localhost:8081

7. Przykładowe endpointy
   Gates

POST /api/gates

GET /api/gates

PATCH /api/gates/{code}/deactivate

Flights

POST /api/flights

GET /api/flights

PATCH /api/flights/{flightNumber}/status/{status}

POST /api/flights/{flightId}/gate/{gateId}

Passengers

POST /api/passengers

GET /api/passengers

PATCH /api/passengers/{id}/check-in

PATCH /api/passengers/{id}/assign-flight/{flightNumber}

Staff / Shift

POST /api/staff

POST /api/shifts





8. Testowanie

Projekt był testowany manualnie przy użyciu:

Postman

logów aplikacji

weryfikacji poprawności zapisu danych w bazie MySQL

9. Ograniczenia projektu

Projekt jest demonstracją architektury i koncepcji systemu AMS.

Nie wszystkie wymagania biznesowe zostały zaimplementowane.

Brak interfejsu użytkownika.

Brak pełnej separacji mikroserwisów.

Brak konteneryzacji.