package unam.fes.historicoacuerdos.model;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "acuerdo")
public class Acuerdo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_acuerdo")
    private Integer idAcuerdo;

    @Column(length = 100, nullable = false)
    private String persona;

    @Column(length = 100, nullable = false)
    private String area;

    @Column(columnDefinition = "TEXT", nullable = false)
    private String asunto;

    @Column(nullable = false)
    private LocalDate fecha;

    @Column(length = 64, unique = true, nullable = false)
    private String hash;

    // Getters y setters

    public Integer getIdAcuerdo() {
        return idAcuerdo;
    }

    public void setIdAcuerdo(Integer idAcuerdo) {
        this.idAcuerdo = idAcuerdo;
    }

    public String getPersona() {
        return persona;
    }

    public void setPersona(String persona) {
        this.persona = persona;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public String getAsunto() {
        return asunto;
    }

    public void setAsunto(String asunto) {
        this.asunto = asunto;
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
