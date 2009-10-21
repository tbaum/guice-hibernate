package de.atns.playground.config;

import static com.google.inject.Guice.createInjector;
import com.google.inject.Injector;
import com.google.inject.servlet.GuiceServletContextListener;

/**
 * @author tbaum
 * @since 21.10.2009
 */
public class SimpleModuleServletContextListner extends GuiceServletContextListener {
// -------------------------- OTHER METHODS --------------------------

    @Override protected Injector getInjector() {
        return createInjector(new SimpleModule());
    }
}


