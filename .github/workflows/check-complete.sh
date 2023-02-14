#!/bin/bash
set -e

if grep -q input *.md; then
  echo "Replace all the with your input"
  exit 1
fi
