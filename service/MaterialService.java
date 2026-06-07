package service;

import java.util.ArrayList;
import java.util.Iterator;
import model.*;

// MVC:
// Esta classe representa o SERVICE do sistema.
// Toda regra de negócio e operações CRUD ficam aqui.
public class MaterialService {

    // ArrayList utilizado para armazenar os materiais em memória
    private ArrayList<Material> materiais = new ArrayList<>();

    // Contador automático de IDs para novos materiais cadastrados
    private int proximoId = 61;

    public MaterialService() {
        carregarMateriaisAutomaticos();
    }

    // ==================== CRUD ====================

    // CRUD - CREATE: adiciona um novo material à lista
    public void adicionarMaterial(Material material) {
        materiais.add(material);
    }

    // Retorna o próximo ID disponível (para uso na view)
    public int getProximoId() {
        return proximoId++;
    }

    // CRUD - READ: retorna todos os materiais cadastrados
    public ArrayList<Material> listarMateriais() {
        return materiais;
    }

    // CRUD - UPDATE: atualiza nome, tempo e dicas de um material pelo ID
    public boolean atualizarMaterial(int id, String novoNome,
                                     String novoTempo, String novasDicas) {
        for (Material material : materiais) {
            if (material.getId() == id) {
                material.setNome(novoNome);
                material.setTempoDecomposicao(novoTempo);
                material.setDicas(novasDicas);
                return true;
            }
        }
        return false;
    }

    // CRUD - DELETE: remove material pelo ID
    // CORREÇÃO: uso de Iterator para evitar ConcurrentModificationException
    public boolean removerMaterial(int id) {
        Iterator<Material> iterator = materiais.iterator();
        while (iterator.hasNext()) {
            Material material = iterator.next();
            if (material.getId() == id) {
                iterator.remove();
                return true;
            }
        }
        return false;
    }

    // ==================== BUSCAS ====================

    // Busca por nome exato (case-insensitive)
    public Material buscarPorNome(String nome) {
        for (Material material : materiais) {
            if (material.getNome().equalsIgnoreCase(nome)) {
                return material;
            }
        }
        return null;
    }

    // SOBRECARGA: busca por palavra-chave parcial (contém trecho do nome)
    public ArrayList<Material> buscarPorNome(String palavraChave, boolean parcial) {
        ArrayList<Material> encontrados = new ArrayList<>();
        for (Material material : materiais) {
            if (material.getNome().toLowerCase()
                    .contains(palavraChave.toLowerCase())) {
                encontrados.add(material);
            }
        }
        return encontrados;
    }

    // Busca por categoria específica
    public ArrayList<Material> buscarPorCategoria(Categoria categoria) {
        ArrayList<Material> encontrados = new ArrayList<>();
        for (Material material : materiais) {
            if (material.getCategoria() == categoria) {
                encontrados.add(material);
            }
        }
        return encontrados;
    }

    // ==================== CARGA INICIAL ====================

    // Cadastro automático de 60 materiais pré-cadastrados
    private void carregarMateriaisAutomaticos() {

        String[] plasticos = {
            "Garrafa PET", "Sacola Plástica", "Pote de Shampoo", "Copo Descartável",
            "Canudo", "Tampa Plástica", "Embalagem de Detergente", "Brinquedo Plástico",
            "Pote de Margarina", "Escova de Dente"
        };

        String[] metais = {
            "Lata de Alumínio", "Panela Velha", "Pregos", "Fios de Cobre",
            "Tampa Metálica", "Ferramenta Antiga", "Clipes", "Parafusos",
            "Chapa de Ferro", "Lata de Tinta"
        };

        String[] papeis = {
            "Jornal", "Revista", "Caixa de Papelão", "Folha Sulfite",
            "Caderno", "Envelope", "Papel Kraft", "Cartolina",
            "Panfleto", "Livro Velho"
        };

        String[] vidros = {
            "Garrafa de Vidro", "Pote de Conserva", "Copo de Vidro", "Janela Quebrada",
            "Frasco de Perfume", "Vidro Temperado", "Taça", "Lâmpada",
            "Espelho", "Pote de Geleia"
        };

        String[] organicos = {
            "Casca de Banana", "Restos de Comida", "Folhas Secas", "Borra de Café",
            "Casca de Ovo", "Frutas Estragadas", "Verduras", "Grama Cortada",
            "Sementes", "Pão Velho"
        };

        String[] rejeitos = {
            "Esponja de Cozinha", "Fralda Descartável", "Papel Higiênico Usado",
            "Embalagem de Pizza com Gordura", "Isopor Sujo", "Absorvente",
            "Fio Dental", "Cotonete", "Cigarro", "Espelho Quebrado"
        };

        int id = 1;

        for (String item : plasticos) {
            adicionarMaterial(new MaterialReciclavel(
                id++, item, Categoria.PLASTICO,
                "100 a 450 anos",
                "Descartar em coleta seletiva de plástico."
            ));
        }

        for (String item : metais) {
            adicionarMaterial(new MaterialReciclavel(
                id++, item, Categoria.METAL,
                "50 a 500 anos",
                "Separar para reciclagem metálica."
            ));
        }

        for (String item : papeis) {
            adicionarMaterial(new MaterialReciclavel(
                id++, item, Categoria.PAPEL,
                "3 a 6 meses",
                "Manter seco para reciclagem."
            ));
        }

        for (String item : vidros) {
            adicionarMaterial(new MaterialReciclavel(
                id++, item, Categoria.VIDRO,
                "Mais de 4000 anos",
                "Levar para ponto de coleta de vidro."
            ));
        }

        for (String item : organicos) {
            adicionarMaterial(new MaterialOrganico(
                id++, item, Categoria.ORGANICO,
                "2 semanas a 6 meses",
                "Ideal para compostagem doméstica."
            ));
        }

        for (String item : rejeitos) {
            adicionarMaterial(new MaterialRejeito(
                id++, item, Categoria.REJEITO,
                "Variável (décadas a séculos)",
                "Descarte no lixo comum (saco preto)."
            ));
        }
    }
}
