# email-server-stub

A simple java email server intended for automated testing.

## Objectives

* Provide a simple Mock / Stub email SMTP server for testing
* Provide a simple http client to access emails submitted via the Stub Email Server for verification

## Contains

* Email-Server (Stub)

A simple java application which can be started via the `./gradlew runShadow` command.
This listens to port 25000.

* Email-Client

A simple web application which can be used to send emails and retrieve emails from the stub server.
This can be started via the command `./gradlew bootRun`.

## Run as a full service (requires Docker)

From the root of the project execute:
```
./gradlew clean build shadowJar

docker-compose up
```

### To rebuild containers from scratch

```
./rebuild-docker.sh
```

## Client API information

http://localhost:8080/swagger-ui.html

## Testing

### Send example email
```
curl -X POST --header 'Content-Type: application/json' --header 'Accept: application/json' -d '{
  "sendTo": "test@example.com",
  "subject": "test",
  "text": "my text"
}' 'http://localhost:8080/email'
```

### List emails
```
http://localhost:8080/emails
```