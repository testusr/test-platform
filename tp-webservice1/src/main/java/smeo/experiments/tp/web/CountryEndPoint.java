package smeo.experiments.tp.web;

import com.testplatform.springsoap.gen.GetCountryRequest;
import com.testplatform.springsoap.gen.GetCountryResponse;
import io.micrometer.core.annotation.Timed;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

@Endpoint
@Timed(extraTags = {"endpoint", "complexAsync", "service", "web_a"})


public class CountryEndPoint {
    private static final String NAMESPACE_URI = "http://www.testplatform.com/springsoap/gen";
    private CountryRepository countryRepository;

    @Autowired
    public CountryEndPoint(CountryRepository countryRepository){
        this.countryRepository = countryRepository;
    }

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "getCountryRequest")
    @ResponsePayload
    public GetCountryResponse getCountry(@RequestPayload GetCountryRequest request){
        GetCountryResponse response = new GetCountryResponse();
        response.setCountry(countryRepository.findCountry(request.getName()));

        return response;
    }
}
