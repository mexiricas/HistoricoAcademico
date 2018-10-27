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

@ManagedBean(name = "usuBean")
public class UsuarioBean implements Serializable {

    private Usuario usu = new Usuario();
    private Pessoas al = new Pessoas();
    private Utilidades util = new Utilidades();

    public String inserirAluno() {

        return "/cadastro?faces-redirect=true";
    }

    public String inserirAdm() {
        System.out.println("passou");
        return "/adm/cadastroAdm?faces-redirect=true";
    }

    public String logar() {
        if (util.validaUsuario(usu) == null) {
            return "index?faces-redirect=true";
        } else if (util.validaUsuario(usu).getTipo().equalsIgnoreCase("ROLE_ADM")){
            return "/adm/indexAdm";
        }else{
            return "/aluno/index";
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
