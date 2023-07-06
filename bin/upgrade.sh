#!/usr/bin/env bash

BASEDIR=$(dirname "$0")

(
  cd "$BASEDIR/.." || exit; \
  ./gradlew dependencyUpdates -Drevision=release
)
