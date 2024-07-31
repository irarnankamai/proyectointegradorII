package ec.edu.ups.demoJakarta.dao;

import ec.edu.ups.demoJakarta.model.Libro;
import ec.edu.ups.demoJakarta.model.LibroClase;
import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;

import java.io.Serializable;
import java.util.List;

@Stateless
public class LibroDAO implements Serializable {

    @PersistenceContext
    private EntityManager entityManager;

    public List<Libro> findAll() {
        String jpql = "SELECT l FROM Libro l";
        Query query = entityManager.createQuery(jpql, Libro.class);
        return query.getResultList();
    }

    public Libro findById(Long id) {
        return entityManager.find(Libro.class, id);
    }

    public void create(Libro libro) {
        entityManager.persist(libro);
    }

    public void update(Libro libro) {
        entityManager.merge(libro);
    }

    public void delete(Long id) {
        Libro libro = findById(id);
        if (libro != null) {
            entityManager.remove(libro);
        }
    }

    public List<LibroClase> obtenerLibrosMasPrestados() {
        String jpql = "SELECT new ec.edu.ups.demoJakarta.model.LibroClase(COUNT(p.id), l.titulo) " +
                "FROM Libro l JOIN Prestamo p ON l.id = p.libro " +
                "GROUP BY l.id, l.titulo, l.autor " +
                "ORDER BY COUNT(p.id) DESC";
        Query query = entityManager.createQuery(jpql, LibroClase.class);
        return query.getResultList();
    }

}
