package ec.edu.ups.demoJakarta.business;

import ec.edu.ups.demoJakarta.dao.PrestamoDAO;
import ec.edu.ups.demoJakarta.model.Prestamo;
import jakarta.ejb.Stateless;
import jakarta.inject.Inject;
import java.util.List;

@Stateless
public class GestionPrestamo {

    @Inject
    private PrestamoDAO prestamoDAO;

    public List<Prestamo> getAllPrestamos() {
        return prestamoDAO.findAll();
    }

    public Prestamo getPrestamoById(Long id) {
        return prestamoDAO.findById(id);
    }

    public Prestamo createPrestamo(Prestamo prestamo) {
        prestamoDAO.create(prestamo);
        return prestamo;
    }

    public void updatePrestamo(Prestamo prestamo) {
        prestamoDAO.update(prestamo);
    }

    public void deletePrestamo(Long id) {
        prestamoDAO.delete(id);
    }

    public List<Prestamo> getPrestamosByLibro(int libroId) {
        return prestamoDAO.findByLibro(libroId);
    }

    public List<Prestamo> getPrestamosByUsuario(int usuarioId) {
        return prestamoDAO.findByUsuario(usuarioId);
    }
}
