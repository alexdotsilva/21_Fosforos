
import java.util.Random; //Random class is used to generate pseudo-random numbers in java. An instance of this class is thread-safe. The instance of this class is however cryptographically insecure. This class provides various method calls to generate different random data types such as float, double, int.

import java.util.Scanner; //In Java, Scanner is a class in java.util package used for obtaining the input of the primitive types like int, double, etc. and strings. Using the Scanner class in Java is the easiest way to read input in a Java program, though not very efficient if you want an input method for scenarios where time is a constraint like in competitive programming.

//import javax.swing;

public class Ph_copy {

    public static boolean isNumeric(String strNum) {
        if (strNum == null) {
            return false;
        } else {
            try {
                Integer.parseInt(strNum);
            } catch (NumberFormatException e) {
                return false;
            }
            return true;
        }
    }

    private static int jogadaUsuario() {
        int jogada;

        // System.out.print("Quantos fósforos você quer retirar (1-4)?");

        do {
            System.out.print("Quantos fósforos você quer retirar (1-4)? ");
            Scanner scanner = new Scanner(System.in);
            jogada = scanner.nextInt(); // read the next Int input from user.
        } while (jogada < 1 || jogada > 4);

        return jogada;
    }

    private static int jogadaComputador(int fosforos) {
        Random random = new Random();
        int jogada = (fosforos - 1) % 5;
        if (jogada == 0) {
            jogada = random.nextInt(4) + 1; // call random to generate a random number between 0 and 4, plus 1. to
                                            // correct the possible 0 and no 4.
        }
        return jogada;
    }

    private static void fosforosRestantes(int fosforos) {
        System.out.println("Fósforos na mesa: " + fosforos);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        int escolha = 0;
        char game = 'S';

        while (game == 'S') {

            System.out.println("Jogo dos 21 Fósforos!");
            int fosforos = 21;
            boolean vezDoUsuario = true;

            System.out.println("Quem começa a jogar? (Escolha 1 para usuário ou 2 para computador): ");
            boolean invalidInput = false;
            while (!invalidInput && (escolha > 2 || escolha < 1)) {
                try { // try e catch para evitar que o usuario digite uma opção diferente do que é
                      // pedido
                    escolha = scanner.nextInt();
                    invalidInput = false;

                    switch (escolha) {
                        case 1:
                            System.out.println("Você começa.");

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

                            break;

                        case 2:
                            vezDoUsuario = false;
                            System.out.println("O computador começa.");

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

                            break;

                        default:
                            System.out.println("Opção errada!");
                            break;
                    }

                } catch (Exception e) {
                    System.out.println("Por favor escolha 1 número.");
                    invalidInput = true;
                }
            }
        }

        /*
         * System.out.println("Jogo dos 21 Fósforos!");
         * int fosforos = 21;
         * boolean vezDoUsuario = true;
         * 
         * System.out.
         * print("Quem começa a jogar? (Escolha 1 para usuário ou 2 para computador): "
         * );
         * boolean invalidInput = false;
         * while (!invalidInput && (escolha > 2 || escolha < 1)) {
         * try { // try e catch para evitar que o usuario digite uma opção diferente do
         * que é
         * // pedido
         * escolha = scanner.nextInt();
         * invalidInput = false;
         * 
         * switch (escolha) {
         * case 1:
         * System.out.println("Você começa.");
         * 
         * while (fosforos > 0) {
         * fosforosRestantes(fosforos);
         * 
         * int jogada;
         * if (vezDoUsuario) {
         * jogada = jogadaUsuario();
         * } else {
         * jogada = jogadaComputador(fosforos);
         * System.out.println("O computador retirou " + jogada + " fósforo(s).");
         * }
         * 
         * fosforos = fosforos - jogada;
         * vezDoUsuario = !vezDoUsuario;
         * }
         * 
         * fosforosRestantes(fosforos);
         * 
         * if (vezDoUsuario) {
         * System.out.println("Parabéns! Você venceu!");
         * } else {
         * System.out.println("O computador venceu. Tente novamente!");
         * }
         * 
         * break;
         * 
         * case 2:
         * vezDoUsuario = false;
         * System.out.println("O computador começa.");
         * 
         * while (fosforos > 0) {
         * fosforosRestantes(fosforos);
         * 
         * int jogada;
         * if (vezDoUsuario) {
         * jogada = jogadaUsuario();
         * } else {
         * jogada = jogadaComputador(fosforos);
         * System.out.println("O computador retirou " + jogada + " fósforo(s).");
         * }
         * 
         * fosforos = fosforos - jogada;
         * vezDoUsuario = !vezDoUsuario;
         * }
         * 
         * fosforosRestantes(fosforos);
         * 
         * if (vezDoUsuario) {
         * System.out.println("Parabéns! Você venceu!");
         * } else {
         * System.out.println("O computador venceu. Tente novamente!");
         * }
         * 
         * break;
         * 
         * default:
         * System.out.println("Opção errada!");
         * break;
         * }
         * 
         * } catch (Exception e) {
         * System.out.println("Por favor escolha 1 número.");
         * invalidInput = true;
         * }
         * }
         */

    }

}