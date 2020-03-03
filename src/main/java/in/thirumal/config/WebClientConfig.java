/**
 * 
 */
package in.thirumal.config;

import org.springframework.cloud.loadbalancer.annotation.LoadBalancerClient;
import org.springframework.context.annotation.Configuration;

/**
 * @author thirumal
 *
 */
@Configuration
@LoadBalancerClient(name = "eureka-client-2", configuration = EurekaClient2Configuration.class)
public class WebClientConfig {
/*
	@LoadBalanced
	@Bean
	WebClient.Builder webClientBuilder() {
	   return WebClient.builder();
	}
	*/
}
