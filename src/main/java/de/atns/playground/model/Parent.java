package de.atns.playground.model;

import static javax.persistence.CascadeType.ALL;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.HashSet;
import java.util.Set;

/**
 * @author tbaum
 * @since 21.10.2009
 */
@Entity public class Parent {
// ------------------------------ FIELDS ------------------------------

    @Id @GeneratedValue(strategy = IDENTITY)
    private Long id;

    private String name;

    @OneToMany(mappedBy = "parent", cascade = ALL)
    private Set<Entry> entries = new HashSet<Entry>();

// --------------------- GETTER / SETTER METHODS ---------------------

    public Set<Entry> getEntries() {
        return entries;
    }

    public void setEntries(final Set<Entry> entries) {
        this.entries = entries;
    }

    public Long getId() {
        return id;
    }

    public void setId(final Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(final String name) {
        this.name = name;
    }

// -------------------------- OTHER METHODS --------------------------

    public void add(final Entry entry) {
        entry.setParent(this);
        entries.add(entry);
    }
}

