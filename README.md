Filters Application
* Run test endpoint - http://localhost:8080/filters
* Java 21 (LTS)

# Run
1. In docker/db directory run `docker-compose up -d`
2. (TODO: make automatic) Run SQL-s in init-scripts
3. Run application

# To Do
1. Add logging config
2. Add exception handler
3. Add Schema creation to liquibase
4. Fix autoloading of docker SQL scripts
5. Unit Tests, IntegTests

# Debug
## Database connection
Connect Management studio
* Server: localhost
* User: sa
* PW: p7HxlQs30aii2ywBR

# Business logic
## GET /filters
* return list of filters with criteria

## POST /filter
* Add filter with criteria