#!/bin/bash
while :
do
	eval 'curl --header "content-type: text/xml" -d @complexasync_request.xml http://localhost:8080/ws'
	sleep $((RANDOM % 2))
done