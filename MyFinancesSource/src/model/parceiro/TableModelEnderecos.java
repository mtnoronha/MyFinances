package model.parceiro;

import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;
import model.parceiro.Endereco;

public class TableModelEnderecos extends AbstractTableModel {

    private static final long serialVersionUID = 1L;
    private List<Endereco> linhas;
    private List<Endereco> filtrados;
    private String[] colunas = new String[]{
        "Tipo","CEP","Estado","Cidade","Bairro","Logradouro","Numero","Complemento"};

    public TableModelEnderecos() {
        linhas = new ArrayList<Endereco>();
        filtrados = new ArrayList<Endereco>();
        filtrar("");
    }

    public TableModelEnderecos(List<Endereco> listaDeEndereco) {
        linhas = new ArrayList<Endereco>(listaDeEndereco);
        filtrados = new ArrayList<Endereco>();
        filtrar("");
    }

    public void filtrar(String pesquisando) {
        filtrados.clear();
        if (pesquisando == null) {
            pesquisando = "";
        }

        pesquisando = pesquisando.toLowerCase();

        for (Endereco atual : linhas) {
            
                if (pesquisando.equals("")
                        || atual.getTipoEndereco().toLowerCase().contains(pesquisando)) {
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
        Endereco Endereco = filtrados.get(rowIndex);


        switch (columnIndex) {
            case 0: return Endereco.getTipoEndereco();
            case 1: return Endereco.getCep();
            case 2: return Endereco.getEstado();
            case 3: return Endereco.getCidade();
            case 4: return Endereco.getBairro();
            case 5: return Endereco.getLogradouro();
            case 7: return Endereco.getComplemento();
            case 6: return Endereco.getNumero();
                
            default:
                throw new IndexOutOfBoundsException("columnIndex out of bounds");
        }
    }

    @Override
    public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
        //nao preciso implementar!
    }

    ;

    public void setValueAt(Endereco aValue, int rowIndex) {
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

    public Endereco getEndereco(int indiceLinha) {
        return filtrados.get(indiceLinha);
    }

    public void addEndereco(Endereco m) {

        linhas.add(m);


        int ultimoIndice = getRowCount() - 1;

        fireTableRowsInserted(ultimoIndice, ultimoIndice);
        filtrar("");
    }

    public void removeEndereco(Endereco c) {
        for (int i = 0; i < linhas.size(); i++) {
            if (linhas.get(i).getId() == c.getId()) {
                linhas.remove(i);
                break;
            }
        }

        fireTableDataChanged();
        filtrar("");
    }

    public void addListaDeEndereco(List<Endereco> Endereco) {


        int tamanhoAntigo = getRowCount();

        linhas.addAll(Endereco);

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

