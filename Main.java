import java.util.Scanner;
import java.util.ArrayList;

public class Main {

    // Criando os repositórios que vão armazenar os dados em memória
    private static FuncionarioRepository funcionarioRepository = new FuncionarioRepository();
    private static ProdutoRepository produtoRepository = new ProdutoRepository();
    private static ClienteRepository clienteRepository = new ClienteRepository();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int opcao;
        do {
            exibirMenuPrincipal();
            opcao = Integer.parseInt(scanner.nextLine());

            switch (opcao) {
                case 1:
                    gerenciarFuncionarios();
                    break;
                case 2:
                    gerenciarProdutos();
                    break;
                case 3:
                    gerenciarClientes();
                    break;
                case 4:
                    cadastrarCliente(); // Atalho [cite: 37]
                    break;
                case 5:
                    cadastrarProduto(); // Atalho [cite: 38]
                    break;
                case 0:
                    System.out.println("Saindo do sistema...");
                    break;
                default:
                    System.out.println("Opção inválida!");
            }
        } while (opcao != 0);
    }

    private static void exibirMenuPrincipal() {
        System.out.println("\n--- MENU PRINCIPAL ---");
        System.out.println("1) Gerenciar Funcionários");
        System.out.println("2) Gerenciar Produtos");
        System.out.println("3) Gerenciar Clientes");
        System.out.println("4) Cadastrar Cliente (atalho)");
        System.out.println("5) Cadastrar Produto (atalho)");
        System.out.println("0) Sair");
        System.out.print("Escolha uma opção: ");
    }

    // MÉTODOS DE GERENCIAMENTO DE FUNCIONÁRIOS
    private static void gerenciarFuncionarios() {
        int opcao;
        do {
            exibirSubmenu("Funcionários");
            opcao = Integer.parseInt(scanner.nextLine());
            switch (opcao) {
                case 1: cadastrarFuncionario(); break;
                case 2: listarFuncionarios(); break;
                case 3: buscarFuncionarioPorId(); break;
                case 4: atualizarFuncionario(); break;
                case 5: excluirFuncionario(); break;
                case 0: break;
                default: System.out.println("Opção inválida!");
            }
        } while (opcao != 0);
    }
    
    private static void cadastrarFuncionario() {
        System.out.print("Digite o nome: ");
        String nome = scanner.nextLine();
        System.out.print("Digite o salário: ");
        double salario = Double.parseDouble(scanner.nextLine());
        System.out.print("Digite a matrícula: ");
        String matricula = scanner.nextLine();

        Funcionario f = new Funcionario(nome, salario, matricula);
        funcionarioRepository.adicionar(f);
        System.out.println("Funcionário cadastrado com sucesso! ID: " + f.getId());
    }

    private static void listarFuncionarios() {
        ArrayList<Funcionario> funcionarios = funcionarioRepository.listar();
        if (funcionarios.isEmpty()) {
            System.out.println("Nenhum funcionário cadastrado.");
            return;
        }
        System.out.println("\n--- LISTA DE FUNCIONÁRIOS ---");
        for (Funcionario f : funcionarios) {
            System.out.println(f);
        }
    }
    
    // ... (Implementar buscar, atualizar, excluir para funcionário seguindo o mesmo padrão dos outros)
    
    // MÉTODOS DE GERENCIAMENTO DE PRODUTOS
    private static void gerenciarProdutos() {
        int opcao;
        do {
            exibirSubmenu("Produtos");
            opcao = Integer.parseInt(scanner.nextLine());
            switch (opcao) {
                case 1: cadastrarProduto(); break;
                case 2: listarProdutos(); break;
                case 3: buscarProdutoPorId(); break;
                case 4: atualizarProduto(); break;
                case 5: excluirProduto(); break;
                case 0: break;
                default: System.out.println("Opção inválida!");
            }
        } while (opcao != 0);
    }

    private static void cadastrarProduto() {
        System.out.print("Digite o nome do produto: ");
        String nome = scanner.nextLine();
        System.out.print("Digite o preço: ");
        double preco = Double.parseDouble(scanner.nextLine());
        System.out.print("Digite a quantidade em estoque: ");
        int qtd = Integer.parseInt(scanner.nextLine());

        Produto p = new Produto(nome, preco, qtd);
        produtoRepository.adicionar(p);
        System.out.println("Produto cadastrado com sucesso! ID: " + p.getId());
    }
    
    private static void listarProdutos() {
        ArrayList<Produto> produtos = produtoRepository.listar();
        if (produtos.isEmpty()) {
            System.out.println("Nenhum produto cadastrado.");
            return;
        }
        System.out.println("\n--- LISTA DE PRODUTOS ---");
        for (Produto p : produtos) {
            System.out.println(p);
        }
    }
    
    // ... (Implementar buscar, atualizar, excluir para produto)

    // MÉTODOS DE GERENCIAMENTO DE CLIENTES
    private static void gerenciarClientes() {
         int opcao;
        do {
            exibirSubmenu("Clientes");
            opcao = Integer.parseInt(scanner.nextLine());
            switch (opcao) {
                case 1: cadastrarCliente(); break;
                case 2: listarClientes(); break;
                case 3: buscarClientePorId(); break;
                case 4: atualizarCliente(); break;
                case 5: excluirCliente(); break;
                case 0: break;
                default: System.out.println("Opção inválida!");
            }
        } while (opcao != 0);
    }
    
    private static void cadastrarCliente() {
        System.out.print("Digite o nome do cliente: ");
        String nome = scanner.nextLine();
        System.out.print("Digite o telefone: ");
        String telefone = scanner.nextLine();
        System.out.print("Digite o email: ");
        String email = scanner.nextLine();

        Cliente c = new Cliente(nome, telefone, email);
        clienteRepository.adicionar(c);
        System.out.println("Cliente cadastrado com sucesso! ID: " + c.getId());
    }
    
    private static void listarClientes() {
        ArrayList<Cliente> clientes = clienteRepository.listar();
        if (clientes.isEmpty()) {
            System.out.println("Nenhum cliente cadastrado.");
            return;
        }
        System.out.println("\n--- LISTA DE CLIENTES ---");
        for (Cliente c : clientes) {
            System.out.println(c);
        }
    }
    
    // (A implementação completa dos métodos de buscar, atualizar e remover
    // foi omitida por brevidade, mas segue o padrão de pedir um ID,
    // chamar o método do repositório e exibir uma mensagem de sucesso/erro)
    
    // MÉTODO GENÉRICO PARA SUBMENUS
    private static void exibirSubmenu(String entidade) {
        System.out.println("\n--- GERENCIAR " + entidade.toUpperCase() + " ---");
        System.out.println("1) Cadastrar");
        System.out.println("2) Listar");
        System.out.println("3) Buscar por ID");
        System.out.println("4) Atualizar por ID");
        System.out.println("5) Excluir por ID");
        System.out.println("0) Voltar ao Menu Principal");
        System.out.print("Escolha uma opção: ");
    }
}
