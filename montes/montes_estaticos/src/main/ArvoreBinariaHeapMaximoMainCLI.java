package main;

import java.util.InputMismatchException;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class ArvoreBinariaHeapMaximoMainCLI {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        boolean loop = true;
        String dadoString;
        Integer dadoInt;

        Amontoavel<Integer> heap = new ArvoreBinariaHeapMaximo<>(50);

        while (loop) {
            mostrarMenu();
            System.out.print("O que deseja: ");
            int resposta = -1;
            try {
                resposta = sc.nextInt();
                sc.nextLine(); 
            } catch (InputMismatchException e) {
                System.err.println("\nEntrada inválida! Por favor, digite um número.");
                sc.nextLine();
                continue; 
            }

            try {
                switch (resposta) {
                    case 0:
                        System.out.println("Saindo.");
                        loop = false;
                        break;
                    case 1:
                        System.out.print("\nDigite o dado (inteiro) que deseja inserir: ");
                        dadoInt = sc.nextInt();
                        sc.nextLine();
                        heap.inserir(dadoInt);
                        System.out.println("Dado inserido!");
                        break;
                    case 2:
                        Integer raiz = heap.obterRaiz();
                        System.out.println("\nA raiz da árvore é: " + raiz);
                        break;
                    case 3:
                        Integer extraido = heap.extrair();
                        System.out.println("\nDado extraído da raiz: " + extraido);
                        break;
                    case 4:
                        System.out.println("\n" + heap.imprimir());
                        break;
                    case 5:
                        if (heap.estaVazia()) {
                            System.out.println("\nA árvore está vazia.");
                        } else {
                            System.out.println("\nA árvore NÃO está vazia.");
                        }
                        break;
                    case 6:
                        if (heap.estaCheia()) {
                            System.out.println("\nA árvore está cheia.");
                        } else {
                            System.out.println("\nA árvore NÃO está cheia.");
                        }
                        break;
                    default:
                        System.err.println("\nOpção inválida!");
                        break;
                }
            } catch (NoSuchElementException e) {
                System.err.println("Erro: " + e.getMessage());
            } catch (Exception e) { 
                System.err.println("Erro na operação: " + e.getMessage());
            }
        }
        sc.close();
    }

    private static void mostrarMenu() {
        System.out.println("\n---- ÁRVORE BINÁRIA HEAP MÁXIMO ----");
        System.out.println("1- Inserir");
        System.out.println("2- Obter Raiz");
        System.out.println("3- Extrair Raiz");
        System.out.println("4- Imprimir");
        System.out.println("5- Verificar se está vazia");
        System.out.println("6- Verificar se está cheia");
        System.out.println("0- Sair\n");
    }
}
