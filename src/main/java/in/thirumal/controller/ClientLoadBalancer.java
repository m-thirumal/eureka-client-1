/**
 * 
 */
package in.thirumal.controller;

import java.util.IntSummaryStatistics;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import in.thirumal.service.EurekaClientService;

/**
 * @author Thirumal
 *
 */
@RestController
@RequestMapping("/load-balancer")
public class ClientLoadBalancer {
	
	@Autowired
	EurekaClientService eurekaClientService;
	
//	private final WebClient.Builder loadBalancedWebClientBuilder;
/*	private final ReactorLoadBalancerExchangeFilterFunction lbFunction;

	public ClientLoadBalancer(WebClient.Builder loadBalancedWebClientBuilder,
			ReactorLoadBalancerExchangeFilterFunction lbFunction) {
		super();
	//	this.loadBalancedWebClientBuilder = loadBalancedWebClientBuilder;
		this.lbFunction = lbFunction;
	}
*/
//	@GetMapping("")
//	public Mono<IntSummaryStatistics> getStatisticFromClient2() {
//		return WebClient.builder()
//        .filter(lbFunction)
//        .build().get().uri("http://eureka-client-2/client2/")
//        .retrieve().bodyToMono(IntSummaryStatistics.class);
//	}
	
	@GetMapping("/feign")
	public IntSummaryStatistics getStatisticFromClient2UsingFeign() {
		System.out.println("hi");
		//return loadBalancedWebClientBuilder.build().get().uri("http://eureka-client-2/client2")
		//		.retrieve().bodyToMono(IntSummaryStatistics.class);
		return eurekaClientService.getStatisticFromClient2UsingFeign();
	}
	
	/*@GetMapping("")
	public IntSummaryStatistics getStatisticFromClient2UsingFeign() {
		return loadBalancedWebClientBuilder.build().get().uri("http://eureka-client-2/client2")
				.retrieve().bodyToMono(IntSummaryStatistics.class);
	}*/
}
