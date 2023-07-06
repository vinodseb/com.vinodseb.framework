#!/usr/bin/env bash

BASEDIR=$(dirname "$0")

(
  cd "$BASEDIR/.." || exit; \
  ./gradlew framework.backend:run \
  framework.frontend:run \
  framework.furniture:run \
  framework.renderer:run
)

