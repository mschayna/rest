package eu.abra.prima.filters;

import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.MediaType;

import com.google.common.collect.ImmutableMap;
import com.sun.jersey.spi.container.ContainerRequest;
import com.sun.jersey.spi.container.ContainerRequestFilter;

public class RewritingFilter implements ContainerRequestFilter {
	
	public static final String METHOD_QUERY_PARAMETER = "method";
	
	public static final String FORMAT_QUERY_PARAMETER = "format";
	
	public static final ImmutableMap<String, String> FORMAT_MAPPINGS = ImmutableMap.of(
			"xml", MediaType.APPLICATION_XML,
			"json", MediaType.APPLICATION_JSON);
	
	private String removeParameter(ContainerRequest request, String name) {
		if (request.getQueryParameters().containsKey(name))
			return request.getQueryParameters().remove(name).get(0);
		return null;
	}
	
	@Override
	public ContainerRequest filter(ContainerRequest request) {
		String method = removeParameter(request, METHOD_QUERY_PARAMETER);
		if (method != null)
			request.setMethod(method);
		String format = removeParameter(request, FORMAT_QUERY_PARAMETER);
		if (format != null) {
			String mediaType = FORMAT_MAPPINGS.get(format);
			if (mediaType != null)
				request.getRequestHeaders().putSingle(HttpHeaders.ACCEPT, mediaType);
		}
		return request;
	}
}
