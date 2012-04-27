package model.contas;

import model.parceiro.ParceiroComercial;
import java.sql.Date;

public class ContaPagar {
    
    private int id;
    private ParceiroComercial parceiro;
    private Date data;
    private double valor;
    private String obs;
    private Date vencimento;
    private boolean pago;
    private Date dataPagamento;
    private int idHistoricoPadrao;
    private String contaCredito;
    private String contaDebito;

    
    public ContaPagar(ParceiroComercial parceiro, Date data, double valor, String obs, Date vencimento, boolean pago,Date dataPagamento,int idHistorico,String contaCredito,String contaDebito) {
        this.parceiro = parceiro;
        this.data = data;
        this.valor = valor;
        this.obs = obs;
        this.vencimento = vencimento;
        this.pago = pago;
        this.dataPagamento = dataPagamento;
               this.idHistoricoPadrao = idHistorico;
        this.contaCredito = contaCredito;
        this.contaDebito = contaDebito; 
    }

    public String getContaCredito() {
        return contaCredito;
    }

    public void setContaCredito(String contaCredito) {
        this.contaCredito = contaCredito;
    }

    public String getContaDebito() {
        return contaDebito;
    }

    public void setContaDebito(String contaDebito) {
        this.contaDebito = contaDebito;
    }

    public int getIdHistoricoPadrao() {
        return idHistoricoPadrao;
    }

    public void setIdHistoricoPadrao(int idHistoricoPadrao) {
        this.idHistoricoPadrao = idHistoricoPadrao;
    }
 

    public Date getDataPagamento() {
        return dataPagamento;
    }

    public void setDataPagamento(Date dataPagamento) {
        this.dataPagamento = dataPagamento;
    }

    
    public boolean isPago() {
        return pago;
    }

    public void setPago(boolean pago) {
        this.pago = pago;
    }

    public Date getVencimento() {
        return vencimento;
    }

    public void setVencimento(Date vencimento) {
        this.vencimento = vencimento;
    }
    
    

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getObs() {
        return obs;
    }

    public void setObs(String obs) {
        this.obs = obs;
    }

    public ParceiroComercial getParceiro() {
        return parceiro;
    }

    public void setParceiro(ParceiroComercial parceiro) {
        this.parceiro = parceiro;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }
    
    
    
}
