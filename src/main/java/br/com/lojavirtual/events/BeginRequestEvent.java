package br.com.lojavirtual.events;

import javax.servlet.http.HttpServletRequest;

public class BeginRequestEvent {

	private HttpServletRequest request;

	public BeginRequestEvent(HttpServletRequest request) {
		this.request = request;
	}

	public HttpServletRequest getRequest() {
		return request;
	}
}
