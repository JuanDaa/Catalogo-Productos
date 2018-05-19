package com.catalogo.productos.repository;

import com.catalogo.productos.config.app.HibernateUtil;
import com.catalogo.productos.entities.CompraProductoEntity;
import com.catalogo.productos.entities.ProductosEntity;
import com.catalogo.productos.entities.User;
import org.hibernate.Query;
import org.hibernate.Session;

import java.util.List;

public class CompraProductoService {
    Session session =  HibernateUtil.getSessionFactory().openSession();
    public void save(CompraProductoEntity infoCompra){
        session.beginTransaction();
        session.save(infoCompra);
        session.getTransaction().commit();

    }

    public List<CompraProductoEntity> findAllCompras() {
        String hql = "from CompraProductoEntity";
        Query query = session.createQuery(hql);
        List<CompraProductoEntity> results = query.list();
        return results;
    }
}
