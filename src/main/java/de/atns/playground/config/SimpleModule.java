package de.atns.playground.config;

import com.google.inject.matcher.Matchers;
import com.google.inject.multibindings.MapBinder;
import static com.google.inject.multibindings.MapBinder.newMapBinder;
import com.google.inject.servlet.ServletModule;
import static com.wideplay.warp.persist.PersistenceService.usingJpa;
import com.wideplay.warp.persist.UnitOfWork;
import com.wideplay.warp.persist.jpa.JpaUnit;
import de.atns.playground.Action;
import de.atns.playground.DispatchServlet;
import de.atns.playground.dao.SimpleRepository;
import de.atns.playground.web.CreateAction;
import de.atns.playground.web.ListAction;

/**
 * @author tbaum
 * @since 22.10.2009
 */
class SimpleModule extends ServletModule {
// -------------------------- OTHER METHODS --------------------------

    @Override protected void configureServlets() {
        serve("/*").with(DispatchServlet.class);

        final MapBinder<String, Action> actionProvider = newMapBinder(binder(), String.class, Action.class);

        actionProvider.addBinding("/").to(ListAction.class);
        actionProvider.addBinding("/list").to(ListAction.class);
        actionProvider.addBinding("/create").to(CreateAction.class);

        bindConstant().annotatedWith(JpaUnit.class).to("unit1");

        install(usingJpa()
                .across(UnitOfWork.TRANSACTION)
                .forAll(Matchers.any())
                .addAccessor(SimpleRepository.class)
                .buildModule());
    }
}
