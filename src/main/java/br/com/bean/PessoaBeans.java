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
import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;

/**
 *
 * @author Denis
 */
@ManagedBean(name = "pessoaBean")
public class PessoaBeans implements Serializable {

    private Pessoas ps = new Pessoas();
    private List<String> sx = new ArrayList<>();
    private Utilidades util = new Utilidades();
    private Usuario us = new Usuario();

    public String inserirAluno() {
        PessoaDao alDao = new PessoaDao();
        boolean test = util.validaAluno(ps);
        us.setTipo("ROLE_ALUNO");
        us.setCpf(ps);
        ps.getUsuarioList().add(us);
        if (test == true) {
            alDao.inserirPessoas(ps);
        } else {
            System.out.println("test == false");
        }
        return "/cadastro?faces-redirect=true";
    }

    public String inserirAdm() {
        PessoaDao alDao = new PessoaDao();
        boolean test = util.validaAluno(ps);
        us.setTipo("ROLE_ADM");
        us.setCpf(ps);
        ps.getUsuarioList().add(us);
        if (test == true) {
            alDao.inserirPessoas(ps);
        } else {
            System.out.println("test == false");
        }
        return "/cadastro?faces-redirect=true";
    }

    public Pessoas getAl() {
        return ps;
    }

    public void setAl(Pessoas al) {
        this.ps = al;
    }

    public List<String> getSx() {
        sx.add("masculino");
        sx.add("feminino");
        return sx;
    }

    public void setSx(List<String> sx) {

        this.sx = sx;
    }

    public Utilidades getUtil() {
        return util;
    }

    public void setUtil(Utilidades util) {
        this.util = util;
    }

    public Usuario getUs() {
        return us;
    }

    public void setUs(Usuario us) {
        this.us = us;
    }

}
