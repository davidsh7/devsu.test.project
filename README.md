# Test Devsu By David Sepulveda

Note: Run from the project root

## Step 1

docker-compose up --build

## Step 2

docker exec -i dbpostgres psql -U postgres -d devsu < ./scripts/init-script.sql

To run locally in Windows you need to create the file C:\Windows\System32\drivers\etc

127.0.0.1 dbpostgres
127.0.0.1 microservice1
