package model.contas;


public class ContaParceiro {
    private int idParceiro;
    private String Conta;
    private String tipoDaConta;

    public ContaParceiro(int idParceiro, String Conta, String tipoDaConta) {
        this.idParceiro = idParceiro;
        this.Conta = Conta;
        this.tipoDaConta = tipoDaConta;
    }

    public String getConta() {
        return Conta;
    }

    public void setConta(String Conta) {
        this.Conta = Conta;
    }

    public int getIdParceiro() {
        return idParceiro;
    }

    public void setIdParceiro(int idParceiro) {
        this.idParceiro = idParceiro;
    }

    public String getTipoDaConta() {
        return tipoDaConta;
    }

    public void setTipoDaConta(String tipoDaConta) {
        this.tipoDaConta = tipoDaConta;
    }    
    
}
