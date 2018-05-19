package com.catalogo.productos.repository;

import com.catalogo.productos.config.app.HibernateUtil;
import com.catalogo.productos.entities.User;
import com.catalogo.productos.entities.UsuariosEntity;
import org.hibernate.Session;

public class UsuarioService {
    Session session = HibernateUtil.getSessionFactory().openSession();
    public UsuariosEntity getUsuario(int idUser) {
        return  (UsuariosEntity) session.get(UsuariosEntity.class, idUser);
    }
}
