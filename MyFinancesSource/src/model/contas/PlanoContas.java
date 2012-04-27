
package model.contas;
public class PlanoContas {
   private String conta;
   private int codigoReduzido;
   private String descricao;
   private String tipo;

    public PlanoContas(String onta, int codigoReduzido, String descricao, String tipo) {
        this.conta = onta;
        this.codigoReduzido = codigoReduzido;
        this.descricao = descricao;
        this.tipo = tipo;
    }

    public PlanoContas(String onta, String descricao, String tipo) {
        this.conta = onta;
        this.descricao = descricao;
        this.tipo = tipo;
    }

    public int getCodigoReduzido() {
        return codigoReduzido;
    }

    public void setCodigoReduzido(int codigoReduzido) {
        this.codigoReduzido = codigoReduzido;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getConta() {
        return conta;
    }

    public void setConta(String onta) {
        this.conta = onta;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    

    
}
