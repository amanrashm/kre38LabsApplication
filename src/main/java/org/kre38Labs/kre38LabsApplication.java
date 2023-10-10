package org.kre38Labs;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;

@SpringBootApplication
@ServletComponentScan
public class kre38LabsApplication {
    public static void main(String[] args) {
        SpringApplication.run(kre38LabsApplication.class, args);
    }
}