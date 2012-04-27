package model.contas;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.swing.table.AbstractTableModel;
import model.Formatar;
import view.contas.JanFluxoConta;
import view.contas.JanHistoricoPadrao;
import view.contas.JanLancamento;
import view.contas.JanPlanoContas;


public class TableModelLancamento extends AbstractTableModel {

    private static final long serialVersionUID = 1L;
    private List<Lancamento> linhas;
    private List<Lancamento> filtrados;
    private String[] colunas = new String[]{
        "Data", "Historico Padrão", "Tipo","Fonte/Destino","Valor"};
    public String conta;
   
   
    public TableModelLancamento(String conta) {
        linhas = new ArrayList<Lancamento>();
        filtrados = new ArrayList<Lancamento>();
        this.conta = conta;
    }

    public TableModelLancamento(List<Lancamento> listaDeLancamento,String conta) {
        linhas = new ArrayList<Lancamento>(listaDeLancamento);
          filtrados = new ArrayList<Lancamento>();
        filtrar("");
        this.conta = conta;
    }

        
        
    public void filtrar(String pesquisando) {
        filtrados.clear();
        if (pesquisando == null) {
            pesquisando = "";
        }

        pesquisando = pesquisando.toLowerCase();

        for (Lancamento atual : linhas) {
                    if (pesquisando.equals("")) {
                        filtrados.add(atual);
                    }
        }

        fireTableDataChanged();
                JanFluxoConta.setarValores();
    }

         public void filtrarData(Date dataInicial, Date dataFinal) {
        filtrados.clear();

        for (Lancamento atual : linhas) {
            try {
                if ((atual.getDataLancamento().after(dataInicial) || Formatar.formatarData(atual.getDataLancamento()).equals(Formatar.formatarData(dataInicial))) && (atual.getDataLancamento().before(dataFinal) || Formatar.formatarData(atual.getDataLancamento()).equals(Formatar.formatarData(dataFinal)))) {
                    filtrados.add(atual);
                }
            } catch (Exception e) {
            }
        }

        fireTableDataChanged();
        JanFluxoConta.setarValores();
    }
    

    @Override
    public int getColumnCount() {
        return colunas.length;
    }

    @Override
    public int getRowCount() {
        return filtrados.size();
    }

    @Override
    public String getColumnName(int columnIndex) {
        return colunas[columnIndex];
    }

    ;

    @Override
    public Class<?> getColumnClass(int columnIndex) {
        return String.class;
    }

    ;


    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Lancamento Lancamento = filtrados.get(rowIndex);


        switch (columnIndex) {
            case 0:
                     return Formatar.formatarData(Lancamento.getDataLancamento());
                     

            case 1:

                    return JanHistoricoPadrao.modelo.getHistoricoPadraoId(Lancamento.getIdHistoricoPadrao()).getDescricao();


            case 2:
                if (Lancamento.getIdContaCredito().equals(conta))
                    return "Credito";
                return "Debito";
            case 3:
                if (Lancamento.getIdContaCredito().equals(conta))
                    return JanPlanoContas.modelo.getPlanoContas(Lancamento.getIdContaDebito()).getDescricao()+" - "+Formatar.formatPlanoContas(Lancamento.getIdContaDebito());
                return JanPlanoContas.modelo.getPlanoContas(Lancamento.getIdContaCredito()).getDescricao()+" - "+Formatar.formatPlanoContas(Lancamento.getIdContaCredito());
            case 4:
                return Formatar.formatarNumero(Lancamento.getValor());


            default:
                throw new IndexOutOfBoundsException("columnIndex out of bounds");
        }
    }

    @Override
    public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
        //nao preciso implementar!
    }

    ;

    public void setValueAt(Lancamento aValue, int rowIndex) {
        //ta certo.. é do filtrados mesmo... OBJETO SAO REFERENCIAS DE MEMORIA...
        //SE ATUALIZAR ESTE, ATUALIZA O OUTRO DA OUTRA LISTA...
        filtrados.set(rowIndex, aValue);

        fireTableRowsUpdated(rowIndex, rowIndex);
        filtrar("");
    }

    ;


    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        return false;
    }

    public Lancamento getLancamento(int indiceLinha) {
        return filtrados.get(indiceLinha);
    }
   
         
    
    public void addLancamento(Lancamento m) {

        linhas.add(m);


        int ultimoIndice = getRowCount() - 1;

        fireTableRowsInserted(ultimoIndice, ultimoIndice);
        filtrar("");
    }


    public void addListaDeLancamento(List<Lancamento> Lancamento) {
        int tamanhoAntigo = getRowCount();

        linhas.addAll(Lancamento);

        fireTableRowsInserted(tamanhoAntigo, getRowCount() - 1);

    }

    public void limpar() {
        linhas.clear();


        fireTableDataChanged();
    }

    public boolean isEmpty() {
        return linhas.isEmpty();
    }

    public double getTotal(String tipo) {
        double totalCred = 0;
        double totalDeb  = 0;
        double v;

        for (Lancamento lan : filtrados) {
            v = lan.getValor();
            if (tipo.equals("Credito")) {
                if (lan.idContaCredito.equals(conta)) {
                    totalCred += v;
                }
            } else {
                if (lan.idContaDebito.equals(conta)) {
                    totalDeb += v;
                }
            }
        }

        if (tipo.equals("Credito")) {
            return totalCred;
        }
        return totalDeb;
    }




}
