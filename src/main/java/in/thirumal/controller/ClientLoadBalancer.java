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

import in.thirumal.service.EurekaClientService;
import reactor.core.publisher.Mono;

/**
 * @author Thirumal
 *
 */
@RestController
@RequestMapping("/load-balancer")
public class ClientLoadBalancer {
	
	@Autowired
	EurekaClientService eurekaClientService;
	@Autowired
	private WebClient.Builder loadBalancedWebClientBuilder;
	//@Autowired
	//private ReactorLoadBalancerExchangeFilterFunction lbFunction;
/*
	@GetMapping("/cloud-load-balancer-reactor")
	public Mono<IntSummaryStatistics> getStatisticFromClient2UsingLoadBalancer() {
		return WebClient.builder()
        .filter(lbFunction)
        .build().get().uri("http://eureka-client-2/client2/")
        .retrieve().bodyToMono(IntSummaryStatistics.class);
	}
	*/
	/**
	 * Using open feign
	 * @return
	 */
	@GetMapping("/open-feign")
	public IntSummaryStatistics getStatisticFromClient2UsingFeign() {
	return eurekaClientService.getStatisticFromClient2UsingFeign();
	}
	
	/**
	 * using cloud load balancer
	 * @return
	 */
	@GetMapping("/cloud-load-balancer-web-client")
	public Mono<IntSummaryStatistics> getStatisticFromClient2UsingWebClient() {
		return loadBalancedWebClientBuilder.build().get().uri("http://eureka-client-2/client2")
				.retrieve().bodyToMono(IntSummaryStatistics.class);
	}
	
}
