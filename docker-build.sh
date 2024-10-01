#!/bin/bash

./gradlew clean build && docker build -t demo-prices .