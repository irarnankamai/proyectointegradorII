package ec.edu.ups.demoJakarta.views;

import ec.edu.ups.demoJakarta.business.GestionLibro;
import ec.edu.ups.demoJakarta.model.Libro;
import jakarta.annotation.PostConstruct;
import jakarta.enterprise.context.RequestScoped;
import jakarta.faces.application.FacesMessage;
import jakarta.faces.context.FacesContext;
import jakarta.inject.Inject;
import jakarta.inject.Named;

import java.io.Serializable;
import java.util.List;

@Named("librobean")
@RequestScoped
public class VistaLibro implements Serializable {
    @Inject
    private GestionLibro geLibro;

    private Libro libro = new Libro();

    private List<Libro> libroList;
    private int idBuscado;

    @PostConstruct
    public void init() {
        libroList = geLibro.getAllLibros();
    }

    public Libro getLibro() {
        return libro;
    }

    public void setLibro(Libro libro) {
        this.libro = libro;
    }

    public List<Libro> getLibroList() {
        return libroList;
    }

    public void setLibroList(List<Libro> libroList) {
        this.libroList = libroList;
    }

    public int getIdBuscado() {
        return idBuscado;
    }

    public void setIdBuscado(int idBuscado) {
        this.idBuscado = idBuscado;
    }

    public String guardar() {
       try {
           libro.setEstado(1);
           geLibro.updateLibro(libro);
           return "inicio?faces-redirect=true";
       }catch (Exception e){
           e.printStackTrace();
           return "error";
       }

    }

    public void buscar(){
        this.libro = geLibro.getLibroById(Long.parseLong(String.valueOf(idBuscado)));
        if (libro == null) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "No se encontró el libro", "No existe un libro con el ID proporcionado."));
        }
    }
    public String actualizar (){
        try {
            geLibro.updateLibro(libro);
            return "principal?faces-redirect=true";
        }catch (Exception e){
            e.printStackTrace();
            return "error";
        }
    }

    public String eliminar (){
        try {
            geLibro.deleteLibro(libro.getId());
            return "principal?faces-redirect=true";
        }catch (Exception e){
            e.printStackTrace();
            return "error";
        }
    }



}
