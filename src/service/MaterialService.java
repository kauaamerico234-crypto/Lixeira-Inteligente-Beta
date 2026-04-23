package service;

import model.Material;
import java.util.ArrayList;

public class MaterialService {

    private ArrayList<Material> materiais;

    public MaterialService() {
        materiais = new ArrayList<>();
    }

    public void adicionarMaterial(Material material) {
        materiais.add(material);
    }

    public void listarMateriais() {
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
}
