/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.bean;

import br.com.dao.CursoDao;
import br.com.modelo.Disciplina;
import br.com.modelo.Tbcurso;
import java.io.Serializable;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.bean.ViewScoped;

/**
 *
 * @author Denis
 */
@SessionScoped
@ManagedBean(name = "cursoBeans")
public class CursosBeans implements Serializable {

    private static final long serialVersionUID = 1L;
    private Tbcurso cr = new Tbcurso();
    private List<Tbcurso> lscursos;
    private List<Disciplina> lsdisc;

    public String cursoNew() {
        cr = new Tbcurso();
        return "cursos?faces-redirect=true";
    }

    public String editarCursoNew() {
        cr = new Tbcurso();
        return "cadastroCursoEdita?faces-redirect=true";
    }

    public String inserirCurso() {
        CursoDao crDao = new CursoDao();
        crDao.inserirCurso(cr);
        return "disciplina";
    }

    public String salvarDisciplina() {
        CursoDao crDao = new CursoDao();
        crDao.atualizaCurso(cr);
        return "cursos";
    }

    public void inserirDisciplina() {
        Disciplina disc = new Disciplina();
        disc.setTbcurso(cr);
        cr.getDisciplinaList().add(disc);
    }

    public Tbcurso getCr() {
        return cr;
    }

    public void setCr(Tbcurso cr) {
        this.cr = cr;
    }

    public List<Disciplina> getLsdisc() {
        lsdisc = cr.getDisciplinaList();
        return lsdisc;
    }

    public List<Tbcurso> getLscursos() {
        CursoDao crDao = new CursoDao();
        lscursos = crDao.buscarIdCurso(cr);
        return lscursos;
    }

    public void setLscursos(List<Tbcurso> lscursos) {
        this.lscursos = lscursos;
    }

}
