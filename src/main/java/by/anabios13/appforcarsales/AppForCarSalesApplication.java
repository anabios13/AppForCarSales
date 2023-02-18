package by.anabios13.appforcarsales;

import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class AppForCarSalesApplication {

	public static void main(String[] args) {
		SpringApplication.run(AppForCarSalesApplication.class, args);
	}
	@Bean
	public ModelMapper modelMapper(){
	return new ModelMapper();
	}
}
