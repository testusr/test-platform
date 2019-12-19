package smeo.experiments.tp.web.aspect;

import io.opentracing.ScopeManager;
import io.opentracing.Span;
import io.opentracing.Tracer;
import io.opentracing.util.GlobalTracer;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

@Aspect
public class TraceMethodAspect {
    @Before("@annotation(smeo.experiments.tp.web.aspect.Traced)")
    public void before(JoinPoint joinPoint) {
       Tracer tracer = GlobalTracer.get();
        Span activeSpan = tracer.activeSpan();
        Span span = tracer.buildSpan(joinPoint.getSignature().getName()).asChildOf(activeSpan).start();
        tracer.scopeManager().activate(span);
    }

    @After("@annotation(smeo.experiments.tp.web.aspect.Traced)")
    public void after(JoinPoint joinPoint) {
        Span span = GlobalTracer.get().activeSpan();
     span.finish();
   }
}
