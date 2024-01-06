import java.util.Scanner;
import java.util.Random;

public class Ph03 {

    private static int jogadaUsuario() {
        int jogada = 0;
        boolean entradaValida = false;
        do {
            Scanner scanner = new Scanner(System.in); // solved infinit loop starting scanner inside the loop!
            System.out.print("Quantos fósforos quer retirar (1-4)? ");
            if (!scanner.hasNextInt()) {
                System.out.println("Insira um número entre 1 e 4. ");
            } else {
                try {
                    jogada = Integer.parseInt(scanner.next());
                    if (jogada >= 1 && jogada <= 4) {
                        entradaValida = true;
                    } else {
                        System.out.println("Insira um número entre 1 e 4.");
                    }
                } catch (NumberFormatException e) {
                    System.out.println("Insira um valor numérico válido.");
                }
            }
        } while (!entradaValida);
        System.out.println("");
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
        System.out.print("Fósforos na mesa: " + fosforos + ". ");
    }

    public static void main(String[] args) {
        String aux1;
        boolean vezDoUsuario = true, game = true;
        int escolha = 0, fosforos, ponto1 = 0, ponto2 = 0, jogo = 0; // aux variable for counting points and loops
        Scanner tecla = new Scanner(System.in);

        do {
            fosforos = 21;
            jogo = jogo + 1;
            System.out.println("»»» JOGO #" + jogo + " «««");
            System.out.println("Jogo dos 21 Fósforos! »»» PONTUAÇÃO - Jogador: " + ponto1 + " | CPU: " + ponto2);
            System.out.print("Quem começa a jogar? (Escolha 1 para usuário ou 2 para computador): ");
            while (game == true) {
                if (tecla.hasNextInt()) {
                    escolha = tecla.nextInt();
                    break;
                } else {
                    System.out.println("Opção inválida! (Escolha 1 para usuário ou 2 para computador): ");
                    tecla.next();
                }
            }

            if (escolha == 2) {
                vezDoUsuario = false;
                System.out.println("O computador começa.");
                System.out.println("");
            } else {
                System.out.println("O usuário começa.");
                System.out.println("");
            }

            while (fosforos > 0) {
                fosforosRestantes(fosforos);

                int jogada = 0;
                if (vezDoUsuario) {
                    while (vezDoUsuario) {
                        jogada = jogadaUsuario();
                        if (fosforos < 4 && fosforos < jogada) {
                            System.out.print("Errado, a mesa só tem "+fosforos+" fósforo(s). ");
                        } else {
                            break;
                        }
                    }
                } else {
                    jogada = jogadaComputador(fosforos);
                    System.out.println(" O computador retirou " + jogada + " fósforo(s).");
                    System.out.println(" ");
                }

                fosforos = fosforos - jogada;
                vezDoUsuario = !vezDoUsuario;
            }
            fosforosRestantes(fosforos);
            if (vezDoUsuario) {
                System.out.println("Parabéns! Você venceu!");
                System.out.println("");
                ponto1 = ponto1 + 1;
            } else {
                System.out.println("O computador venceu. Tente novamente!");
                System.out.println("");
                ponto2 = ponto2 + 1;
            }

            System.out.print("Aperte qualquer tecla para sair do jogo! Para jogar novamente, escolha [S] Sim. ");
            aux1 = tecla.next();
            String aux1Upper = aux1.toUpperCase();
            if (!aux1Upper.equals("S")) {
                game = false;
                System.out.println("");
                System.out.println("»» GAME OVER ««");
                System.out.println("»» PONTUAÇÃO - Jogador: "+ ponto1 +" | CPU: " + ponto2+" ««");
                System.out.println("");
            }
            System.out.println("");
            System.out.println("");
        } while (game == true);// end loop of game

    }
}
