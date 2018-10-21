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
   public List<Usuario> buscaUsuario(Usuario u ) {
        EntityManagerFactory factory = Persistence
                .createEntityManagerFactory("HistoricoAcademicoJPA");
        entityManager = factory.createEntityManager();
        entityManager.getTransaction().begin();
    List<Usuario> listPersons = entityManager.createQuery(
            "SELECT u FROM Usuario u WHERE u.login = '"+u.getLogin()+"' AND u.senha ='" + u.getSenha()+"'").getResultList();
        entityManager.getTransaction().commit();
        entityManager.close();
        factory.close();
    if (listPersons == null) {
            System.out.println("No persons found . ");
        } else {
        for (Usuario usu : listPersons) {
        System.out.print("Usuario login= " + usu.getLogin() + ", senha= '" + usu.getSenha()+"'");
        }
    }

    return listPersons;
        }

    }

