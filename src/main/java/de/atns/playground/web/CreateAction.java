package de.atns.playground.web;

import com.google.inject.Inject;
import com.google.inject.Provider;
import com.google.inject.servlet.RequestScoped;
import com.wideplay.warp.persist.Transactional;
import de.atns.playground.Action;
import de.atns.playground.Forwarder;
import de.atns.playground.model.Entry;
import de.atns.playground.model.Parent;

import javax.persistence.EntityManager;
import javax.servlet.ServletException;
import java.io.IOException;

/**
 * @author tbaum
 * @since 21.10.2009
 */
@RequestScoped public class CreateAction implements Action {
// ------------------------------ FIELDS ------------------------------

    private final Forwarder forwarder;
    private final Provider<EntityManager> em;
    private final SimpleForm form;

// --------------------------- CONSTRUCTORS ---------------------------

    @Inject public CreateAction(final Forwarder forwarder, final Provider<EntityManager> em, final SimpleForm form) {
        this.em = em;
        this.form = form;
        this.forwarder = forwarder;
    }

// ------------------------ INTERFACE METHODS ------------------------


// --------------------- Interface Action ---------------------

    @Transactional public void service() throws IOException, ServletException {
        final Parent parent = new Parent();
        parent.setName(form.getName());
        for (String s : form.getEntries()) {
            parent.add(new Entry(s));
        }
        em.get().persist(parent);
        forwarder.forward("success.jspx");
    }
}