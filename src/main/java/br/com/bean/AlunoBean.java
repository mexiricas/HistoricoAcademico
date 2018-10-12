/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.bean;

import br.com.dao.AlunoDao;
import br.com.modelo.Aluno;
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
    
    public String inserir() {
        AlunoDao alDao = new AlunoDao();
        alDao.valida(al);
        alDao.inserir(al);
        
        return "index.xhtml";
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
    
}
