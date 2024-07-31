package ec.edu.ups.demoJakarta.business;

import ec.edu.ups.demoJakarta.dao.PrestamoHistorialDAO;
import ec.edu.ups.demoJakarta.model.PrestamoHistorial;
import ec.edu.ups.demoJakarta.model.Usuario;
import jakarta.ejb.Stateless;
import jakarta.inject.Inject;
import java.util.List;

@Stateless
public class GestionHistorial {

    @Inject
    private PrestamoHistorialDAO historialPrestamoDAO;

    public List<PrestamoHistorial> getHistorialByPrestamoId(Long prestamoId) {
        return historialPrestamoDAO.findAllByPrestamoId(prestamoId);
    }

    public void addHistorial(PrestamoHistorial historialPrestamo) {
        historialPrestamoDAO.create(historialPrestamo);
    }

    public List<PrestamoHistorial> getAllHistorialPrestamo() {
        return historialPrestamoDAO.getAll();
    }

}
