package it.my.test.router;

import java.util.List;

import org.apache.camel.CamelContext;
import org.apache.camel.model.ModelHelper;
import org.apache.camel.model.RouteDefinition;
import org.apache.camel.model.RoutesDefinition;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class CamelDynamicRouterApplication implements ApplicationRunner {
	
	@Autowired
	private CamelContext camelContext;

	public static void main(String[] args) {
		SpringApplication.run(CamelDynamicRouterApplication.class, args);
	}

	@Override
	public void run(ApplicationArguments args) throws Exception {
		
		List<RouteDefinition> routes = camelContext.getRouteDefinitions();
	    RoutesDefinition def = new RoutesDefinition();
	    def.setRoutes(routes);
	    System.out.println(ModelHelper.dumpModelAsXml(camelContext, def));
		
	}

}
