package edu.ilp.sysgailp.entity;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "fichaMatricula")
public class fichaMatricula {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idfichamatricula")
    private Long idfichaMatricula;

    @Column(name = "semestre", nullable = false, length = 50)
    private String semestre;

    @Column(name = "anioacademico", nullable = false, length = 100)
    private Date anioacademico;

    @Column(name = "fmatricula", nullable = false, length = 100)
    private String fmatricula;

    @Column(name = "idestudiante")
    private int idestudiante;

    @Column(name = "idasignatura")
    private int idasignatura;

    @JoinColumn(name = "codigo", nullable = false)
    @ManyToOne(optional = false, cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private Estudiante estudiante;


   @OneToMany(cascade = CascadeType.ALL)
    private List<Asignatura> asignatura;

    public fichaMatricula() {
    }

    public fichaMatricula(Long idfichaMatricula) {
        this.idfichaMatricula = idfichaMatricula;
    }

    public fichaMatricula(Long idfichaMatricula, String semestre, Date anioacademico, String fmatricula, int idestudiante, int idasignatura, Estudiante estudiante, List<Asignatura> asignatura) {
        this.idfichaMatricula = idfichaMatricula;
        this.semestre = semestre;
        this.anioacademico = anioacademico;
        this.fmatricula = fmatricula;
        this.idestudiante = idestudiante;
        this.idasignatura = idasignatura;
        this.estudiante = estudiante;
        this.asignatura = asignatura;
    }

    public Estudiante getEstudiante() {
        return estudiante;
    }

    public void setEstudiante(Estudiante estudiante) {
        this.estudiante = estudiante;
    }

    public Long getIdfichaMatricula() {
        return idfichaMatricula;
    }

    public void setIdfichaMatricula(Long idfichaMatricula) {
        this.idfichaMatricula = idfichaMatricula;
    }

    public String getSemestre() {
        return semestre;
    }

    public void setSemestre(String semestre) {
        this.semestre = semestre;
    }

    public Date getAnioacademico() {
        return anioacademico;
    }

    public void setAnioacademico(Date anioacademico) {
        this.anioacademico = anioacademico;
    }

    public String getFmatricula() {
        return fmatricula;
    }

    public void setFmatricula(String fmatricula) {
        this.fmatricula = fmatricula;
    }

    public int getIdestudiante() {
        return idestudiante;
    }

    public void setIdestudiante(int idestudiante) {
        this.idestudiante = idestudiante;
    }

    public int getIdasignatura() {
        return idasignatura;
    }

    public void setIdasignatura(int idasignatura) {
        this.idasignatura = idasignatura;
    }

    public List<Asignatura> getAsignatura() {
        return asignatura;
    }

    public void setAsignatura(List<Asignatura> asignatura) {
        this.asignatura = asignatura;
    }
}
