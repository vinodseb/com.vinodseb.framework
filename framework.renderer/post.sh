#!/bin/sh

curl -X POST "localhost:8081/page" -H "Content-Type: application/json" -d "{title: \"Some Random Title\"}"