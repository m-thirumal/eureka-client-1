/**
 * 
 */
package in.thirumal.config;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.DefaultServiceInstance;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.loadbalancer.core.ServiceInstanceListSupplier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import com.netflix.discovery.EurekaClient;
import com.netflix.discovery.shared.Applications;

import reactor.core.publisher.Flux;

/**
 * @author thirumal
 *
 */
@Configuration
public class EurekaClient2Configuration {
	
	@Bean
	@Primary
	ServiceInstanceListSupplier serviceInstanceListSupplier() {
		return new DemoServiceInstanceListSuppler("eureka-client-2");
	}

}


class DemoServiceInstanceListSuppler implements ServiceInstanceListSupplier {

	private final String serviceId;
	@Autowired
	private EurekaClient eurekaClient;

	DemoServiceInstanceListSuppler(String serviceId) {
		this.serviceId = serviceId;
	}

	@Override
	public String getServiceId() {
		return serviceId;
	}

	@Override
	public Flux<List<ServiceInstance>> get() {
		 Applications applications = eurekaClient.getApplications();
	        applications.getRegisteredApplications().forEach(registeredApplication -> 
		        registeredApplication.getInstances().forEach(instance -> 
		            System.out.println(instance.getAppName() + " (" + instance.getInstanceId() + ") : ")));
	        System.out.println("hi");
		return Flux.just(Arrays
				.asList(new DefaultServiceInstance(serviceId + "1", serviceId, "localhost", 8074, false),
						//new DefaultServiceInstance(serviceId + "2", serviceId, "localhost", 8075, false),
						new DefaultServiceInstance(serviceId + "2", serviceId, "localhost", 8075, false)));
	}
}