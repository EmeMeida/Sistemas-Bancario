import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Banco {
    private Map<String, ContaBancaria> contas;

    public Banco() {
        contas = new HashMap<>();
    }

    public void criarConta(String numeroConta, String titular) {
        if (!contas.containsKey(numeroConta)) {
            ContaBancaria novaConta = new ContaBancaria(numeroConta, titular);
            contas.put(numeroConta, novaConta);
            System.out.println("Conta criada com sucesso para " + titular);
        } else {
            System.out.println("Conta já existe.");
        }
    }

    public ContaBancaria getConta(String numeroConta) {
        return contas.get(numeroConta);
    }

    public void exibirSaldo(String numeroConta) {
        ContaBancaria conta = getConta(numeroConta);
        if (conta != null) {
            System.out.println("Saldo da conta " + numeroConta + ": R$ " + conta.getSaldo());
        } else {
            System.out.println("Conta não encontrada.");
        }
    }

    public static void main(String[] args) {
        Banco banco = new Banco();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Escolha uma opção:");
            System.out.println("1- Criar conta");
            System.out.println("2- Depositar");
            System.out.println("3- Sacar");
            System.out.println("4- Ver saldo");
            System.out.println("5- Sair");
            int opcao = scanner.nextInt();

            switch (opcao) {
                case 1:
                    System.out.print("Número da conta: ");
                    String numeroConta = scanner.next();
                    System.out.print("Nome do titular: ");
                    String titular = scanner.next();
                    banco.criarConta(numeroConta, titular);
                    break;
                case 2:
                    System.out.print("Número da conta: ");
                    numeroConta = scanner.next();
                    System.out.print("Valor a depositar: ");
                    double valorDeposito = scanner.nextDouble();
                    ContaBancaria contaDeposito = banco.getConta(numeroConta);
                    if (contaDeposito != null) {
                        contaDeposito.dp(valorDeposito);
                    } else {
                        System.out.println("Conta não encontrada.");
                    }
                    break;
                case 3:
                    System.out.print("Número da conta: ");
                    numeroConta = scanner.next();
                    System.out.print("Valor a sacar: ");
                    double valorSaque = scanner.nextDouble();
                    ContaBancaria contaSaque = banco.getConta(numeroConta);
                    if (contaSaque != null) {
                        contaSaque.saque(valorSaque);
                    } else {
                        System.out.println("Conta não encontrada.");
                    }
                    break;
                case 4:
                    System.out.print("Número da conta: ");
                    numeroConta = scanner.next();
                    banco.exibirSaldo(numeroConta);
                    break;
                case 5:
                    System.out.println("Saindo...");
                    scanner.close();
                    return;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }
        }
    }
}
