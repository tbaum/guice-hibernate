package de.atns.playground.web;

import com.google.inject.Inject;
import com.google.inject.servlet.RequestScoped;
import com.wideplay.warp.persist.Transactional;
import de.atns.playground.Action;
import de.atns.playground.Forwarder;
import de.atns.playground.RequestContext;
import de.atns.playground.dao.SimpleRepository;

import javax.servlet.ServletException;
import java.io.IOException;

/**
 * @author tbaum
 * @since 21.10.2009
 */
@RequestScoped public class ListAction implements Action {
// ------------------------------ FIELDS ------------------------------

    private final Forwarder forwarder;
    private final SimpleRepository simpleRepository;
    private final RequestContext context;

// --------------------------- CONSTRUCTORS ---------------------------

    @Inject
    public ListAction(final Forwarder forwarder, final SimpleRepository repository, final RequestContext context) {
        this.simpleRepository = repository;
        this.forwarder = forwarder;
        this.context = context;
    }

// ------------------------ INTERFACE METHODS ------------------------


// --------------------- Interface Action ---------------------

    @Transactional public void service() throws IOException, ServletException {
        context.put("list", simpleRepository.listAllComplete());
        forwarder.forward("list.jspx");
    }
}