package Etapa2;

import java.util.Scanner;

public class Principal {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean sair = false;

        while (!sair) {
            System.out.println("Escolha uma opção:");
            System.out.println("(1) Criar uma loja");
            System.out.println("(2) Criar um produto");
            System.out.println("(3) Sair");
            System.out.print("Opção: ");

            int opcao = scanner.nextInt();
            scanner.nextLine();

            switch (opcao) {
                case 1:
                    System.out.println("Você escolheu criar uma loja.");
                    criarLoja(scanner);
                    break;
                case 2:
                    System.out.println("Você escolheu criar um produto.");
                    criarProduto(scanner);
                    break;
                case 3:
                    sair = true;
                    break;
                default:
                    System.out.println("Opção inválida! Tente novamente.");
                    break;
            }
        }
        scanner.close();
    }

    private static void criarLoja(Scanner scanner) {
        System.out.print("Digite o nome da loja: ");
        String nome = scanner.nextLine();

        System.out.print("Digite a quantidade de funcionários: ");
        int quantidadeFuncionarios = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Digite o salário base dos funcionários: ");
        double salarioBaseFuncionario = scanner.nextDouble();
        scanner.nextLine();

        // Endereço
        System.out.print("Digite o nome da rua do endereço: ");
        String nomeDaRua = scanner.nextLine();

        System.out.print("Digite o número da residência: ");
        String numero = scanner.nextLine();

        System.out.print("Digite o complemento (se houver): ");
        String complemento = scanner.nextLine();

        System.out.print("Digite a cidade do endereço: ");
        String cidade = scanner.nextLine();

        System.out.print("Digite o estado do endereço: ");
        String estado = scanner.nextLine();

        System.out.print("Digite o país do endereço: ");
        String pais = scanner.nextLine();

        System.out.print("Digite o CEP do endereço: ");
        String cep = scanner.nextLine();

        Endereco endereco = new Endereco(nomeDaRua, cidade, estado, pais, cep, numero, complemento);

        // Data
        System.out.print("Digite a data de fundação (dd/mm/yyyy): ");
        String dataCompleta = scanner.nextLine();

        String[] partesData = dataCompleta.split("/");

        int dia = Integer.parseInt(partesData[0]);
        int mes = Integer.parseInt(partesData[1]);
        int ano = Integer.parseInt(partesData[2]);
        Data dataFundacao = new Data(dia, mes, ano);


        // Criação da Loja
        Loja loja = new Loja(nome, quantidadeFuncionarios, salarioBaseFuncionario, endereco, dataFundacao);

        System.out.println(loja);

    }

    private static void criarProduto(Scanner scanner) {
        System.out.print("Digite o nome do produto: ");
        String nomeProduto = scanner.nextLine();

        System.out.print("Digite o preço do produto: ");
        double precoProduto = scanner.nextDouble();
        scanner.nextLine();

        // Data
        System.out.print("Digite a data de validade (formato dd/mm/yyyy:): ");
        String dataCompleta = scanner.nextLine();

        String[] partesData = dataCompleta.split("/");

        int dia = Integer.parseInt(partesData[0]);
        int mes = Integer.parseInt(partesData[1]);
        int ano = Integer.parseInt(partesData[2]);

        Data data = new Data(dia, mes, ano);
        Produto produto = new Produto(nomeProduto, precoProduto, data);

        if(produto.estaVencido(new Data(20,10,2024))) {
            System.out.println("PRODUTO VENCIDO");

        } else {
            System.out.println("PRODUTO NÃO VENCIDO");

        }
        System.out.println(produto);
    }
}
