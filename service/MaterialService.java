package service;

import model.Material;
import model.MaterialOrganico;
import model.MaterialReciclavel;

import java.util.ArrayList;

public class MaterialService {

    private ArrayList<Material> materiais;

    public MaterialService() {

        materiais = new ArrayList<>();

        carregarMateriaisIniciais();
    }

    private void carregarMateriaisIniciais() {

        materiais.add(new MaterialReciclavel(1, "Garrafa PET", "Plástico", "400 anos", "Lavar antes de reciclar", "Vermelha"));
        materiais.add(new MaterialReciclavel(2, "Sacola Plástica", "Plástico", "100 anos", "Evitar descarte irregular", "Vermelha"));
        materiais.add(new MaterialReciclavel(3, "Copo Descartável", "Plástico", "250 anos", "Separar limpo", "Vermelha"));
        materiais.add(new MaterialReciclavel(4, "Pote de Margarina", "Plástico", "200 anos", "Lavar antes do descarte", "Vermelha"));
        materiais.add(new MaterialReciclavel(5, "Tampa Plástica", "Plástico", "150 anos", "Separar por tipo", "Vermelha"));

        materiais.add(new MaterialReciclavel(11, "Lata de Alumínio", "Metal", "200 anos", "Amassar antes de descartar", "Amarela"));
        materiais.add(new MaterialReciclavel(12, "Tampa Metálica", "Metal", "100 anos", "Separar corretamente", "Amarela"));

        materiais.add(new MaterialReciclavel(21, "Jornal", "Papel", "6 meses", "Manter seco", "Azul"));
        materiais.add(new MaterialReciclavel(22, "Revista", "Papel", "6 meses", "Evitar molhar", "Azul"));

        materiais.add(new MaterialReciclavel(31, "Garrafa de Vidro", "Vidro", "1000 anos", "Descartar com cuidado", "Verde"));
        materiais.add(new MaterialReciclavel(32, "Pote de Vidro", "Vidro", "1000 anos", "Lavar antes do descarte", "Verde"));

        materiais.add(new MaterialOrganico(41, "Casca de Banana", "Orgânico", "2 meses", "Pode compostar", true));
        materiais.add(new MaterialOrganico(42, "Restos de Comida", "Orgânico", "1 mês", "Separar dos recicláveis", true));
    }

    public void adicionarMaterial(Material material) {
        materiais.add(material);
    }

    public void listarMateriais() {

        if (materiais.isEmpty()) {
            System.out.println("Nenhum material cadastrado.");
            return;
        }

        for (Material m : materiais) {
            System.out.println(m);
        }
    }

    public Material buscarPorNome(String nome) {

        for (Material m : materiais) {

            if (m.getNome().equalsIgnoreCase(nome)) {
                return m;
            }
        }

        return null;
    }

    public void buscarPorCategoria(String categoria) {

        boolean encontrado = false;

        for (Material m : materiais) {

            if (m.getCategoria().equalsIgnoreCase(categoria)) {

                System.out.println(m);
                encontrado = true;
            }
        }

        if (!encontrado) {
            System.out.println("Nenhum material encontrado.");
        }
    }

    public boolean removerMaterial(String nome) {

        Material material = buscarPorNome(nome);

        if (material != null) {

            materiais.remove(material);

            return true;
        }

        return false;
    }
}
