package io.github.crisstanza.resources;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;

import java.io.IOException;

@Path("/")
public class StaticResources {

    @GET
    @Path("css/{file}")
    @Produces("text/css")
    public byte[] css(@PathParam("file") String file) throws IOException {
        return getClass().getResourceAsStream("/css/" + file ).readAllBytes();
    }

    @GET
    @Path("js/{file}")
    @Produces("text/js")
    public byte[] js(@PathParam("file") String file) throws IOException {
        return getClass().getResourceAsStream("/js/" + file).readAllBytes();
    }

}
