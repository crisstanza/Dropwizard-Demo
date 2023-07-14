package io.github.crisstanza.view;

import io.dropwizard.views.common.View;
import io.github.crisstanza.api.Person;

public class PersonView extends View {
    private final Person person;

    public PersonView(Person person) {
        super("person.ftl");
        this.person = person;
    }

    public Person getPerson() {
        return person;
    }
}