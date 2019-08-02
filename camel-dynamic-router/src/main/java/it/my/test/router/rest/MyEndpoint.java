package it.my.test.router.rest;

import org.apache.camel.ProducerTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("")
public class MyEndpoint {

	@Autowired
	private ProducerTemplate producer;

	@GetMapping("serviceCall")
	public String callService(@RequestParam("to") String to, @RequestBody(required = false) String body) {
		return producer.requestBodyAndHeader("direct:service-call", body, "to", to, String.class);
	}

}
