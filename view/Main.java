package view;

import service.MaterialService;
import model.*;

import java.util.ArrayList;
import java.util.Scanner;

// MVC:
// Esta classe representa a VIEW.
// Responsável pela interação com o usuário (menu e leitura de entradas).
public class Main {

    // Credenciais do administrador
    private static final String ADMIN_ID = "adm";
    private static final String SENHA = "12345";

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        MaterialService service = new MaterialService();

        int opcao = -1;

        do {

            System.out.println("\n===== LIXEIRA INTELIGENTE =====");
            System.out.println("1 - Listar todos os materiais");
            System.out.println("2 - Buscar material por nome exato");
            System.out.println("3 - Buscar por categoria");
            System.out.println("4 - Busca por palavra-chave");
            System.out.println("5 - Cadastrar novo material (admin)");
            System.out.println("6 - Editar material (admin)");
            System.out.println("7 - Remover material (admin)");
            System.out.println("0 - Sair");
            System.out.print("Escolha: ");

            // try/catch para validação de entrada
            try {
                opcao = Integer.parseInt(scanner.nextLine());

                switch (opcao) {

                    // ===== OPÇÃO 1: LISTAR TODOS =====
                    case 1:
                        ArrayList<Material> todos = service.listarMateriais();
                        if (todos.isEmpty()) {
                            System.out.println("Nenhum material cadastrado.");
                        } else {
                            for (Material m : todos) {
                                System.out.println(m);
                                System.out.println("---------------------------");
                            }
                        }
                        break;

                    // ===== OPÇÃO 2: BUSCA POR NOME EXATO =====
                    case 2:
                        System.out.print("Digite o nome do material: ");
                        String nome = scanner.nextLine();

                        Material encontrado = service.buscarPorNome(nome);

                        if (encontrado != null) {
                            System.out.println(encontrado);
                        } else {
                            System.out.println("Material não encontrado. Tente a busca por palavra-chave (opção 4).");
                        }
                        break;

                    // ===== OPÇÃO 3: BUSCA POR CATEGORIA =====
                    case 3:
                        System.out.println("Escolha a categoria:");
                        System.out.println("1 - PLÁSTICO");
                        System.out.println("2 - METAL");
                        System.out.println("3 - PAPEL");
                        System.out.println("4 - VIDRO");
                        System.out.println("5 - ORGÂNICO");
                        System.out.println("6 - REJEITO");
                        System.out.print("Categoria: ");

                        int cat = Integer.parseInt(scanner.nextLine());
                        Categoria categoria = null;

                        // if/else aninhado para seleção da categoria
                        if (cat == 1) {
                            categoria = Categoria.PLASTICO;
                        } else if (cat == 2) {
                            categoria = Categoria.METAL;
                        } else if (cat == 3) {
                            categoria = Categoria.PAPEL;
                        } else if (cat == 4) {
                            categoria = Categoria.VIDRO;
                        } else if (cat == 5) {
                            categoria = Categoria.ORGANICO;
                        } else if (cat == 6) {
                            categoria = Categoria.REJEITO;
                        } else {
                            System.out.println("Categoria inválida.");
                        }

                        if (categoria != null) {
                            ArrayList<Material> lista =
                                    service.buscarPorCategoria(categoria);

                            if (lista.isEmpty()) {
                                System.out.println("Nenhum material encontrado para esta categoria.");
                            } else {
                                System.out.println("=== Materiais encontrados: " + lista.size() + " ===");
                                for (Material m : lista) {
                                    System.out.println(m);
                                    System.out.println("---------------------------");
                                }
                            }
                        }
                        break;

                    // ===== OPÇÃO 4: BUSCA PARCIAL POR PALAVRA-CHAVE =====
                    case 4:
                        System.out.print("Digite a palavra-chave: ");
                        String palavraChave = scanner.nextLine();

                        // SOBRECARGA: chama buscarPorNome com segundo parâmetro boolean
                        ArrayList<Material> parciais =
                                service.buscarPorNome(palavraChave, true);

                        if (parciais.isEmpty()) {
                            System.out.println("Nenhum material encontrado com essa palavra-chave.");
                        } else {
                            System.out.println("=== " + parciais.size() + " resultado(s) encontrado(s) ===");
                            for (Material m : parciais) {
                                System.out.println(m);
                                System.out.println("---------------------------");
                            }
                        }
                        break;

                    // ===== OPÇÃO 5: CADASTRAR MATERIAL (ADMIN) =====
                    case 5:
                        if (autenticar(scanner)) {

                            int novoId = service.getProximoId();
                            System.out.println("ID atribuído automaticamente: " + novoId);

                            System.out.print("Nome do material: ");
                            String novoNome = scanner.nextLine();

                            System.out.println("Categoria:");
                            System.out.println("1 - PLÁSTICO  2 - METAL  3 - PAPEL");
                            System.out.println("4 - VIDRO     5 - ORGÂNICO  6 - REJEITO");
                            System.out.print("Escolha: ");
                            int catOpcao = Integer.parseInt(scanner.nextLine());

                            Categoria novaCategoria;
                            switch (catOpcao) {
                                case 2:  novaCategoria = Categoria.METAL;    break;
                                case 3:  novaCategoria = Categoria.PAPEL;    break;
                                case 4:  novaCategoria = Categoria.VIDRO;    break;
                                case 5:  novaCategoria = Categoria.ORGANICO; break;
                                case 6:  novaCategoria = Categoria.REJEITO;  break;
                                default: novaCategoria = Categoria.PLASTICO;
                            }

                            System.out.print("Tempo de decomposição: ");
                            String tempo = scanner.nextLine();

                            System.out.print("Dicas de descarte: ");
                            String dicas = scanner.nextLine();

                            Material novoMaterial;

                            // Instancia subclasse correta com base na categoria
                            if (novaCategoria == Categoria.ORGANICO) {
                                novoMaterial = new MaterialOrganico(novoId, novoNome, novaCategoria, tempo, dicas);
                            } else if (novaCategoria == Categoria.REJEITO) {
                                novoMaterial = new MaterialRejeito(novoId, novoNome, novaCategoria, tempo, dicas);
                            } else {
                                novoMaterial = new MaterialReciclavel(novoId, novoNome, novaCategoria, tempo, dicas);
                            }

                            service.adicionarMaterial(novoMaterial);
                            System.out.println("Material cadastrado com sucesso! ID: " + novoId);
                        }
                        break;

                    // ===== OPÇÃO 6: EDITAR MATERIAL (ADMIN) =====
                    case 6:
                        if (autenticar(scanner)) {

                            System.out.print("ID do material a editar: ");
                            int idEditar = Integer.parseInt(scanner.nextLine());

                            System.out.print("Novo nome: ");
                            String nomeAtualizado = scanner.nextLine();

                            System.out.print("Novo tempo de decomposição: ");
                            String tempoAtualizado = scanner.nextLine();

                            System.out.print("Novas dicas: ");
                            String dicasAtualizadas = scanner.nextLine();

                            if (service.atualizarMaterial(idEditar, nomeAtualizado,
                                    tempoAtualizado, dicasAtualizadas)) {
                                System.out.println("Material atualizado com sucesso!");
                            } else {
                                System.out.println("Material com ID " + idEditar + " não encontrado.");
                            }
                        }
                        break;

                    // ===== OPÇÃO 7: REMOVER MATERIAL (ADMIN) =====
                    case 7:
                        if (autenticar(scanner)) {

                            System.out.print("Digite o ID do material a remover: ");
                            int idRemover = Integer.parseInt(scanner.nextLine());

                            if (service.removerMaterial(idRemover)) {
                                System.out.println("Material removido com sucesso.");
                            } else {
                                System.out.println("Material com ID " + idRemover + " não encontrado.");
                            }
                        }
                        break;

                    case 0:
                        System.out.println("Sistema encerrado. Obrigado por usar a Lixeira Inteligente!");
                        break;

                    default:
                        System.out.println("Opção inválida. Digite um número entre 0 e 7.");
                }

            } catch (NumberFormatException e) {
                System.out.println("Erro: por favor, digite apenas números no menu.");
            } catch (Exception e) {
                System.out.println("Erro inesperado: " + e.getMessage());
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

        System.out.println("Acesso negado! Credenciais inválidas.");
        return false;
    }
}
