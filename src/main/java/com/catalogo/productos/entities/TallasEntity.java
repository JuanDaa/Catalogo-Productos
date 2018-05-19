package com.catalogo.productos.entities;

import java.util.Objects;

@javax.persistence.Entity
@javax.persistence.Table(name = "tallas", schema = "productos_venta", catalog = "")
public class TallasEntity {
    private int id;
    private String nombreTalla;

    @javax.persistence.Id
    @javax.persistence.Column(name = "id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @javax.persistence.Basic
    @javax.persistence.Column(name = "nombre_talla")
    public String getNombreTalla() {
        return nombreTalla;
    }

    public void setNombreTalla(String nombreTalla) {
        this.nombreTalla = nombreTalla;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TallasEntity that = (TallasEntity) o;
        return id == that.id &&
                Objects.equals(nombreTalla, that.nombreTalla);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, nombreTalla);
    }
}
