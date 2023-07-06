#!/usr/bin/env bash

BASEDIR=$(dirname "$0")

(
  cd "$BASEDIR/.." || exit; \
  ./gradlew framework.backend:build \
  framework.frontend:build \
  framework.furniture:build \
  framework.renderer:build \
  framework.utilities:build
)
