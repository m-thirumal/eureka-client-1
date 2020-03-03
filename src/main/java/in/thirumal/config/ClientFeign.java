/**
 * 
 */
package in.thirumal.config;

import java.util.IntSummaryStatistics;

import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @author Thirumal
 *
 */
@FeignClient(name = "eureka-client-2", configuration = ClientFeignConfig.class)
@RibbonClient(name = "eureka-client-2", configuration = ClientFeignConfig.class)
//@LoadBalancerClient(name = "eureka-client-2", configuration = EurekaClient2Configuration.class)
public interface ClientFeign {

	@GetMapping("/client2")
	public IntSummaryStatistics getSummaryStatistics();
	
}
