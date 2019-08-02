package it.my.test.router.routes;

import org.apache.camel.builder.RouteBuilder;
import org.springframework.stereotype.Component;

@Component
public class MyRoutes extends RouteBuilder{

	@Override
	public void configure() throws Exception {
	    from("direct:service-call").setHeader("to", simple("direct:${in.header.to}")).toD("${in.header.to}");
	    from("direct:foo").log("We are in the FOO route").setBody(simple("This is the ${in.header.to} response")).to("mock:result");
	    from("direct:bar").log("We are in the BAR route").setBody(simple("This is the ${in.header.to} response")).to("mock:result");

		
	}

}
