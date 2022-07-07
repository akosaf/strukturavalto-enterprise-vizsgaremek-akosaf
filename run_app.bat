mvn clean package
docker build . -t inventory-app
docker network create inventory_app-net
docker stop inventory_app_db
docker stop inventory_app-api
docker run --net inventory_app-net -e POSTGRES_PASSWORD=inventory --name inventory-db -p 5432:5432 -e POSTGRES_USER=inventory -e POSTGRES_DB=inventory-db -d --rm postgres:14.4-alpine
docker run --net inventory_app-net --name inventory_app_api -p 8080:8080 --rm inventory_app

docker run -d -e SPRING_DATASOURCE_URL=jdbc:postgresql://inventory-db/inventory_db -p 8080:8080 --net inventory_app-net --name inventory-api inventory_app

docker run --net inventory_app-net -e POSTGRES_PASSWORD=inventory-pw --name inventory_db -p 5432:5432 -e POSTGRES_USER=inventory-user -e POSTGRES_DB=inventory-db -d --rm postgres:14.4-alpine

mvn -DskipTests=true package
docker build -t inventory .
cd inventory
docker compose up
docker ps

docker build . -t inventory-app

docker run --net inventory_app-net --name inventory-db -e POSTGRES_USER=inventory-db -e POSTGRES_PASSWORD=inventory-db -p 5432:5432 -d inventory-db -d --rm postgres:14.4-alpine

