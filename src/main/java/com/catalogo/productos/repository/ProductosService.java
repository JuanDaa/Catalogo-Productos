package com.catalogo.productos.repository;

import com.catalogo.productos.config.app.HibernateUtil;
import com.catalogo.productos.entities.ProductosEntity;
import org.hibernate.Query;
import org.hibernate.Session;

import java.util.List;

public class ProductosService {
    Session session = HibernateUtil.getSessionFactory().openSession();

    public List<ProductosEntity> findAllProductos() {
        String hql = "from ProductosEntity where cantidadDisponible > 0";
        Query query = session.createQuery(hql);
        List<ProductosEntity> results = query.list();
        return results;
    }

    public void updateProducto(ProductosEntity producto) {
        session.beginTransaction();
        session.update(producto);
        session.getTransaction().commit();
    }
}
