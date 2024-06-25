package Controle; //A nossa classe foi feita dentro de um pacote chamado Controle

import java.util.Scanner; //importamos o scanner para ler as entradas do usuário

public class ControleDeGastos { //Classe pública, a qual foi declarada as variáveis de forma estática(para obter acesso direto) e o scanner para ler entradas do usuário
    static double salario = 0;
    static double gastosEssenciais = 0;
    static double estiloDeVida = 0;
    static double reserva = 0;
    static Scanner scanner = new Scanner(System.in);

    public static void calcularGastosIdeais(double salario) { //Método do qual vai calcular o salário com base no que é ideal
        gastosEssenciais = salario * 0.50; //50% do salário
        estiloDeVida = salario * 0.30; //30% do salário
        reserva = salario * 0.20; //20% do salário
    }

    public static void exibirControle() { //Método que vai exibir o menu ao usuário
        System.out.println("------Controle de gastos------");
        System.out.println("1. Gastos essenciais (fixos)");
        System.out.println("2. Estilo de vida (lazer e afins)");
        System.out.println("3. Reserva");
    }

    public static void main(String[] args) { //Método principal do programa, onde vai ocorrer o processo

        String continua = "s"; //Declaração de variável


        while (continua.equals("s")) { //Loop vai retornar o menu de opções caso o usuário diga que sim
            if (salario == 0) {
                double inputSalario = 0;

                while (true) { //Loop que será feito até o usuário digitar um valor numérico válido
                    try {
                        System.out.print("Informe o valor do salário/lucro: R$");
                        String input = scanner.next().replace(',', '.');

                        inputSalario = Double.parseDouble(input);

                        if (inputSalario <= 0) {
                            System.out.println("Por favor, informe um valor de salário válido (maior que zero).");
                        } else {
                            break;
                        }
                    } catch (NumberFormatException e) {
                        System.out.println("Por favor, informe um valor numérico válido para o salário.");
                    }
                }

                salario = inputSalario;
                calcularGastosIdeais(salario);
            }

            int opcao = 0;
            while (true) {
                exibirControle();
                System.out.print("Escolha uma opção do menu (1-3): ");

                try {
                    opcao = Integer.parseInt(scanner.next());

                    if (opcao >= 1 && opcao <= 3) {
                        break; //Opção válida, sai do loop
                    } else {
                        System.out.println("Por favor, escolha uma opção válida.");
                    }
                } catch (NumberFormatException e) {
                    System.out.println("Por favor, informe um número correspondente à opção desejada.");
                }
            }

            switch (opcao) { //Bloco de opções que vai ser exibido de acordo com a opção escolhida pelo usuário
                case 1:
                    System.out.println("Para gastos essenciais, você deve deixar R$ " + String.format("%.2f", gastosEssenciais));
                    break;
                case 2:
                    System.out.println("Para estilo de vida, você deve deixar R$ " + String.format("%.2f", estiloDeVida));
                    break;
                case 3:
                    System.out.println("Para reserva, você deve deixar R$ " + String.format("%.2f", reserva));
                    break;
            }

            while (true) { //Loop para exibir se o usuário deseja ver outra opção do menu, se ele disser não, o sistema encerra
                System.out.print("Deseja ver outra opção do menu? (s/n): ");
                continua = scanner.next().toLowerCase();
                if (continua.equals("s") || continua.equals("n")) {
                    break;
                } else {
                }
            }
        }

        System.out.println("Obrigado por usar o sistema de controle de gastos!"); //Exibido assim que o usuário escolher não
        scanner.close();
    }
}