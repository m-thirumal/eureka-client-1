/**
 * 
 */
package in.thirumal.config;

import java.util.IntSummaryStatistics;
import java.util.stream.IntStream;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @author Thirumal
 * Feign can work without ribbon
 */
@FeignClient(name = "eureka-client-2", configuration = ClientFeignConfig.class, fallback = FeignFallback.class)
//@FeignClient(name = "eureka-client-2", configuration = ClientFeignConfig.class, fallbackFactory = FeignFallbackFactory.class)
//@RibbonClient(name = "eureka-client-2", configuration = ClientFeignConfig.class)
//@LoadBalancerClient(name = "eureka-client-2", configuration = EurekaClient2Configuration.class)
public interface ClientFeign {

	@GetMapping("/client2")
	public IntSummaryStatistics getSummaryStatistics();
	
}

@Component
class FeignFallback implements ClientFeign {
	
	@Override
	public IntSummaryStatistics getSummaryStatistics() {
		System.out.println("Fallback response");
		return IntStream.range(0, 0).summaryStatistics();
	}

}

