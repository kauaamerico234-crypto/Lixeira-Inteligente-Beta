package controller;

import java.util.ArrayList;
import model.*;

// MVC:
// Esta classe representa o CONTROLLER do sistema.
// Toda regra de negócio e CRUD ficam aqui.
public class MaterialController {

    // ArrayList utilizado para armazenar os materiais
    private ArrayList<Material> materiais = new ArrayList<>();

    public MaterialController() {
        carregarMateriaisAutomaticos();
    }

    // CRUD - CREATE
    public void adicionarMaterial(Material material) {
        materiais.add(material);
    }

    // CRUD - READ
    public ArrayList<Material> listarMateriais() {
        return materiais;
    }

    // CRUD - DELETE
    public boolean removerMaterial(int id) {

        for (Material material : materiais) {
            if (material.getId() == id) {
                materiais.remove(material);
                return true;
            }
        }

        return false;
    }

    // Busca por nome
    public Material buscarPorNome(String nome) {

        for (Material material : materiais) {
            if (material.getNome().equalsIgnoreCase(nome)) {
                return material;
            }
        }

        return null;
    }

    // Busca por categoria
    public ArrayList<Material> buscarPorCategoria(Categoria categoria) {

        ArrayList<Material> encontrados = new ArrayList<>();

        for (Material material : materiais) {
            if (material.getCategoria() == categoria) {
                encontrados.add(material);
            }
        }

        return encontrados;
    }

    // Cadastro automático dos 50 materiais
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
                "Levar para coleta de vidro."
            ));
        }

        for (String item : organicos) {
            adicionarMaterial(new MaterialOrganico(
                id++, item, Categoria.ORGANICO,
                "2 semanas a 6 meses",
                "Ideal para compostagem."
            ));
        }
    }
}