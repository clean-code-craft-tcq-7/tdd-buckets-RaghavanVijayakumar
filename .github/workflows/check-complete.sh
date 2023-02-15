#!/bin/bash
set -e

if grep -q input *.md; then
  echo "Replaced"
  exit 1
fi
