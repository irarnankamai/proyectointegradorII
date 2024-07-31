package ec.edu.ups.demoJakarta.model;

import jakarta.persistence.*;
import java.util.Date;

@Entity
@Table(name = "TBL_HISTORIALPRESTAMO")
public class PrestamoHistorial {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "prestamo_id", nullable = false)
    private Prestamo prestamo;

    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaEvento;

    private String tipoEvento;
    private String descripcion;

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Prestamo getPrestamo() {
        return prestamo;
    }

    public void setPrestamo(Prestamo prestamo) {
        this.prestamo = prestamo;
    }

    public Date getFechaEvento() {
        return fechaEvento;
    }

    public void setFechaEvento(Date fechaEvento) {
        this.fechaEvento = fechaEvento;
    }

    public String getTipoEvento() {
        return tipoEvento;
    }

    public void setTipoEvento(String tipoEvento) {
        this.tipoEvento = tipoEvento;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
}
