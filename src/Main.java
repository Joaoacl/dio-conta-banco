import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Banco banco = new Banco();

        boolean executando = true;
        while (executando) {
            System.out.println("\n1. Criar conta\n2. Depositar\n3. Sacar\n4. Transferir\n5. Ver conta\n6. Sair");
            int opcao = scanner.nextInt();

            switch (opcao) {
                case 1:
                    // Criar conta
                    System.out.print("Nome do titular: ");
                    scanner.nextLine();
                    String nome = scanner.nextLine();
                    System.out.print("Número da conta: ");
                    int numero = scanner.nextInt();
                    Conta novaConta = new Conta(nome, numero);
                    banco.adicionarConta(novaConta);
                    System.out.println("Conta criada com sucesso!");
                    break;

                case 2:
                    // Depositar
                    System.out.print("Número da conta: ");
                    int numeroConta = scanner.nextInt();
                    Conta conta = banco.buscarConta(numeroConta);

                    if (conta != null) {
                        System.out.print("Valor para depositar: R$ ");
                        double valor = scanner.nextDouble();

                        if (valor > 0) {
                            conta.depositar(valor);
                            System.out.println("Depósito realizado com sucesso!");
                        } else {
                            System.out.println("Valor inválido. O valor deve ser maior que zero.");
                        }
                    } else {
                        System.out.println("Conta não encontrada.");
                    }
                    break;

                case 3:
                    // Sacar
                    System.out.print("Número da conta: ");
                    int numeroSaque = scanner.nextInt();
                    Conta contaSaque = banco.buscarConta(numeroSaque);

                    if (contaSaque != null) {
                        System.out.print("Valor a sacar: R$ ");
                        double valorSaque = scanner.nextDouble();

                        if (valorSaque > 0) {
                            boolean sucesso = contaSaque.sacar(valorSaque);
                            if (sucesso) {
                                System.out.println("Saque realizado com sucesso!");
                            } else {
                                System.out.println("Saldo insuficiente.");
                            }
                        } else {
                            System.out.println("Valor inválido. O valor deve ser maior que zero.");
                        }
                    } else {
                        System.out.println("Conta não encontrada.");
                    }
                    break;

                case 4:
                    // Transferir
                    System.out.print("Número da conta de origem: ");
                    int numeroOrigem = scanner.nextInt();
                    Conta contaOrigem = banco.buscarConta(numeroOrigem);

                    System.out.print("Número da conta de destino: ");
                    int numeroDestino = scanner.nextInt();
                    Conta contaDestino = banco.buscarConta(numeroDestino);

                    if (contaOrigem != null && contaDestino != null) {
                        System.out.print("Valor para transferir: R$ ");
                        double valorTransferencia = scanner.nextDouble();

                        if (valorTransferencia > 0) {
                            boolean sucesso = contaOrigem.transferir(contaDestino, valorTransferencia);
                            if (sucesso) {
                                System.out.println("Transferência realizada com sucesso!");
                            } else {
                                System.out.println("Saldo insuficiente para transferir.");
                            }
                        } else {
                            System.out.println("Valor inválido. O valor deve ser maior que zero.");
                        }
                    } else {
                        System.out.println("Conta de origem ou destino não encontrada.");
                    }
                    break;

                case 5:
                    // Consultar conta
                    System.out.print("Consultar a conta de Número: ");
                    int numeroConsulta = scanner.nextInt();
                    Conta contaConsulta = banco.buscarConta(numeroConsulta);

                    if (contaConsulta != null) {
                        contaConsulta.exibirDados();
                    } else {
                        System.out.println("Conta não encontrada.");
                    }
                    break;
                case 6:
                    executando = false;
                    break;
                default:
                    System.out.println("Opção inválida.");
            }
        }

        scanner.close();
    }
}
