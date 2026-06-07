package model;

// HERANÇA:
// MaterialRejeito herda atributos e métodos da classe Material
// Representa materiais que NÃO podem ser reciclados nem compostados
public class MaterialRejeito extends Material {

    public MaterialRejeito(int id, String nome, Categoria categoria,
                           String tempoDecomposicao, String dicas) {
        super(id, nome, categoria, tempoDecomposicao, dicas);
    }

    // POLIMORFISMO:
    // Override do método toString() com alerta específico para rejeitos
    @Override
    public String toString() {
        return "\n===== MATERIAL REJEITO =====\n" + super.toString() +
                "\nATENÇÃO: Este material não pode ser reciclado. Descarte no lixo comum (saco preto).";
    }
}
