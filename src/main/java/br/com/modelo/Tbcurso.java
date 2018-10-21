/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.modelo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author Denis
 */
@Entity
@Table(name = "tbcurso")

public class Tbcurso implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_curso")
    private Integer idCurso;
    @Column(name = "nome")
    private String nome;
    @Column(name = "nome_corde")
    private String nomeCorde;
    @Column(name = "telefone_corde")
    private String telefoneCorde;

    public Tbcurso() {
    }

    public Tbcurso(Integer idCurso) {
        this.idCurso = idCurso;
    }

    public Tbcurso(Integer idCurso, String nome) {
        this.idCurso = idCurso;
        this.nome = nome;
    }

    public Integer getIdCurso() {
        return idCurso;
    }

    public void setIdCurso(Integer idCurso) {
        this.idCurso = idCurso;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getNomeCorde() {
        return nomeCorde;
    }

    public void setNomeCorde(String nomeCorde) {
        this.nomeCorde = nomeCorde;
    }

    public String getTelefoneCorde() {
        return telefoneCorde;
    }

    public void setTelefoneCorde(String telefoneCorde) {
        this.telefoneCorde = telefoneCorde;
    }

    @Override
    public String toString() {
        return nome;
    }

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "tbcurso", fetch = FetchType.EAGER)
    private List<Disciplina> disciplinaList = new ArrayList<Disciplina>();

    public List<Disciplina> getDisciplinaList() {
        return disciplinaList;
    }

    public void setDisciplinaList(List<Disciplina> disciplinaList) {
        this.disciplinaList = disciplinaList;
    }

}
