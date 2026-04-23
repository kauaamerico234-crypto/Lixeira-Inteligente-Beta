package model;

public class Material {
    private int id;
    private String nome;
    private String categoria;
    private String tempoDecomposicao;
    private String dicas;

    public Material(int id, String nome, String categoria, String tempoDecomposicao, String dicas) {
        this.id = id;
        this.nome = nome;
        this.categoria = categoria;
        this.tempoDecomposicao = tempoDecomposicao;
        this.dicas = dicas;
    }

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }

    public String getCategoria() { return categoria; }
    public void setCategoria(String categoria) { this.categoria = categoria; }

    public String getTempoDecomposicao() { return tempoDecomposicao; }
    public void setTempoDecomposicao(String tempoDecomposicao) { this.tempoDecomposicao = tempoDecomposicao; }

    public String getDicas() { return dicas; }
    public void setDicas(String dicas) { this.dicas = dicas; }

    @Override
    public String toString() {
        return "Material: " + nome +
                "\nCategoria: " + categoria +
                "\nTempo de decomposição: " + tempoDecomposicao +
                "\nDicas: " + dicas + "\n";
    }
}
