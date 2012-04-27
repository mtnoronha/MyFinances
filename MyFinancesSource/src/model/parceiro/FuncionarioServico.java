
package model.parceiro;


public class FuncionarioServico {
    private int idParceiro,idOs;

    public FuncionarioServico(int idParceiro, int idOs) {
        this.idParceiro = idParceiro;
        this.idOs = idOs;
    }

    public int getIdOs() {
        return idOs;
    }

    public void setIdOs(int idOs) {
        this.idOs = idOs;
    }

    public int getIdParceiro() {
        return idParceiro;
    }

    public void setIdParceiro(int idParceiro) {
        this.idParceiro = idParceiro;
    }
    
    
}
