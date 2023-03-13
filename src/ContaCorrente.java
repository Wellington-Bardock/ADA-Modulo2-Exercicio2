public class ContaCorrente extends Conta{

    public static final String VALOR_INSUFICIENTE = "Valor Insuficiente";
    public static final String TRANSACAO_EFETUADA = "Transação Efetuada";
    private double saldoCC;

    public double getSaldoCC() {
        return saldoCC;
    }

    public void setSaldoCC(double saldoCC) {
        this.saldoCC = saldoCC;
    }

    @Override
    public double depositar(double valor) {
        saldoCC= saldoCC + valor;

        return 0;
    }

    @Override
    public double sacar(double valor) {

        if(saldoCC<valor && !isClienteEspecial()) {

           Imprimir.i(VALOR_INSUFICIENTE);}

        else {saldoCC= saldoCC-valor;
            Imprimir.i(TRANSACAO_EFETUADA);}

        return 0;
    }

    @Override
    public void exibirSaldo() {

        Imprimir.i(String.format("Nome: %s", getNomeCliente()));
        Imprimir.i(String.format("Número da conta: %s", getNumConta()));
        Imprimir.i(String.format("Saldo: %.2f", getSaldoCC()));

    }

    @Override
    public void infClienteEspecial(String msg) {

        if (msg.equalsIgnoreCase("S")) {
            setClienteEspecial(true);
        } else setClienteEspecial(false);
    }
}
