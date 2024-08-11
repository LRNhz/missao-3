/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package cadastrobd;

public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);

    while (true) {
        System.out.println("Opções:");
        System.out.println("1 - Incluir");
        System.out.println("2 - Alterar");
        System.out.println("3 - Excluir");
        System.out.println("4 - Exibir pelo ID");
        System.out.println("5 - Exibir todos");
        System.out.println("0 - Sair");

        int opcao = scanner.nextInt();

        switch (opcao) {
            case 1:
                incluir(scanner);
                break;
            case 2:
                alterar(scanner);
                break;
            case 3:
                excluir(scanner);
                break;
            case 4:
                obter(scanner);
                break;
            case 5:
                obterTodos(scanner);
                break;
            case 0:
                System.out.println("Saindo...");
                return;
            default:
                System.out.println("Opção inválida");
        }
    }
}

private static void incluir(Scanner scanner) {
    System.out.println("Incluir:");
    System.out.println("1 - Pessoa Física");
    System.out.println("2 - Pessoa Jurídica");

    int tipo = scanner.nextInt();

    PessoaDAO dao;
    if (tipo == 1) {
        dao = new PessoaFisicaDAO();
    } else {
        dao = new PessoaJuridicaDAO();
    }

    System.out.println("Digite os dados:");
    // ler dados do teclado e criar objeto Pessoa
    Pessoa pessoa = new Pessoa(/* dados */);
    dao.incluir(pessoa);
}

private static void alterar(Scanner scanner) {
    System.out.println("Alterar:");
    System.out.println("1 - Pessoa Física");
    System.out.println("2 - Pessoa Jurídica");

    int tipo = scanner.nextInt();

    PessoaDAO dao;
    if (tipo == 1) {
        dao = new PessoaFisicaDAO();
    } else {
        dao = new PessoaJuridicaDAO();
    }

    System.out.println("Digite o ID:");
    int id = scanner.nextInt();

    Pessoa pessoa = dao.obter(id);
    if (pessoa != null) {
        System.out.println("Dados atuais:");
        // imprimir dados atuais
        System.out.println("Digite os novos dados:");
        // ler dados do teclado e atualizar objeto Pessoa
        dao.alterar(pessoa);
    } else {
        System.out.println("Pessoa não encontrada");
    }
}

private static void excluir(Scanner scanner) {
    System.out.println("Excluir:");
    System.out.println("1 - Pessoa Física");
    System.out.println("2 - Pessoa Jurídica");

    int tipo = scanner.nextInt();

    PessoaDAO dao;
    if (tipo == 1) {
        dao = new PessoaFisicaDAO();
    } else {
        dao = new PessoaJuridicaDAO();
    }

    System.out.println("Digite o ID:");
    int id = scanner.nextInt();

    dao.excluir(id);
}

private static void obter(Scanner scanner) {
    System.out.println("Obter:");
    System.out.println("1 - Pessoa Física");
    System.out.println("2 - Pessoa Jurídica");

    int tipo = scanner.nextInt();

    PessoaDAO dao;
    if (tipo == 1) {
        dao = new PessoaFisicaDAO();
    } else {
        dao = new PessoaJuridicaDAO();
    }

    System.out.println("Digite o ID:");
    int id = scanner.nextInt();

    Pessoa pessoa = dao.obter(id);
    if (pessoa != null) {
        System.out.println("Dados:");
        // imprimir dados
    } else {
        System.out.println("Pessoa não encontrada");
    }
}

private static void obterTodos(Scanner scanner) {
    System.out.println("Obter todos:");
    System.out.println("1 - Pessoa Física");
    System.out.println("2 - Pessoa Jurídica");

    int tipo = scanner.nextInt();

    PessoaDAO dao;
    if (tipo == 1) {
        dao = new PessoaFisicaDAO();
    } else {
        dao = new PessoaJuridicaDAO();
    }

    List<Pessoa> pessoas = dao.obterTodos();
    for (Pessoa pessoa : pessoas) {
        System.out.println("Dados:");
        // imprimir dados
    }
}
