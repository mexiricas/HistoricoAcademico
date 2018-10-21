/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.modelo;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 *
 * @author Denis
 */
@Entity
@Table(name = "usuario")

public class Usuario implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = true)
    @Column(name = "id_usu")
    private int idUsu;
    @Basic(optional = true)
    @Column(name = "tipo")
    private String tipo;
    @Column(name = "login")
    private String login;
    @Basic(optional = true)
    @Column(name = "senha")
    private String senha;

    public Usuario() {
    }

    public Usuario(Integer idUsu) {
        this.idUsu = idUsu;
    }

    public Usuario(Integer idUsu, String tipo, String senha) {
        this.idUsu = idUsu;
        this.tipo = tipo;
        this.senha = senha;
    }

    public Integer getIdUsu() {
        return idUsu;
    }

    public void setIdUsu(Integer idUsu) {
        this.idUsu = idUsu;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public Pessoas getCpf() {
        return cpf;
    }

    public void setCpf(Pessoas cpf) {
        this.cpf = cpf;
    }

    @Override
    public String toString() {
        return "br.com.modelo.Usuario[ idUsu=" + idUsu + " ]";
    }

    @JoinColumn(name = "cpf", referencedColumnName = "cpf")
    @ManyToOne(optional = true)
    private Pessoas cpf;
}
