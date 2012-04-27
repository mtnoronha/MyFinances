
package model.contas;

import java.sql.Date;


public class Lancamento {
    int idLancamento;
    int idHistoricoPadrao;
    String idContaCredito;
    String idContaDebito;
    Date dataLancamento;
    double valor;

    public Lancamento(int idHistoricoPadrao, String idContaCredito, String idContaDebito, Date dataLancamento, double valor) {
        this.idHistoricoPadrao = idHistoricoPadrao;
        this.idContaCredito = idContaCredito;
        this.idContaDebito = idContaDebito;
        this.dataLancamento = dataLancamento;
        this.valor = valor;
    }

    public Date getDataLancamento() {
        return dataLancamento;
    }

    public void setDataLancamento(Date dataLancamento) {
        this.dataLancamento = dataLancamento;
    }

    public String getIdContaCredito() {
        return idContaCredito;
    }

    public void setIdContaCredito(String idContaCredito) {
        this.idContaCredito = idContaCredito;
    }

    public String getIdContaDebito() {
        return idContaDebito;
    }

    public void setIdContaDebito(String idContaDebito) {
        this.idContaDebito = idContaDebito;
    }

    public int getIdHistoricoPadrao() {
        return idHistoricoPadrao;
    }

    public void setIdHistoricoPadrao(int idHistoricoPadrao) {
        this.idHistoricoPadrao = idHistoricoPadrao;
    }

    public int getIdLancamento() {
        return idLancamento;
    }

    public void setIdLancamento(int idLancamento) {
        this.idLancamento = idLancamento;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }
    
    
    
}
