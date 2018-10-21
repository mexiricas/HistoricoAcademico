/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.dao;

import ConnectionFactory.MyConnectionPostgresSQL;
import br.com.modelo.Tbcurso;
import java.io.Serializable;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author Denis
 */
public class CursoDao implements Serializable {

    private EntityManager entityManager;
    private MyConnectionPostgresSQL connection = new MyConnectionPostgresSQL();

    public void inserirCurso(Tbcurso cr) {

        entityManager = Persistence.createEntityManagerFactory("HistoricoAcademicoJPA").createEntityManager();
        entityManager.getTransaction().begin();
        entityManager.persist(cr);

        entityManager.getTransaction().commit();
        entityManager.close();

    }

    public void atualizaCurso(Tbcurso cr) {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("HistoricoAcademicoJPA");
        entityManager = factory.createEntityManager();
        entityManager.getTransaction().begin();
        Tbcurso c = (Tbcurso) entityManager.createQuery(
                "SELECT t FROM Tbcurso t WHERE t.nome = '" + cr.getNome() + "' AND t.nomeCorde = '" + cr.getNomeCorde() + "'").getSingleResult();
        c.setNome(cr.getNome());
        c.setNomeCorde(cr.getNomeCorde());
        c.setTelefoneCorde(c.getTelefoneCorde());
        c.setDisciplinaList(cr.getDisciplinaList());
        entityManager.persist(c);
        entityManager.getTransaction().commit();
        entityManager.close();
        factory.close();

    }

    public List<Tbcurso> buscarIdCurso(Tbcurso c) {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("HistoricoAcademicoJPA");
        List<Tbcurso> lisCursos;
        entityManager = factory.createEntityManager();
        entityManager.getTransaction().begin();
        if (c.getNome() != null) {
            lisCursos = entityManager.createQuery(
                    "SELECT t FROM Tbcurso t WHERE t.nome = '" + c.getNome() + "' AND t.nomeCorde = '" + c.getNomeCorde() + "'").getResultList();
        } else {
            lisCursos = entityManager.createQuery(
                    "SELECT t FROM Tbcurso t").getResultList();

        }
        entityManager.getTransaction().commit();
        entityManager.close();
        factory.close();

        return lisCursos;
    }
}
