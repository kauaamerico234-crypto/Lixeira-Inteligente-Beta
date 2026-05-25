package model;

// Classe principal do sistema
public class Material {

    private int id;
    private String nome;
    private String categoria;
    private String tempoDecomposicao;
    private String dicas;

    // Construtor principal
    public Material(int id, String nome, String categoria,
                    String tempoDecomposicao, String dicas) {

        this.id = id;
        this.nome = nome;
        this.categoria = categoria;
        this.tempoDecomposicao = tempoDecomposicao;
        this.dicas = dicas;
    }

    // SOBRECARGA DE CONSTRUTOR
    public Material(String nome, String categoria) {
        this.nome = nome;
        this.categoria = categoria;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {

        if (id > 0) {
            this.id = id;
        }
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {

        if (!nome.isEmpty()) {
            this.nome = nome;
        }
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public String getTempoDecomposicao() {
        return tempoDecomposicao;
    }

    public void setTempoDecomposicao(String tempoDecomposicao) {
        this.tempoDecomposicao = tempoDecomposicao;
    }

    public String getDicas() {
        return dicas;
    }

    public void setDicas(String dicas) {
        this.dicas = dicas;
    }

    @Override
    public String toString() {

        return "\nID: " + id +
                "\nNome: " + nome +
                "\nCategoria: " + categoria +
                "\nTempo de decomposição: " + tempoDecomposicao +
                "\nDicas: " + dicas +
                "\n--------------------------------";
    }
}
