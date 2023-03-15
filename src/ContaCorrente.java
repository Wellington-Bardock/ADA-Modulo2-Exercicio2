public class ContaCorrente extends Conta{

    public static final String VALOR_INSUFICIENTE = "Valor Insuficiente, Transação Não Efetuada!\n";
    public static final String TRANSACAO_EFETUADA = "Transação Efetuada!\n";
    private double saldoCC;

    public double getSaldoCC() {
        return saldoCC;
    }

    @Override
    public double depositar(double valor) {
        saldoCC= saldoCC + valor;
        Imprimir.i(TRANSACAO_EFETUADA);

        return saldoCC;
    }

    @Override
    public double sacar(double valor) {

        if(saldoCC<valor && !isClienteEspecial()) {

           Imprimir.i(VALOR_INSUFICIENTE);}

        else {saldoCC= saldoCC-valor;
            Imprimir.i(TRANSACAO_EFETUADA);}

        return saldoCC;
    }

    @Override
    public void exibirSaldo() {
        Imprimir.i(String.format("Saldo: %.2f\n", getSaldoCC()));
    }

    @Override
    public void infClienteEspecial(String msg, String complementoMsg) {

        setClienteEspecial(Perguntar.q(msg, complementoMsg));

    }
}
