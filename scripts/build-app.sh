#!/usr/bin/env bash

set -euo pipefail

./gradlew clean bootJar --no-daemon
