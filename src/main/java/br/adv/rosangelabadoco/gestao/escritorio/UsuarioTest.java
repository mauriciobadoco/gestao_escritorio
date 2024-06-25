/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.adv.rosangelabadoco.gestao.escritorio;

import br.adv.rosangelabadoco.gestao.escritorio.model.Usuario;
import br.adv.rosangelabadoco.gestao.escritorio.modelo.dao.UsuarioDao;
import java.time.LocalDateTime;

/**
 *
 * @author mauri
 */
public class UsuarioTest {
    
    public static void main(String[] args) {
        Usuario usuario = new Usuario(4L, "Fábio", "888", null, null);
        
       UsuarioDao usuarioDao = new UsuarioDao();
       String mensagem = usuarioDao.salvar(usuario);
        System.out.println(mensagem);
    }


}
