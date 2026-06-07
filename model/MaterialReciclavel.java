package model;

// HERANÇA:
// MaterialReciclavel herda atributos e métodos da classe Material
public class MaterialReciclavel extends Material {

    public MaterialReciclavel(int id, String nome, Categoria categoria,
                              String tempoDecomposicao, String dicas) {
        super(id, nome, categoria, tempoDecomposicao, dicas);
    }

    // POLIMORFISMO:
    // Override do método toString() com identificação visual específica
    @Override
    public String toString() {
        return "\n===== MATERIAL RECICLÁVEL =====\n" + super.toString();
    }
}
