package com.catalogo.productos.entities;

import java.util.Objects;

@javax.persistence.Entity
@javax.persistence.Table(name = "productos", schema = "productos_venta", catalog = "")
public class ProductosEntity {
    private int id;
    private double precio;
    private String imagenProducto;
    private String descripcion;
    private String color;
    private int cantidadDisponible;
    private String nombre;

    @javax.persistence.Id
    @javax.persistence.Column(name = "producto_id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @javax.persistence.Basic
    @javax.persistence.Column(name = "precio")
    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    @javax.persistence.Basic
    @javax.persistence.Column(name = "imagen_producto")
    public String getImagenProducto() {
        return imagenProducto;
    }

    public void setImagenProducto(String imagenProducto) {
        this.imagenProducto = imagenProducto;
    }

    @javax.persistence.Basic
    @javax.persistence.Column(name = "descripcion")
    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    @javax.persistence.Basic
    @javax.persistence.Column(name = "color")
    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    @javax.persistence.Basic
    @javax.persistence.Column(name = "cantidad_disponible")
    public int getCantidadDisponible() {
        return cantidadDisponible;
    }

    public void setCantidadDisponible(int cantidadDisponible) {
        this.cantidadDisponible = cantidadDisponible;
    }

    @javax.persistence.Basic
    @javax.persistence.Column(name = "nombre")
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ProductosEntity that = (ProductosEntity) o;
        return id == that.id &&
                Double.compare(that.precio, precio) == 0 &&
                Objects.equals(descripcion ,that.descripcion) &&
                cantidadDisponible == that.cantidadDisponible &&
                Objects.equals(imagenProducto, that.imagenProducto) &&
                Objects.equals(color, that.color) &&
                Objects.equals(nombre, that.nombre);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, precio, imagenProducto, descripcion, color, cantidadDisponible, nombre);
    }
}
