import java.util.Scanner;
import java.util.Random;

public class Ph02 {

    // check if number
    public static int isNumeric(String strNum) {
        if (strNum == null) {
            return 0;
        } else {
            try {
                Integer.parseInt(strNum);
            } catch (NumberFormatException e) {
                return 1;
            }
            return 2;
        }
    }
// --------------------------------------------

    private static int jogadaUsuario() {
        int jogada;
        do {
            System.out.print("Quantos fósforos você quer retirar (1-4)? ");
            Scanner scanner = new Scanner(System.in);
            jogada = scanner.nextInt();
        } while (jogada < 1 || jogada > 4);
        return jogada;
    }
// -------------------------------------------

    private static int jogadaComputador(int fosforos) {
        Random random = new Random();
        int jogada = (fosforos - 1) % 5;
        if (jogada == 0) {
            jogada = random.nextInt(4) + 1;
        }
        return jogada;
    }
// ---------------------------------------------

    private static void fosforosRestantes(int fosforos) {
        System.out.println("Fósforos na mesa: " + fosforos);
    }
// ----------------------------------------------

// Main code starts here

    public static void main(String[] args) {
        String escolha, aux2;
        boolean vezDoUsuario = true;
        int fosforos = 21, aux1 = 0, ponto1 = 0, ponto2 = 0; // aux variable for counting points and loops

        Scanner tecla = new Scanner(System.in);
        do { // start of loop for the game
            System.out.println("Jogo dos 21 Fósforos! »»» PONTUAÇÃO - Jogador: " + ponto1 + " | CPU: " + ponto2);
            aux2 = "S";
            do { // start of loop to select player
                System.out.println("Quem começa a jogar? (Escolha 1 para usuário ou 2 para computador): ");
                escolha = tecla.nextLine();
                if (isNumeric(escolha) == 0) {
                    System.out.println("Você precisa decidir!");
                } else if (isNumeric(escolha) == 1) {
                    System.out.println("Deve escolher um número!");
                } else {//here starts the game

                    if (!escolha.equals("2") && !escolha.equals("1")) {
                        while (isNumeric(escolha) == 2) {
                            System.out.println("Opção inválida! (Escolha 1 para usuário ou 2 para computador):");
                            escolha = tecla.nextLine();
                        } //parei de editar aqui!
                        System.out.println("Opção inválida! (Escolha 1 para usuário ou 2 para computador):");
                    } else if (escolha.equals("2")) {
                        vezDoUsuario = false;
                        System.out.println("O computador começa.");
                        break;
                    }
                    while (fosforos > 0) {
                        fosforosRestantes(fosforos);
                        int jogada;
                        if (vezDoUsuario) {
                            jogada = jogadaUsuario();
                        } else {
                            jogada = jogadaComputador(fosforos);
                            System.out.println("O computador retirou "+jogada+" fósforo(s).");
                        }
                        fosforos = fosforos-jogada;
                        vezDoUsuario = !vezDoUsuario;
                    }
                    fosforosRestantes(fosforos);
                    if (vezDoUsuario) {
                        System.out.println("Parabéns! Você venceu!");
                    } else {
                        System.out.println("O computador venceu. Tente novamente!");
                    }


                    /*switch (escolha) {
                        case "1":
                            System.out.println("Você escolheu o usuário!"); // code for user starting
                            ponto1 = ponto1 + 1;
                            aux1 = 1;
                            break;
                        case "2":
                            System.out.println("você escolheu o computador!"); // code for computer starting
                            ponto2 = ponto2 + 1;
                            aux1 = 1;
                            break;

                        default:
                            System.out.println("Opção inválida!");
                            break;
                    }*/

                }
            } while (aux1 == 0);// end loop of select player

            System.out.println("Aperte qualquer tecla para sair do jogo!");
            System.out.println("Para jogar novamente, escolha [S]Sim ou [N]Não.");
            aux2 = tecla.nextLine();
            String aux2Upper = aux2.toUpperCase();
            if (aux2Upper.equals("N")) {
                break;
            } else if (aux2Upper.equals("S")) {
                break;
            } else {
                break;
            }
        } while (aux2.equals("S"));// end loop of game

    }

}
