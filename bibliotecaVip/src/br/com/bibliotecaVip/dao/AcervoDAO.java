package br.com.bibliotecaVip.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import br.com.bibliotecaVip.factory.ConnectionFactory;
import br.com.bibliotecaVip.model.Acervo;

public class AcervoDAO {
    
    public void save(Acervo livro){
        String sql = "INSERT INTO acervo (titulo, autor, ano) VALUES(?, ?, ?)";
        Connection conn = null;
        PreparedStatement pstm = null;
        try{
            conn = ConnectionFactory.createConnectionToMySQL();
            pstm = conn.prepareStatement(sql);
            pstm.setString(1, livro.getTitulo());
            pstm.setString(2, livro.getAutor());
            pstm.setInt(3, livro.getAno());
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

    public List<Acervo> getAcervo(){
        List<Acervo> acervo = new ArrayList<Acervo>();
        String sql = "SELECT * FROM acervo";
        Connection conn = null;
        PreparedStatement pstm = null;
        ResultSet rset = null;
        try {
            conn = ConnectionFactory.createConnectionToMySQL();
            pstm = conn.prepareStatement(sql);
            rset = pstm.executeQuery();
            while(rset.next()){
                Acervo l = new Acervo();
                l.setId(rset.getInt("id"));
                l.setAutor(rset.getString("autor"));
                l.setTitulo(rset.getString("titulo"));
                l.setAno(rset.getInt("ano"));
                acervo.add(l);
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
        return acervo;
    }

    public void update(Acervo livro){
        String sql = "UPDATE acervo SET titulo = ?, autor = ? , ano = ? WHERE id = ?";
        Connection conn = null;
        PreparedStatement pstm = null;
        try {
            conn = ConnectionFactory.createConnectionToMySQL();
            pstm = conn.prepareStatement(sql);
            pstm.setString(1, livro.getTitulo());
            pstm.setString(2, livro.getAutor());
            pstm.setInt(3, livro.getAno());
            pstm.setInt(4, livro.getId());
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
        String sql = "DELETE FROM acervo WHERE id = ?";
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
