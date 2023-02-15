#!/bin/bash
set -e

if grep -q _enter *.md; then
  echo "Replaced"
  exit 1
fi
