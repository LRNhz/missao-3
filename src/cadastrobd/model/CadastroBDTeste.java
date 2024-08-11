/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cadastrobd.model;

public class CadastroBDTeste {
    public static void main(String[] args) {
        PessoaFisicaDAO pessoaFisicaDAO = new PessoaFisicaDAO();
        PessoaJuridicaDAO pessoaJuridicaDAO = new PessoaJuridicaDAO();

        // Instanciar uma pessoa física e persistir no banco de dados
        PessoaFisica pessoaFisica = new PessoaFisica("João da Silva", "Rua dos Bobos", "São Paulo", "SP", "11999999999", "joao@email.com", "12345678909");
        pessoaFisicaDAO.incluir(pessoaFisica);

        // Alterar os dados da pessoa física no banco
        pessoaFisica.setNome("João da Silva Junior");
        pessoaFisicaDAO.alterar(pessoaFisica);

        // Consultar todas as pessoas físicas do banco de dados e listar no console
        List<PessoaFisica> pessoasFisicas = pessoaFisicaDAO.getPessoas();
        for (PessoaFisica pf : pessoasFisicas) {
            System.out.println(pf.toString());
        }

        // Excluir a pessoa física criada anteriormente no banco
        pessoaFisicaDAO.excluir(pessoaFisica.getId());

        // Instanciar uma pessoa jurídica e persistir no banco de dados
        PessoaJuridica pessoaJuridica = new PessoaJuridica("Empresa XYZ Ltda", "Rua dos Empreendedores", "São Paulo", "SP", "11999999999", "empresa@email.com", "12345678901234");
        pessoaJuridicaDAO.incluir(pessoaJuridica);

        // Alterar os dados da pessoa jurídica no banco
        pessoaJuridica.setNome("Empresa XYZ Ltda ME");
        pessoaJuridicaDAO.alterar(pessoaJuridica);

        // Consultar todas as pessoas jurídicas do banco de dados e listar no console
        List<PessoaJuridica> pessoasJuridicas = pessoaJuridicaDAO.getPessoas();
        for (PessoaJuridica pj : pessoasJuridicas) {
            System.out.println(pj.toString());
        }

        // Excluir a pessoa jurídica criada anteriormente no banco
        pessoaJuridicaDAO.excluir(pessoaJuridica.getId());
    }
}