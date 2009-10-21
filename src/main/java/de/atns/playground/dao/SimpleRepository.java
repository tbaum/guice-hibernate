package de.atns.playground.dao;

import com.google.inject.name.Named;
import com.wideplay.warp.persist.dao.Finder;
import de.atns.playground.model.Parent;

import java.util.List;

/**
 * @author tbaum
 * @since 21.10.2009
 */
public interface SimpleRepository {
// -------------------------- OTHER METHODS --------------------------

    @Finder(query = "FROM Parent WHERE name = :name") Parent find(@Named("name") String name);

    @Finder(query = "FROM Parent") List<Parent> listAll();

    @Finder(query = "FROM Parent FETCH ALL PROPERTIES") List<Parent> listAllComplete();
}
