public class ContaPoupanca extends Conta{


    private double saldoPP;

    public double getSaldoPP() {
        return saldoPP;
    }

    @Override
    public double depositar(double valor) {

        if(isClienteEspecial()) {
            double taxaClienteEsp = 1.05;

            saldoPP = saldoPP + (valor * taxaClienteEsp);
        }

        else saldoPP = saldoPP + valor;

        return 0;
    }

    @Override
    public double sacar(double valor) {

        if(saldoPP<valor) {

            Imprimir.i(ContaCorrente.VALOR_INSUFICIENTE);}

        else {saldoPP= saldoPP-valor;
            Imprimir.i(ContaCorrente.TRANSACAO_EFETUADA);}

        return 0;
    }

    @Override
    public void exibirSaldo() {

        Imprimir.i(String.format("Nome: %s", getNomeCliente()));
        Imprimir.i(String.format("Número da conta: %s", getNumConta()));
        Imprimir.i(String.format("Saldo: %.2f", getSaldoPP()));

    }

    @Override
    public void infClienteEspecial(String msg) {

        setClienteEspecial(msg.equalsIgnoreCase("S"));
    }
}
