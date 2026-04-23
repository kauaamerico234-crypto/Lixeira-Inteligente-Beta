package view;

import model.Material;
import service.MaterialService;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        MaterialService service = new MaterialService();
        Scanner scanner = new Scanner(System.in);

        service.adicionarMaterial(new Material(1, "Garrafa PET", "Reciclável", "400 anos", "Lavar e amassar"));
        service.adicionarMaterial(new Material(2, "Casca de banana", "Orgânico", "2 meses", "Pode compostar"));

        int opcao;

        do {
            System.out.println("\n=== LIXEIRA INTELIGENTE ===");
            System.out.println("1 - Listar materiais");
            System.out.println("2 - Buscar material");
            System.out.println("3 - Cadastrar material");
            System.out.println("0 - Sair");
            System.out.print("Escolha: ");
            opcao = scanner.nextInt();
            scanner.nextLine();

            switch (opcao) {

                case 1:
                    service.listarMateriais();
                    break;

                case 2:
                    System.out.print("Digite o nome: ");
                    String nome = scanner.nextLine();
                    Material m = service.buscarPorNome(nome);

                    if (m != null) {
                        System.out.println(m);
                    } else {
                        System.out.println("Material não encontrado!");
                    }
                    break;

                case 3:
                    System.out.print("Nome: ");
                    String n = scanner.nextLine();

                    System.out.print("Categoria: ");
                    String c = scanner.nextLine();

                    System.out.print("Tempo de decomposição: ");
                    String t = scanner.nextLine();

                    System.out.print("Dicas: ");
                    String d = scanner.nextLine();

                    service.adicionarMaterial(new Material(0, n, c, t, d));
                    System.out.println("Material cadastrado!");
                    break;
            }

        } while (opcao != 0);

        scanner.close();
    }
}
