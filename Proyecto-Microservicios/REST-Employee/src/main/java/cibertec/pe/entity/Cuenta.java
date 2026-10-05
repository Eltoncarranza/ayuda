package cibertec.pe.entity;

public class Cuenta {
    private String banco;
    private String tipo;
    private int cod_Empl;

    public Cuenta() {
    }

    public Cuenta(String banco, String tipo, int cod_Empl) {
        this.banco = banco;
        this.tipo = tipo;
        this.cod_Empl = cod_Empl;
    }

    public String getBanco() {
        return banco;
    }

    public void setBanco(String banco) {
        this.banco = banco;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public int getCod_Empl() {
        return cod_Empl;
    }

    public void setCod_Empl(int cod_Empl) {
        this.cod_Empl = cod_Empl;
    }
}
