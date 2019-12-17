package smeo.experiments.tp.web;

import com.testplatform.springsoap.gen.GetOneServiceComplexAsyncRequest;
import com.testplatform.springsoap.gen.GetOneServiceComplexAsyncResponse;
import com.testplatform.springsoap.gen.GetOneServiceComplexSyncRequest;
import com.testplatform.springsoap.gen.GetOneServiceComplexSyncResponse;
import io.micrometer.core.annotation.Timed;
import org.checkerframework.checker.units.qual.Time;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.*;

@Endpoint
@Timed(extraTags = {"endpoint", "complexAsync", "service", "web_a"})
public class ComplexAsyncEndpoint {

    private static final String NAMESPACE_URI = "http://www.testplatform.com/springsoap/gen";
    Random random = new Random(System.nanoTime());

    BlockingQueue<Runnable> queue = new ArrayBlockingQueue<Runnable>(50);

    ThreadPoolExecutor executor = new ThreadPoolExecutor(2, 20, 5000, TimeUnit.MILLISECONDS, queue);

    public ComplexAsyncEndpoint() {
    }

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "getOneServiceComplexAsyncRequest")
    @ResponsePayload
    @Timed(extraTags = {"service", "web_a"})
    public GetOneServiceComplexAsyncResponse getComplexAsync(@RequestPayload GetOneServiceComplexAsyncRequest request) {
        GetOneServiceComplexAsyncResponse response = new GetOneServiceComplexAsyncResponse();
        method2(response);
        response.setEndMethod1(System.currentTimeMillis());
        return response;
    }

    private void method2(GetOneServiceComplexAsyncResponse response) {
        List<FutureTask> futureTasks = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            FutureTask newTask = new FutureTask(() -> doSomethingMethod());
            futureTasks.add(newTask);
            executor.execute(newTask);
        }

        try {
            response.setEndMethod21((long) futureTasks.get(0).get());
            response.setEndMethod22((long) futureTasks.get(1).get());
            response.setEndMethod23((long) futureTasks.get(2).get());
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
    }

    private Long doSomethingMethod() {
        long start = System.currentTimeMillis();
        try {
            Thread.sleep(random.nextInt(500));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return System.currentTimeMillis() - start;
    }
}