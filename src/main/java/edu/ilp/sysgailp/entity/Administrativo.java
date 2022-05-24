package edu.ilp.sysgailp.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import java.util.Date;

@Entity
@Table(name = "administrativo")
@PrimaryKeyJoinColumn(referencedColumnName = "IDPERSONA")
public class Administrativo extends Persona {
    @Column(name = "admin_codigo",length = 10,nullable = false)
    private String AdminCodigo;
    @Column(name = "cargo",length = 50)
    private String cargo;

    public Administrativo() {
    }

    public Administrativo(Long idpersona, String adminCodigo, String cargo) {
        super(idpersona);
        AdminCodigo = adminCodigo;
        this.cargo = cargo;
    }

    public Administrativo(String adminCodigo, String cargo) {
        AdminCodigo = adminCodigo;
        this.cargo = cargo;
    }

    public Administrativo(String nombre, String apellido, String edad, String dni, Date fechaNacimiento, String genero, String adminCodigo, String cargo) {
        super(nombre, apellido, edad, dni, fechaNacimiento, genero);
        AdminCodigo = adminCodigo;
        this.cargo = cargo;
    }

    public String getAdminCodigo() {
        return AdminCodigo;
    }

    public void setAdminCodigo(String adminCodigo) {
        AdminCodigo = adminCodigo;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }
}
