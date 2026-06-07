package model;

// HERANÇA:
// MaterialOrganico herda atributos e métodos da classe Material
public class MaterialOrganico extends Material {

    public MaterialOrganico(int id, String nome, Categoria categoria,
                            String tempoDecomposicao, String dicas) {
        super(id, nome, categoria, tempoDecomposicao, dicas);
    }

    // POLIMORFISMO:
    // Override do método toString() com identificação visual específica
    @Override
    public String toString() {
        return "\n===== MATERIAL ORGÂNICO =====\n" + super.toString();
    }
}
