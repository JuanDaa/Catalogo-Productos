package com.catalogo.productos.entities;

import java.sql.Date;
import java.util.Objects;

@javax.persistence.Entity
@javax.persistence.Table(name = "usuarios", schema = "productos_venta", catalog = "")
public class UsuariosEntity {
    private int id;
    private String correo;
    private String contrasenia;
    private Date fechaCracion;

    @javax.persistence.Id
    @javax.persistence.Column(name = "usuario_id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @javax.persistence.Basic
    @javax.persistence.Column(name = "correo")
    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    @javax.persistence.Basic
    @javax.persistence.Column(name = "contrasenia")
    public String getContrasenia() {
        return contrasenia;
    }

    public void setContrasenia(String contrasenia) {
        this.contrasenia = contrasenia;
    }

    @javax.persistence.Basic
    @javax.persistence.Column(name = "fecha_cracion")
    public Date getFechaCracion() {
        return fechaCracion;
    }

    public void setFechaCracion(Date fechaCracion) {
        this.fechaCracion = fechaCracion;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UsuariosEntity that = (UsuariosEntity) o;
        return id == that.id &&
                Objects.equals(correo, that.correo) &&
                Objects.equals(contrasenia, that.contrasenia) &&
                Objects.equals(fechaCracion, that.fechaCracion);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, correo, contrasenia, fechaCracion);
    }
}
