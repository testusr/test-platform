package smeo.experiments.tp.web;

import io.micrometer.core.instrument.ImmutableTag;
import io.micrometer.core.instrument.MeterRegistry;
import io.micrometer.core.instrument.Metrics;
import io.micrometer.core.instrument.Tag;
import io.micrometer.core.instrument.binder.jvm.JvmGcMetrics;
import io.micrometer.core.instrument.binder.jvm.JvmMemoryMetrics;
import io.micrometer.core.instrument.binder.jvm.JvmThreadMetrics;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.ArrayList;
import java.util.List;

/**
 * Starting out SOAP service
 *
 */

@SpringBootApplication
public class App
{
    private MeterRegistry registry;

    @Autowired
    public void setRegistry(MeterRegistry registry) {
        this.registry = registry;
        System.out.println("######## ‚registry set '"+registry+"'");
        Metrics.addRegistry(registry);

        List<Tag> tags = new ArrayList<>();
        tags.add(new ImmutableTag("service", "web_a"));
        new JvmMemoryMetrics(tags).bindTo(registry);
        new JvmGcMetrics(tags).bindTo(registry);
        new JvmThreadMetrics(tags).bindTo(registry);
    }

    public static void main(String[] args )
    {
        SpringApplication.run(App.class, args);
    }


}
