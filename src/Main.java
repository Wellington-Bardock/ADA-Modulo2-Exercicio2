import java.util.Scanner;

public class Main {

    public static final String MENU_INICIAL = """
            Por favor, informar qual o tipo de conta:
            1 - Conta Corrente
            2 - Conta Poupança""";

    public static final String MENU_OPERACAO = """
            Por favor, selecionar a operação:
            1 - Depósito
            2 - Saque""";

    public static final String MENU_NOME = "Por favor, informar o seu nome:";
    public static final String MENU_CONTA = "Por favor informar a sua conta:\n";
    public static final String INTRODUCAO_NOME = "Olá %s!\n";
    public static final String VALOR_DE_DEPOSITO = "Qual o valor de depósito?";
    public static final String VALOR_DE_SAQUE = "Qual o valor de saque?";
    public static final String CLIENTE_ESPECIAL = "Você é cliente especial? (S/N)";
    public static final String REALIZAR_OUTRA_OPERACAO = "Gostaria de realizar outra operação? (S/N)";
    public static final String VALOR_INVALIDO_TENTE_NOVAMENTE = "Valor Invalido!";
    public static final String CHECAGEM_SALDO = "Gostaria de ver o seu saldo? (S/N)";

    public static Scanner sc = new Scanner(System.in);
    public static ContaCorrente CC = new ContaCorrente();
    public static ContaPoupanca CP = new ContaPoupanca();

    static boolean checkconta;
    static boolean loop;
    static boolean checkClienteEspecial;
    static boolean checkSaldo;

    public static void main(String[] args) {

        Imprimir.i(MENU_NOME);
        CC.setNomeCliente(sc.nextLine());
        CP.setNomeCliente(CC.getNomeCliente());

        Imprimir.i(INTRODUCAO_NOME, CC.getNomeCliente());

        do {

            try {

                checkconta = true;

                Imprimir.i(MENU_CONTA, CC.getNomeCliente());
                CC.setNumConta(Integer.parseInt(sc.nextLine()));
                CP.setNumConta(CC.getNumConta());

            } catch (NumberFormatException e) {
                Imprimir.i(VALOR_INVALIDO_TENTE_NOVAMENTE);
                checkconta = false;
            }

        } while (!checkconta);

        Imprimir.i(CLIENTE_ESPECIAL);
        checkClienteEspecial = Pergunta.q(sc.nextLine(), CLIENTE_ESPECIAL);

        do {

            try {

                Imprimir.i(MENU_INICIAL);

                int menuInicial = Integer.parseInt(sc.nextLine());

                if (menuInicial == 1) {

                    CC.setClienteEspecial(checkClienteEspecial);

                    Imprimir.i(MENU_OPERACAO);
                    int menuOperacao = Integer.parseInt(sc.nextLine());

                    if (menuOperacao == 1) {
                        Imprimir.i(VALOR_DE_DEPOSITO);
                        CC.depositar(Double.parseDouble(sc.nextLine()));

                    } else if (menuOperacao == 2) {
                        Imprimir.i(VALOR_DE_SAQUE);
                        CC.sacar(Double.parseDouble(sc.nextLine()));
                    }

                } else if (menuInicial == 2) {

                    CP.setClienteEspecial(checkClienteEspecial);

                    Imprimir.i(MENU_OPERACAO);
                    int menuOperacao = Integer.parseInt(sc.nextLine());

                    if (menuOperacao == 1) {
                        Imprimir.i(VALOR_DE_DEPOSITO);
                        CP.depositar(Double.parseDouble(sc.nextLine()));

                    } else if (menuOperacao == 2) {
                        Imprimir.i(VALOR_DE_SAQUE);
                        CP.sacar(Double.parseDouble(sc.nextLine()));

                    }

                } amostragemSaldos();

            } catch (NumberFormatException e) {
                Imprimir.i(VALOR_INVALIDO_TENTE_NOVAMENTE);

            }
            Imprimir.i(REALIZAR_OUTRA_OPERACAO);
            loop = Pergunta.q(sc.nextLine(), REALIZAR_OUTRA_OPERACAO);

        } while (loop);
    }

    public static void amostragemSaldos () {

        Imprimir.i(CHECAGEM_SALDO);
        checkSaldo = Pergunta.q(sc.nextLine(),CHECAGEM_SALDO);


        if (checkSaldo) {

            Imprimir.i("Nome: " + CC.getNomeCliente());
            Imprimir.i("Nº da Conta: " + CC.getNumConta() + "\n");

            Imprimir.i("Conta Corrente:");
            CC.exibirSaldo();
            Imprimir.i("Conta Poupança:");
            CP.exibirSaldo();

        }
    }
}