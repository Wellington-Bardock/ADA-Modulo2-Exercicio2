public abstract class Conta {

    private String nomeCliente;
    private int numConta;
    private boolean clienteEspecial;


    public boolean isClienteEspecial() {
        return clienteEspecial;
    }

    public void setClienteEspecial(boolean clienteEspecial) {
        this.clienteEspecial = clienteEspecial;
    }


    public String getNomeCliente() {
        return nomeCliente;
    }

    public void setNomeCliente(String nomeCliente) {
        this.nomeCliente = nomeCliente;
    }

    public int getNumConta() {
        return numConta;
    }

    public void setNumConta(int numConta) {
        this.numConta = numConta;
    }

    public abstract double depositar (double valor);

    public abstract double sacar (double valor);

    public abstract void exibirSaldo ();

    public abstract void infClienteEspecial(String msg);

}
