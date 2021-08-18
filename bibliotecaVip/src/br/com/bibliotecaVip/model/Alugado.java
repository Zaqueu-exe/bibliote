package br.com.bibliotecaVip.model;

public class Alugado {
    private int id;
    private int id_pessoa;
    private int id_livro;
    private String livro;
    private String pessoa;

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public int getId_pessoa() {
        return id_pessoa;
    }
    public void setId_pessoa(int id_pessoa) {
        this.id_pessoa = id_pessoa;
    }
    public int getId_livro() {
        return id_livro;
    }
    public void setId_livro(int id_livro) {
        this.id_livro = id_livro;
    }
    public String getLivro() {
        return livro;
    }
    public void setLivro(String livro) {
        this.livro = livro;
    }
    public String getPessoa() {
        return pessoa;
    }
    public void setPessoa(String pessoa) {
        this.pessoa = pessoa;
    }
    @Override
    public String toString() {
        return 
        "Codigo: " + id + "\n" +
        "Titulo do livro: " + livro + "\n" +
        "Nome da pessoa: " + pessoa + "\n";
    }
    
    
}
