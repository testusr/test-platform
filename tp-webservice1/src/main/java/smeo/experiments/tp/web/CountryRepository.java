package smeo.experiments.tp.web;

import com.testplatform.springsoap.gen.Country;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.HashMap;
import java.util.Map;

@Component
public class CountryRepository {
    private static final Map<String, Country> countries = new HashMap<>();

    @PostConstruct
    public void initData(){

    }

    public Country findCountry(String name){
        return countries.get(name);
    }
}
