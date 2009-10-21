package de.atns.playground.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

/**
 * @author tbaum
 * @since 21.10.2009
 */
@Entity public class Entry {
// ------------------------------ FIELDS ------------------------------

    @Id @GeneratedValue(strategy = IDENTITY)
    private Long id;

    private String name;

    @ManyToOne(optional = false)
    private Parent parent;

// --------------------------- CONSTRUCTORS ---------------------------

    public Entry() {
    }

    public Entry(final String name) {
        this.name = name;
    }

// --------------------- GETTER / SETTER METHODS ---------------------

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(final String name) {
        this.name = name;
    }

    public Parent getParent() {
        return parent;
    }

    public void setParent(final Parent parent) {
        this.parent = parent;
    }
}
