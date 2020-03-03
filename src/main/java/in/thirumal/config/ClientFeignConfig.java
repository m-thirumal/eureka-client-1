package in.thirumal.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import feign.Request;

@Configuration
public class ClientFeignConfig {

	@Bean
	public Request.Options antivirusOptions() {
		return new Request.Options(60 * 1000, 60 * 1000);
	}
	
}
