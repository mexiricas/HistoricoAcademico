/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.bean;

import br.com.dao.PessoaDao;
import br.com.modelo.Pessoas;
import br.com.modelo.Usuario;
import br.com.util.Utilidades;
import java.io.Serializable;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@SessionScoped
@ManagedBean(name = "usuBean")
public class UsuarioBean implements Serializable {

    private static final long serialVersionUID = 1L;
    private Usuario usu = new Usuario();
    private Pessoas al = new Pessoas();
    private Utilidades util = new Utilidades();

    public String sair() {
        usu = new Usuario();
        al = new Pessoas();
        return "/public/index";
    }

    public String inserirAluno() {
        return "/public/cadastro?faces-redirect=true";
    }

    public String inserirAdm() {
        return "/adm/cadastroAdm?faces-redirect=true";
    }

    public String logar() {
        usu = util.validaUsuario(usu);
        if (usu.getTipo() != null) {
            if (usu.getTipo().equalsIgnoreCase("ROLE_ADM")) {
                return "/adm/indexAdm";
            } else if (usu.getTipo().equalsIgnoreCase("ROLE_ALUNO")) {
                return "/aluno/indexAluno";
            }
        }
        usu = new Usuario();
        return "/public/index";
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
