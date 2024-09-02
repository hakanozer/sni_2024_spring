package com.works.overview;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.data.redis.repository.configuration.EnableRedisRepositories;

@SpringBootApplication
@EnableJpaAuditing
@EnableCaching
@EnableRedisRepositories
public class OverviewApplication {

	public static void main(String[] args) {
		SpringApplication.run(OverviewApplication.class, args);
	}

}
