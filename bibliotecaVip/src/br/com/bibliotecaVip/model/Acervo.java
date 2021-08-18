package br.com.bibliotecaVip.model;

public class Acervo {
    private int id;
    private String titulo;
    private String autor;
    private int ano;
    
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getTitulo() {
        return titulo;
    }
    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }
    public String getAutor() {
        return autor;
    }
    public void setAutor(String autor) {
        this.autor = autor;
    }
    public int getAno() {
        return ano;
    }
    public void setAno(int ano) {
        this.ano = ano;
    }
    @Override
    public String toString() {
        return "Livro ID: " + id + "\n" +
        "Autor: " + autor + "\n" + 
        "Titulo: " + titulo + "\n" +
        "Ano de lancamento: " + ano + "\n";
    }
    
}
