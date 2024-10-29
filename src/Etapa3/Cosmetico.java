package Etapa3;

public class Cosmetico extends Loja {
    private double taxaComercializacao;

    // Construtor que inicializa todos os atributos, incluindo os da superclasse
    public Cosmetico(String nome, int quantidadeFuncionarios, double salarioBaseFuncionario,
                     Endereco endereco, Data dataFundacao, double taxaComercializacao) {
        super(nome, quantidadeFuncionarios, salarioBaseFuncionario, endereco, dataFundacao);
        this.taxaComercializacao = taxaComercializacao;
    }

    // Construtor alternativo, caso a loja não tenha salário base definido
    public Cosmetico(String nome, int quantidadeFuncionarios, Endereco endereco,
                     Data dataFundacao, double taxaComercializacao) {
        super(nome, quantidadeFuncionarios, endereco, dataFundacao);
        this.taxaComercializacao = taxaComercializacao;
    }

    // Getter e Setter para taxaComercializacao
    public double getTaxaComercializacao() {
        return taxaComercializacao;
    }

    public void setTaxaComercializacao(double taxaComercializacao) {
        this.taxaComercializacao = taxaComercializacao;
    }

    // Sobrescrevendo o método toString para incluir taxaComercializacao
    @Override
    public String toString() {
        return super.toString() +
                ", Taxa de Comercialização: " + String.format("%.2f", taxaComercializacao) + "]";
    }
}
