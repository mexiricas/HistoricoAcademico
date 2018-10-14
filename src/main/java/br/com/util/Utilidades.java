/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.util;

import br.com.dao.AlunoDao;
import br.com.dao.UsuarioDao;
import br.com.modelo.Aluno;
import br.com.modelo.Usuario;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Denis
 */
public class Utilidades {
    
    private AlunoDao alDao = new AlunoDao();
    private UsuarioDao usDao = new UsuarioDao();
    
    public boolean valida(Aluno al) {
        List<Aluno> ls = new ArrayList<Aluno>();
        ls = alDao.buscarEditora(al);
        if (ls.isEmpty()) {
            return true;
        }
        return false;
    }

    public void insertUsusarioAluno(Usuario us) {
        us.setTipo("ROLE_ALUNO");
        usDao.inserir(us);
    }    

    public AlunoDao getAlDao() {
        return alDao;
    }
    
    public void setAlDao(AlunoDao alDao) {
        this.alDao = alDao;
    }
    
    public UsuarioDao getUsDao() {
        return usDao;
    }
    
    public void setUsDao(UsuarioDao usDao) {
        this.usDao = usDao;
    }
    
}
