package br.com.bibliotecaVip.aplicacao;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Funcoes f = new Funcoes();
        Scanner scan = new Scanner(System.in);
        int aux = -1;
        do {
            aux = f.selecionaOpcao(scan);
            f.executaOpcao(scan, aux);
        } while (aux != 0);

    }
}
