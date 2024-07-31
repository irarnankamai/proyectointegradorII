package ec.edu.ups.demoJakarta.business;

import ec.edu.ups.demoJakarta.dao.UsuarioDAO;
import ec.edu.ups.demoJakarta.model.Usuario;
import jakarta.ejb.Stateless;
import jakarta.inject.Inject;

import java.util.List;

@Stateless
public class GestionUsuario {

    @Inject
    private UsuarioDAO usuarioDAO;

    public List<Usuario> getAllUsuarios() {
        return usuarioDAO.findAll();
    }

    public Usuario getUsuarioById(Long id) {
        return usuarioDAO.findById(id);
    }

    public Usuario createUsuario(Usuario usuario) {
        usuarioDAO.create(usuario);
        return usuario;
    }

    public void updateUsuario(Usuario usuario) {
        usuarioDAO.update(usuario);
    }

    public void deleteUsuario(Long id) {
        usuarioDAO.delete(id);
    }

    public Usuario getUsuarioByUsernameAndPassword(String username, String password) {
        return usuarioDAO.findByUsernameAndPassword(username, password);
    }

}
