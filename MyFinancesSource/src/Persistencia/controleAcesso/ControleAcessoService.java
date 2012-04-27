
package Persistencia.controleAcesso;

import Persistencia.Conectar;
import java.sql.Statement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import model.controleAcesso.Perfil;
import model.parceiro.ParceiroComercial;
import model.controleAcesso.Usuario;
import view.parceiro.JanParceirosComerciais;

public class ControleAcessoService {
    
    private static final String buscarUsuarioSQL = "select * from Usuario";
    private static PreparedStatement buscarUsuario = null; 
    private static final String buscarPerfilSQL = "select * from Perfil where idParceiro = ?";
    private static PreparedStatement buscarPerfil = null;

    
    private static final String inserirUsuarioSQL = "insert into Usuario values(?, ?, ?, false)";
    private static PreparedStatement inserirUsuario = null;
    private static final String inserirPerfilSQL = "insert into Perfil values(?, ? ,? ,? ,? ,?)";
    private static PreparedStatement inserirPerfil = null;
    
    //fazer idem aqui

    //update    
    private static final String updateUsuarioSQL = "update Usuario set login = ?, senha = ?, deletado = ? where idParceiro = ?";
    private static PreparedStatement updateUsuario = null;
    private static final String updatePerfilSQL = "update Perfil set visualizar = ?, alterar = ?, inserir = ?, deletar = ? where idParceiro = ? and nomeJanela = ?";
    private static PreparedStatement updatePerfil = null;
    
       public static ArrayList<Usuario> buscarUsuario() throws ClassNotFoundException,SQLException{
           ArrayList<Usuario> users = new ArrayList<Usuario>();
           
        if (buscarUsuario == null) {
            buscarUsuario = Conectar.open().prepareStatement(buscarUsuarioSQL);
        }

        ResultSet rs = buscarUsuario.executeQuery();

        
        while (rs.next()) {
            Usuario r = new Usuario(rs.getInt(1), rs.getString(2), rs.getString(3));
            r.setDeletado(rs.getBoolean(4));
            
            r.setPerfil(buscarPerfil(r.getIdParceiro()));
            users.add(r);
        }

           
           
           return users;
          
       }
       
           private static ArrayList<Perfil> buscarPerfil(int idParceiro) throws ClassNotFoundException,SQLException{
           ArrayList<Perfil> perfis = new ArrayList<Perfil>();
           
                if (buscarPerfil == null) {
            buscarPerfil = Conectar.open().prepareStatement(buscarPerfilSQL);
        }
   
             buscarPerfil.setInt(1, idParceiro);


        ResultSet rs = buscarPerfil.executeQuery();

        
        while (rs.next()) {
            Perfil p = new Perfil(idParceiro, rs.getString(2), rs.getBoolean(3), rs.getBoolean(4), rs.getBoolean(5), rs.getBoolean(6));
            perfis.add(p);            
        }

           
           
           return perfis;
          
       }
    private static void atualizarPerfil(Perfil acesso) throws ClassNotFoundException,SQLException{
        if(updatePerfil == null){
            updatePerfil = Conectar.open().prepareStatement(updatePerfilSQL);
        }
       
       
        updatePerfil.setBoolean(1, acesso.isVisualizar());
       updatePerfil.setBoolean(2, acesso.isAlterar());
       updatePerfil.setBoolean(3, acesso.isInserir());
       updatePerfil.setBoolean(4, acesso.isDeletar());
       updatePerfil.setInt(5, acesso.getIdParceiro());
       updatePerfil.setString(6, acesso.getNomeJanela());
      
       
       
       updatePerfil.executeUpdate();
    }
    public static void atualizarUsuario(Usuario acesso) throws ClassNotFoundException,SQLException{
        if(updateUsuario == null){
            updateUsuario = Conectar.open().prepareStatement(updateUsuarioSQL);
        }
       
       
       
       updateUsuario.setString(1, acesso.getLogin());
       updateUsuario.setString(2, acesso.getSenha());
       updateUsuario.setBoolean(3, acesso.isDeletado());
       updateUsuario.setDouble(4, acesso.getIdParceiro());
      
       
       updateUsuario.executeUpdate();
       
               for(Perfil a : acesso.getPerfis()){
            atualizarPerfil(a);
        }
       
    }
   public static void inserirUsuario(Usuario acesso) throws ClassNotFoundException,SQLException{
        if(inserirUsuario == null){
            inserirUsuario = Conectar.open().prepareStatement(inserirUsuarioSQL);           
        }
        
        inserirUsuario.setInt(1, acesso.getIdParceiro());
        inserirUsuario.setString(2, acesso.getLogin());
        inserirUsuario.setString(3, acesso.getSenha());
        
        inserirUsuario.executeUpdate();
        
        for(Perfil a : acesso.getPerfis()){
            inserirPerfil(a);
        }
        
        
    }
   
   private static void inserirPerfil(Perfil acesso) throws ClassNotFoundException,SQLException{
        if(inserirPerfil == null){
            inserirPerfil = Conectar.open().prepareStatement(inserirPerfilSQL);           
        }
        
        
        inserirPerfil.setInt(1, acesso.getIdParceiro());
        inserirPerfil.setString(2, acesso.getNomeJanela());
        inserirPerfil.setBoolean(3, acesso.isVisualizar());
        inserirPerfil.setBoolean(4, acesso.isAlterar());
        inserirPerfil.setBoolean(5, acesso.isInserir());
        inserirPerfil.setBoolean(6, acesso.isDeletar());
        
      
        inserirPerfil.executeUpdate();
        
        
    }
    
    
    

}
