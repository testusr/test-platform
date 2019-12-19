package smeo.experiments.tp.web;

import com.testplatform.springsoap.gen.GetOneServiceSimpleSyncRequest;
import com.testplatform.springsoap.gen.GetOneServiceSimpleSyncResponse;
import io.micrometer.core.annotation.Timed;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;
import smeo.experiments.tp.web.aspect.Traced;

@Endpoint
@Timed(extraTags = {"endpoint", "complexAsync", "service", "web_a"})
public class SimpleSyncEndpoint {

        private static final String NAMESPACE_URI = "http://www.testplatform.com/springsoap/gen";

        public SimpleSyncEndpoint(){
        }

        @PayloadRoot(namespace = NAMESPACE_URI, localPart = "getOneServiceSimpleSyncRequest")
        @ResponsePayload
        @Timed(extraTags = {"service", "web_a"})
        @Traced
        public GetOneServiceSimpleSyncResponse getSimpleSync(@RequestPayload GetOneServiceSimpleSyncRequest request){
            GetOneServiceSimpleSyncResponse response = new GetOneServiceSimpleSyncResponse();
            response.setEndMethod(System.currentTimeMillis());
            return response;
        }
    }