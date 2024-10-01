# demo-prices

Hello welcome to this little spring-boot project

## Requirements

1. java 21
2. gradle
3. docker (optional)

## Build

To build the project there are two options, you can execute the following commands
```
./gradlew clean build
```
optional to build docker
```
docker build -t demo-prices .
```
or execute the build script
```
docker-build.sh
```
## Run
### Jar file
```
java -jar build/libs/demo-prices-0.0.1-SNAPSHOT.jar
```

### Docker image
```
docker run -p 8080:8080 demo-prices
```

## How to Call the api

There is **swagger ui** at http://localhost:8080/swagger-ui/index.html available

Here there is an example with curl
```
curl --request POST \
--url http://localhost:8080/api/prices/search \
--header 'Content-Type: application/json' \
--data '{
"applicationDate" : "2020-06-15T10:00:00",
"brandId": 1,
"productId": 35455
}'
```
You will get something like:
```
{
"productId": 35455,
"brandId": 1,
"priceId": 3,
"startDate": "2020-06-15T00:00:00",
"endDate": "2020-06-15T11:00:00",
"price": 30.5,
"currency": "EUR"
}
```