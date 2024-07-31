package ec.edu.ups.demoJakarta.dao;

import ec.edu.ups.demoJakarta.model.Cliente;
import ec.edu.ups.demoJakarta.model.Usuario;
import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;

import java.io.Serializable;
import java.util.List;

@Stateless
public class UsuarioDAO implements Serializable {

    @PersistenceContext()
    private EntityManager entityManager;

    public List<Usuario> findAll() {
        String jpql = "SELECT c FROM Usuario c";
        Query query = entityManager.createQuery(jpql, Usuario.class);
        return query.getResultList();
    }

    public Usuario findById(Long id) {
        return entityManager.find(Usuario.class, id);
    }
    public Usuario findByUsernameAndPassword(String username, String password) {
        try {
            return entityManager.createQuery("SELECT u FROM Usuario u WHERE u.username = :username AND u.password = :password", Usuario.class)
                    .setParameter("username", username)
                    .setParameter("password", password)
                    .getSingleResult();
        } catch (Exception e) {
            return null;
        }
    }

    public void create(Usuario usuario) {
        entityManager.persist(usuario);
    }

    public void update(Usuario usuario) {
        entityManager.merge(usuario);
    }

    public void delete(Long id) {
        Usuario usuario = findById(id);
        if (usuario != null) {
            entityManager.remove(usuario);
        }
    }
}

