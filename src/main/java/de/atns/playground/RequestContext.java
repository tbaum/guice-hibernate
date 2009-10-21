package de.atns.playground;

import com.google.inject.Inject;
import com.google.inject.servlet.RequestScoped;

import javax.servlet.http.HttpServletRequest;

/**
 * @author tbaum
 * @since 21.10.2009
 */
@RequestScoped public class RequestContext {
// ------------------------------ FIELDS ------------------------------

    private final HttpServletRequest request;

// --------------------------- CONSTRUCTORS ---------------------------

    @Inject public RequestContext(final HttpServletRequest request) {
        this.request = request;
    }

// -------------------------- OTHER METHODS --------------------------

    public void put(final String key, final Object value) {
        request.setAttribute(key, value);
    }
}