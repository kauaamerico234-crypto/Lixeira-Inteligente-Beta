package view;

import controller.MaterialController;
import model.*;

import java.util.ArrayList;
import java.util.Scanner;

// MVC:
// Esta classe representa a VIEW.
// Responsável pela interação com o usuário.
public class Main {

    // Login do administrador
    private static final String ADMIN_ID = "adm";
    private static final String SENHA = "12345";

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        MaterialController controller = new MaterialController();

        int opcao = -1;

        do {

            System.out.println("\n===== LIXEIRA INTELIGENTE =====");
            System.out.println("1 - Listar materiais");
            System.out.println("2 - Buscar material por nome");
            System.out.println("3 - Buscar por categoria");
            System.out.println("4 - Cadastrar material");
            System.out.println("5 - Remover material");
            System.out.println("0 - Sair");
            System.out.print("Escolha: ");

            // try/catch para validação
            try {
                opcao = Integer.parseInt(scanner.nextLine());

                switch (opcao) {

                    case 1:
                        for (Material material : controller.listarMateriais()) {
                            System.out.println(material);
                            System.out.println("---------------------------");
                        }
                        break;

                    case 2:
                        System.out.print("Digite o nome: ");
                        String nome = scanner.nextLine();

                        Material encontrado = controller.buscarPorNome(nome);

                        if (encontrado != null) {
                            System.out.println(encontrado);
                        } else {
                            System.out.println("Material não encontrado.");
                        }
                        break;

                    case 3:

                        System.out.println("1-PLASTICO");
                        System.out.println("2-METAL");
                        System.out.println("3-PAPEL");
                        System.out.println("4-VIDRO");
                        System.out.println("5-ORGANICO");

                        int cat = Integer.parseInt(scanner.nextLine());

                        Categoria categoria = null;

                        switch (cat) {
                            case 1:
                                categoria = Categoria.PLASTICO;
                                break;
                            case 2:
                                categoria = Categoria.METAL;
                                break;
                            case 3:
                                categoria = Categoria.PAPEL;
                                break;
                            case 4:
                                categoria = Categoria.VIDRO;
                                break;
                            case 5:
                                categoria = Categoria.ORGANICO;
                                break;
                            default:
                                System.out.println("Categoria inválida.");
                        }

                        if (categoria != null) {

                            ArrayList<Material> lista =
                                    controller.buscarPorCategoria(categoria);

                            for (Material material : lista) {
                                System.out.println(material);
                                System.out.println("---------------------------");
                            }
                        }

                        break;

                    case 4:

                        if (autenticar(scanner)) {

                            System.out.print("ID: ");
                            int id = Integer.parseInt(scanner.nextLine());

                            System.out.print("Nome: ");
                            String novoNome = scanner.nextLine();

                            System.out.println("1-PLASTICO");
                            System.out.println("2-METAL");
                            System.out.println("3-PAPEL");
                            System.out.println("4-VIDRO");
                            System.out.println("5-ORGANICO");

                            int categoriaOpcao =
                                    Integer.parseInt(scanner.nextLine());

                            Categoria novaCategoria = Categoria.PLASTICO;

                            switch (categoriaOpcao) {
                                case 1:
                                    novaCategoria = Categoria.PLASTICO;
                                    break;
                                case 2:
                                    novaCategoria = Categoria.METAL;
                                    break;
                                case 3:
                                    novaCategoria = Categoria.PAPEL;
                                    break;
                                case 4:
                                    novaCategoria = Categoria.VIDRO;
                                    break;
                                case 5:
                                    novaCategoria = Categoria.ORGANICO;
                                    break;
                            }

                            System.out.print("Tempo de decomposição: ");
                            String tempo = scanner.nextLine();

                            System.out.print("Dicas: ");
                            String dicas = scanner.nextLine();

                            Material material;

                            if (novaCategoria == Categoria.ORGANICO) {

                                material = new MaterialOrganico(
                                        id,
                                        novoNome,
                                        novaCategoria,
                                        tempo,
                                        dicas
                                );

                            } else {

                                material = new MaterialReciclavel(
                                        id,
                                        novoNome,
                                        novaCategoria,
                                        tempo,
                                        dicas
                                );
                            }

                            controller.adicionarMaterial(material);

                            System.out.println("Material cadastrado com sucesso!");
                        }

                        break;

                    case 5:

                        if (autenticar(scanner)) {

                            System.out.print("Digite o ID do material: ");
                            int idRemover =
                                    Integer.parseInt(scanner.nextLine());

                            if (controller.removerMaterial(idRemover)) {
                                System.out.println("Material removido.");
                            } else {
                                System.out.println("Material não encontrado.");
                            }
                        }

                        break;

                    case 0:
                        System.out.println("Sistema encerrado.");
                        break;

                    default:
                        System.out.println("Opção inválida.");
                }

            } catch (Exception e) {

                // Tratamento de erros usando try/catch
                System.out.println("Erro: entrada inválida.");
            }

        } while (opcao != 0);

        scanner.close();
    }

    // Método de autenticação do administrador
    private static boolean autenticar(Scanner scanner) {

        System.out.print("ID de administrador: ");
        String id = scanner.nextLine();

        System.out.print("Senha: ");
        String senha = scanner.nextLine();

        if (id.equals(ADMIN_ID) && senha.equals(SENHA)) {
            System.out.println("Acesso autorizado!");
            return true;
        }

        System.out.println("Acesso negado!");
        return false;
    }
}