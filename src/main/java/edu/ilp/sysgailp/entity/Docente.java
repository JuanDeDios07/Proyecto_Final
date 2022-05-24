package edu.ilp.sysgailp.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import java.util.Date;

@Entity
@Table(name = "docente")
@PrimaryKeyJoinColumn(referencedColumnName = "IDPERSONA")
public class Docente extends Persona {
    @Column(name = "codigoi_docente",length = 10,nullable = false)
    private String codigoDocente;
    @Column(name = "curso",length = 50)
    private String curso;
    @Column(name = "horas_asignadas",length = 10)
    private String horasAsignadas;

    public Docente() {
    }

    public Docente(Long idpersona, String codigoDocente, String curso, String horasAsignadas) {
        super(idpersona);
        this.codigoDocente = codigoDocente;
        this.curso = curso;
        this.horasAsignadas = horasAsignadas;
    }

    public Docente(String codigoDocente, String curso, String horasAsignadas) {
        this.codigoDocente = codigoDocente;
        this.curso = curso;
        this.horasAsignadas = horasAsignadas;
    }

    public Docente(String nombre, String apellido, String edad, String dni, Date fechaNacimiento, String genero, String codigoDocente, String curso, String horasAsignadas) {
        super(nombre, apellido, edad, dni, fechaNacimiento, genero);
        this.codigoDocente = codigoDocente;
        this.curso = curso;
        this.horasAsignadas = horasAsignadas;
    }

    public String getCodigoDocente() {
        return codigoDocente;
    }

    public void setCodigoDocente(String codigoDocente) {
        this.codigoDocente = codigoDocente;
    }

    public String getCurso() {
        return curso;
    }

    public void setCurso(String curso) {
        this.curso = curso;
    }

    public String getHorasAsignadas() {
        return horasAsignadas;
    }

    public void setHorasAsignadas(String horasAsignadas) {
        this.horasAsignadas = horasAsignadas;
    }
}
