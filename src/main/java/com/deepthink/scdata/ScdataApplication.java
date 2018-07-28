package com.deepthink.scdata;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan(value = "com.deepthink.scdata.model")
public class ScdataApplication {

	public static void main(String[] args) {
		SpringApplication.run(ScdataApplication.class, args);
	}
}
