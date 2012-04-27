package model.parceiro;

import java.sql.Date;

public class Compromisso {
    private int id;
    private String status,prioridade;
    private Date data;
    private String hora;
    private Endereco endereco;
    private String obs;

    public Compromisso(String status, String prioridade, Date data, String hora, Endereco endereco, String obs) {
        this.status = status;
        this.prioridade = prioridade;
        this.data = data;
        this.hora = hora;
        this.endereco = endereco;
        this.obs = obs;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }

    public String getHora() {
        return hora;
    }

    public void setHora(String hora) {
        this.hora = hora;
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

    public String getPrioridade() {
        return prioridade;
    }

    public void setPrioridade(String prioridade) {
        this.prioridade = prioridade;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
    
    
}
