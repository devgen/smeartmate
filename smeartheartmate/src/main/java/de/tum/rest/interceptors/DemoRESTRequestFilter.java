package de.tum.rest.interceptors;

import java.io.IOException;
import java.util.logging.Logger;

import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerRequestFilter;
import javax.ws.rs.container.PreMatching;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.Provider;



@Provider
@PreMatching
public class DemoRESTRequestFilter implements ContainerRequestFilter {

	private final static Logger log = Logger
			.getLogger(DemoRESTRequestFilter.class.getName());

	@Override
	public void filter(ContainerRequestContext requestCtx) throws IOException {

		String path = requestCtx.getUriInfo().getPath();
		log.info("Filtering request path: " + path);

		// IMPORTANT!!! First, Acknowledge any pre-flight test from browsers for
		// this case before validating the headers (CORS stuff)
		if (requestCtx.getRequest().getMethod().equals("OPTIONS")) {

			requestCtx.abortWith(Response.status(Response.Status.OK).build());

			return;
		}

		// Then check is the service key exists and is valid.
		//DemoAuthenticator demoAuthenticator = DemoAuthenticator.getInstance();

		String serviceKey = requestCtx
				.getHeaderString(DemoHTTPHeaderNames.SERVICE_KEY);
		log.info(serviceKey);
		// // if (!demoAuthenticator.isServiceKeyValid(serviceKey)) {
		// if (!serviceKey.equals("test")) {
		// // Kick anyone without a valid service key
		// log.info("service key is not valid "
		// + requestCtx.getHeaders().get("service_key"));
		// requestCtx.abortWith(Response.status(Response.Status.UNAUTHORIZED)
		// .build());
		//
		// return;
		// }

		// For any pther methods besides login, the authToken must be verified

		// log.info(path);
		// if (!path.startsWith("/users/login")
		// || !path.startsWith("/users/register")) {
		//
		// log.info("method don'T statt with login"
		// + requestCtx.getHeaders().toString() + "link:"
		// + requestCtx.getUriInfo().getPath());
		//
		// String authToken = requestCtx
		// .getHeaderString(DemoHTTPHeaderNames.AUTH_TOKEN);
		//
		// // if it isn't valid, just kick them out.
		// // if (!demoAuthenticator.isAuthTokenValid(serviceKey, authToken)) {
		// // requestCtx.abortWith(Response.status(
		// // Response.Status.UNAUTHORIZED).build());
		// // }
		// }

	}
}
