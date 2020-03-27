package leavetracker.main;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableEurekaClient
@ComponentScan(basePackages = {"leavetracker.controller"})
@ComponentScan(basePackages = {"leavetracker.service"})
@EntityScan(basePackages = {"leavetracker.model"} )
@EnableJpaRepositories(basePackages = {"leavetracker.repository"})
public class EmployeeLeaveTrackerApplication {

	public static void main(String[] args) {
		SpringApplication.run(EmployeeLeaveTrackerApplication.class, args);
	}

}
