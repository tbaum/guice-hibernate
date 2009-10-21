package de.atns.playground.web;

import com.google.inject.Inject;
import com.google.inject.servlet.RequestParameters;
import com.google.inject.servlet.RequestScoped;

import java.util.Map;

/**
 * @author tbaum
 * @since 21.10.2009
 */
@RequestScoped public class SimpleForm {
// ------------------------------ FIELDS ------------------------------

    private final String name;
    private final String[] entries;

// --------------------------- CONSTRUCTORS ---------------------------

    @Inject public SimpleForm(@RequestParameters final Map<String, String[]> params) {
        name = extractParameter(params, "name")[0];
        entries = extractParameter(params, "entries");
    }

    private String[] extractParameter(final Map<String, String[]> params, final String name) {
        final String[] values = params.get(name);

        if (values == null) {
            throw new IllegalArgumentException("Parameter '" + name + "' wrong or missing");
        }
        return values;
    }

// --------------------- GETTER / SETTER METHODS ---------------------

    public String[] getEntries() {
        return entries;
    }

    public String getName() {
        return name;
    }
}