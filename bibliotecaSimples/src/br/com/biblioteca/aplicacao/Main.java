package br.com.biblioteca.aplicacao;

import java.util.Scanner;

import br.com.biblioteca.dao.LivroDAO;
import br.com.biblioteca.dao.PessoaDAO;
import br.com.biblioteca.model.Livros;
import br.com.biblioteca.model.Pessoas;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int aux = -1;

        do {
            aux = escolherOpcaos(scan);
            executaOpcao(scan, aux);
        } while (aux != 0);

    }

    public static int escolherOpcaos(Scanner scan) {
        String aux1;
        int aux2 = 0;
        boolean teste = false;
        do {
            System.out.println();
            System.out.println("Bem vindo a tela principal");
            System.out.println("Escolha uma das opcoes abaixo");
            System.out.println("---------------------------");
            System.out.println("1 - Cadastrar um livro");
            System.out.println("2 - Cadastrar uma pessoa");
            System.out.println("3 - Ver todos os livros");
            System.out.println("4 - Ver todas as pessoas");
            System.out.println("5 - Deletar livro por ID");
            System.out.println("6 - Deletar pessoa por ID");
            System.out.println("7 - Fazer update em livro");
            System.out.println("8 - Fazer update em pessoa");
            System.out.println("9 - Inserir livro que pessoa pegou emprestado ");
            System.out.println("10 - Ver pessoa que pegou livro na biblioteca");
            System.out.println("0 - Para Sair");
            System.out.println();
            aux1 = scan.nextLine();
            aux2 = Integer.parseInt(aux1);
            if (aux2 >= 0 & aux2 <= 10) {
                teste = true;
            }
        } while (!teste);
        return aux2;
    }

    public static void executaOpcao(Scanner scan, int aux){
        PessoaDAO pessoaDAO = new PessoaDAO();
        LivroDAO livroDAO = new LivroDAO();
        Pessoas pessoa = new Pessoas();
        Livros livro = new Livros();
        Pessoas pessoaU = new Pessoas();
        Livros livroU = new Livros();
        String nome, nome1, id, id1;
        switch(aux){
            case 0 : break;
            case 1 : {
                System.out.println("Digite o titulo do livro");
                nome = scan.nextLine();
                System.out.println("Digite o nome do autor do livro");
                nome1 = scan.nextLine();
                livro.setTitulo(nome); livro.setAutor(nome1); livroDAO.save(livro);
            }break;
            case 2 :{
                System.out.println("Digite o nome da pessoa");
                nome = scan.nextLine();
                pessoa.setNome(nome); pessoaDAO.save(pessoa);
            }break;
            case 3 : {
                for(Livros l : livroDAO.getLivros()){ 
                    System.out.println("Livro: " +l.getId() + " : " + l.getTitulo() + " : " + l.getAutor()); 
                }
            }break;
            case 4 :{
                for(Pessoas p : pessoaDAO.getPessoas()){
                    System.out.println("Usuario: "+ " : " + p.getId() + " : " + p.getNome()); 
                }
            }break;
            case 5 :{
                System.out.println("Digite a ID do livro a ser deletado");
                id = scan.nextLine();
                livroDAO.delete(Integer.parseInt(id));
            }break;
            case 6 :{
                System.out.println("Digite a ID da pessoa a ser deletado");
                id = scan.nextLine();
                pessoaDAO.delete(Integer.parseInt(id));
            }break;
            case 7 : {
                System.out.println("Digite a ID do livro a ser editado");
                id = scan.nextLine();
                System.out.println("Insira o novo titulo");
                nome = scan.nextLine();
                System.out.println("Insira o novo autor");
                nome1 = scan.nextLine();
                livroU.setId(Integer.parseInt(id)); livroU.setTitulo(nome);livroU.setAutor(nome1); livroDAO.update(livroU);
            }break;
            case 8 :{
                System.out.println("Digite a ID da pessoa a ser editado");
                id = scan.nextLine();
                System.out.println("Insira o novo nome");
                nome = scan.nextLine();
                pessoaU.setId(Integer.parseInt(id)); pessoaU.setNome(nome); pessoaDAO.update(pessoaU);
            }break;
            case 9 :{
                System.out.println("Insira a ID da pessoa que pegou o livro");
                id = scan.nextLine();
                System.out.println("Insira a ID do livro");
                id1 = scan.nextLine();
                pessoaDAO.setLivroEmprestado(Integer.parseInt(id), Integer.parseInt(id1));
            }break;
            case 10 : {
                for (Pessoas p1 : pessoaDAO.pessoaComLivro()) {
                    System.out.println(p1.getId() + " " + p1.getNome() + " : " + p1.getNomeLivro());
                }
            }break;
        }
    }
}
