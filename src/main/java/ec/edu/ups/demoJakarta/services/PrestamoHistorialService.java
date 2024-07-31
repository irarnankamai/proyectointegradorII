package ec.edu.ups.demoJakarta.services;

import ec.edu.ups.demoJakarta.business.GestionHistorial;
import ec.edu.ups.demoJakarta.model.PrestamoHistorial;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import java.util.List;

@Path("/historial-prestamos")
public class PrestamoHistorialService {

    @Inject
    private GestionHistorial gestionHistorialPrestamo;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/{prestamoId}")
    public List<PrestamoHistorial> getHistorialByPrestamoId(@PathParam("prestamoId") Long prestamoId) {
        return gestionHistorialPrestamo.getHistorialByPrestamoId(prestamoId);
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response addHistorial(PrestamoHistorial historialPrestamo) {
        gestionHistorialPrestamo.addHistorial(historialPrestamo);
        return Response.status(Response.Status.CREATED).entity(historialPrestamo).build();
    }
}
