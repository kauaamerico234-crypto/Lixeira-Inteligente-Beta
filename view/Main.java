package view;

import model.Material;
import service.MaterialService;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        MaterialService service = new MaterialService();

        Scanner scanner = new Scanner(System.in);

        int opcao = -1;

        do {

            System.out.println("\n========= LIXEIRA INTELIGENTE =========");
            System.out.println("1 - Listar materiais");
            System.out.println("2 - Buscar material por nome");
            System.out.println("3 - Buscar por categoria");
            System.out.println("4 - Cadastrar material");
            System.out.println("5 - Remover material");
            System.out.println("0 - Sair");

            System.out.print("Escolha: ");

            try {

                opcao = scanner.nextInt();

                scanner.nextLine();

                switch (opcao) {

                    case 1:
                        service.listarMateriais();
                        break;

                    case 2:

                        System.out.print("Digite o nome: ");

                        String nome = scanner.nextLine();

                        Material material = service.buscarPorNome(nome);

                        if (material != null) {
                            System.out.println(material);
                        } else {
                            System.out.println("Material não encontrado.");
                        }

                        break;

                    case 3:

                        System.out.print("Digite a categoria: ");

                        String categoria = scanner.nextLine();

                        service.buscarPorCategoria(categoria);

                        break;

                    case 4:

                        System.out.print("ID: ");
                        int id = scanner.nextInt();

                        scanner.nextLine();

                        System.out.print("Nome: ");
                        String n = scanner.nextLine();

                        System.out.print("Categoria: ");
                        String c = scanner.nextLine();

                        System.out.print("Tempo de decomposição: ");
                        String t = scanner.nextLine();

                        System.out.print("Dicas: ");
                        String d = scanner.nextLine();

                        Material novo = new Material(id, n, c, t, d);

                        service.adicionarMaterial(novo);

                        System.out.println("Material cadastrado com sucesso!");

                        break;

                    case 5:

                        System.out.print("Digite o nome do material: ");

                        String remover = scanner.nextLine();

                        boolean removido = service.removerMaterial(remover);

                        if (removido) {
                            System.out.println("Material removido.");
                        } else {
                            System.out.println("Material não encontrado.");
                        }

                        break;

                    case 0:
                        System.out.println("Sistema encerrado.");
                        break;

                    default:
                        System.out.println("Opção inválida.");
                }

            } catch (InputMismatchException e) {

                System.out.println("Digite apenas números.");

                scanner.nextLine();
            }

        } while (opcao != 0);

        scanner.close();
    }
}
