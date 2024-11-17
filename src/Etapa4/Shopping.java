package Etapa4;
import java.text.Normalizer;

public class Shopping {
    private String nome;
    private Endereco endereco;
    private Loja[] lojas;

    public Shopping(String nome, Endereco endereco, int quantidadeMaximaLojas) {
        this.nome = nome;
        this.endereco = endereco;
        this.lojas = new Loja[quantidadeMaximaLojas];
    }

    // Getters
    public String getNome() {
        return nome;
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public Loja[] getLojas() {
        return lojas;
    }

    // Setters
    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }

    public void setLojas(Loja[] lojas) {
        this.lojas = lojas;
    }

    @Override
    public String toString() {
        StringBuilder lojasStr = new StringBuilder();
        for (Loja loja : lojas) {
            if (loja != null) {
                lojasStr.append(loja.toString()).append("\n");
            }
        }
        return "Shopping [Nome: " + nome +
                ", Endereço: " + endereco.toString() +
                ", Lojas: \n" + lojasStr.toString() + "]";
    }

    public boolean insereLoja(Loja novaLoja) {
        for (int i = 0; i < lojas.length; i++) {
            if (lojas[i] == null) {
                lojas[i] = novaLoja;
                return true;
            }
        }
        return false;
    }

    public boolean removeLoja(String nomeLoja) {
        for (int i = 0; i < lojas.length; i++) {
            if (lojas[i] != null && lojas[i].getNome().equals(nomeLoja)) {
                lojas[i] = null;
                return true;
            }
        }
        return false;
    }


    public int quantidadeLojasPorTipo(String tipoLoja) {

        int contador = 0;
        String[] tiposValidos = {"Cosmético", "Vestuário", "Bijuteria", "Alimentação", "Informática"};

        boolean tipoValido = false;
        String tipoLojaNormalizado = Normalizer.normalize(tipoLoja, Normalizer.Form.NFD).replaceAll("\\p{M}", "");

        for (String tipo : tiposValidos) {
            String tipoNormalizado = Normalizer.normalize(tipo, Normalizer.Form.NFD).replaceAll("\\p{M}", "");

            if (tipoNormalizado.equalsIgnoreCase(tipoLojaNormalizado)) {
                tipoValido = true;
                break;
            }
        }

        if (!tipoValido) {
            return -1;
        }

        for (Loja loja : lojas) {
            String tipoLojaDaClasse = Normalizer.normalize(loja.getClass().getSimpleName(), Normalizer.Form.NFD).replaceAll("\\p{M}", "");

            if (loja != null && tipoLojaDaClasse.equalsIgnoreCase(tipoLojaNormalizado)) {
                contador++;
            }
        }
        return contador;
    }
    public Informatica lojaSeguroMaisCaro() {
        Informatica maisCaro = null;
        double maiorSeguro = 0;

        for (Loja loja : lojas) {
            if (loja instanceof Informatica) {
                Informatica lojaInformatica = (Informatica) loja;
                if (lojaInformatica.getSeguroEletronicos() > maiorSeguro) {
                    maiorSeguro = lojaInformatica.getSeguroEletronicos();
                    maisCaro = lojaInformatica;
                }
            }
        }
        return maisCaro;
    }




}

