/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.dao;

import ConnectionFactory.MyConnectionPostgresSQL;
import br.com.modelo.Usuario;
import java.io.Serializable;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author Denis
 */
public class UsuarioDao implements Serializable {

    private static final long serialVersionUID = 1L;
    private EntityManager entityManager;
    private MyConnectionPostgresSQL connection = new MyConnectionPostgresSQL();

    public void inserir(Usuario us) {

        entityManager = Persistence.createEntityManagerFactory("HistoricoAcademicoJPA").createEntityManager();
        entityManager.getTransaction().begin();
        entityManager.persist(us);

        entityManager.getTransaction().commit();
        entityManager.close();

    }

    public Usuario buscaUsuario(Usuario u) {
        Usuario usua = new Usuario();
        EntityManagerFactory factory = Persistence
                .createEntityManagerFactory("HistoricoAcademicoJPA");
        try {
            entityManager = factory.createEntityManager();
            entityManager.getTransaction().begin();
            usua = (Usuario) entityManager.createQuery(
                    "SELECT u FROM Usuario u WHERE u.login = '" + u.getLogin() + "' AND u.senha ='" + u.getSenha() + "'", Usuario.class).getSingleResult();
            entityManager.getTransaction().commit();
        } catch (Exception e) {
            System.out.println("no person");
        }
        entityManager.close();
        factory.close();
        return usua;
    }

}
