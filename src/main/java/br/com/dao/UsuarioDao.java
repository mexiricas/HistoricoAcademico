/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.dao;

import ConnectionFactory.MyConnectionPostgresSQL;
import br.com.modelo.Usuario;
import java.io.Serializable;
import javax.persistence.EntityManager;
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

}
