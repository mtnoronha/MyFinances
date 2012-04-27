package Persistencia.contas;

import Persistencia.Conectar;
import java.sql.Statement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import model.contas.ContaPagar;
import model.contas.ContaParceiro;
import model.contas.ContaReceber;
import model.contas.HistoricoPadrao;
import model.contas.Lancamento;
import model.contas.PlanoContas;
import view.parceiro.JanParceirosComerciais;

public class ContasService {
          
    private static final String buscarContasPagarSQL = "select * from ContasPagar";
    private static PreparedStatement buscarContasPagar = null;
    private static final String buscarContasReceberSQL = "select * from ContasReceber";
    private static PreparedStatement buscarContasReceber = null;
    private static final String buscarHistoricoPadraoSQL = "select * from HistoricoPadrao";
    private static PreparedStatement buscarHistoricoPadrao = null;
    private static final String buscarPlanoContasSQL = "select * from PlanoContas order by Conta";
    private static PreparedStatement buscarPlanoContas = null;
    private static final String buscarLancamentoSQL = "select la.* from PlanoContas pc, lancamento la where pc.conta like ? and ((pc.conta=la.idcontaDebito) or (pc.conta=la.idcontaCredito)) order by dataLancamento";
    private static PreparedStatement buscarLancamento = null;
    
    private static final String inserirContaPagarSQL = "insert into ContasPagar values(default, ?, ? ,? ,?,?,?,?,?,?,?)";
    private static PreparedStatement inserirContaPagar = null;
    private static final String inserirContaReceberSQL = "insert into ContasReceber values(default, ?, ? ,? ,?,?,?,?,?,?,?)";
    private static PreparedStatement inserirContaReceber = null;
    private static final String inserirHistoricoPadraoSQL = "insert into HistoricoPadrao values (default,?)";
    private static PreparedStatement inserirHistoricoPadrao = null;
    private static final String inserirPlanoContasSQL = "insert into PlanoContas values (?,?,?,?)";
    private static PreparedStatement inserirPlanoContas = null;
    private static final String inserirLancamentoSQL = "insert into Lancamento values (default,?,?,?,?,?)";
    private static PreparedStatement inserirLancamento = null;

    private static final String updateContaReceberSQL = "update ContasReceber set recebido = ?, dataRecebimento = ? where idContaReceber = ?";
    private static PreparedStatement updateContaReceber = null;
    private static final String updateContaPagarSQL = "update ContasPagar set pago = ?, dataPagamento = ? where idContaPagar = ?";
    private static PreparedStatement updateContaPagar = null;
    private static final String updateHistoricoPadraoSQL = "update HistoricoPadrao set descricao = ? where idHistoricoPadrao = ?";
    private static PreparedStatement updateHistoricoPadrao = null;
    private static final String updatePlanoContasSQL = "update PlanoContas set CodigoReduzido = ?, Descricao = ?, Tipo = ? where Conta = ?";
    private static PreparedStatement updatePlanoContas = null;
       
    //contaParceiro
    private static PreparedStatement inserirContaParceiro = null;
    private static final String inserirContaParceiroSQL = "insert into ContaParceiro values (default,?,?,?)";    
    private static PreparedStatement buscarContaParceiro = null;
    private static final String buscarContaParceiroSQL = "select * from ContaParceiro where idParceiro = ?";
            
            
    //tabela configuracao
    private static final String selecionarNumSQL = "select proximo from configuracao where id = ?";
    private static PreparedStatement selecionarNum = null;
        
    private static final String updateConfiguracaoCliSQL = "update Configuracao set proximo = nextval('cliente') where id = ?";
    private static final String updateConfiguracaoFunSQL = "update Configuracao set proximo = nextval('funcionario') where id = ?";
    private static final String updateConfiguracaoForSQL = "update Configuracao set proximo = nextval('fornecedor') where id = ?";
    
    private static PreparedStatement updateConfiguracao = null;
    
    public static final int CLI = 1;
    public static final int FOR = 2;
    public static final int FUN = 3;
    
    public static void inserirContaParceiro(ContaParceiro c) throws ClassNotFoundException, SQLException{
        if(inserirContaParceiro == null){
            inserirContaParceiro = Conectar.open().prepareStatement(inserirContaParceiroSQL);
        }
        
        inserirContaParceiro.setInt(1, c.getIdParceiro());
        inserirContaParceiro.setString(2, c.getConta());
        inserirContaParceiro.setString(3, c.getTipoDaConta());
        
        inserirContaParceiro.executeUpdate();
        
    }
    
    public static ArrayList<ContaParceiro> getContaParceiro(int idParceiro) throws ClassNotFoundException, SQLException{
        ArrayList<ContaParceiro> contas = new ArrayList<ContaParceiro>();
        
        if(buscarContaParceiro == null){
            buscarContaParceiro = Conectar.open().prepareStatement(buscarContaParceiroSQL);
        }
        
        buscarContaParceiro.setInt(1, idParceiro);
        
        ResultSet rs = buscarContaParceiro.executeQuery();
        
        while(rs.next()){
            ContaParceiro c = new ContaParceiro(rs.getInt(2), rs.getString(3), rs.getString(4));
            contas.add(c);
        }
        
        return contas;
    }
  
    public static int selecionarNum(int tipo) throws ClassNotFoundException, SQLException{
        if(selecionarNum == null){
            selecionarNum = Conectar.open().prepareStatement(selecionarNumSQL);
        }
        
        selecionarNum.setInt(1, tipo);
        
        ResultSet rs = selecionarNum.executeQuery();
        atualizarConfiguracao(tipo);
        if(rs.next()){
        return rs.getInt(1);
        }
        return -1;
    }
    
    public static void atualizarConfiguracao(int tipo) throws ClassNotFoundException, SQLException{
        switch (tipo) {
            case CLI:
                            updateConfiguracao = Conectar.open().prepareStatement(updateConfiguracaoCliSQL);
                 break;
            case FUN:
                            updateConfiguracao = Conectar.open().prepareStatement(updateConfiguracaoFunSQL);
                 break;
            case FOR:
                            updateConfiguracao = Conectar.open().prepareStatement(updateConfiguracaoForSQL);
                 break;
        }

       updateConfiguracao.setInt(1, tipo);         
       
        
        updateConfiguracao.executeUpdate();
    }
    
    public static int inserirLancamento(Lancamento conta) throws ClassNotFoundException, SQLException {
        if (inserirLancamento == null) {
            inserirLancamento = Conectar.open().prepareStatement(inserirLancamentoSQL);
        }

        inserirLancamento.setInt(1, conta.getIdHistoricoPadrao());
        inserirLancamento.setString(2, conta.getIdContaCredito());
        inserirLancamento.setString(3, conta.getIdContaDebito());
        inserirLancamento.setDate(4, conta.getDataLancamento());
        inserirLancamento.setDouble(5, conta.getValor());

        inserirLancamento.executeUpdate();
        Statement stmt = Conectar.open().createStatement();
        ResultSet rs = stmt.executeQuery("select max(idLancamento) from Lancamento");
        int id = 0;

        if (rs.next()) {
            id = rs.getInt(1);
        }
        return id;

    }
    
    public static void atualizarContaReceber(ContaReceber c) throws ClassNotFoundException, SQLException {
        if(updateContaReceber == null){
            updateContaReceber = Conectar.open().prepareStatement(updateContaReceberSQL);
        }    
        
        updateContaReceber.setBoolean(1, c.isRecebido());
        updateContaReceber.setDate(2,c.getDataRecebimento());
        updateContaReceber.setInt(3, c.getId());
        
        updateContaReceber.executeUpdate();
    }
    
    public static void atualizarContaPagar(ContaPagar c) throws ClassNotFoundException, SQLException {
        if(updateContaPagar == null){
            updateContaPagar = Conectar.open().prepareStatement(updateContaPagarSQL);
        }    
        
        updateContaPagar.setBoolean(1, c.isPago());
        updateContaPagar.setDate(2, c.getDataPagamento());
        updateContaPagar.setInt(3, c.getId());
        
        updateContaPagar.executeUpdate();
    }
    
    public static void atualizarHistoricoPadrao(HistoricoPadrao hp) throws ClassNotFoundException, SQLException {
        if(updateHistoricoPadrao == null){
            updateHistoricoPadrao= Conectar.open().prepareStatement(updateHistoricoPadraoSQL);
        }    
        
        updateHistoricoPadrao.setString(1, hp.getDescricao());
        updateHistoricoPadrao.setInt(2, hp.getId());
        
        
        
        updateHistoricoPadrao.executeUpdate();
    }
    
    public static void atualizarPlanoContas(PlanoContas pp) throws ClassNotFoundException, SQLException {
        if(updatePlanoContas == null){
            updatePlanoContas= Conectar.open().prepareStatement(updatePlanoContasSQL);
        }    
        
        updatePlanoContas.setInt(1, pp.getCodigoReduzido());
        updatePlanoContas.setString(2, pp.getDescricao());
        updatePlanoContas.setString(3, pp.getTipo());
        updatePlanoContas.setString(4, pp.getConta());
        
        
        updatePlanoContas.executeUpdate();
    }
    
    public static ArrayList<ContaPagar> preencherContasPagar() throws ClassNotFoundException, SQLException {
        ArrayList<ContaPagar> orser = new ArrayList<ContaPagar>();

        if (buscarContasPagar == null) {
            buscarContasPagar = Conectar.open().prepareStatement(buscarContasPagarSQL);
        }

   

        ResultSet rs = buscarContasPagar.executeQuery();


        while (rs.next()) {
            ContaPagar ex = new ContaPagar(JanParceirosComerciais.getInstance().modelo.getParceiroComercialId(rs.getInt(2)), rs.getDate(3), rs.getDouble(4), rs.getString(5),rs.getDate(6), rs.getBoolean(7),rs.getDate(8),rs.getInt(9),rs.getString(10),rs.getString(11));
            ex.setId(rs.getInt(1));
            orser.add(ex);
        }
        return orser;
    }

    public static ArrayList<ContaReceber> preencherContasReceber() throws ClassNotFoundException, SQLException {
        ArrayList<ContaReceber> orser = new ArrayList<ContaReceber>();

        if (buscarContasReceber == null) {
            buscarContasReceber = Conectar.open().prepareStatement(buscarContasReceberSQL);
        }

        ResultSet rs = buscarContasReceber.executeQuery();


        while (rs.next()) {
            ContaReceber ex = new ContaReceber(JanParceirosComerciais.getInstance().modelo.getParceiroComercialId(rs.getInt(2)), rs.getDate(3), rs.getDouble(4), rs.getString(5), rs.getDate(6), rs.getBoolean(7),rs.getDate(8),rs.getInt(9),rs.getString(10),rs.getString(11));
            ex.setId(rs.getInt(1));
            orser.add(ex);
        }
        return orser;
    }
    
     public static ArrayList<Lancamento> preencherLancamento(String conta) throws ClassNotFoundException, SQLException {
        ArrayList<Lancamento> lanc = new ArrayList<Lancamento>();

        if (buscarLancamento == null) {
            buscarLancamento = Conectar.open().prepareStatement(buscarLancamentoSQL);
        }
        
        buscarLancamento.setString(1, conta);

        ResultSet rs = buscarLancamento.executeQuery();


        while (rs.next()) {
            Lancamento ex = new Lancamento(rs.getInt(2), rs.getString(3), rs.getString(4), rs.getDate(5), rs.getDouble(6));
             ex.setIdLancamento(rs.getInt(1));
            lanc.add(ex);
        }
        return lanc;
    }

        
    public static int inserirContaPagar(ContaPagar conta) throws ClassNotFoundException, SQLException {
        if (inserirContaPagar == null) {
            inserirContaPagar = Conectar.open().prepareStatement(inserirContaPagarSQL);
        }


        inserirContaPagar.setInt(1, conta.getParceiro().getId());
        inserirContaPagar.setDate(2, conta.getData());
        inserirContaPagar.setDouble(3, conta.getValor());
        inserirContaPagar.setString(4, conta.getObs());
        inserirContaPagar.setDate(5, conta.getVencimento());
        inserirContaPagar.setBoolean(6, conta.isPago());
        inserirContaPagar.setDate(7, conta.getDataPagamento());
        inserirContaPagar.setInt(8, conta.getIdHistoricoPadrao());
        inserirContaPagar.setString(9, conta.getContaCredito());
        inserirContaPagar.setString(10,conta.getContaDebito());

        inserirContaPagar.executeUpdate();
        Statement stmt = Conectar.open().createStatement();
        ResultSet rs = stmt.executeQuery("select max(idContaPagar) from ContasPagar");
        int id = 0;

        if (rs.next()) {
            id = rs.getInt(1);
        }
        return id;

    }

    public static int inserirContaReceber(ContaReceber conta) throws ClassNotFoundException, SQLException {
        if (inserirContaReceber == null) {
            inserirContaReceber = Conectar.open().prepareStatement(inserirContaReceberSQL);
        }


        inserirContaReceber.setInt(1, conta.getParceiro().getId());
        inserirContaReceber.setDate(2, conta.getData());
        inserirContaReceber.setDouble(3, conta.getValor());
        inserirContaReceber.setString(4, conta.getObs());
        inserirContaReceber.setDate(5, conta.getVencimento());
        inserirContaReceber.setBoolean(6, conta.isRecebido());
        inserirContaReceber.setDate(7, conta.getDataRecebimento());
        inserirContaReceber.setInt(8, conta.getIdHistoricoPadrao());
        inserirContaReceber.setString(9, conta.getContaCredito());
        inserirContaReceber.setString(10,conta.getContaDebito());

        inserirContaReceber.executeUpdate();
        Statement stmt = Conectar.open().createStatement();
        ResultSet rs = stmt.executeQuery("select max(idContaReceber) from ContasReceber");
        int id = 0;

        if (rs.next()) {
            id = rs.getInt(1);
        }
        return id;

    }
    
    public static int inserirHistoricoPadrao(HistoricoPadrao hp) throws ClassNotFoundException, SQLException {
        if (inserirHistoricoPadrao == null) {
            inserirHistoricoPadrao = Conectar.open().prepareStatement(inserirHistoricoPadraoSQL);
        }

        inserirHistoricoPadrao.setString(1, hp.getDescricao());
        
        inserirHistoricoPadrao.executeUpdate();
                Statement stmt = Conectar.open().createStatement();
        ResultSet rs = stmt.executeQuery("select max(idHistoricoPadrao) from HistoricoPadrao");
        int id = 0;

        if (rs.next()) {
            id = rs.getInt(1);
        }
        return id;

        

    }
    
    public static int inserirPlanoContas(PlanoContas pp) throws ClassNotFoundException, SQLException {
        if (inserirPlanoContas == null) {
            inserirPlanoContas = Conectar.open().prepareStatement(inserirPlanoContasSQL);
        }
    
        Statement stmt = Conectar.open().createStatement();
        ResultSet rs = stmt.executeQuery("select max(codigoReduzido) from PlanoContas");
        int id = 0;

        if (rs.next()) {
            id = rs.getInt(1);
        }
        
        id+=1;

        
        inserirPlanoContas.setString(1, pp.getConta());
        inserirPlanoContas.setInt(2, id);
        inserirPlanoContas.setString(3, pp.getDescricao());
        inserirPlanoContas.setString(4, pp.getTipo());

        inserirPlanoContas.executeUpdate();
        return id;
    }

    public static ArrayList<HistoricoPadrao> preencherHistoricoPadrao() throws ClassNotFoundException, SQLException {
        ArrayList<HistoricoPadrao> orser = new ArrayList<HistoricoPadrao>();

        if (buscarHistoricoPadrao == null) {
            buscarHistoricoPadrao = Conectar.open().prepareStatement(buscarHistoricoPadraoSQL);
        }

        ResultSet rs = buscarHistoricoPadrao.executeQuery();


        while (rs.next()) {
            HistoricoPadrao ex = new HistoricoPadrao(rs.getString(2));
            ex.setId(rs.getInt(1));
            orser.add(ex);
        }
        
        return orser;   
    }
    
        public static ArrayList<PlanoContas> preencherPlanoContas() throws ClassNotFoundException, SQLException {
        ArrayList<PlanoContas> orser = new ArrayList<PlanoContas>();

        if (buscarPlanoContas == null) {
            buscarPlanoContas = Conectar.open().prepareStatement(buscarPlanoContasSQL);
        }

        ResultSet rs = buscarPlanoContas.executeQuery();


        while (rs.next()) {
            PlanoContas ex = new PlanoContas(rs.getString(1), rs.getInt(2), rs.getString(3), rs.getString(4));
            orser.add(ex);
        }
        
        return orser;   
    }
}
