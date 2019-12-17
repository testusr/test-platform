Based on:
https://www.baeldung.com/spring-boot-soap-web-service


url --header "content-type: text/xml" -d @request.xml http://localhost:8080/ws | xmllint --format -

curl --header "content-type: text/xml" -d @complexasync_request.xml http://localhost:8080/ws | xmllint --format -
curl --header "content-type: text/xml" -d @complexsync_request.xml http://localhost:8080/ws | xmllint --format -
curl --header "content-type: text/xml" -d @simplesync_request.xml http://localhost:8080/ws | xmllint --format -