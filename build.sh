#!/usr/bin/env bash

./gradlew framework.backend:build \
framework.frontend:build \
framework.furniture:build \
framework.renderer:build \
framework.utilities:build
