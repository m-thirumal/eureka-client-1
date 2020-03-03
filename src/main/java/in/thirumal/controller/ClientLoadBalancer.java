/**
 * 
 */
package in.thirumal.controller;

import java.util.IntSummaryStatistics;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.reactive.function.client.WebClient;

import in.thirumal.config.ClientFeign;
import reactor.core.publisher.Mono;

/**
 * @author Thirumal
 *
 */
@RestController
@RequestMapping("/load-balancer")
public class ClientLoadBalancer {
	
	@Autowired
	private ClientFeign clientFeign;
	private final WebClient.Builder loadBalancedWebClientBuilder;
	//private final ReactorLoadBalancerExchangeFilterFunction lbFunction;

	public ClientLoadBalancer(WebClient.Builder loadBalancedWebClientBuilder) {//,
		//	ReactorLoadBalancerExchangeFilterFunction lbFunction) {
		super();
		this.loadBalancedWebClientBuilder = loadBalancedWebClientBuilder;
		//this.lbFunction = lbFunction;
	}

//	@GetMapping("")
//	public Mono<IntSummaryStatistics> getStatisticFromClient2() {
//		return WebClient.builder()
//        .filter(lbFunction)
//        .build().get().uri("http://eureka-client-2/client2/")
//        .retrieve().bodyToMono(IntSummaryStatistics.class);
//	}
	
	@GetMapping("")
	public IntSummaryStatistics getStatisticFromClient2() {
		System.out.println("hi");
		//return loadBalancedWebClientBuilder.build().get().uri("http://eureka-client-2/client2")
		//		.retrieve().bodyToMono(IntSummaryStatistics.class);
		return clientFeign.getSummaryStatistics();
	}
}
