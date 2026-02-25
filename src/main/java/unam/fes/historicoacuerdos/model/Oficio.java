package unam.fes.historicoacuerdos.model;

import jakarta.persistence.Entity;
import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "oficio")
public class Oficio {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idOficio;

    private String persona;

    private String area;

    @Column(columnDefinition = "TEXT")
    private String asunto;

    private LocalDate fecha;

    @Column(unique = true, length = 64)
    private String hash;

    // getters y setters

    public String getPersona() {
        return persona;
    }

    public void setPersona(String persona) {
        this.persona = persona;
    }

    public Integer getIdOficio() {
        return idOficio;
    }

    public void setIdOficio(Integer idOficio) {
        this.idOficio = idOficio;
    }

    public String getAsunto() {
        return asunto;
    }

    public void setAsunto(String asunto) {
        this.asunto = asunto;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public String getHash() {
        return hash;
    }

    public void setHash(String hash) {
        this.hash = hash;
    }
}

