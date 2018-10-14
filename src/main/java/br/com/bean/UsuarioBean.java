/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.bean;

import br.com.dao.AlunoDao;
import br.com.modelo.Aluno;
import br.com.modelo.Usuario;
import br.com.util.Utilidades;
import java.io.Serializable;
import javax.faces.bean.ManagedBean;

@ManagedBean(name = "usuBean")
public class UsuarioBean implements Serializable {

    private Usuario usu = new Usuario();
    private Aluno al = new Aluno();
    private Utilidades util = new Utilidades();

    public String inserir() {

        return "cadastro";
    }

    public String logar() {
        boolean test = util.valida(al);

        if (test == true) {
            return "index?faces-redirect=true";
        } else {
            return "/adm/indexAdm";
            
        }

    }

    //getter e setter
    public Usuario getUsu() {
        return usu;
    }

    public void setUsu(Usuario usu) {
        this.usu = usu;
    }

    public Utilidades getUtil() {
        return util;
    }

    public void setUtil(Utilidades util) {
        this.util = util;
    }

}
