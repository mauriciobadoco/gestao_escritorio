/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.adv.rosangelabadoco.gestao.escritorio.modelo.dao;

import br.adv.rosangelabadoco.gestao.escritorio.model.Usuario;
import br.adv.rosangelabadoco.gestao.escritorio.modelo.conexao.Conexao;
import br.adv.rosangelabadoco.gestao.escritorio.modelo.conexao.ConexaoMysql;
import com.mysql.cj.xdevapi.PreparableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author mauri
 */
public class UsuarioDao {
    
    private final Conexao conexao;
    
    public UsuarioDao() {
        this.conexao = new ConexaoMysql();
    }
    
    public String salvar(Usuario usuario){
    
    return usuario.getId()== 0L  ? adicionar (usuario) :editar (usuario);
    }

    private String adicionar(Usuario usuario) {
        String sql = "INSERT INTO usuario(nome, senha ) VALUES (?,?)";
        
        Usuario usuarioTemp = buscarPeloUsuario(usuario.getNome());
        
        if(usuarioTemp != null) {
            return String.format("Error: Usuário %s já existe no banco de dados", usuario.getNome());
        }
        try {
            PreparedStatement preparedStatement = conexao.obterConexao().prepareStatement(sql);
            
            preencherValoresPreparedStatement(preparedStatement, usuario);
            
            int resultado = preparedStatement. executeUpdate();
            
            return resultado == 1? "Usuario adicionado com sucesso" : "Não foi possível adicionar usuario" ;
            
        } catch (SQLException e) {
            return String.format("Error: %s", e.getMessage());
        }
    }

        
     private String editar(Usuario usuario) {
         String sql = "UPDATE usuario SET nome =? , senha=? , WHERE id = ?";
        try {
            PreparedStatement preparedStatement = conexao.obterConexao().prepareStatement(sql);
            
            preencherValoresPreparedStatement(preparedStatement, usuario);
            
            int resultado = preparedStatement. executeUpdate();
            
            return resultado == 1? "Usuario editado com sucesso" : "Não foi possível editar usuario" ;
            
        } catch (SQLException e) {
            return String.format("Error: %s", e.getMessage());
        }
    }

    private void preencherValoresPreparedStatement(PreparedStatement preparedStatement, Usuario usuario) throws SQLException {
        preparedStatement.setString(1,usuario.getNome());
        preparedStatement.setString(2,usuario.getSenha());
        
        if(usuario.getId() != 0L) {
            preparedStatement.setLong(3, usuario.getId());
        }
    }
    
    public List<Usuario> buscarTodosUsuarios(){
        String sql = "SELECT * FROM usuario";
        List<Usuario> usuarios = new ArrayList<>();
        try {
            ResultSet result = conexao.obterConexao().prepareStatement(sql).executeQuery();
            
            while (result.next()){
                usuarios.add(getUsuario(result));
        }
        }
            catch (SQLException e) {
                System.out.println(String.format("Error:", e.getMessage()));
        }
        return usuarios;
    }
    //metodo para inserir os dados no BD
    private Usuario getUsuario(ResultSet result) throws SQLException{
        Usuario usuario = new Usuario ();
        
        usuario.setId(result.getLong("id"));
        usuario.setNome(result.getString("nome"));
        usuario.setSenha(result.getString("senha"));
        
        return usuario;
    }
    
    public Usuario buscarUsuarioPeloId(Long id){
        String sql;
        sql = String.format("SELECT * FROM usuario WHERE id = %d", id);
        try {
            ResultSet result = conexao.obterConexao().prepareStatement(sql).executeQuery();
            
            if (result.next()){
                return getUsuario(result);
        }
        }
            catch (SQLException e) {
                System.out.println(String.format("Error:", e.getMessage()));
        }
        return null;
    }
    
        public Usuario buscarPeloUsuario(String usuario){
        String sql;
        sql = String.format("SELECT * FROM usuario WHERE id = %s", usuario);
        try {
            ResultSet result = conexao.obterConexao().prepareStatement(sql).executeQuery();
            
            if (result.next()){
                return getUsuario(result);
        }
        }
            catch (SQLException e) {
                System.out.println(String.format("Error:", e.getMessage()));
        }
        return null;
    }
}
