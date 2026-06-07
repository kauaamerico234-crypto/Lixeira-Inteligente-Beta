package model;

// Classe base do sistema
// ENCAPSULAMENTO:
// Os atributos são private e acessados por getters/setters
public class Material {

    private int id;
    private String nome;
    private Categoria categoria;
    private String tempoDecomposicao;
    private String dicas;

    // SOBRECARGA:
    // Construtor vazio
    public Material() {
    }

    // SOBRECARGA:
    // Construtor com parâmetros básicos
    public Material(int id, String nome, Categoria categoria) {
        this.id = id;
        this.nome = nome;
        this.categoria = categoria;
    }

    // SOBRECARGA:
    // Construtor completo
    public Material(int id, String nome, Categoria categoria,
                    String tempoDecomposicao, String dicas) {
        this.id = id;
        this.nome = nome;
        this.categoria = categoria;
        this.tempoDecomposicao = tempoDecomposicao;
        this.dicas = dicas;
    }

    // GETTERS E SETTERS (Encapsulamento)

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
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

    // POLIMORFISMO (sobrescrito nas subclasses):
    @Override
    public String toString() {
        return "ID: " + id +
                "\nNome: " + nome +
                "\nCategoria: " + categoria +
                "\nTempo de decomposição: " + tempoDecomposicao +
                "\nDicas: " + dicas;
    }
}
