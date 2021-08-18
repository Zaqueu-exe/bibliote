package br.com.bibliotecaVip.aplicacao;

import java.util.Scanner;
import br.com.bibliotecaVip.dao.AcervoDAO;
import br.com.bibliotecaVip.dao.AlugadoDAO;
import br.com.bibliotecaVip.dao.PessoaDAO;
import br.com.bibliotecaVip.model.Acervo;
import br.com.bibliotecaVip.model.Alugado;
import br.com.bibliotecaVip.model.Pessoas;

public class Funcoes {

    public int selecionaOpcao(Scanner scan) {
        String aux1;
        int opcao;
        do {
            System.out.println();
            System.out.println("+----------------------------------+");
            System.out.println("|                                  |");
            System.out.println("|     Bem vindo a tela de menu     |");
            System.out.println("| Selecione uma opção para navegar |");
            System.out.println("|                                  |");
            System.out.println("+----------------------------------+");
            System.out.println();
            System.out.println("1 - Cadastrar uma pessoa");
            System.out.println("2 - Cadastrar um livro");
            System.out.println("3 - Ver todas as pessoas cadastradas");
            System.out.println("4 - Ver todos os livros cadastrados");
            System.out.println("5 - Atualizar dados de uma pessoa pelo ID");
            System.out.println("6 - Atualizar dados de um livro pela ID");
            System.out.println("7 - Deletar uma pessoas pelo ID");
            System.out.println("8 - Deletar um livro pela ID");
            System.out.println("9 - Alugar um livro");
            System.out.println("10 - Ver pessoas com livro alugado");
            System.out.println("");
            aux1 = scan.nextLine();
            opcao = Integer.parseInt(aux1);
        } while (opcao < 0 || opcao > 15);
        return opcao;
    }
    public void executaOpcao(Scanner scan, int op) {
        PessoaDAO pessoaDAO = new PessoaDAO();
        Pessoas pessoa = new Pessoas();
        AcervoDAO acervoDAO = new AcervoDAO();
        Acervo livro = new Acervo();
        Alugado aluga = new Alugado();
        AlugadoDAO alugaDAO = new AlugadoDAO();
        String nome, titulo, autor, ano, id, id2;
        int aux2, aux3;
        switch (op) {
            case 1: {
                System.out.println("Digite o nome da pessoa");
                nome = scan.nextLine();
                pessoa.setNome(nome);
                pessoaDAO.save(pessoa);
            }
                break;
            case 2: {
                System.out.println("Digite o nome do livro");
                titulo = scan.nextLine();
                System.out.println("Digite o nome do autor do livro");
                autor = scan.nextLine();
                System.out.println("Digite o ano de lancamento");
                ano = scan.nextLine();
                aux2 = Integer.parseInt(ano);
                livro.setTitulo(titulo);
                livro.setAutor(autor);
                livro.setAno(aux2);
                acervoDAO.save(livro);
            }
                break;
            case 3: {
                for (Pessoas p : pessoaDAO.getPessoas()) {
                    System.out.println(p.toString());
                }
            }
                break;
            case 4: {
                for (Acervo l : acervoDAO.getAcervo()) {
                    System.out.println(l.toString());
                }
            }
                break;
            case 5: {
                System.out.println("Digite a ID da pessoa a ser atualizada");
                id = scan.nextLine();
                System.out.println("Digite o nome da pessoa");
                nome = scan.nextLine();
                aux2 = Integer.parseInt(id);
                pessoa.setId(aux2);
                pessoa.setNome(nome);
                pessoaDAO.update(pessoa);
            }
                break;
            case 6: {
                System.out.println("Digite a ID do livro");
                id = scan.nextLine();
                System.out.println("Digite o nome do livro");
                titulo = scan.nextLine();
                System.out.println("Digite o nome do autor do livro");
                autor = scan.nextLine();
                System.out.println("Digite o ano de lancamento");
                ano = scan.nextLine();
                aux3 = Integer.parseInt(id);
                aux2 = Integer.parseInt(ano);
                livro.setId(aux3);
                livro.setTitulo(titulo);
                livro.setAutor(autor);
                livro.setAno(aux2);
                acervoDAO.update(livro);
            }
                break;
            case 7: {
                System.out.println("Digite a ID da pessoa a ser deletada");
                id = scan.nextLine();
                aux2 = Integer.parseInt(id);
                pessoaDAO.delete(aux2);
            }
                break;
            case 8: {
                System.out.println("Digite a ID do livro a ser deletado");
                id = scan.nextLine();
                aux2 = Integer.parseInt(id);
                acervoDAO.delete(aux2);
            }
                break;
            case 9: {
                System.out.println("Digite o codigo do livro");
                id = scan.nextLine();
                System.out.println("Digite o codigo da pessoa");
                id2 = scan.nextLine();
                aux2 = Integer.parseInt(id);
                aux3 = Integer.parseInt(id2);
                aluga.setId_livro(aux2);
                aluga.setId_pessoa(aux3);
                alugaDAO.Alugar(aluga);
            }
                break;
            case 10: {
                for(Alugado a : alugaDAO.getAlugado()){
                    System.out.println(a.toString());
                }
            }
                break;
        }
    }
}
