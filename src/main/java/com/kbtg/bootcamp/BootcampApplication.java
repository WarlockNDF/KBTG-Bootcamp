package com.kbtg.bootcamp;

import com.kbtg.bootcamp.entities.UserEntities;
import com.kbtg.bootcamp.users.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.annotation.PostConstruct;

@SpringBootApplication
@RequiredArgsConstructor
@Slf4j
public class BootcampApplication {

	private final UserService userService;

	//TODO SHOULD NOT BE ON PRODUCTION
	@PostConstruct
	private void afterBoot(){
		log.info("Initialize MockUP Data");
		userService.getRepo().save(UserEntities.builder().firstName("Tim").lastName("Dev").build());
		log.info("End MockUP Data");
	}

	public static void main(String[] args) {
		SpringApplication.run(BootcampApplication.class, args);
	}

}