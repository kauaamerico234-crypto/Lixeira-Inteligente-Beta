package model;

public class MaterialReciclavel extends Material {

    private String corLixeira;

    public MaterialReciclavel(int id,
                              String nome,
                              String categoria,
                              String tempoDecomposicao,
                              String dicas,
                              String corLixeira) {

        super(id, nome, categoria, tempoDecomposicao, dicas);

        this.corLixeira = corLixeira;
    }

    public String getCorLixeira() {
        return corLixeira;
    }

    public void setCorLixeira(String corLixeira) {
        this.corLixeira = corLixeira;
    }

    @Override
    public String toString() {

        return super.toString() +
                "\nCor da lixeira: " + corLixeira +
                "\n================================";
    }
}
