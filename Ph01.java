// Tema: Jogo dos 21 fósforos
// Jogam 2 jogadores. Existem 21 fósforos na mesa. 
// Os jogadores vão jogar alternadamente
// Em cada jogada, cada jogador pode retirar 1, 2, 3, ou 4 fósforos.
// Quem retirar o último perde.

/* Especifique um algoritmo e codifique-o posteriormente em java que obedeça aos seguintes requisitos:
   • o programa deverá implementar o jogo em que um dos jogadores é o computador e o outro é o utilizador;
   • o utilizador poderá escolher quem começa a jogar;
   • caso o computador seja o segundo a jogar deverá ganhar o jogo 
   (descubra qual o raciocínio que o segundo jogador deverá fazer para ganhar o jogo);
   • caso o computador seja o primeiro a jogar deverá estar atento aos erros de raciocínio do utilizador 
   e caso este cometa um erro, o computador deverá ganhar o jogo. */

import java.util.Random;
import java.util.Scanner;
import javax.swing;

public class Ph {

    private static int jogadaUsuario() {
        int jogada = 0;
        boolean entradaValida = false;
        Scanner scanner = new Scanner(System.in);

        do {
            try {
                System.out.print("Quantos fósforos quer retirar (1-4)? ");
                jogada = Integer.parseInt(scanner.nextLine());

                if (jogada >= 1 && jogada <= 4) {
                    entradaValida = true;
                } else {
                    System.out.println("Insira um número entre 1 e 4.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Insira um valor numérico válido.");
            }
        } while (!entradaValida);

        return jogada;
    }

    private static int jogadaComputador(int fosforos) {
        Random random = new Random();
        int jogada = (fosforos - 1) % 5;
        if (jogada == 0) {
            jogada = random.nextInt(4) + 1;
        }
        return jogada;
    }

    private static void fosforosRestantes(int fosforos) {
        System.out.println("Fósforos na mesa: " + fosforos);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        System.out.println("Jogo dos 21 Fósforos!");

        int fosforos = 21;
        boolean vezDoUsuario = true;

        int escolha;
        do {
            System.out.print("Quem começa a jogar? (Escolha 1 para usuário ou 2 para computador): ");
            while (!scanner.hasNextInt()) {
                System.out.print("Entrada inválida. Digite apenas 1 (para usuário) ou 2 (para computador): ");
                scanner.next();
            }
            escolha = scanner.nextInt();
        } while (escolha != 1 && escolha != 2);

        if (escolha == 2) {
            vezDoUsuario = false;
            System.out.println("O computador começa.");
        }

        while (fosforos > 0) {
            fosforosRestantes(fosforos);

            int jogada;
            if (vezDoUsuario) {
                jogada = jogadaUsuario();
            } else {
                jogada = jogadaComputador(fosforos);
                System.out.println("O computador retirou " + jogada + " fósforo(s).");
            }

            fosforos = fosforos - jogada;
            vezDoUsuario = !vezDoUsuario;
        }

        fosforosRestantes(fosforos);

        if (vezDoUsuario) {
            System.out.println("Parabéns! Você venceu!");
        } else {
            System.out.println("O computador venceu. Tente novamente!");
        }

    }

}