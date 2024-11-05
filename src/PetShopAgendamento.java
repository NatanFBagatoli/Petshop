import java.util.Scanner;

public class PetShopAgendamento {

    static final int MAX_CLIENTES = 5;

    // Vetores para armazenar informações dos clientes e animais
    static String[] vetCliente = new String[MAX_CLIENTES];
    static String[] vetAnimal = new String[MAX_CLIENTES];
    static String[] vetTipoAnimal = new String[MAX_CLIENTES];

    // Vetores para armazenar informações dos agendamentos
    static String[] vetServico = new String[MAX_CLIENTES];
    static String[] vetStatus = new String[MAX_CLIENTES];

    static Scanner scanner = new Scanner(System.in);

    // Função para cadastrar clientes e seus animais
    public static void cadastrarCliente() {
        for (int i = 0; i < MAX_CLIENTES; i++) {
            if (vetCliente[i] == null) {
                System.out.print("Nome do Cliente: ");
                vetCliente[i] = scanner.nextLine();
                System.out.print("Nome do Animal: ");
                vetAnimal[i] = scanner.nextLine();
                System.out.print("Tipo de Animal: ");
                vetTipoAnimal[i] = scanner.nextLine();
                System.out.println("Cadastro realizado para " + vetCliente[i] + " e seu animal " + vetAnimal[i] + " (" + vetTipoAnimal[i] + ").\n");
                return;
            }
        }
        System.out.println("Limite de clientes atingido! Não é possível cadastrar mais clientes.\n");
    }

    // Função para agendar um serviço
    public static void agendarServico() {
        System.out.print("Informe o nome do cliente para agendar um serviço: ");
        String nomeCliente = scanner.nextLine();

        for (int i = 0; i < MAX_CLIENTES; i++) {
            if (nomeCliente.equals(vetCliente[i])) {
                System.out.print("Tipo de serviço (Banho ou Tosa): ");
                vetServico[i] = scanner.nextLine();
                vetStatus[i] = "Agendado";
                System.out.println("Serviço '" + vetServico[i] + "' agendado para " + vetCliente[i] + " e seu animal " + vetAnimal[i] + ".\n");
                return;
            }
        }
        System.out.println("Cliente não encontrado. Tente novamente.\n");
    }

    // Função para atualizar o status de um serviço
    public static void atualizarStatusServico() {
        System.out.print("Informe o nome do cliente para atualizar o status do serviço: ");
        String nomeCliente = scanner.nextLine();

        for (int i = 0; i < MAX_CLIENTES; i++) {
            if (nomeCliente.equals(vetCliente[i])) {
                if ("Agendado".equals(vetStatus[i])) {
                    vetStatus[i] = "Realizado";
                    System.out.println("Status atualizado para 'Realizado' para o serviço de " + vetServico[i] + " de " + vetAnimal[i] + ".\n");
                } else {
                    System.out.println("O serviço já foi realizado.\n");
                }
                return;
            }
        }
        System.out.println("Cliente não encontrado. Tente novamente.\n");
    }

    // Função para gerar o relatório
    public static void gerarRelatorio() {
        int totalAgendados = 0;
        int totalRealizados = 0;
        System.out.println("\nRelatório de Agendamentos:");
        for (int i = 0; i < MAX_CLIENTES; i++) {
            if (vetCliente[i] != null) {
                System.out.println(vetCliente[i] + " - " + vetAnimal[i] + " (" + vetTipoAnimal[i] + ") - " + vetServico[i] + " - " + vetStatus[i]);
                if ("Agendado".equals(vetStatus[i])) {
                    totalAgendados++;
                } else if ("Realizado".equals(vetStatus[i])) {
                    totalRealizados++;
                }
            }
        }
        System.out.println("\nTotal de serviços agendados: " + totalAgendados);
        System.out.println("Total de serviços realizados: " + totalRealizados + "\n");
    }

    // Menu principal do sistema
    public static void menu() {
        while (true) {
            System.out.println("Sistema de Agendamento de Banho e Tosa");
            System.out.println("1. Cadastrar Cliente e Animal");
            System.out.println("2. Agendar Serviço");
            System.out.println("3. Atualizar Status do Serviço");
            System.out.println("4. Gerar Relatório");
            System.out.println("5. Sair");
            System.out.print("Escolha uma opção: ");
            String opcao = scanner.nextLine();

            switch (opcao) {
                case "1":
                    cadastrarCliente();
                    break;
                case "2":
                    agendarServico();
                    break;
                case "3":
                    atualizarStatusServico();
                    break;
                case "4":
                    gerarRelatorio();
                    break;
                case "5":
                    System.out.println("Saindo do sistema...");
                    return;
                default:
                    System.out.println("Opção inválida! Tente novamente.\n");
                    break;
            }
        }
    }

    // Método principal para iniciar o sistema
    public static void main(String[] args) {
        menu();
    }
}
