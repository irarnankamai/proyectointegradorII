package ec.edu.ups.demoJakarta.services;

import ec.edu.ups.demoJakarta.business.GestionUsuario;
import ec.edu.ups.demoJakarta.model.Usuario;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.util.List;

@Path("/usuarios")
public class UsuarioService  {

    @Inject
    private GestionUsuario gestionUsuario;

    @GET
    @Produces("application/json")
    public List<Usuario> getAllUsuarios() {
        return gestionUsuario.getAllUsuarios();
    }

    @GET
    @Produces("application/json")
    @Path("/{id}")
    public Usuario getUsuarioById(@PathParam("id") Long id) {
        return gestionUsuario.getUsuarioById(id);
    }

    @POST
    @Produces("application/json")
    public Response createUsuario(Usuario usuario) {
        Usuario createdUsuario = gestionUsuario.createUsuario(usuario);
        return Response.status(Response.Status.CREATED).entity(createdUsuario).build();
    }

    @PUT
    @Produces("application/json")
    @Path("/{id}")
    public Response updateUsuario(@PathParam("id") Long id, Usuario usuario) {
        usuario.setId(id);
        gestionUsuario.updateUsuario(usuario);
        return Response.ok().entity(usuario).build();
    }

    @DELETE
    @Produces("application/json")
    @Path("/{id}")
    public Response deleteUsuario(@PathParam("id") Long id) {
        gestionUsuario.deleteUsuario(id);
        return Response.status(Response.Status.NO_CONTENT).build();
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/autenticacion")
    public Response authenticateUser(@QueryParam("username") String username, @QueryParam("password") String password) {
        Usuario usuario = gestionUsuario.getUsuarioByUsernameAndPassword(username, password);
        if (usuario != null) {
            return Response.ok(usuario).build();
        } else {
            return Response.status(Response.Status.UNAUTHORIZED).entity("Usuario o contraseña incorrecto").build();
        }
    }

}

