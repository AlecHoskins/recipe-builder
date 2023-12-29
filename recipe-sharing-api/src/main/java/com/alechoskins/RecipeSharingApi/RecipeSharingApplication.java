package com.alechoskins.RecipeSharingApi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController

public class RecipeSharingApplication {

	public static void main(String[] args) {
		try{
			SpringApplication.run(RecipeSharingApplication.class, args);
		}catch (Exception e){
			System.out.println(e.getMessage());
		}
	}
}

