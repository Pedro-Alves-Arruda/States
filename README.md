# States

Project for return states from specific country



\# States API



This Spring Boot API exposes endpoints to retrieve countries and states. It uses PostgreSQL as the backing database and follows a simple MVC structure (Controller -> Service -> Repository). The API accepts English parameters and returns DTOs.



\## Swagger / OpenAPI

After starting the application, you can view the API documentation and interact with the endpoints at:



\- Swagger UI: http://localhost:8080/swagger-ui/index.html

\- OpenAPI JSON: http://localhost:8080/v3/api-docs



(If you run the app on a different port, replace `8080` accordingly.)



\## Endpoints



Base path: `/api/v1`



1\) Get all countries



\- URL: `/api/v1/countries`

\- Method: GET

\- Query parameters: none

\- Response: JSON array of Country DTOs (fields: `id`, `name`)

\- Example:

&nbsp; - Request: `GET http://localhost:8080/api/v1/countries`

&nbsp; - Response: `\[{"id":"...","name":"Brazil"}, {"id":"...","name":"USA"}]`



2\) Get states by country name



\- URL: `/api/v1/states`

\- Method: GET

\- Query parameters:

&nbsp; - `country` (required) — name of the country to search (case-insensitive)

\- Response: JSON array of States DTOs (fields: `name`)

\- Example:

&nbsp; - Request: `GET http://localhost:8080/api/v1/states?country=Brazil`

&nbsp; - Response: `\[{"name":"Sao Paulo"}, {"name":"Rio de Janeiro"}]`



\## Notes about security and CORS

\- SecurityFilterChain is configured to allow all requests (public) and to enable CORS. If you change security settings, make sure to allow the Swagger UI endpoints: `/v3/api-docs/\*\*`, `/swagger-ui/\*\*`, `/swagger-ui.html`.

