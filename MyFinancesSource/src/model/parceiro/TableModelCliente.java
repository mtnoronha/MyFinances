package model.parceiro;

import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;


public class TableModelCliente extends AbstractTableModel {

    private static final long serialVersionUID = 1L;
    private List<ParceiroComercial> linhas;
    private List<ParceiroComercial> filtrados;
    private String[] colunas = new String[]{
        "Nome", "CPF", "RG"};

    public TableModelCliente() {
        linhas = new ArrayList<ParceiroComercial>();
        filtrados = new ArrayList<ParceiroComercial>();
        filtrar("");
    }

    public TableModelCliente(List<ParceiroComercial> listaDeParceiroComercial) {
        linhas = new ArrayList<ParceiroComercial>(listaDeParceiroComercial);
    }

    public void filtrar(String pesquisando) {
        filtrados.clear();
        if (pesquisando == null) {
            pesquisando = "";
        }

        pesquisando = pesquisando.toLowerCase();

        for (ParceiroComercial atual : linhas) {
            if (pesquisando.equals("")
                    || atual.getNome().toLowerCase().contains(pesquisando)) {
                filtrados.add(atual);
            }

        }

        fireTableDataChanged();
    }

     public void filtrarCPF(String pesquisando) {
        filtrados.clear();
        if (pesquisando == null) {
            pesquisando = "";
        }

        pesquisando = pesquisando.toLowerCase();

        for (ParceiroComercial atual : linhas) {
            if (pesquisando.equals("")
                    || atual.getCpf().toLowerCase().contains(pesquisando)) {
                filtrados.add(atual);
            }

        }

        fireTableDataChanged();
    }
     
      public void filtrarRG(String pesquisando) {
        filtrados.clear();
        if (pesquisando == null) {
            pesquisando = "";
        }

        pesquisando = pesquisando.toLowerCase();

        for (ParceiroComercial atual : linhas) {
            if (pesquisando.equals("")
                    || atual.getRg().toLowerCase().contains(pesquisando)) {
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
        ParceiroComercial ParceiroComercial = filtrados.get(rowIndex);


        switch (columnIndex) {
            case 0:
                if (ParceiroComercial.isFisica()) {
                    return ParceiroComercial.getNome();
                }
                return ParceiroComercial.getRazaoSocial();            case 1:
                return ParceiroComercial.getCpf();
            case 2:
                return ParceiroComercial.getRg();

            default:
                throw new IndexOutOfBoundsException("columnIndex out of bounds");
        }
    }

    @Override
    public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
        //nao preciso implementar!
    }

    ;

    public void setValueAt(ParceiroComercial aValue, int rowIndex) {
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

    public ParceiroComercial getParceiroComercial(int indiceLinha) {
        return filtrados.get(indiceLinha);
    }

    public void addParceiroComercial(ParceiroComercial m) {

        linhas.add(m);


        int ultimoIndice = getRowCount() - 1;
        
        fireTableRowsInserted(ultimoIndice, ultimoIndice);
        filtrar("");
    }
    
    
    public void removeParceiroComercial(ParceiroComercial c) {
        for (int i = 0; i < linhas.size(); i++) {
            if (linhas.get(i).getId() == c.getId()) {
                linhas.remove(i);
                break;
            }
        }

        fireTableDataChanged();
        filtrar("");
    }

    public void addListaDeParceiroComercial(List<ParceiroComercial> ParceiroComercial) {


        int tamanhoAntigo = getRowCount();

        linhas.addAll(ParceiroComercial);

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
