package challenge.dataprev;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@SpringBootApplication
@EntityScan(basePackages = {"challenge.dataprev.entity"})
public class DataprevApplication {

	public static void main(String[] args) {
		SpringApplication.run(DataprevApplication.class, args);
	}

}
