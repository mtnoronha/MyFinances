
package model.contas;

public class HistoricoPadrao {
    private int id;
    private String descricao;

    public HistoricoPadrao(String descricao) {
        this.descricao = descricao;
    }

    
    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    
    
           
    
}
