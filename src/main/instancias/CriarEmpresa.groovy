package main.instancias

import main.Empresa

class CriarEmpresa implements Instancias {

    @Override
      criarInstancia() {
        Scanner sc = new Scanner(System.in);

        println("Insira o nome da empresa:");
        String nomeEmpresa = sc.nextLine();

        println("Insira o email corporativo da empresa:");
        String emailEmpresa = sc.nextLine();

        println("Insira o cnpj da empresa:");
        String cnpjEmpresa = sc.nextLine();

        println("Insira o pais da empresa:");
        String paisEmpresa = sc.nextLine();

        println("Insira o cep da empresa:");
        String cepEmpresa = sc.nextLine();

        println("Insira a descrição da empresa:");
        String descricaoEmpresa = sc.nextLine();

        println("Insira a senha da empresa:");
        String senhaEmpresa = sc.nextLine();

        Empresa NovaEmpresa = new Empresa(
                nomeEmpresa,
                emailEmpresa,
                cnpjEmpresa,
                paisEmpresa,
                cepEmpresa,
                descricaoEmpresa,
                senhaEmpresa
        );

        return NovaEmpresa
    }
}
