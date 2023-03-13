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

    public static final String MENU_NOME = "Por favor, informar o usuário";
    public static final String MENU_CONTA = "Por favor, informar a conta";
    public static final String VALOR_DE_DEPOSITO = "Qual o valor de depósito?";
    public static final String VALOR_DE_SAQUE = "Qual o valor de saque?";
    public static final String CLIENTE_ESPECIAL = "Você é cliente especial?";
    public static final String REALIZAR_OUTRA_OPERACAO = "Gostaria de realizar outra operação?";

    public static void main(String[] args) {

        double valorsaque;
        double valordeposito;
        String loop;

        Scanner sc = new Scanner(System.in);
        ContaCorrente CC = new ContaCorrente();
        ContaPoupanca CP = new ContaPoupanca();

        Imprimir.i(MENU_NOME);
        CC.setNomeCliente(sc.nextLine());
        CP.setNomeCliente(CC.getNomeCliente());

        Imprimir.i(MENU_CONTA);
        CC.setNumConta(Integer.parseInt(sc.nextLine()));
        CP.setNumConta(CC.getNumConta());

        Imprimir.i(CLIENTE_ESPECIAL);
        String informeCE = sc.nextLine();
        CC.infClienteEspecial(informeCE);
        CP.infClienteEspecial(informeCE);

        do {

            Imprimir.i(MENU_INICIAL);

            int menuInicial = Integer.parseInt(sc.nextLine());

            if (menuInicial == 1) {

                Imprimir.i(MENU_OPERACAO);
                int menuOperacao = Integer.parseInt(sc.nextLine());

                if (menuOperacao == 1) {
                    Imprimir.i(VALOR_DE_DEPOSITO);
                    valordeposito = Double.parseDouble(sc.nextLine());
                    CC.depositar(valordeposito);
                    CC.exibirSaldo();

                } else if (menuOperacao == 2) {
                    Imprimir.i(VALOR_DE_SAQUE);
                    valorsaque = Double.parseDouble(sc.nextLine());
                    CC.sacar(valorsaque);
                    CC.exibirSaldo();

                }
            } else if (menuInicial == 2) {

                Imprimir.i(MENU_OPERACAO);
                int menuOperacao = Integer.parseInt(sc.nextLine());

                if (menuOperacao == 1) {
                    Imprimir.i(VALOR_DE_DEPOSITO);
                    valordeposito = Double.parseDouble(sc.nextLine());
                    CP.depositar(valordeposito);
                    CP.exibirSaldo();

                } else if (menuOperacao == 2) {
                    Imprimir.i(VALOR_DE_SAQUE);
                    valorsaque = Double.parseDouble(sc.nextLine());
                    CP.sacar(valorsaque);
                    CP.exibirSaldo();
                }

            } Imprimir.i(REALIZAR_OUTRA_OPERACAO);
              loop = sc.nextLine();

        } while (loop.equalsIgnoreCase("S"));
    }
}