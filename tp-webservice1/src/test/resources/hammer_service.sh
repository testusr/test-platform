#!/bin/bash

./run_simplesync.sh &>/dev/null &
./run_simplesync.sh &>/dev/null &
./run_simplesync.sh &>/dev/null &

./run_complexsync.sh &>/dev/null &
./run_complexsync.sh &>/dev/null &
./run_complexsync.sh &>/dev/null &

./run_complexasync.sh &>/dev/null &
./run_complexasync.sh &>/dev/null &
./run_complexasync.sh &>/dev/null &




read -p  "Press enter to terminate"

kill $(jobs -pr)