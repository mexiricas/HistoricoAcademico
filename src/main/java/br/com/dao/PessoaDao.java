/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.dao;

import ConnectionFactory.MyConnectionPostgresSQL;
import br.com.modelo.Pessoas;
import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

/**
 *
 * @author Denis
 */
public class PessoaDao implements Serializable {

    private EntityManager entityManager;
    private MyConnectionPostgresSQL connection = new MyConnectionPostgresSQL();

    public void inserirPessoas(Pessoas al) {

        entityManager = Persistence.createEntityManagerFactory("HistoricoAcademicoJPA").createEntityManager();
        entityManager.getTransaction().begin();
        entityManager.persist(al);

        entityManager.getTransaction().commit();
        entityManager.close();

    }

    public List<Pessoas> buscarAluno(Pessoas al) {
        List<Pessoas> ls = new ArrayList<>();
        if (connection.conecta() == false) {
            System.out.println("Falha na conexão com o banco de dados");
            return null;
        }
        try {
            String sql = "SELECT * FROM TBALUNO T WHERE T.CPF = '" + al.getCpf() + "'";
            Connection conexao = connection.getConnection();
            PreparedStatement comando = conexao.prepareStatement(sql);
            ResultSet rs = comando.executeQuery();
            while (rs.next()) {
                Pessoas alu = new Pessoas();
                alu.setCpf(rs.getString("cpf"));
                alu.setNome(rs.getString("nome"));
                alu.setDataNascimeto(rs.getDate("data_nascimento"));
                ls.add(alu);
            }
            comando.close();
            rs.close();

        } catch (Exception e) {
            System.out.println("Erro na consulta SQL");
            System.out.println(e.getMessage());
        }
        connection.encerra();
        return ls;

    }
}
