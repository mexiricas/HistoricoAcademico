/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.dao;

import br.com.modelo.Aluno;
import java.io.Serializable;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

/**
 *
 * @author Denis
 */
public class AlunoDao implements Serializable {

    private EntityManager entityManager;

    public void inserir(Aluno al) {

        entityManager = Persistence.createEntityManagerFactory("HistoricoAcademicoJPA").createEntityManager();
        entityManager.getTransaction().begin();
        entityManager.persist(al);

        entityManager.getTransaction().commit();
        entityManager.close();

    }

    public boolean valida(Aluno al) {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("HistoricoAcademicoJPA");
        EntityManager manager = factory.createEntityManager();
        manager.getTransaction().begin();
        Query query = manager.createQuery("SELECT l FROM tbaluno l Where l.id = '" + al.getCpf() + "'", Aluno.class);
        Aluno lv = (Aluno) query.getSingleResult();
        if (lv.getCpf().isEmpty()) {
            return false;
        }
        manager.close();
        return true;
    }
}
