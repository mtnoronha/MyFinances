
package model.contas;

import java.util.AbstractList;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;
import model.contas.HistoricoPadrao;

public class TableModelHistoricoPadrao extends AbstractTableModel {

    private static final long serialVersionUID = 1L;
    private List<HistoricoPadrao> linhas;
    private List<HistoricoPadrao> filtrados;
    private String[] colunas = new String[]{
        "ID", "Descrição"};

    public TableModelHistoricoPadrao() {
        linhas = new ArrayList<HistoricoPadrao>();
        filtrados = new ArrayList<HistoricoPadrao>();
    }

    public TableModelHistoricoPadrao(List<HistoricoPadrao> listaDeHistoricoPadrao) {       
        filtrados = new ArrayList<HistoricoPadrao>();
        if (listaDeHistoricoPadrao == null) {
            linhas = new ArrayList<HistoricoPadrao>();
        } else {
            linhas = new ArrayList<HistoricoPadrao>(listaDeHistoricoPadrao);
        }
        filtrar("");
    }

    public void filtrar(String pesquisando) {
        filtrados.clear();
        if (pesquisando == null) {
            pesquisando = "";
        }

        pesquisando = pesquisando.toLowerCase();

        for (HistoricoPadrao atual : linhas) {
            if ((pesquisando.equals("")
                    || atual.getDescricao().toLowerCase().contains(pesquisando)) ) {
                filtrados.add(atual);
            }

        }

        fireTableDataChanged();
    }
    
    public HistoricoPadrao getHistoricoPadraoId(int id){
        HistoricoPadrao achei = null;
        
        for(HistoricoPadrao a : linhas){
            if(a.getId() == id){
                achei = a;
                break;
            }
        }
        return achei;
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
        HistoricoPadrao HistoricoPadrao = filtrados.get(rowIndex);


        switch (columnIndex) {
            case 0:
                return HistoricoPadrao.getId();
            case 1:
                return HistoricoPadrao.getDescricao();
 
            default:
                throw new IndexOutOfBoundsException("columnIndex out of bounds");
        }
    }

    @Override
    public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
        //nao preciso implementar!
    }

    ;

    public void setValueAt(HistoricoPadrao aValue, int rowIndex) {
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

    
    public HistoricoPadrao getHistoricoPadrao(int indiceLinha) {
        return filtrados.get(indiceLinha);
    }

    public void addHistoricoPadrao(HistoricoPadrao m) {

        linhas.add(m);


        int ultimoIndice = getRowCount() - 1;
        
        fireTableRowsInserted(ultimoIndice, ultimoIndice);
        filtrar("");
    }
    
    public HistoricoPadrao getHistoricoPadrao(String desc){
        HistoricoPadrao achei = null;
        
        for(HistoricoPadrao a : linhas){
            if(a.getDescricao().toLowerCase().equals(desc.toLowerCase())){
                achei = a;
                break;
            }
        }
        
        return achei;
    }

    public void addListaDeHistoricoPadrao(List<HistoricoPadrao> HistoricoPadrao) {


        int tamanhoAntigo = getRowCount();

        linhas.addAll(HistoricoPadrao);

        fireTableRowsInserted(tamanhoAntigo, getRowCount() - 1);

    }

    public void limpar() {
        linhas.clear();


        fireTableDataChanged();
    }

    public boolean isEmpty() {
        return linhas.isEmpty();
    }
    
    public int size(){
        return linhas.size();
    }
}

    

