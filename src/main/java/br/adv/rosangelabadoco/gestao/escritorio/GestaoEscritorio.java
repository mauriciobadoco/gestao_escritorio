/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package br.adv.rosangelabadoco.gestao.escritorio;

import br.adv.rosangelabadoco.gestao.escritorio.modelo.conexao.Conexao;
import br.adv.rosangelabadoco.gestao.escritorio.modelo.conexao.ConexaoMysql;
import br.adv.rosangelabadoco.gestao.escritorio.model.Parceiro;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author mauri
 */
public class GestaoEscritorio {

    public static void main(String[] args) throws SQLException {
        
        String sql = "Select * from parceiro";
        
        Conexao conexao = new ConexaoMysql();
        
        Parceiro parceiro = new Parceiro(null,"Fernando");
        
        String inserirSQL = "INSERT INTO  parceiro( nome) VALUE (?)";
        
       
        PreparedStatement preparedStatement = conexao.obterConexao().prepareStatement(inserirSQL);// para fazer inserção
        
         //informar o valor a ser preenchido
        preparedStatement.setString(1,parceiro.getNome());
        
        int resultadoDoCadastro = preparedStatement.executeUpdate(); // vai permitir com que o dado seja persistido no Banco de Dados.
        
        System.out.println(resultadoDoCadastro);
      
                
        
       // System.out.println(conexao.obterConexao());
       
        ResultSet result = conexao.obterConexao().prepareStatement(sql).executeQuery();// para fazer consulta
        
// para fazer inserção
        
        while(result.next()){
            System.out.println(result.getString("nome"));
        }
    }
}
