mvn clean -DskipTests=true package
docker build -t inventory .
cd inventory
docker compose up
cmd