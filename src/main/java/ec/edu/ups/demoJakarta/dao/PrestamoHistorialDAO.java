package ec.edu.ups.demoJakarta.dao;


import ec.edu.ups.demoJakarta.model.PrestamoHistorial;
import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;

import java.io.Serializable;
import java.util.List;

@Stateless
public class PrestamoHistorialDAO implements Serializable {

    @PersistenceContext()
    private EntityManager entityManager;

    public List<PrestamoHistorial> findAllByPrestamoId(Long prestamoId) {
        String jpql = "SELECT h FROM PrestamoHistorial h WHERE h.prestamo.id = :prestamoId";
        Query query = entityManager.createQuery(jpql, PrestamoHistorial.class);
        query.setParameter("prestamoId", prestamoId);
        return query.getResultList();
    }
    public List<PrestamoHistorial> getAll(){
        String jpql = "SELECT c FROM PrestamoHistorial c";
        Query query = entityManager.createQuery(jpql, PrestamoHistorial.class);
        return query.getResultList();
    }
    public void create(PrestamoHistorial historialPrestamo) {
        entityManager.persist(historialPrestamo);
    }
}
