package de.atns.playground;

import com.google.inject.Inject;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author tbaum
 * @since 21.10.2009
 */
public class Forwarder {
// ------------------------------ FIELDS ------------------------------

    private final HttpServletRequest request;
    private final HttpServletResponse response;

// --------------------------- CONSTRUCTORS ---------------------------

    @Inject public Forwarder(final HttpServletRequest request, final HttpServletResponse response) {
        this.response = response;
        this.request = request;
    }

// -------------------------- OTHER METHODS --------------------------

    public void forward(final String target) throws ServletException, IOException {
        request.getRequestDispatcher(target).forward(request, response);
    }
}
