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
