/**
 * 
 */
package com.mind.hateoas.event;

import javax.servlet.http.HttpServletResponse;

import org.springframework.context.ApplicationEvent;

/**
 * @author mrinalvatsya
 *
 */
public class SingleResourceRetrievedEvent extends ApplicationEvent {
    /**
	 * 
	 */
	private static final long serialVersionUID = -1780027473520428472L;
	private final HttpServletResponse response;

    public SingleResourceRetrievedEvent(final Object source, final HttpServletResponse response) {
        super(source);

        this.response = response;
    }

    // API

    public HttpServletResponse getResponse() {
        return response;
    }

}