package model.parceiro;

import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;
import model.parceiro.Contato;

public class TableModelContatos extends AbstractTableModel {

    private static final long serialVersionUID = 1L;
    private List<Contato> linhas;
    private List<Contato> filtrados;
    private String[] colunas = new String[]{
        "Nome"};

    public TableModelContatos() {
        linhas = new ArrayList<Contato>();
        filtrados = new ArrayList<Contato>();
        filtrar("");
    }

    public TableModelContatos(List<Contato> listaDeContato) {
        linhas = new ArrayList<Contato>(listaDeContato);
        filtrados = new ArrayList<Contato>();
        filtrar("");
    }

    public void filtrar(String pesquisando) {
        filtrados.clear();
        if (pesquisando == null) {
            pesquisando = "";
        }

        pesquisando = pesquisando.toLowerCase();

        for (Contato atual : linhas) {
            
                if (pesquisando.equals("")
                        || atual.getNome().toLowerCase().contains(pesquisando)) {
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
        Contato Contato = filtrados.get(rowIndex);


        switch (columnIndex) {
            case 0: return Contato.getNome();
                
            default:
                throw new IndexOutOfBoundsException("columnIndex out of bounds");
        }
    }

    @Override
    public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
        //nao preciso implementar!
    }

    ;

    public void setValueAt(Contato aValue, int rowIndex) {
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

    public Contato getContato(int indiceLinha) {
        return filtrados.get(indiceLinha);
    }

    public void addContato(Contato m) {

        linhas.add(m);


        int ultimoIndice = getRowCount() - 1;

        fireTableRowsInserted(ultimoIndice, ultimoIndice);
        filtrar("");
    }

    public void removeContato(Contato c) {
        for (int i = 0; i < linhas.size(); i++) {
            if (linhas.get(i).getId() == c.getId()) {
                linhas.remove(i);
                break;
            }
        }

        fireTableDataChanged();
        filtrar("");
    }

    public void addListaDeContato(List<Contato> Contato) {


        int tamanhoAntigo = getRowCount();

        linhas.addAll(Contato);

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
