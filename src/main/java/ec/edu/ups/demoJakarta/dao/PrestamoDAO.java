package ec.edu.ups.demoJakarta.dao;

import ec.edu.ups.demoJakarta.model.Prestamo;
import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;

import java.io.Serializable;
import java.util.List;

@Stateless
public class PrestamoDAO implements Serializable {

    @PersistenceContext()
    private EntityManager entityManager;

    public List<Prestamo> findAll() {
        String jpql = "SELECT p FROM Prestamo p";
        Query query = entityManager.createQuery(jpql, Prestamo.class);
        return query.getResultList();
    }

    public Prestamo findById(Long id) {
        return entityManager.find(Prestamo.class, id);
    }

    public void create(Prestamo prestamo) {
        entityManager.persist(prestamo);
    }

    public void update(Prestamo prestamo) {
        entityManager.merge(prestamo);
    }

    public void delete(Long id) {
        Prestamo prestamo = findById(id);
        if (prestamo != null) {
            entityManager.remove(prestamo);
        }
    }

    public List<Prestamo> findByLibro(int libroId) {
        String jpql = "SELECT p FROM Prestamo p WHERE p.libro = :libroId";
        Query query = entityManager.createQuery(jpql, Prestamo.class);
        query.setParameter("libroId", libroId);
        return query.getResultList();
    }

    public List<Prestamo> findByUsuario(int usuarioId) {
        String jpql = "SELECT p FROM Prestamo p WHERE p.usuario = :usuarioId";
        Query query = entityManager.createQuery(jpql, Prestamo.class);
        query.setParameter("usuarioId", usuarioId);
        return query.getResultList();
    }
}
