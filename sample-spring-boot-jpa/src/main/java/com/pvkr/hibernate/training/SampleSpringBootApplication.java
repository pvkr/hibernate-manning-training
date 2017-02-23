package com.pvkr.hibernate.training;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SampleSpringBootApplication implements CommandLineRunner {

    public static void main(String[] args) {
		SpringApplication.run(SampleSpringBootApplication.class, args);
	}

    @Autowired
    private SampleBean sampleBean;

    @Override
    public void run(String... strings) throws Exception {
        sampleBean.createMessages();
        sampleBean.searchMessages();
    }
}
