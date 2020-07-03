//package com.sysco.rps.config;
//
//import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateSerializer;
//import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateTimeSerializer;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.autoconfigure.jackson.Jackson2ObjectMapperBuilderCustomizer;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.scheduling.annotation.EnableAsync;
//import org.springframework.validation.beanvalidation.MethodValidationPostProcessor;
//import org.springframework.web.servlet.HandlerInterceptor;
//import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
//import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
//
//import javax.validation.Validation;
//import javax.validation.Validator;
//import javax.validation.ValidatorFactory;
//import java.time.format.DateTimeFormatter;
//
///**
// * Created by IntelliJ IDEA. Author: rohana.kumara@sysco.com Date: 3/28/20 Time: 12:54 PM
// */
//
//@Configuration
//@EnableAsync
//public class AppConfig implements WebMvcConfigurer {
//
//    private static final String DATE_FORMAT = "yyyy-MM-dd";
//    private static final String DATE_TIME_FORMAT = "yyyy-MM-dd HH:mm:ss";
//
//
//    //  @Autowired
////  @Qualifier("requestLoggingInterceptor")
////  HandlerInterceptor requestLoggingInterceptor;
//    @Autowired
//    HandlerInterceptor correlationIdInterceptor;
//
//    @Override
//    public void addInterceptors(InterceptorRegistry registry) {
//        registry.addInterceptor(correlationIdInterceptor);
////    registry.addInterceptor(requestLoggingInterceptor);
//    }
//
//    @Bean
//    public Jackson2ObjectMapperBuilderCustomizer jsonCustomizer() {
//        return builder -> {
//            builder.simpleDateFormat(DATE_TIME_FORMAT);
//            builder.serializers(new LocalDateSerializer(DateTimeFormatter.ofPattern(DATE_FORMAT)));
//            builder.serializers(new LocalDateTimeSerializer(DateTimeFormatter.ofPattern(DATE_TIME_FORMAT)));
//        };
//    }
//
//    @Bean("CustomValidator")
//    public Validator createValidator() {
//        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
//        return factory.getValidator();
//    }
//
//    @Bean
//    public MethodValidationPostProcessor methodValidationPostProcessor() {
//        return new MethodValidationPostProcessor();
//    }
//
////  @Bean("envPrefix")
////  public String getEnvPrefix() {
////    String currentEnvironment = System.getenv(EnvironmentValue.SERVER_ENVIRONMENT_VARIABLE);
////    switch (currentEnvironment.toUpperCase()) {
////      case Constants.EnvironmentValue.DEVELOPMENT:
////        return "d";
////      case EnvironmentValue.QUALITY:
////        return "q";
////      case EnvironmentValue.TUNING:
////        return "s";
////      case EnvironmentValue.EXE:
////        return "e";
////      case EnvironmentValue.PRODUCTION:
////        return "";
////      default:
////        return "d";
////    }
////  }
////
////  @Bean("environment")
////  public String getEnv() {
////    String currentEnvironment = System.getenv(EnvironmentValue.SERVER_ENVIRONMENT_VARIABLE);
////    if (!currentEnvironment.isEmpty()) {
////      return currentEnvironment.toUpperCase();
////    }
////    return EnvironmentValue.DEVELOPMENT;
////  }
//}
