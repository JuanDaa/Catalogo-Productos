package com.catalogo.productos.web;
import com.catalogo.productos.entities.CompraProductoEntity;
import com.catalogo.productos.entities.ProductosEntity;
import com.catalogo.productos.entities.UsuariosEntity;
import com.catalogo.productos.repository.CompraProductoService;
import com.catalogo.productos.repository.ProductosService;
import com.catalogo.productos.repository.UsuarioService;
import org.primefaces.context.RequestContext;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import java.io.Serializable;
import java.util.List;

@ManagedBean
@ViewScoped
public class CatalogoBean implements Serializable {

    private static final long serialVersionUID = 1L;
    private List<ProductosEntity> listaProductos;
    private List<CompraProductoEntity> listaCompras;

    private ProductosService productosService;
    private UsuarioService usuarioService;
    private CompraProductoService compraProductoService;

    private ProductosEntity productoSeleccionado;
    private ProductosEntity cargaProductoSeleccionado;
    private CompraProductoEntity compraSeleccionada;
    private CompraProductoEntity infoCompra;
    private UsuariosEntity usuariosEntity;
    private int cantidadComprar = 1;

    public CatalogoBean(){
    }

    @PostConstruct
    public void init() {
        productosService = new ProductosService();
        compraProductoService = new CompraProductoService();
        usuarioService = new UsuarioService();
        listaProductos = productosService.findAllProductos();
        listaCompras = compraProductoService.findAllCompras();
        usuariosEntity = usuarioService.getUsuario(1);
        cargaProductoSeleccionado = new ProductosEntity();
    }

    public void comprarProductos() {

        if (cantidadComprar == 0){
            FacesContext context = FacesContext.getCurrentInstance();
            context.addMessage(null, new FacesMessage("Debe agregar una cantidad valida", "Error"));
            return;
        }
        compraProductoService = new CompraProductoService();
        int nuevaCantidadProducto = cargaProductoSeleccionado.getCantidadDisponible() - cantidadComprar;
        ProductosEntity productoAcomprar = cargaProductoSeleccionado;

        infoCompra = new CompraProductoEntity();
        infoCompra.setFechaCompra(java.sql.Date.valueOf("2018-05-19"));
        infoCompra.setCantidadAdquirida(cantidadComprar);
        infoCompra.setUsuario(usuariosEntity);
        infoCompra.setProducto(productoAcomprar);
        infoCompra.setNombreProducto(cargaProductoSeleccionado.getNombre());

        compraProductoService.save(infoCompra);

        productoAcomprar.setCantidadDisponible(nuevaCantidadProducto);
        productosService.updateProducto(productoAcomprar);

        FacesContext context = FacesContext.getCurrentInstance();
        context.addMessage(null, new FacesMessage("La compra se ha realizado con exito", "Guardado") );

        RequestContext.getCurrentInstance().execute("PF('productoDialog').hide()");

        listaProductos = productosService.findAllProductos();
    }

    public void cargarProductoSeleccionado() {
        cargaProductoSeleccionado = productoSeleccionado;
    }

    public List<ProductosEntity> getListaProductos() {
        return listaProductos;
    }

    public void setListaProductos(List<ProductosEntity> listaProductos) {
        this.listaProductos = listaProductos;
    }

    public ProductosEntity getProductoSeleccionado() {
        return productoSeleccionado;
    }

    public void setProductoSeleccionado(ProductosEntity productoSeleccionado) {
        this.productoSeleccionado = productoSeleccionado;
    }

    public int getCantidadComprar() {
        return cantidadComprar;
    }

    public void setCantidadComprar(int cantidadComprar) {
        this.cantidadComprar = cantidadComprar;
    }

    public List<CompraProductoEntity> getListaCompras() {
        return listaCompras;
    }

    public void setListaCompras(List<CompraProductoEntity> listaCompras) {
        this.listaCompras = listaCompras;
    }

    public CompraProductoEntity getCompraSeleccionada() {
        return compraSeleccionada;
    }

    public void setCompraSeleccionada(CompraProductoEntity compraSeleccionada) {
        this.compraSeleccionada = compraSeleccionada;
    }
}