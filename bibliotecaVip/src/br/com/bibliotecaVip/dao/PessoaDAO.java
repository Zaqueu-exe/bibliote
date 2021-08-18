package br.com.bibliotecaVip.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import br.com.bibliotecaVip.factory.ConnectionFactory;
import br.com.bibliotecaVip.model.Pessoas;

public class PessoaDAO {

    public void save(Pessoas pessoa){
        String sql = "INSERT INTO pessoas (nome) VALUES (?)";
        Connection conn = null;
        PreparedStatement pstm = null;
        try {
            conn = ConnectionFactory.createConnectionToMySQL();
            pstm = conn.prepareStatement(sql);
            pstm.setString(1, pessoa.getNome());
            pstm.execute();
        } catch (Exception e) {
            e.printStackTrace();
        }finally{
            try {
                if(conn != null){
                    conn.close();
                }
                if(pstm != null){
                    pstm.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public List<Pessoas> getPessoas(){
        List<Pessoas> pessoa = new ArrayList<Pessoas>();
        String sql = "SELECT * FROM pessoas";
        Connection conn = null;
        PreparedStatement pstm = null;
        ResultSet rset = null;
        try {
            conn = ConnectionFactory.createConnectionToMySQL();
            pstm = conn.prepareStatement(sql);
            rset = pstm.executeQuery();
            while(rset.next()){
                Pessoas p = new Pessoas();
                p.setId(rset.getInt("id"));
                p.setNome(rset.getString("nome"));
                pessoa.add(p);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }finally{
            try {
                if(conn != null){
                    conn.close();
                }
                if(pstm != null){
                    pstm.close();
                }
                if(rset != null){
                    rset.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return pessoa;
    }

    public void update(Pessoas pessoa){
        String sql = "UPDATE pessoas SET nome = ? WHERE id = ?";
        Connection conn = null;
        PreparedStatement pstm = null;
        try {
            conn = ConnectionFactory.createConnectionToMySQL();
            pstm = conn.prepareStatement(sql);
            pstm.setString(1, pessoa.getNome());
            pstm.setInt(2, pessoa.getId());
            pstm.execute();
        } catch (Exception e) {
            e.printStackTrace();
        }finally{
            try {
                if(conn != null){
                    conn.close();
                }
                if(pstm != null){
                    pstm.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public void delete(int id){
        String sql = "DELETE FROM pessoas WHERE id = ?";
        Connection conn = null;
        PreparedStatement pstm = null;
        try {
            conn = ConnectionFactory.createConnectionToMySQL();
            pstm = conn.prepareStatement(sql);
            pstm.setInt(1, id);
            pstm.execute();
        } catch (Exception e) {
            e.printStackTrace();
        }finally{
            try {
                if(conn != null){
                    conn.close();
                }
                if(pstm != null){
                    pstm.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
