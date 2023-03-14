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

        else {saldoPP = saldoPP + valor;

        } Imprimir.i(ContaCorrente.TRANSACAO_EFETUADA);

        return saldoPP;
    }

    @Override
    public double sacar(double valor) {

        if(saldoPP<valor) {

            Imprimir.i(ContaCorrente.VALOR_INSUFICIENTE);}

        else {saldoPP= saldoPP-valor;
            Imprimir.i(ContaCorrente.TRANSACAO_EFETUADA);}

        return saldoPP;
    }

    @Override
    public void exibirSaldo() {

        Imprimir.i(String.format("Saldo: %.2f\n", getSaldoPP()));

    }

    @Override
    public void infClienteEspecial(String msg, String complementoMsg) {

        setClienteEspecial(Pergunta.q(msg, complementoMsg));

    }
}
