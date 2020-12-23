package pl.mondodbspeedtest.demo.aspects;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Aspect
@Component
public class TimeMeasurementAspect {

    public TimeMeasurementAspect() {
    }

    @Around("@annotation(PersonAspect)")
    private void MeasureTime(ProceedingJoinPoint joinPoint) throws Throwable {
        double start = System.currentTimeMillis();
        joinPoint.proceed();
        double stop = System.currentTimeMillis();
        System.out.println(stop - start);
    }


}
