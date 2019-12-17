package smeo.experiments.tp.web;

import com.testplatform.springsoap.gen.GetOneServiceSimpleSyncRequest;
import com.testplatform.springsoap.gen.GetOneServiceSimpleSyncResponse;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

@Endpoint
public class SimpleSyncEndpoint {

        private static final String NAMESPACE_URI = "http://www.testplatform.com/springsoap/gen";

        public SimpleSyncEndpoint(){
        }

        @PayloadRoot(namespace = NAMESPACE_URI, localPart = "getOneServiceSimpleSyncRequest")
        @ResponsePayload
        public GetOneServiceSimpleSyncResponse getSimpleSync(@RequestPayload GetOneServiceSimpleSyncRequest request){
            GetOneServiceSimpleSyncResponse response = new GetOneServiceSimpleSyncResponse();
            response.setEndMethod(System.currentTimeMillis());
            return response;
        }
    }