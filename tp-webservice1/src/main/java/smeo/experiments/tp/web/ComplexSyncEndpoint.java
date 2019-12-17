package smeo.experiments.tp.web;

import com.testplatform.springsoap.gen.GetOneServiceComplexSyncRequest;
import com.testplatform.springsoap.gen.GetOneServiceComplexSyncResponse;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import java.util.Random;

@Endpoint
public class ComplexSyncEndpoint {

    private static final String NAMESPACE_URI = "http://www.testplatform.com/springsoap/gen";
    Random random = new Random(System.nanoTime());

    public ComplexSyncEndpoint() {
    }

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "getOneServiceComplexSyncRequest")
    @ResponsePayload
    public GetOneServiceComplexSyncResponse getComplexSync(@RequestPayload GetOneServiceComplexSyncRequest request) {
        GetOneServiceComplexSyncResponse response = new GetOneServiceComplexSyncResponse();
        method2(response);
        response.setEndMethod1(System.currentTimeMillis());
        method4(response);
        return response;
    }

    private void method4(GetOneServiceComplexSyncResponse response) {
        try {
            Thread.sleep(random.nextInt(300));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        response.setEndMethod4(System.currentTimeMillis());
    }

    private void method2(GetOneServiceComplexSyncResponse response) {
        try {
            Thread.sleep(random.nextInt(1000));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        method3(response);
        response.setEndMethod2(System.currentTimeMillis());
    }

    private void method3(GetOneServiceComplexSyncResponse response) {
        try {
            Thread.sleep(50);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        response.setEndMethod3(System.currentTimeMillis());
    }
}