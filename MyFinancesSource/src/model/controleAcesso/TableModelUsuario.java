
package model.controleAcesso;

import java.util.AbstractList;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;
import model.controleAcesso.Usuario;

public class TableModelUsuario extends AbstractTableModel {

    private static final long serialVersionUID = 1L;
    private List<Usuario> linhas;
    private List<Usuario> filtrados;
    private String[] colunas = new String[]{
        "ID do Funcionário", "Login"};

    public TableModelUsuario() {
        linhas = new ArrayList<Usuario>();
        filtrados = new ArrayList<Usuario>();
        filtrar("");
    }

    public TableModelUsuario(List<Usuario> listaDeUsuario) {       
        filtrados = new ArrayList<Usuario>();
        if (listaDeUsuario == null) {
            linhas = new ArrayList<Usuario>();
        } else {
            linhas = new ArrayList<Usuario>(listaDeUsuario);
        }
        filtrar("");
    }

    public void filtrar(String pesquisando) {
        filtrados.clear();
        if (pesquisando == null) {
            pesquisando = "";
        }

        pesquisando = pesquisando.toLowerCase();

        for (Usuario atual : linhas) {
            if ((pesquisando.equals("")
                    || atual.getLogin().toLowerCase().contains(pesquisando)) && atual.isDeletado() == false) {
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
        Usuario Usuario = filtrados.get(rowIndex);


        switch (columnIndex) {
            case 0:
                return Usuario.getIdParceiro();
            case 1:
                return Usuario.getLogin();
 
            default:
                throw new IndexOutOfBoundsException("columnIndex out of bounds");
        }
    }

    @Override
    public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
        //nao preciso implementar!
    }

    ;

    public void setValueAt(Usuario aValue, int rowIndex) {
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

    public Usuario getusuarioId(int idParceiro){
        Usuario achei = null;
        
        for(Usuario a : linhas){
            if (a.getIdParceiro() == idParceiro){
                achei = a;
                break;
            }
        }
        
        return achei;
    }
    
    public Usuario getusuarioAutenticar(String u, String s){
        Usuario achei = null;
        
        for(Usuario a : linhas){
            if (a.getLogin().equals(u) && a.getSenha().equals(s)){
                achei = a;
                break;
            }
        }
        
        return achei;
    }
    
    public Usuario getUsuario(int indiceLinha) {
        return filtrados.get(indiceLinha);
    }

    public void addUsuario(Usuario m) {

        linhas.add(m);


        int ultimoIndice = getRowCount() - 1;
        
        fireTableRowsInserted(ultimoIndice, ultimoIndice);
        filtrar("");
    }
    
    
    public void removeUsuario(Usuario c) {
        for (int i = 0; i < linhas.size(); i++) {
            if (linhas.get(i).getIdParceiro() == c.getIdParceiro()) {
                linhas.remove(i);
                break;
            }
        }

        fireTableDataChanged();
        filtrar("");
    }

    public void addListaDeUsuario(List<Usuario> Usuario) {


        int tamanhoAntigo = getRowCount();

        linhas.addAll(Usuario);

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

    

