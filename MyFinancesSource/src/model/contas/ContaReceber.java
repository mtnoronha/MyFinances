package model.contas;

import model.parceiro.ParceiroComercial;
import java.sql.Date;

public class ContaReceber {
    private int id;
    private ParceiroComercial parceiro;
    private Date data;
    private double valor;
    private String obs;
    private Date vencimento;
    private boolean recebido;
    private Date dataRecebimento;    
    private int idHistoricoPadrao;
    private String contaCredito;
    private String contaDebito;

          
    public ContaReceber(ParceiroComercial parceiro, Date data, double valor, String obs, Date vencimento, boolean pago,Date dataRecebimento,int idHistorico,String contaCredito,String contaDebito){
        this.parceiro = parceiro;
        this.data = data;
        this.valor = valor;
        this.obs = obs;
        this.vencimento = vencimento;
        this.recebido = pago;
        this.dataRecebimento = dataRecebimento;
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

    
    
    public Date getDataRecebimento() {
        return dataRecebimento;
    }

    public void setDataRecebimento(Date dataRecebimento) {
        this.dataRecebimento = dataRecebimento;
    }
    
    public boolean isRecebido() {
        return recebido;
    }

    public void setRecebido(boolean pago) {
        this.recebido = pago;
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
