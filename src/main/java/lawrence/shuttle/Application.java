package lawrence.shuttle;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;;

@EnableJpaRepositories(basePackages = "lawrence.shuttle")
@ComponentScan(basePackages = "lawrence.shuttle")
@Configuration
@EnableTransactionManagement
@EnableAutoConfiguration
public class Application implements CommandLineRunner {
	  public static void main(final String[] args) {
	    SpringApplication.run(Application.class, args);
	  }
	  
	  public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
	}
}