package Persistencia.parceiro;

import Persistencia.Conectar;
import java.sql.Statement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.parceiro.Compromisso;
import model.parceiro.Contato;
import model.parceiro.Endereco;
import model.parceiro.ParceiroComercial;

public class ParceirosService {

    //select
    private static final String buscarCidadeSQL = "select nom_cidade from cidade where sigla_estado = ?";
    private static PreparedStatement buscarCidade = null;
    private static final String buscarParceiroSQL = "select * from parceiro_comercial";
    private static PreparedStatement buscarParceiro = null;
    private static final String buscarCompromissoSQL = "select * from compromisso";
    private static PreparedStatement buscarCompromisso = null;
    private static final String buscarIdContatoSQL = "select idContato from contato_parceiro where idparceiro = ?";
    private static PreparedStatement idContato = null;
    private static final String buscarContatoSQL = "select * from contato where idcontato = ?";
    private static PreparedStatement buscarContato = null;
    private static final String buscarIdEnderecoSQL = "select idEndereco from endereco_parceiro where idparceiro = ?";
    private static PreparedStatement idEndereco = null;
    private static final String buscarEnderecoSQL = "select * from endereco where idendereco = ? AND deletado = false";
    private static PreparedStatement buscarEndereco = null;
    private static final String buscarEnderecoAllSQL = "select * from endereco where deletado = false";
    private static PreparedStatement buscarEnderecoAll = null;
    //delete
    private static final String deletarContatoSQL = "delete from Contato where idContato = ?";
    private static PreparedStatement deletarContato = null;
    private static final String deletarCompromissoSQL = "delete from Compromisso where idCompromisso = ?";
    private static PreparedStatement deletarCompromisso = null;
    
    //insert
    private static final String inserirParceiroSQL = "insert into Parceiro_Comercial values(default, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, false)";
    private static PreparedStatement inserirParceiro = null;
    private static final String inserirContatoSQL = "insert into Contato values(default, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
    private static PreparedStatement inserirContato = null;
    private static final String inserirCompromissoSQL = "insert into Compromisso values(default, ?, ?, ?, ?, ?, ?)";
    private static PreparedStatement inserirCompromisso = null;
    
    private static final String inserirEnderecoSQL = "insert into Endereco values(default,?,?,?,?,?,?,?,?,false)";
    private static PreparedStatement inserirEndereco = null;
    private static final String relacaoContatoParceiroSQL = "insert into Contato_Parceiro values(?,?)";
    private static PreparedStatement relacaoContato = null;
    private static final String relacaoEnderecoParceiroSQL = "insert into Endereco_Parceiro values(?,?)";
    private static PreparedStatement relacaoEndereco = null;
    
    //update        
    private static final String updateParceiroSQL = "update Parceiro_Comercial set fisica = ?, funcionario = ?, fornecedor = ?, cliente = ?, dadosadicionais = ?, nome = ?, rg = ?, cpf = ?, datanascimento = ?, cnpj = ?, razaosocial = ?, nomefantasia = ?, deletado = ? where idParceiro = ?";
    private static PreparedStatement updateParceiro = null;
    private static final String updateContatoSQL = "update Contato set nome = ?, email = ?, skype = ?, msn = ?, fax = ?, telefone1 = ?, telefone2 = ?, telefone3 = ?, ramal1 = ?, ramal2 = ?, ramal3 = ?, celular = ? where idContato = ?";
    private static PreparedStatement updateContato = null;
        private static final String updateCompromissoSQL = "update Compromisso set status = ?, prioridade = ?, data = ?, hora = ?, obs = ?, idEndereco = ? where idCompromisso = ?";
    private static PreparedStatement updateCompromisso = null;
    private static final String updateEnderecoSQL = "update Endereco set estado = ?, cidade = ?, bairro = ?, logradouro = ?, numero = ?, complemento = ?, cep = ?, tipoendereco = ?, deletado = ? where idEndereco = ? ";
    private static PreparedStatement updateEndereco = null;
    
    //atualizar parceiro
    public static void atualizarParceiro(ParceiroComercial par) throws ClassNotFoundException,SQLException{
        if(updateParceiro == null){
            updateParceiro = Conectar.open().prepareStatement(updateParceiroSQL);
        }
        
       updateParceiro.setBoolean(1, par.isFisica());
       updateParceiro.setBoolean(2, par.isFuncionario());
       updateParceiro.setBoolean(3, par.isFornecedor());
       updateParceiro.setBoolean(4, par.isCliente());
       updateParceiro.setString(5, par.getDadosAdicionais());
       updateParceiro.setString(6, par.getNome());
       updateParceiro.setString(7, par.getRg());
       updateParceiro.setString(8, par.getCpf());
       updateParceiro.setDate(9, par.getDataNascimento());
       updateParceiro.setString(10, par.getCnpj());
       updateParceiro.setString(11, par.getRazaoSocial());
       updateParceiro.setString(12, par.getNomeFantasia());
       updateParceiro.setInt(14, par.getId());
       updateParceiro.setBoolean(13, par.isDeletado());
       
       updateParceiro.executeUpdate();
    }
    
    //atualizar contato
    
    public static void atualizarContato(Contato con) throws ClassNotFoundException,SQLException{
        if(updateContato == null){
            updateContato = Conectar.open().prepareStatement(updateContatoSQL);
        }
        
       updateContato.setString(1, con.getNome());
       updateContato.setString(2, con.getEmail());
       updateContato.setString(3, con.getSkype());
       updateContato.setString(4, con.getMsn() );
       updateContato.setString(5, con.getFax());
       updateContato.setString(6, con.getTel1());
       updateContato.setString(7, con.getTel2());
       updateContato.setString(8, con.getTel3());
       updateContato.setString(9, con.getRamal1());
       updateContato.setString(10, con.getRamal2());
       updateContato.setString(11, con.getRamal3());
       updateContato.setString(12, con.getCel());
       updateContato.setInt(13, con.getId());
       
       updateContato.executeUpdate();
    }
    
    //atualizar endereco
    
    public static void atualizarEndereco(Endereco end) throws ClassNotFoundException,SQLException{
        if(updateEndereco == null){
            updateEndereco = Conectar.open() .prepareStatement(updateEnderecoSQL);
        }
        
       updateEndereco.setString(1, end.getEstado());
       updateEndereco.setString(2, end.getCidade());
       updateEndereco.setString(3, end.getBairro());
       updateEndereco.setString(4, end.getLogradouro());
       updateEndereco.setInt(5, end.getNumero());
       updateEndereco.setString(6, end.getComplemento());
       updateEndereco.setString(7, end.getCep());
       updateEndereco.setString(8, end.getTipoEndereco());
       updateEndereco.setInt(10, end.getId());         
       updateEndereco.setBoolean(9, end.isDeletado());
        updateEndereco.executeUpdate();
    }
    
    
    
    //inserir Parceiro
    public static int inserirParceiro(ParceiroComercial par) throws ClassNotFoundException,SQLException{        
       if(inserirParceiro == null){
           inserirParceiro = Conectar.open().prepareStatement(inserirParceiroSQL);
       }
       
       //,nome,rg,cpf,datanascimento,cnpj,razaosocial,nomefantasia
       inserirParceiro.setBoolean(1, par.isFisica());
       inserirParceiro.setBoolean(2, par.isFuncionario());
       inserirParceiro.setBoolean(3, par.isFornecedor());
       inserirParceiro.setBoolean(4, par.isCliente());
       inserirParceiro.setString(5, par.getDadosAdicionais());
       inserirParceiro.setString(6, par.getNome());
       inserirParceiro.setString(7, par.getRg());
       inserirParceiro.setString(8, par.getCpf());
       inserirParceiro.setDate(9, par.getDataNascimento());
       inserirParceiro.setString(10, par.getCnpj());
       inserirParceiro.setString(11, par.getRazaoSocial());
       inserirParceiro.setString(12, par.getNomeFantasia());
       
       inserirParceiro.executeUpdate();
       
       Statement stmt = Conectar.open().createStatement();
       ResultSet rs = stmt.executeQuery("select max(idParceiro) from parceiro_comercial");
       int id = 0;
       
       if(rs.next()){
           id = rs.getInt(1);
       }
        return id;
    }
    
    
    //Inserir Endereço
    public static int inserirEndereco(Endereco end) throws ClassNotFoundException,SQLException{
       if(inserirEndereco == null){
           inserirEndereco = Conectar.open().prepareStatement(inserirEnderecoSQL);
       }
       
       //id endereco, estado, cidade, bairro, logradouro, numero, complemento, cep, tipo endereco
       inserirEndereco.setString(1, end.getEstado());
       inserirEndereco.setString(2, end.getCidade());
       inserirEndereco.setString(3, end.getBairro());
       inserirEndereco.setString(4, end.getLogradouro());
       inserirEndereco.setInt(5, end.getNumero());
       inserirEndereco.setString(6, end.getComplemento());
       inserirEndereco.setString(7, end.getCep());
       inserirEndereco.setString(8, end.getTipoEndereco());
       
       inserirEndereco.executeUpdate();

       Statement stmt = Conectar.open().createStatement();
       ResultSet rs = stmt.executeQuery("select max(idEndereco) from Endereco");
       int id = 0;
       
       if(rs.next()){
           id = rs.getInt(1);
       }
        return id;
        
    }
    
    //InserirContato
    public static int inserirContato(Contato con) throws ClassNotFoundException,SQLException{
if(inserirContato == null){
           inserirContato = Conectar.open().prepareStatement(inserirContatoSQL);
       }
        
        //id contato, nome, email, skype, msn, fax, telefone1, telefone2, telefone3, ramal1, ramal2, ramal3, celular
       inserirContato.setString(1, con.getNome());
       inserirContato.setString(2, con.getEmail());
       inserirContato.setString(3, con.getSkype());
       inserirContato.setString(4, con.getMsn() );
       inserirContato.setString(5, con.getFax());
       inserirContato.setString(6, con.getTel1());
       inserirContato.setString(7, con.getTel2());
       inserirContato.setString(8, con.getTel3());
       inserirContato.setString(9, con.getRamal1());
       inserirContato.setString(10, con.getRamal2());
       inserirContato.setString(11, con.getRamal3());
       inserirContato.setString(12, con.getCel());
       
       inserirContato.executeUpdate();
        
       Statement stmt = Conectar.open().createStatement();
       ResultSet rs = stmt.executeQuery("select max(idContato) from Contato");
       int id = 0;
       
       if(rs.next()){
           id = rs.getInt(1);
       }
        return id;
        
    }
    
    //Relacionamento 1 para muitos entre endereço e parceiro
    public static void inserirRelacaoEndereco(int idEndereco,int idParceiro) throws ClassNotFoundException,SQLException{
        if(relacaoEndereco == null){
            relacaoEndereco = Conectar.open().prepareStatement(relacaoEnderecoParceiroSQL);
        }
        
        relacaoEndereco.setInt(1, idParceiro);
        relacaoEndereco.setInt(2, idEndereco);
        
        relacaoEndereco.executeUpdate();
        
    }
    
    //Relacionamento 1 para muitos entre contato e parceiro
    public static void inserirRelacaoContato(int idContato, int idParceiro) throws ClassNotFoundException,SQLException{
        if(relacaoContato == null){
            relacaoContato = Conectar.open().prepareStatement(relacaoContatoParceiroSQL);
        }
        relacaoContato.setInt(1,idParceiro);
        relacaoContato.setInt(2,idContato);
        
        relacaoContato.executeUpdate();
    }
    
    //Usado para preencher a GUI ao iniciar o programa...
    public static ArrayList<ParceiroComercial> preencherParceiros() throws ClassNotFoundException, SQLException {
        ArrayList<ParceiroComercial> parceiros = new ArrayList<ParceiroComercial>();

        if (buscarParceiro == null) {
            buscarParceiro = Conectar.open().prepareStatement(buscarParceiroSQL);
        }

        ResultSet rs = buscarParceiro.executeQuery();

        /*
        1 - int   	id
        2 - boolean     fisica
        3 - boolean     funcionario
        4 - boolean     fornecedor
        5 - boolean     cliente
        6 - String      dados add
        --FISICA
        7 - String      nome      
        8 - String      rg
        9 - String      cpf
        10 - date       nascimento
        --JURIDICA
        11 - String     cnpj
        12 - String     razaoSocial
        13 - String     nome fantasia
         */

        while (rs.next()) {
            ParceiroComercial parceiro;

            if (rs.getBoolean(2)) {
                parceiro = new ParceiroComercial(rs.getBoolean(3), rs.getBoolean(4), rs.getBoolean(5), rs.getString(6), rs.getString(7), rs.getString(8), rs.getString(9), rs.getDate(10));
            } else {
                parceiro = new ParceiroComercial(rs.getBoolean(3), rs.getBoolean(4), rs.getBoolean(5), rs.getString(6), rs.getString(11), rs.getString(12), rs.getString(13));
            }

            parceiro.setId(rs.getInt(1));
            parceiro.setDeletado(rs.getBoolean(14));
            parceiros.add(parceiro);
        }

        carregarContatos(parceiros);
        carregarEnderecos(parceiros);

        return parceiros;
    }

    //Usado para carregar os Enderecos de cada parceiro.
    private static void carregarEnderecos(ArrayList<ParceiroComercial> parceiros) throws ClassNotFoundException, SQLException {
        if (idEndereco == null) {
            idEndereco = Conectar.open().prepareStatement(buscarIdEnderecoSQL);
        }

        for (ParceiroComercial parceiro : parceiros) {
            idEndereco.setInt(1, parceiro.getId());
            ResultSet rs = idEndereco.executeQuery();
            while (rs.next()) {
                Endereco e = buscarEndereco(rs.getInt(1));
                if(e != null){
                parceiro.addEndereco(e);
                }
            }
        }
    }

    //Usado para carregar os Contatos de cada parceiro.
    private static void carregarContatos(ArrayList<ParceiroComercial> parceiros) throws ClassNotFoundException, SQLException {

        if (idContato == null) {
            idContato = Conectar.open().prepareStatement(buscarIdContatoSQL);
        }

        for (ParceiroComercial parceiro : parceiros) {

            idContato.setInt(1, parceiro.getId());
            ResultSet rs = idContato.executeQuery();
            while (rs.next()) {
                parceiro.addContato(buscarContato(rs.getInt(1)));
            }
        }
    }

    //usado para criar o endereco
    public static Endereco buscarEndereco(int idDoEnd) throws ClassNotFoundException, SQLException {
        if (buscarEndereco == null) {
            buscarEndereco = Conectar.open().prepareStatement(buscarEnderecoSQL);
        }

        buscarEndereco.setInt(1, idDoEnd);
        ResultSet rs = buscarEndereco.executeQuery();

        /*
        1 - int       idEndereco
        2 - String    estado    
        3 - String    cidade
        4 - String    bairro
        5 - String    logradouro
        6 - int       numero
        7 - String    complemento
        8 - String    cep
        9 - String    tipoEndereco
         */

        Endereco endereco = null;
        while (rs.next()) {
            endereco = new Endereco(rs.getString(9), rs.getString(4), rs.getString(5), rs.getString(7), rs.getString(8), rs.getString(2), rs.getString(3), rs.getInt(6));
            endereco.setId(idDoEnd);
        }
        return endereco;

    }
    

        public static ArrayList<Endereco> buscarEnderecoAll() throws ClassNotFoundException, SQLException {
        ArrayList<Endereco> lista = new ArrayList<Endereco>();
        
            if (buscarEnderecoAll == null) {
            buscarEnderecoAll = Conectar.open().prepareStatement(buscarEnderecoAllSQL);
        }

        ResultSet rs = buscarEnderecoAll.executeQuery();

        /*
        1 - int       idEndereco
        2 - String    estado    
        3 - String    cidade
        4 - String    bairro
        5 - String    logradouro
        6 - int       numero
        7 - String    complemento
        8 - String    cep
        9 - String    tipoEndereco
         */


        while (rs.next()) {
            Endereco endereco = null;
            endereco = new Endereco(rs.getString(9), rs.getString(4), rs.getString(5), rs.getString(7), rs.getString(8), rs.getString(2), rs.getString(3), rs.getInt(6));
            endereco.setId(rs.getInt(1));
            lista.add(endereco);
        }
        
        return lista;

    }

        
    //usado para criar o contato
    private static Contato buscarContato(int idDoContato) throws ClassNotFoundException, SQLException {
        if (buscarContato == null) {
            buscarContato = Conectar.open().prepareStatement(buscarContatoSQL);
        }

        buscarContato.setInt(1, idDoContato);
        ResultSet rs = buscarContato.executeQuery();

        /*
        1 - int   	id
        2 - String      nome
        3 - String      email
        4 - String      skype
        5 - String      msn
        6 - String      fax
        7 - String      tel1      
        8 - String      tel2
        9 - String      tel3
        10 - String     ramal1
        11 - String     ramal2
        12 - String     ramal3
        13 - String     Celular
         */
        Contato contato = null;
        while (rs.next()) {
            contato = new Contato(rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getString(7), rs.getString(8), rs.getString(9), rs.getString(13), rs.getString(10), rs.getString(11), rs.getString(12));
            contato.setId(idDoContato);
        }
        return contato;
    }

    //Preenche a combo box de cidade ao modificar o  valor do campoEstado.
    public static ArrayList<String> preencherCidade(String estado) throws ClassNotFoundException, SQLException {

        if (buscarCidade == null) {
            buscarCidade = Conectar.open().prepareStatement(buscarCidadeSQL);
        }
        buscarCidade.setString(1, estado);
        ResultSet rs = buscarCidade.executeQuery();
        ArrayList<String> cidades = new ArrayList<String>();

        while (rs.next()) {
            cidades.add(rs.getString(1));
        }

        return cidades;
    }

   
 
    //deletar Contato
    public static void deletarContato(Contato con) throws ClassNotFoundException, SQLException {
        if (deletarContato == null) {
            deletarContato = Conectar.open().prepareStatement(deletarContatoSQL);
        }

        deletarContato.setInt(1, con.getId());
        deletarContato.executeUpdate();
    }
    
        //deletar Compromisso
    public static void deletarCompromisso(Compromisso con) throws ClassNotFoundException, SQLException {
        if (deletarCompromisso == null) {
            deletarCompromisso = Conectar.open().prepareStatement(deletarCompromissoSQL);
        }

        deletarCompromisso.setInt(1, con.getId());
        deletarCompromisso.executeUpdate();
    }

    public static int inserirCompromisso(Compromisso con) throws ClassNotFoundException, SQLException{

        if(inserirCompromisso == null){
           inserirCompromisso = Conectar.open().prepareStatement(inserirCompromissoSQL);
       }
        

       inserirCompromisso.setString(1, con.getStatus());
       inserirCompromisso.setString(2, con.getPrioridade());
       inserirCompromisso.setDate(3, con.getData());
       inserirCompromisso.setString(4, con.getHora() );
       inserirCompromisso.setInt(5, con.getEndereco().getId());
       inserirCompromisso.setString(6, con.getObs());
       
       inserirCompromisso.executeUpdate();
        
       Statement stmt = Conectar.open().createStatement();
       ResultSet rs = stmt.executeQuery("select max(idCompromisso) from Compromisso");
       int id = 0;
       
       if(rs.next()){
           id = rs.getInt(1);
       }
        return id;
        
    }

    public static void atualizarCompromisso(Compromisso con) throws SQLException, ClassNotFoundException {
        if(updateCompromisso == null){
            updateCompromisso = Conectar.open().prepareStatement(updateCompromissoSQL);
        }
        
//      oridade = ?, data = ?, hora = ?, obs = ?, idEndereco = ? where idCompromisso = ?";
                
       updateCompromisso.setString(1, con.getStatus());
       updateCompromisso.setString(2, con.getPrioridade());
       updateCompromisso.setDate(3, con.getData());
       updateCompromisso.setString(4, con.getHora() );
       updateCompromisso.setString(5, con.getObs());
       updateCompromisso.setInt(6, con.getEndereco().getId());
       updateCompromisso.setInt(7, con.getId());
       
       updateCompromisso.executeUpdate();
    }

    public static List<Compromisso> preencherCompromissos() throws ClassNotFoundException, SQLException {
   ArrayList<Compromisso> compromisso2 = new ArrayList<Compromisso>();

        if (buscarCompromisso == null) {
            buscarCompromisso = Conectar.open().prepareStatement(buscarCompromissoSQL);
        }

        ResultSet rs = buscarCompromisso.executeQuery();

        while (rs.next()) {
            Compromisso compromisso;
            compromisso = new Compromisso(rs.getString(2), rs.getString(3), rs.getDate(4), rs.getString(5), buscarEndereco(rs.getInt(6)), rs.getString(7));
            compromisso.setId(rs.getInt(1));
            compromisso2.add(compromisso);
        }

        return compromisso2;
    }
    
}
