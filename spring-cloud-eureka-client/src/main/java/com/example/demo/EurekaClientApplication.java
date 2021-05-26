package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;


@EnableEurekaClient
@SpringBootApplication
@RestController
@EnableDiscoveryClient
public class EurekaClientApplication {

    public static void main(String[] args) {

        SpringApplication.run(EurekaClientApplication.class, args);
    }

    @Value("${server.port}")
    String port;
    @Autowired
    RestTemplate restTemplate;

    @RequestMapping("/hi")
    public String home(@RequestParam(value = "name", defaultValue = "forezp") String name) {
//        return restTemplate.getForObject("http://spring-cloud/hi?name="+name+",from:"+port,String.class);

        return "hi " + name + " ,i am from port:" + port;
    }

    @RequestMapping("/hi2")
    public String home2(@RequestParam(value = "name", defaultValue = "forezp") String name) {
        return name;
    }

    @Bean
    @LoadBalanced
    RestTemplate restTemplate() {
        return new RestTemplate();
    }
}
