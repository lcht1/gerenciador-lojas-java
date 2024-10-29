package Etapa1;

public class Data {

    private int dia;
    private int mes;
    private int ano;

    public Data(int dia, int mes, int ano) {
        if (isDataValida(dia, mes, ano)) {
            this.dia = dia;
            this.mes = mes;
            this.ano = ano;
        } else {
            this.dia = 1;
            this.mes = 1;
            this.ano = 2000;
        }
    }


    // Getters
    public int getDia() {
        return dia;
    }

    public int getMes() {
        return mes;
    }

    public int getAno() {
        return ano;
    }

    // Setters
    public void setDia(int dia) {
        if (isDataValida(dia, mes, ano)) {
            this.dia = dia;
        }
    }

    public void setMes(int mes) {
        if (isDataValida(dia, mes, ano)) {
            this.mes = mes;
        }
    }

    public void setAno(int ano) {
        if (isDataValida(dia, mes, ano)) {
            this.ano = ano;
        }
    }

    private boolean isDataValida(int dia, int mes, int ano) {
        if (ano < 1 || mes < 1 || mes > 12 || dia < 1) {
            return false;
        }

        int diasNoMes;
        switch (mes) {
            case 1: case 3: case 5: case 7: case 8: case 10: case 12:
                diasNoMes = 31;
                break;
            case 4: case 6: case 9: case 11:
                diasNoMes = 30;
                break;
            case 2:
                diasNoMes = (verificaAnoBissexto(ano)) ? 29 : 28;
                break;
            default:
                return false;
        }
        return dia <= diasNoMes;
    }

    public boolean verificaAnoBissexto() {
        return verificaAnoBissexto(this.ano);
    }

    private boolean verificaAnoBissexto(int ano) {
        return (ano % 4 == 0 && ano % 100 != 0) || (ano % 400 == 0);
    }


    @Override
    public String toString() {
        return dia + "/" + mes + "/" + ano;
    }

}
