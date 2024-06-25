package br.adv.rosangelabadoco.gestao.escritorio.modelo.dao;

import br.adv.rosangelabadoco.gestao.escritorio.model.Usuario;
import br.adv.rosangelabadoco.gestao.escritorio.view.modelo.LoginDTO;

public class AutenticacaoDao {

    private final UsuarioDao usuarioDao;

    public AutenticacaoDao(){
        this.usuarioDao = new UsuarioDao();
    }

    public Usuario login(LoginDTO login){
        Usuario usuario = usuarioDao.buscarPeloUsuario(login.getUsuario());
        
        if(usuario == null){
           return null;
        } 
        
        if(validaSenha(usuario.getSenha(), login.getSenha())){
           return usuario;   
        }

        return null;
    }

    private boolean validaSenha(String senhaUsuario, String senhaLogin) {
        return senhaUsuario.equals(senhaLogin);
    }
}

