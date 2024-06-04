package hello.springtx;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.retry.annotation.EnableRetry;

@SpringBootApplication
@EnableRetry
public class SpringtxApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringtxApplication.class, args);
	}

}
