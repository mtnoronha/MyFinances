package model.parceiro;


import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;
import model.Formatar;
import model.parceiro.Compromisso;


public class TableModelCompromisso extends AbstractTableModel {


    private static final long serialVersionUID = 1L;
    private List<Compromisso> linhas;
    private List<Compromisso> filtrados;
    private String[] colunas = new String[]{
        "Prioridade","Status","Data","Hora","Endereço","Observação"};

    public TableModelCompromisso() {
        linhas = new ArrayList<Compromisso>();
        filtrados = new ArrayList<Compromisso>();
        filtrar("");

    }

    public TableModelCompromisso(List<Compromisso> listaDeCompromisso) {
        linhas = new ArrayList<Compromisso>(listaDeCompromisso);
        filtrados = new ArrayList<Compromisso>();
        filtrar("");
    }
    
        public void limparFiltrados(){
        filtrados.clear();
         fireTableDataChanged();
    }
    
    public void AdicionarAosFiltrados(Compromisso s){
        filtrados.add(s);
         fireTableDataChanged();
    }

    
    public void filtrar(String pesquisando) {
        filtrados.clear();
        if (pesquisando == null) {
            pesquisando = "";
        }

        pesquisando = pesquisando.toLowerCase();

        for (Compromisso atual : linhas) {
            
                if (pesquisando.equals("")
                        || atual.getPrioridade().toLowerCase().contains(pesquisando)) {
                    filtrados.add(atual);
                }
            

        }

        fireTableDataChanged();
    }

    public void filtrarStatus(String pesquisando) {
        filtrados.clear();
        if (pesquisando == null) {
            pesquisando = "";
        }

        pesquisando = pesquisando.toLowerCase();

        for (Compromisso atual : linhas) {
            
                if (pesquisando.equals("")
                        || atual.getStatus().toLowerCase().contains(pesquisando)) {
                    filtrados.add(atual);
                }
            

        }

        fireTableDataChanged();
    }

       public void filtrarObs(String pesquisando) {
        filtrados.clear();
        if (pesquisando == null) {
            pesquisando = "";
        }

        pesquisando = pesquisando.toLowerCase();

        for (Compromisso atual : linhas) {
            
                if (pesquisando.equals("")
                        || atual.getObs().toLowerCase().contains(pesquisando)) {
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
        Compromisso Compromisso = filtrados.get(rowIndex);

//        "Prioridade","Status","Data","Hora","Endereço","Observação"};
        
        switch (columnIndex) {
            case 0: return Compromisso.getPrioridade();
            case 1: return Compromisso.getStatus();
            case 2: return Formatar.formatarData(Compromisso.getData());
            case 3: return Compromisso.getHora();
            case 4: return Compromisso.getEndereco().getTipoEndereco() + " Bairro: " + Compromisso.getEndereco().getBairro() + " Rua: " + Compromisso.getEndereco().getLogradouro() + " Numero: " + Compromisso.getEndereco().getNumero();
            case 5: return Compromisso.getObs();
               
            default:
                throw new IndexOutOfBoundsException("columnIndex out of bounds");
        }
    }

    @Override
    public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
        //nao preciso implementar!
    }

    ;

    public void setValueAt(Compromisso aValue, int rowIndex) {
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

    public Compromisso getCompromisso(int indiceLinha) {
        return filtrados.get(indiceLinha);
    }

    public void addCompromisso(Compromisso m) {

        linhas.add(m);


        int ultimoIndice = getRowCount() - 1;

        fireTableRowsInserted(ultimoIndice, ultimoIndice);
        filtrar("");
    }

    public void removeCompromisso(Compromisso c) {
        for (int i = 0; i < linhas.size(); i++) {
            if (linhas.get(i).getId() == c.getId()) {
                linhas.remove(i);
                break;
            }
        }

        fireTableDataChanged();
        filtrar("");
    }

    public void addListaDeCompromisso(List<Compromisso> Compromisso) {


        int tamanhoAntigo = getRowCount();

        linhas.addAll(Compromisso);

        fireTableRowsInserted(tamanhoAntigo, getRowCount() - 1);

    }

    public void limpar() {
        linhas.clear();


        fireTableDataChanged();
    }

    public boolean isEmpty() {
        return linhas.isEmpty();
    }

    public List<Compromisso> getComp() {
        return linhas;
    }



    
}
