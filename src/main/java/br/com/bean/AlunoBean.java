/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.bean;

import br.com.dao.AlunoDao;
import br.com.modelo.Aluno;
import br.com.util.Utilidades;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;
/**
 *
 * @author Denis
 */
@ManagedBean(name = "alunoBean")
public class AlunoBean implements Serializable {

    private Aluno al = new Aluno();
    private List<String> sx = new ArrayList<>();
    private Utilidades util = new Utilidades();
    public String inserir() {

        AlunoDao alDao = new AlunoDao();
        boolean test = util.valida(al);

        if (test == true) {
            System.out.println("test = true");
            alDao.inserir(al);
        } else {
            System.out.println("test == false");
       }

        return "cadastro?faces-redirect=true";
    }

    public Aluno getAl() {
        return al;
    }

    public void setAl(Aluno al) {
        this.al = al;
    }

    public List<String> getSx() {
        return sx;
    }

    public void setSx(List<String> sx) {
        sx.add("masculino");
        sx.add("feminino");
        this.sx = sx;
    }

    public Utilidades getUtil() {
        return util;
    }

    public void setUtil(Utilidades util) {
        this.util = util;
    }
}
