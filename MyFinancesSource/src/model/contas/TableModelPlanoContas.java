package model.contas;

import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;
import model.Formatar;


public class TableModelPlanoContas extends AbstractTableModel {

    private static final long serialVersionUID = 1L;
    private List<PlanoContas> linhas;
    private List<PlanoContas> filtrados;
    private String[] colunas = new String[]{
        "Cód. Reduz.", "Conta", "Descrição","Tipo"};
   
   
    public TableModelPlanoContas() {
        linhas = new ArrayList<PlanoContas>();
        filtrados = new ArrayList<PlanoContas>();
        filtrar("");
    }

    public TableModelPlanoContas(List<PlanoContas> listaDePlanoContas) {
        linhas = new ArrayList<PlanoContas>(listaDePlanoContas);
          filtrados = new ArrayList<PlanoContas>();
        filtrar("");
    }

        
        
    public void filtrar(String pesquisando) {
        filtrados.clear();
        if (pesquisando == null) {
            pesquisando = "";
        }

        pesquisando = pesquisando.toUpperCase();

        for (PlanoContas atual : linhas) {
                    if ((pesquisando.equals("")
                            || atual.getConta().contains(pesquisando))) {
                        filtrados.add(atual);
                    }
        }

        fireTableDataChanged();
    }

         public void filtrarDescricao(String pesquisando) {
        filtrados.clear();
        if (pesquisando == null) {
            pesquisando = "";
        }

        pesquisando = pesquisando.toUpperCase();

        for (PlanoContas atual : linhas) {
                    if ((pesquisando.equals("")
                            || atual.getDescricao().contains(pesquisando))) {
                        filtrados.add(atual);
                    }
        }

        fireTableDataChanged();
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
        PlanoContas PlanoContas = filtrados.get(rowIndex);


        switch (columnIndex) {
            case 0:
                     return PlanoContas.getCodigoReduzido();
                     

            case 1:

                    return Formatar.formatPlanoContas(PlanoContas.getConta());


            case 2:

                    return PlanoContas.getDescricao();
            case 3:
                return PlanoContas.getTipo();


            default:
                throw new IndexOutOfBoundsException("columnIndex out of bounds");
        }
    }

    @Override
    public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
        //nao preciso implementar!
    }

    ;

    public void setValueAt(PlanoContas aValue, int rowIndex) {
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

    public PlanoContas getPlanoContas(int indiceLinha) {
        return filtrados.get(indiceLinha);
    }
   
    public void filtrarDescricaoAnalitica(String pesquisando) {
               filtrados.clear();
        if (pesquisando == null) {
            pesquisando = "";
        }

        pesquisando = pesquisando.toLowerCase();

        for (PlanoContas atual : linhas) {

                    if ((pesquisando.equals("")
                            || atual.getDescricao().toLowerCase().contains(pesquisando)) && atual.getConta().length() == 12) {
                        filtrados.add(atual);
                    }

        }

        fireTableDataChanged();
    }
       
    public boolean existeNivelSuperior(String conta) {
        int digitos = conta.length();   
        
        switch (digitos) {
            case 1:
                return true;
            case 3:
                return (getPlanoContas(conta.substring(0, 1)) != null);
            case 5:
                return (getPlanoContas(conta.substring(0, 3)) != null);
            case 7:
                return (getPlanoContas(conta.substring(0, 5)) != null);
            case 12:
                return (getPlanoContas(conta.substring(0, 7)) != null);
            default:
                return true;
        }
    }
   
    public PlanoContas getPlanoContas(String text) {
        PlanoContas achei = null;
        for (PlanoContas a : linhas) {
            if (a.getConta().equals(text)) {
                achei = a;
                break;
            }

        }
        return achei;
    }
    
    
      
    
    public void addPlanoContas(PlanoContas m) {

        linhas.add(m);


        int ultimoIndice = getRowCount() - 1;

        fireTableRowsInserted(ultimoIndice, ultimoIndice);
        filtrar("");
    }


    public void addListaDePlanoContas(List<PlanoContas> PlanoContas) {
        int tamanhoAntigo = getRowCount();

        linhas.addAll(PlanoContas);

        fireTableRowsInserted(tamanhoAntigo, getRowCount() - 1);

    }

    public void limpar() {
        linhas.clear();


        fireTableDataChanged();
    }

    public boolean isEmpty() {
        return linhas.isEmpty();
    }




}
