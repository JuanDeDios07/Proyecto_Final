package edu.ilp.sysgailp.entity;

import javax.persistence.*;

@Entity
@Table(name = "asignatura")
public class Asignatura {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idasignatura",length = 10)
    private Long idasignatura;

    @Column(name = "sigla", nullable = false,length = 50)
    private String sigla;

    @Column(name = "denominacion", nullable = false,length = 50)
    private String denominacion;

    @Column(name = "creditos", nullable = false,length = 50)
    private String creditos;

    @Column(name = "hteoricas", nullable = false,length = 50)
    private String hteoricas;

    @Column(name = "hpracticas", nullable = false,length = 50)
    private String hpracticas;

    public Asignatura() {
    }

    public Asignatura(Long idasignatura) {
        this.idasignatura = idasignatura;
    }

    public Asignatura(Long idasignatura, String sigla, String denominacion, String creditos, String hteoricas, String hpracticas) {
        this.idasignatura = idasignatura;
        this.sigla = sigla;
        this.denominacion = denominacion;
        this.creditos = creditos;
        this.hteoricas = hteoricas;
        this.hpracticas = hpracticas;
    }

    public Long getIdasignatura() {
        return idasignatura;
    }

    public void setIdasignatura(Long idasignatura) {
        this.idasignatura = idasignatura;
    }

    public String getSigla() {
        return sigla;
    }

    public void setSigla(String sigla) {
        this.sigla = sigla;
    }

    public String getDenominacion() {
        return denominacion;
    }

    public void setDenominacion(String denominacion) {
        this.denominacion = denominacion;
    }

    public String getCreditos() {
        return creditos;
    }

    public void setCreditos(String creditos) {
        this.creditos = creditos;
    }

    public String getHteoricas() {
        return hteoricas;
    }

    public void setHteoricas(String hteoricas) {
        this.hteoricas = hteoricas;
    }

    public String getHpracticas() {
        return hpracticas;
    }

    public void setHpracticas(String hpracticas) {
        this.hpracticas = hpracticas;
    }
}
