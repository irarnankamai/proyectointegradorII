package ec.edu.ups.demoJakarta.services;

import ec.edu.ups.demoJakarta.business.GestionLibro;
import ec.edu.ups.demoJakarta.model.Libro;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import java.util.List;

@Path("/libros")
public class LibroService {

    @Inject
    private GestionLibro gestionLibro;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Libro> getAllLibros() {
        return gestionLibro.getAllLibros();
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/{id}")
    public Libro getLibroById(@PathParam("id") Long id) {
        return gestionLibro.getLibroById(id);
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response createLibro(Libro libro) {
        Libro createdLibro = gestionLibro.createLibro(libro);
        return Response.status(Response.Status.CREATED).entity(createdLibro).build();
    }

    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/{id}")
    public Response updateLibro(@PathParam("id") Long id, Libro libro) {
        libro.setId(id);
        gestionLibro.updateLibro(libro);
        return Response.status(Response.Status.OK).entity(libro).build();
    }

    @DELETE
    @Path("/{id}")
    public Response deleteLibro(@PathParam("id") Long id) {
        gestionLibro.deleteLibro(id);
        return Response.status(Response.Status.NO_CONTENT).build();
    }
}
