/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.util;


import br.com.dao.AlunoDao;
import br.com.modelo.Aluno;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Denis
 */
public class Utilidades {

    private AlunoDao alDao = new AlunoDao();

    public boolean valida(Aluno al) {
        List<Aluno> ls = new ArrayList<Aluno>();
        ls = alDao.buscarEditora(al);
        if (ls.isEmpty()) {
            return true;
        }
        return false;
    }

    public AlunoDao getAlDao() {
        return alDao;
    }

    public void setAlDao(AlunoDao alDao) {
        this.alDao = alDao;
    }

}
