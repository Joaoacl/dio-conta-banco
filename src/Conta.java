public class Conta {

    private String titular;
    private int numero;
    private double saldo;

    public Conta(String titular, int numero) {
        this.titular = titular;
        this.numero = numero;
        this.saldo = 0;
    }

    public void depositar(double valor) {
        saldo += valor;
    }

    public boolean sacar(double valor) {
        if (saldo >= valor) {
            saldo -= valor;
            return true;
        }
        return false;
    }

    public boolean transferir(Conta destino, double valor) {
        if (sacar(valor)) {
            destino.depositar(valor);
            return true;
        }
        return false;
    }

    public void exibirDados() {
        System.out.println("----- DADOS DA CONTA -----");
        System.out.println("Número da conta: " + numero);
        System.out.println("Titular: " + titular);
        System.out.printf("Saldo: R$ %.2f\n", saldo);
    }

    public int getNumero() {
        return numero;
    }

}
