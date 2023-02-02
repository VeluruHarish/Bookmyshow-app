package com.hm.Capstoneproject.Security;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.HandlerExceptionResolver;

import com.hm.Capstoneproject.Exception.NoSuchElementException;

@Component
public class AuthFilter implements Filter {

	@Autowired
	RestTemplate rt;
	
	@Autowired
	@Qualifier("handlerExceptionResolver")
	HandlerExceptionResolver resolver;

	
	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
	

		HttpServletRequest httpServletRequest = (HttpServletRequest) request;
		HttpServletResponse httpServletResponse = (HttpServletResponse)response;
		
		String header = httpServletRequest.getHeader("auth");
		System.out.println(header);
		
		HttpHeaders headers = new HttpHeaders();
		headers.set("Accept", "application/json");
		headers.set("auth", header);
		HttpEntity<String> httpEntity = new HttpEntity<>(null,headers);
		try {
		rt.exchange("http://bookmyshow-auth/auth/login", HttpMethod.GET, httpEntity, String.class);
		chain.doFilter(request, response);
		}
		catch (RestClientException ex) {
			resolver.resolveException(httpServletRequest,httpServletResponse , null, 
					new NoSuchElementException("User Must be Logged In")
					);
		}
		
		

		
	}

}
