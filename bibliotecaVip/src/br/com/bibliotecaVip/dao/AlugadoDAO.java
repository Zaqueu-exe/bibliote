package br.com.bibliotecaVip.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import br.com.bibliotecaVip.factory.ConnectionFactory;
import br.com.bibliotecaVip.model.Alugado;

public class AlugadoDAO {

    public void Alugar(Alugado aluga){
        String sql = "INSERT INTO alugado(id_livro, id_pessoa) VALUES (?, ?)";
        Connection conn = null;
        PreparedStatement pstm = null;
        try {
            conn = ConnectionFactory.createConnectionToMySQL();
            pstm = conn.prepareStatement(sql);
            pstm.setInt(1, aluga.getId_livro());
            pstm.setInt(2, aluga.getId_pessoa());
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

    public List<Alugado> getAlugado(){
        List<Alugado> alugado = new ArrayList<Alugado>();
        String sql = "SELECT alugado.id, acervo.titulo, pessoas.nome FROM alugado JOIN acervo ON acervo.id = alugado.id_livro JOIN pessoas ON pessoas.id = alugado.id_pessoa";
        Connection conn = null;
        PreparedStatement pstm = null;
        ResultSet rset = null;
        try {
            conn = ConnectionFactory.createConnectionToMySQL();
            pstm = conn.prepareStatement(sql);
            rset = pstm.executeQuery();
            while(rset.next()){
                Alugado a = new Alugado();
                a.setId(rset.getInt("alugado.id"));
                a.setLivro(rset.getString("acervo.titulo"));
                a.setPessoa(rset.getString("pessoas.nome"));
                alugado.add(a);
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
        return alugado;
    }
}
