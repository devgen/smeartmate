package  de.tum.rest.interceptors;

import java.io.IOException;

import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerResponseContext;
import javax.ws.rs.container.ContainerResponseFilter;
import javax.ws.rs.ext.Provider;

import org.jboss.logging.Logger;

//prematching
@Provider
public class DemoRESTResponseFilter implements ContainerResponseFilter {

	@Override
	public void filter(ContainerRequestContext requestContext,
			ContainerResponseContext responseContext) throws IOException {
		log.info("Filtering REST Response");
		// TODO Auto-generated method stub
		responseContext.getHeaders().add("Access-Control-Allow-Origin", "*");
		responseContext.getHeaders().add("Access-Control-Allow-Credentials",
				"true");
		responseContext.getHeaders().add("Access-Control-Allow-Methods",
				" GET, POST, DELETE, PUT, OPTIONS");
		responseContext
				.getHeaders()
				.add("Access-Control-Allow-Headers",
						"origin, content-type, accept, authorization, X-Requested-With, X-Codingpedia");
		responseContext.getHeaders().add(
				"Access-Control-Allow-Headers",
				DemoHTTPHeaderNames.SERVICE_KEY + ", "
						+ DemoHTTPHeaderNames.AUTH_TOKEN);

	}

	private final static Logger log = Logger
			.getLogger(DemoRESTResponseFilter.class.getName());

	public DemoRESTResponseFilter() {
		log.info("request filter");
	}

}
