/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.util;

import br.com.dao.PessoaDao;
import br.com.dao.UsuarioDao;
import br.com.modelo.Pessoas;
import br.com.modelo.Usuario;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Denis
 */
public class Utilidades {

    private PessoaDao alDao = new PessoaDao();
    private UsuarioDao usDao = new UsuarioDao();

    public boolean validaAluno(Pessoas al) {
        List<Pessoas> ls = new ArrayList<Pessoas>();
        ls = alDao.buscarAluno(al);
        if (ls.isEmpty()) {
            return true;
        }
        return false;
    }

    public boolean validaUsuario(Usuario u) {
        List<Usuario> ls = new ArrayList<Usuario>();
        ls = usDao.buscaUsuario(u);
        if (ls.isEmpty()) {
            return true;
        }
        return false;
    }

    public void insertUsusarioAluno(Usuario us) {
        usDao.inserir(us);
    }

    public PessoaDao getAlDao() {
        return alDao;
    }

    public void setAlDao(PessoaDao alDao) {
        this.alDao = alDao;
    }

    public UsuarioDao getUsDao() {
        return usDao;
    }

    public void setUsDao(UsuarioDao usDao) {
        this.usDao = usDao;
    }

}
