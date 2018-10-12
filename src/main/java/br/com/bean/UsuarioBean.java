/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.bean;

import br.com.modelo.Usuario;
import java.io.Serializable;
import javax.faces.bean.ManagedBean;

@ManagedBean(name = "usuBean")
public class UsuarioBean implements Serializable {

    private Usuario usu = new Usuario();

    public String inserir() {

        return "cadastro";
    }

    //getter e setter
    public Usuario getUsu() {
        return usu;
    }

    public void setUsu(Usuario usu) {
        this.usu = usu;
    }

}
