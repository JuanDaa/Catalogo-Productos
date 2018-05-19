package com.catalogo.productos.entities;

import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.sql.Date;
import java.util.Objects;

@javax.persistence.Entity
@javax.persistence.Table(name = "compra_producto", schema = "productos_venta", catalog = "")
public class CompraProductoEntity {
    private int id;
    private Date fechaCompra;
    private int cantidadAdquirida;
    private String nombreProducto;

    @javax.persistence.Id
    @javax.persistence.Column(name = "id")
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }

    @javax.persistence.Basic
    @javax.persistence.Column(name = "fecha_compra")
    public Date getFechaCompra() {
        return fechaCompra;
    }

    public void setFechaCompra(Date fechaCompra) {
        this.fechaCompra = fechaCompra;
    }

    @javax.persistence.Basic
    @javax.persistence.Column(name = "cantidad_adquirida")
    public int getCantidadAdquirida() {
        return cantidadAdquirida;
    }

    public void setCantidadAdquirida(int cantidadAdquirida) {
        this.cantidadAdquirida = cantidadAdquirida;
    }

    @ManyToOne
    @JoinColumn(name="usuario_id")
    private UsuariosEntity usuario;

    public void setUsuario(UsuariosEntity usuario) {
        this.usuario = usuario;
    }

    @ManyToOne
    @JoinColumn(name="producto_id")
    private ProductosEntity producto;

    public void setProducto(ProductosEntity producto) {
        this.producto = producto;
    }

    @javax.persistence.Basic
    @javax.persistence.Column(name = "nombre_producto")
    public String getNombreProducto() {
        return nombreProducto;
    }

    public void setNombreProducto(String nombreProducto) {
        this.nombreProducto = nombreProducto;
    }



    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CompraProductoEntity that = (CompraProductoEntity) o;
        return id == that.id &&
                cantidadAdquirida == that.cantidadAdquirida &&
                Objects.equals(fechaCompra, that.fechaCompra) &&
                Objects.equals(nombreProducto, that.nombreProducto);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, fechaCompra, cantidadAdquirida,usuario,producto,nombreProducto);
    }
}
