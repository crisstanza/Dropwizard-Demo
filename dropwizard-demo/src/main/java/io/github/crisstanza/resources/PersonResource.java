package io.github.crisstanza.resources;


import io.github.crisstanza.api.Person;
import io.github.crisstanza.view.PersonView;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

@Path("/people/{name}")
@Produces(MediaType.TEXT_HTML)
public class PersonResource {

//    private final PersonDAO dao;

//    public PersonResource(PersonDAO dao) {
//        this.dao = dao;
//    }

    @GET
    public PersonView getPerson(@PathParam("name") String name) {
        final Person person = new Person(name);
        return new PersonView(person);
    }
}