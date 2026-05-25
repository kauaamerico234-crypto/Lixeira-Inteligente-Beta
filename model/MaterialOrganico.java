package model;

public class MaterialOrganico extends Material {

    private boolean compostavel;

    public MaterialOrganico(int id,
                            String nome,
                            String categoria,
                            String tempoDecomposicao,
                            String dicas,
                            boolean compostavel) {

        super(id, nome, categoria, tempoDecomposicao, dicas);

        this.compostavel = compostavel;
    }

    public boolean isCompostavel() {
        return compostavel;
    }

    public void setCompostavel(boolean compostavel) {
        this.compostavel = compostavel;
    }

    @Override
    public String toString() {

        String status = compostavel ? "Sim" : "Não";

        return super.toString() +
                "\nCompostável: " + status +
                "\n================================";
    }
}
