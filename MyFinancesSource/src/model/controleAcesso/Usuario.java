
package model.controleAcesso;

import java.util.ArrayList;


public class Usuario {
    private int idParceiro;
    private String login,senha;
    private ArrayList<Perfil> perfil;
    private boolean deletado;

    public Usuario(int idParceiro, String login, String senha) {
        this.idParceiro = idParceiro;
        this.login = login;
        this.senha = senha;
        perfil = new ArrayList<Perfil>();
        deletado = false;
    }

    public boolean isDeletado() {
        return deletado;
    }

    public void setDeletado(boolean deletado) {
        this.deletado = deletado;
    }

    public ArrayList<Perfil> getPerfil() {
        return perfil;
    }

    public void setPerfil(ArrayList<Perfil> perfil) {
        this.perfil = perfil;
    }
    

    public void addPerfil(Perfil e){
        perfil.add(e);
    }
    
    public int getIdParceiro() {
        return idParceiro;
    }

    public void setIdParceiro(int idParceiro) {
        this.idParceiro = idParceiro;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public ArrayList<Perfil> getPerfis() {
        return perfil;
    }
    
}
