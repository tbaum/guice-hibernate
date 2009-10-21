package de.atns.playground;

import javax.servlet.ServletException;
import java.io.IOException;

/**
 * @author tbaum
 * @since 21.10.2009
 */
public interface Action {
// -------------------------- OTHER METHODS --------------------------

    void service() throws IOException, ServletException;
}
