# Rest Service application

This project is developed with Java 17 and above and built using Spring Boot 3.2.2. Hibernate 6 and above were used for database operations.

`startup.sh` is used to compile and run the project.

The project uses port: `8080`

API to request: http://localhost:8080/api/v1/rates

type parameters: `FOREX, BANKNOTE, CROSS, INFORMATION, or null`

createdDate: When the Date Range or Blank is passed, the latest records are fetched 

currencyCode: Other parameters can be accessed when Multiple Currency Code or Empty is passed).
Bringing all records accordingly 

Example: http://localhost:8080/api/v1/rates?currencyCode=USD

