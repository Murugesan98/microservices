package userlogin.main;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableEurekaClient
@ComponentScan(basePackages = {"userlogin.controller"})
@ComponentScan(basePackages = {"userlogin.service"})
@EntityScan(basePackages = {"userlogin.model"} )
@EnableJpaRepositories(basePackages = {"userlogin.repository"})
public class UserLoginApplication {

	public static void main(String[] args) {
		SpringApplication.run(UserLoginApplication.class, args);
	}

}
