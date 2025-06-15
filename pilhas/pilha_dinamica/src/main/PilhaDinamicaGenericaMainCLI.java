package main;

import java.util.Scanner;

/**
 * Classe principal executável para testar funcionalidades da pilha
 * 
 * @author Maria Eduarda Campos
 */
public class PilhaDinamicaGenericaMainCLI {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        boolean loop = true;
        String dado = "";
        //Tratar excessões
        Empilhavel pilha = new PilhaDinamicaGenerica<String>(50);

        while(loop){
            mostrarMenu();
            System.out.print("O que deseja: ");
            int resposta = sc.nextInt();
            sc.nextLine();

            switch (resposta) {
                case 0:
                    System.out.println("Saindo.");
                    loop = false;
                    break;
                case 1:
                    System.out.print("\nDigite o dado que deseja: ");
                    dado = sc.nextLine();
                    pilha.empilhar(dado);
                    System.out.println("Dado empilhado!");
                    break;
                case 2:
                    pilha.desempilhar();
                    System.out.println("\nDado desempilhado!");
                    break;
                case 3:
                    System.out.print("\nDigite o dado que deseja: ");
                    dado = sc.nextLine();
                    pilha.atualizar(dado);
                    System.out.println("Dado atualizado!");
                  break;
                case 4:
                    System.out.println("\nO dado no topo é: " + pilha.espiar());
                    break;
                case 5:
                    System.out.println("\n" + pilha.imprimir());
                    break;
                default:
                    System.err.println("\nEntrada inválida!");
                    break;
            }
        }
    }

    private static void mostrarMenu(){
        System.out.println("\n---- PILHA DINÂMICA GENÉRICA ----");
        System.out.println("1- Empilhar");
        System.out.println("2- Desempilhar");
        System.out.println("3- Atualizar");
        System.out.println("4- Espiar");
        System.out.println("5- Imprimir");
        System.out.println("0- Sair\n");
    }
}
