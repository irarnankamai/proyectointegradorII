package ec.edu.ups.demoJakarta.views;

import ec.edu.ups.demoJakarta.business.GestionHistorial;
import ec.edu.ups.demoJakarta.business.GestionLibro;
import ec.edu.ups.demoJakarta.model.PrestamoHistorial;
import ec.edu.ups.demoJakarta.model.LibroClase;
import jakarta.annotation.PostConstruct;
import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Inject;
import jakarta.inject.Named;

import java.io.Serializable;
import java.util.List;
import java.util.stream.Collectors;

@Named("historial")
@RequestScoped
public class VistaHistorial implements Serializable {

    @Inject
    private GestionHistorial gestionHistorialPrestamo;

    @Inject
    private GestionLibro gestionLibro;

    private PrestamoHistorial historialPrestamo = new PrestamoHistorial();

    private LibroClase libroClase = new LibroClase();
    private List<PrestamoHistorial> historialPrestamoList;
    private List<LibroClase> claseList;

    @PostConstruct
    public void init() {
        historialPrestamoList = gestionHistorialPrestamo.getAllHistorialPrestamo();
        claseList = gestionLibro.librosReporte();
    }


    public GestionHistorial getGestionHistorialPrestamo() {
        return gestionHistorialPrestamo;
    }

    public void setGestionHistorialPrestamo(GestionHistorial gestionHistorialPrestamo) {
        this.gestionHistorialPrestamo = gestionHistorialPrestamo;
    }

    public PrestamoHistorial getHistorialPrestamo() {
        return historialPrestamo;
    }

    public void setHistorialPrestamo(PrestamoHistorial historialPrestamo) {
        this.historialPrestamo = historialPrestamo;
    }

    public List<PrestamoHistorial> getHistorialPrestamoList() {
        return historialPrestamoList;
    }

    public void setHistorialPrestamoList(List<PrestamoHistorial> historialPrestamoList) {
        this.historialPrestamoList = historialPrestamoList;
    }

    public GestionLibro getGestionLibro() {
        return gestionLibro;
    }

    public void setGestionLibro(GestionLibro gestionLibro) {
        this.gestionLibro = gestionLibro;
    }

    public LibroClase getLibroClase() {
        return libroClase;
    }

    public void setLibroClase(LibroClase libroClase) {
        this.libroClase = libroClase;
    }

    public List<LibroClase> getClaseList() {
        return claseList;
    }

    public void setClaseList(List<LibroClase> claseList) {
        this.claseList = claseList;
    }

    public String getNombresDeLibros() {
        return claseList.stream()
                .map(libro -> "\"" + libro.getNombreLibro() + "\"")
                .collect(Collectors.joining(", "));
    }

    public String getCantidadesDeLibros() {
        return claseList.stream()
                .map(libro -> String.valueOf(libro.getCantidad()))
                .collect(Collectors.joining(", "));
    }
}
