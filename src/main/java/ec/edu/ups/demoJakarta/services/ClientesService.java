package ec.edu.ups.demoJakarta.services;

import java.util.List;

import ec.edu.ups.demoJakarta.business.GestionClientes;
import ec.edu.ups.demoJakarta.model.Cliente;
import jakarta.inject.Inject;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Path("/cliente")
public class ClientesService {
    
    @Inject
    private GestionClientes  gClientes;
    
    @POST
    @Produces("application/json")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response create(Cliente cliente) {
        try {
            gClientes.createCliente(cliente);
            return Response.ok(cliente).build();
        } catch(Exception e) {
            e.printStackTrace();
            return Response.status(503).entity(new Respuesta(Respuesta.ERROR, "Error en BD")).build();
        }
    }
    
    @PUT
    @Produces("application/json")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response update(Cliente cliente) {
        try {
            gClientes.actualizarCliente(cliente);
            return Response.ok(cliente).build();
        } catch (Exception e) {
            e.printStackTrace();
            return Response.status(503).entity(new Respuesta(Respuesta.ERROR, "Error en BD")).build();
        }
    }

    @DELETE
    @Path("/{cedula}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response delete(@PathParam("cedula") String cedula) {
        try {
            gClientes.borrarCliente(cedula);
            return Response.ok().entity(new Respuesta(Respuesta.OK, "Cliente eliminado correctamente")).build();
        } catch (Exception e) {
            e.printStackTrace();
            return Response.status(503).entity(new Respuesta(Respuesta.ERROR, "Error en BD")).build();
        }
    }
    
    @GET
    @Produces("application/json")
    @Path("/{cedula}")
    public Cliente get(@PathParam("cedula") String cedula) {
        Cliente cliente;
        try {
            cliente = gClientes.getCliente(cedula);
            return cliente;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
    
    @GET
    @Produces("application/json")
    public List<Cliente> list() {
        List<Cliente> clientes = gClientes.getClientes();
        return clientes;
    }

    @GET
    @Produces("application/json")
    @Path("/usuario/{userId}")
    public Response getByUserId(@PathParam("userId") int userId) {
        try {
            Cliente cliente = gClientes.getClienteByUserId(userId);
            if (cliente == null) {
                return Response.status(404).entity(new Respuesta(Respuesta.ERROR, "Cliente no encontrado")).build();
            }
            return Response.ok(cliente).build();
        } catch (Exception e) {
            e.printStackTrace();
            return Response.status(503).entity(new Respuesta(Respuesta.ERROR, "Error en BD")).build();
        }
    }
}
