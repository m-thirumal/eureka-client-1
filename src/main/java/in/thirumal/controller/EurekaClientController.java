/**
 * 
 */
package in.thirumal.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import in.thirumal.service.EurekaClientService;

/**
 * @author Thirumal
 *
 */
@RestController
@RequestMapping("/client")
public class EurekaClientController {

	@Autowired
	private EurekaClientService eurekaClientService;

	@GetMapping(value = "/{applicationName}")
	public boolean getApplicationInstance(@PathVariable(value = "applicationName") String applicationName) {
		return eurekaClientService.getAllInstances(applicationName);
	}
	
}
