/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.dao;

import br.com.modelo.Aluno;
import java.io.Serializable;
import javax.persistence.EntityManager;
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
        
       entityManager = Persistence.createEntityManagerFactory("HistoricoAcademicoJPA").createEntityManager();
        entityManager.getTransaction().begin();
       Query query = entityManager.createQuery("SELECT l FROM tbaluno l Where l.cpf = '" + al.getCpf() + "'", Aluno.class);
        
        Aluno lv = (Aluno) query.getSingleResult();
        if (lv.getCpf().isEmpty()) {
            return false;
        }
        entityManager.close();
        return true;
    }
}
