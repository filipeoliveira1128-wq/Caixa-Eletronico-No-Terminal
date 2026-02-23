import java.util.Scanner;

public class CaixaEletronicoNoTerminal {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);

        System.out.println("CAIXA ELETRÔNICO");

        double saldoInicial = 1000;

        boolean loop = true;

        while (loop){
            int menu;
            do {
                System.out.println("[1]Consultar saldo [2]Depositar [3]Sacar [4]Sair");
                menu = scanner.nextInt();

                if (menu < 1 || menu > 4){
                    System.out.println("Escolha uma opção válida. ");
                }

            } while (menu < 1 || menu > 4);

            switch (menu){
                case 1:
                    System.out.println("Saldo: R$ " + saldoInicial);

                    if (saldoInicial == 0){
                        System.out.println("Seu saldo está zerado, faça um depósito para continuar usando o Caixa Eletrônico.");
                    }
                    break;

                case 2:
                    double valorDeposito;
                    do {
                        System.out.print("Valor do deposito: R$ ");
                        valorDeposito = scanner.nextDouble();

                        if (valorDeposito <= 0){
                            System.out.println("O valor do depósito não pode ser menor ou igual a 0.");
                        }
                    } while(valorDeposito < 0);
                    System.out.println("Depósito de R$ " + valorDeposito + " realizado com sucesso.");

                    double saldoAposDeposito = saldoInicial + valorDeposito;
                    saldoInicial = saldoAposDeposito;
                    break;

                case 3:
                    double valorSaque;
                    do {

                        System.out.print("Valor do saque: R$ ");
                        valorSaque = scanner.nextDouble();

                        if (valorSaque <= 0){
                            System.out.println("O valor do saque não pode ser menor ou igual a 0.");

                        } else if (valorSaque > saldoInicial) {
                            System.out.println("Saldo insuficiente, verifique seu saldo e tente novamente.");

                        } else if (valorSaque <= saldoInicial) {
                            double saldoAposSaque = saldoInicial - valorSaque;
                            saldoInicial = saldoAposSaque;

                            System.out.println("Saque de R$ " + valorSaque + " realizado com sucesso.");
                        }
                    } while(valorSaque <=0);
                    break;

                case 4:
                    System.out.print("Deseja sair? (s/n) ");
                    String sair = scanner.next();

                    if (sair.equalsIgnoreCase("s")){
                        loop = false;
                        System.out.println("SAINDO...");
                    }
                    else {
                        loop = true;
                    }

            }
        }
        scanner.close();
    }
}

