# email-server-stub

This project is still a work in progress!

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
