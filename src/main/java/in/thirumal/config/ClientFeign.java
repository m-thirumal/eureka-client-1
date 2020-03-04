/**
 * 
 */
package in.thirumal.config;

import java.util.IntSummaryStatistics;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @author Thirumal
 * Feign can work without ribbon
 */
@FeignClient(name = "eureka-client-2", configuration = ClientFeignConfig.class)
//@RibbonClient(name = "eureka-client-2", configuration = ClientFeignConfig.class)
//@LoadBalancerClient(name = "eureka-client-2", configuration = EurekaClient2Configuration.class)
public interface ClientFeign {

	@GetMapping("/client2")
	public IntSummaryStatistics getSummaryStatistics();
	
}
