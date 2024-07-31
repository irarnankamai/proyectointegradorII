package ec.edu.ups.demoJakarta.business;

import ec.edu.ups.demoJakarta.dao.LibroDAO;
import ec.edu.ups.demoJakarta.model.Libro;
import ec.edu.ups.demoJakarta.model.LibroClase;
import jakarta.ejb.Stateless;
import jakarta.inject.Inject;
import java.util.List;

@Stateless
public class GestionLibro {

    @Inject
    private LibroDAO libroDAO;

    public List<Libro> getAllLibros() {
        return libroDAO.findAll();
    }

    public Libro getLibroById(Long id) {
        return libroDAO.findById(id);
    }

    public Libro createLibro(Libro libro) {
        libroDAO.create(libro);
        return libro;
    }

    public void updateLibro(Libro libro) {
        libroDAO.update(libro);
    }

    public void deleteLibro(Long id) {
        libroDAO.delete(id);
    }

    public List<LibroClase> librosReporte() {
        return libroDAO.obtenerLibrosMasPrestados();
    }
}
