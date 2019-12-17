Based on:
https://www.baeldung.com/spring-boot-soap-web-service


url --header "content-type: text/xml" -d @request.xml http://localhost:8080/ws | xmllint --format -