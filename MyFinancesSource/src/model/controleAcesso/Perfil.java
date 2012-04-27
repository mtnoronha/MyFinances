
package model.controleAcesso;


public class Perfil {
    
    private int IdParceiro;
    private String nomeJanela;
    private boolean visualizar,alterar,inserir,deletar;

    public Perfil(int IdParceiro, String nomeJanela, boolean visualizar, boolean alterar, boolean inserir, boolean deletar) {
        this.IdParceiro = IdParceiro;
        this.nomeJanela = nomeJanela;
        this.visualizar = visualizar;
        this.alterar = alterar;
        this.inserir = inserir;
        this.deletar = deletar;
    }
    
    
    public int getIdParceiro() {
        return IdParceiro;
    }

    public void setIdParceiro(int IdParceiro) {
        this.IdParceiro = IdParceiro;
    }

    public boolean isAlterar() {
        return alterar;
    }

    public void setAlterar(boolean alterar) {
        this.alterar = alterar;
    }

    public boolean isDeletar() {
        return deletar;
    }

    public void setDeletar(boolean deletar) {
        this.deletar = deletar;
    }

    public boolean isInserir() {
        return inserir;
    }

    public void setInserir(boolean inserir) {
        this.inserir = inserir;
    }

    public String getNomeJanela() {
        return nomeJanela;
    }

    public void setNomeJanela(String nomeJanela) {
        this.nomeJanela = nomeJanela;
    }

    public boolean isVisualizar() {
        return visualizar;
    }

    public void setVisualizar(boolean visualizar) {
        this.visualizar = visualizar;
    }
    
    
    
}
