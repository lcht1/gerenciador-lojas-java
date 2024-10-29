package Etapa3;

public class Produto {
    private String nome;
    private double preco;
    private Data dataValidade;

    public Produto(String nome, double preco, Data dataValidade) {
        this.nome = nome;
        this.preco = preco;
        this.dataValidade = dataValidade;


    }

    /* Setters */
    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    public void setDataValidade(Data dataValidade) {
        this.dataValidade = dataValidade;
    }


    /* Getters */
    public String getNome() {
        return nome;
    }

    public double getPreco() {
        return preco;
    }

    public Data getDataValidade() {
        return dataValidade;
    }

    @Override
    public String toString() {
        return "Produto [Nome: " + nome +
                ", Preço: R$ " + String.format("%.2f", preco) +
                ", Data de Validade: " + dataValidade.toString() + "]";    }

    public boolean estaVencido(Data data) {
        if (this.dataValidade.getAno() < data.getAno()) {
            return true;
        } else if (this.dataValidade.getAno() > data.getAno()) {
            return false;
        }
        if (this.dataValidade.getMes() < data.getMes()) {
            return true;
        } else if (this.dataValidade.getMes() > data.getMes()) {
            return false;
        }
        return this.dataValidade.getDia() <= data.getDia();
    }

}
