#!/bin/bash

curl -X POST --header 'Content-Type: application/json' --header 'Accept: application/json' -d '{
  "sendTo": "test@example.com",
  "subject": "test",
  "text": "my text"
}' 'http://localhost:8080/email'