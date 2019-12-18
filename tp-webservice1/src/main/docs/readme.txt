Based on:
https://www.baeldung.com/spring-boot-soap-web-service


url --header "content-type: text/xml" -d @request.xml http://localhost:8080/ws | xmllint --format -

curl --header "content-type: text/xml" -d @complexasync_request.xml http://localhost:8080/ws | xmllint --format -
curl --header "content-type: text/xml" -d @complexsync_request.xml http://localhost:8080/ws | xmllint --format -
curl --header "content-type: text/xml" -d @simplesync_request.xml http://localhost:8080/ws | xmllint --format -


docker start influxdb
docker exec -it influxdb influx


-- opentracing
https://www.youtube.com/watch?v=RvCcWltMY7U
https://www.hawkular.org/blog/2017/06/9/opentracing-spring-boot.html

docker run -p 9411:9411 openzipkin/zipkin
http://localhost:9411/zipkin


async -
 - reference types - childOf, followsFrom (kicked off but parent does not wait)
-- zipkin

