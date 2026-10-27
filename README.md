# bank-teller-channel

**Channel server** for a bank branch teller terminal demo.
It provides REST APIs called by teller screens built with WebSquare.

> This is a personal learning project. It contains no code or data from any real financial institution.

## Architecture

```
[WebSquare screens]  --JSON/HTTP-->  [Channel server (this repo)]  -->  [PostgreSQL]
```

## Tech Stack

| Category | Technology |
| --- | --- |
| Language | Java 17 |
| Framework | Spring Boot 3.3 |
| Build | Maven (Wrapper, Maven 3.9.9) |
| Database | PostgreSQL, MyBatis (planned) |

## Getting Started

**Requirements:** JDK 17 or later

```bash
./mvnw spring-boot:run
```

The server runs at `http://localhost:8090`.

## Progress

- [x] Project setup
- [ ] Common response format and exception handling
- [ ] WebSquare request handling and CORS
- [ ] PostgreSQL connection
- [ ] MyBatis mappers
- [ ] Transaction services (deposit, withdrawal, account opening, cancellation)
- [ ] REST APIs
- [ ] Tests (including concurrent withdrawals)