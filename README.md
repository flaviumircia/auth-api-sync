## Details

A JWT authentication micro-service which works like an API Gateway for providing access.

It uses Spring boot with MySQL as Database.

The user password is hashed (one way function) so is securely stored inside the database.

## Database 

The database contains a single table (respecting all the normalized forms) that stores the first_name, last_name, email, hashed password and the role(user/admin).

<img src ="https://github.com/flaviumircia/auth-api-sync/assets/74871618/7d40dade-8420-4ba1-88c4-3fb11b64d596" alt ="database_schema" height="400px"/>

## Spring Project

It is an up-to-date Java 21 and Spring 3+ micro-service acting as an api Gateway for secure signing-in. It uses a JWT because it is mainly used for an Android Application, resulting in a no cookie approach.

A close design schema would be similar to this:

<img src ="https://github.com/flaviumircia/auth-api-sync/assets/74871618/9faec127-5874-48c0-9ea3-249f4340cacf" alt ="api_gateway_design" height="400px"/>
