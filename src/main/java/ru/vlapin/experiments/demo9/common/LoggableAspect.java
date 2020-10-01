package ru.vlapin.experiments.demo9.common;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import lombok.val;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Slf4j
@Aspect
@Component
@RequiredArgsConstructor
public final class LoggableAspect {

//  @Order(1)
//  @Around("@annotation(ru.vlapin.experiments.demo9.common.Loggable)")
//  Object logging(ProceedingJoinPoint pjp) throws Throwable {
//    val name = pjp.getSignature().getName();
//    val args = pjp.getArgs();
//    log.info("Method {} was called with {} params", name, args);
//    val result = pjp.proceed();
//    log.info("Method {} was returned {} for {} params", name, result, args);
//    return result;
//  }
}
