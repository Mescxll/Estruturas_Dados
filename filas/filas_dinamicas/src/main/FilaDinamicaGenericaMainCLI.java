package main;

import java.util.Scanner;

/**
 * Classe principal executável para testar funcionalidades da fila
 * 
 * @author Maria Eduarda Campos
 */
public class FilaDinamicaGenericaMainCLI {
    public static void main(String[] args) {
        FilaDinamicaGenerica<String> fila = new FilaDinamicaGenerica<>(50);
        Scanner sc = new Scanner(System.in);

        boolean loop = true;
        while(loop){
            menu();
            int resp = sc.nextInt();
            sc.nextLine();

            switch (resp) {
                case 1:
                    System.out.print("\nDigite o dado: ");
                    String dado1 = sc.nextLine();
                    fila.enfileirar(dado1);
                    System.out.println("Dado enfileirado!");
                    break;
                case 2:
                    fila.desenfileirar();
                    System.out.println("Dado desenfileirado!");
                    break;
                case 4:
                    System.out.print("\nDigite o dado: ");
                    String dado3 = sc.nextLine();
                    fila.atualizarFim(dado3);
                    System.out.println("Dado Atualizado!");
                    break;
                case 5:
                    System.out.println("\nA frente é: " + fila.frente());
                    break;
                case 6:
                    System.out.println("\nFila: " + fila.imprimir());
                    break;
                case 7:
                    System.out.println("\nPrograma Finalizado!");
                    loop = false;
                    break;
                default:
                    System.err.println("\nEntrada Inválida!");
            }
        }
    }

    private static void menu(){
        System.out.println("\n---- FILA DINÂMICA GENÉRICA ----");
        System.out.println("1- Enfileirar");
        System.out.println("2- Desenfileirar");
        System.out.println("4- Atualiza Fim");
        System.out.println("5- Espiar Frente");
        System.out.println("6- Imprimir");
        System.out.println("7- Sair");
        System.out.print("\nO que deseja? ");
    }
}
