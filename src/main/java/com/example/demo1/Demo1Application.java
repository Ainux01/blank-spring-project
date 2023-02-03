package com.example.demo1;

import com.example.demo1.infoapp.InfoApp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.core.env.Environment;
import org.springframework.web.SpringServletContainerInitializer;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@EnableFeignClients
public class Demo1Application extends SpringBootServletInitializer {

    @Value(value = "${spring.application.name}")
    private String applicationName;

    @Autowired
    private Environment environment;

    @Value(value = "${info.app.name}")
    private String appName;
    @Autowired
    RestTemplate restTemplate;

//    @Override
//    protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
//        return builder.sources(Demo1Application.class);
//    }

    public static void main(String[] args) {
        SpringApplication.run(Demo1Application.class, args);
    }

    @Bean
    CommandLineRunner getCommandLineRunner() {
        return args -> {
            System.out.println("The application Name is : "+applicationName);
            System.out.println("For info The Application name is "+appName);
            System.out.println("The Application Name Using Environment Bean: "+environment.getProperty("info.app.name"));
        };
    }

    @Bean
    ApplicationRunner getApplicationRunner() {
        return args -> {
            System.out.println("The Application Name is : "+applicationName+" from applicationRunner");
        };
    }

    @Bean
    CommandLineRunner commandLineRunnerInfoApp(InfoApp infoApp){
        return args -> {
            System.out.println("CommandLine Runner for Info App");
            System.out.println(infoApp);
        };

    }




}
