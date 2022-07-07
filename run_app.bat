mvn clean package
docker build . -t inventory_app
docker network create inventory_app-net
docker stop inventory_app_db
docker stop inventory_app_api
docker run --net inventory_app-net -e POSTGRES_PASSWORD=inventory-pw --name inventory_db -e POSTGRES_USER=inventory-user -e POSTGRES_DB=inventory-db -d --rm postgres:14.4-alpine
docker run --net inventory_app-net --name inventory_app_api -p 8080:8080 --rm inventory_app