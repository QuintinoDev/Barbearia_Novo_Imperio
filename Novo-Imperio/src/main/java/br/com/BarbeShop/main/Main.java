package br.com.BarbeShop.main;

import br.com.BarbeShop.model.Barber;
import br.com.BarbeShop.model.Client;
import br.com.BarbeShop.repository.IBarberRepository;
import br.com.BarbeShop.repository.IClientRepository;

import java.util.Optional;
import java.util.Scanner;

public class Main {

    private IClientRepository clientRepository;
    private IBarberRepository barberRepository;
    Scanner scanner = new Scanner(System.in);

    public Main(IBarberRepository barberRepository) {
        this.barberRepository = barberRepository;
    }


    public void exibirMenu(){
        var opcao = -1;
        while (opcao != 0) {
            var menu = """
                    1 - Cadastro de Cliente
                    2 - Cadastro de Barbeiro
                    3 - Buscar Usuario por nome
                    
                    0 - Sair                                 
                    """;
            System.out.println(menu);
            System.out.println("Digite a opção desejada");
            opcao = scanner.nextInt();
            scanner.nextLine();

            switch (opcao) {
                case 1:
                    cadastroCliente();
                    break;
                case 2:
                    cadastroBarbeiro();
                    break;
                case 3:
                    buscarClientePorNome();
                    break;
                case 0:
                    System.out.println("Saindo...");
                    break;
                default:
                    System.out.println("Opção invalida!");
            }
        }
    }

    private void cadastroCliente() {
        System.out.println("Nome: ");
        var nome = scanner.nextLine();
        System.out.println("Email: ");
        var email = scanner.nextLine();
        System.out.println("Senha: ");
        var senha = scanner.nextLine();
        System.out.println("Telefone");
        var telefone = scanner.nextLine();
        Client client = new Client(nome,email,senha,telefone);
        clientRepository.save(client);
        System.out.println("Cliente cadastrado com sucesso");
    }

    private void cadastroBarbeiro() {
        System.out.println("Nome: ");
        var nome = scanner.nextLine();
        System.out.println("Email: ");
        var email = scanner.nextLine();
        System.out.println("Senha: ");
        var senha = scanner.nextLine();
        System.out.println("Telefone");
        var telefone = scanner.nextLine();
        Barber barber = new Barber(nome,email,senha,telefone);
        barberRepository.save(barber);
        System.out.println("Barbairo cadastrado com sucesso");
    }

    private void buscarClientePorNome() {
        System.out.println("Digite o nome para buscar");
        var nomeClient = scanner.nextLine();
        Optional<Client> clientBusca = clientRepository.findByNomeContainingIgnoreCase(nomeClient);

        if (clientBusca.isPresent()){
            System.out.println("Cliente encontrado: "+clientBusca.get());
        }else {
            System.out.println("Cliente nao encontrado!");
        }
    }
}
