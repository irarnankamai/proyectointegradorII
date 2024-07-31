package ec.edu.ups.demoJakarta.model;

import jakarta.persistence.*;
import jakarta.json.bind.annotation.JsonbDateFormat;
import java.util.Date;

@Entity
@Table(name = "TBL_PRESTAMO")
public class Prestamo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private int dias;

    private int caducado;

    @Temporal(TemporalType.DATE)
    @JsonbDateFormat("yyyy-MM-dd")
    private Date fechaInicio;

    @Temporal(TemporalType.DATE)
    @JsonbDateFormat("yyyy-MM-dd")
    private Date fechaFin;

    private int estado;

    private int libro;
    private int usuario;

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }


    public Date getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(Date fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public Date getFechaFin() {
        return fechaFin;
    }

    public void setFechaFin(Date fechaFin) {
        this.fechaFin = fechaFin;
    }

    public int getEstado() {
        return estado;
    }

    public void setEstado(int estado) {
        this.estado = estado;
    }

    public int getUsuario() {
        return usuario;
    }

    public void setUsuario(int usuario) {
        this.usuario = usuario;
    }

    public int getLibro() {
        return libro;
    }

    public void setLibro(int libro) {
        this.libro = libro;
    }

    public int getDias() {
        return dias;
    }

    public void setDias(int dias) {
        this.dias = dias;
    }

    public int getCaducado() {
        return caducado;
    }

    public void setCaducado(int caducado) {
        this.caducado = caducado;
    }
}
