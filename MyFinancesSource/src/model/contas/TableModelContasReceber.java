package model.contas;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.swing.table.AbstractTableModel;
import model.Formatar;
import view.contas.JanCadContaReceber;
import view.contas.JanContaReceber;


public class TableModelContasReceber extends AbstractTableModel {
    
    private static final long serialVersionUID = 1L;
    private List<ContaReceber> linhas;
    private List<ContaReceber> filtrados;
    private String[] colunas = new String[]{
          "ID","Cliente","Data","Vencimento","Observação","Valor","Recebido"};
    public static final int A_RECEBER = 0;
    public static final int RECEBIDO = 1;
    
        public List<ContaReceber> getContas() {
        return linhas;
    }
        
     public double somar(int tipo) {
        double totalReceber = 0;
        double totalRecebido = 0;


        for (ContaReceber c : filtrados) {
            if (!c.isRecebido()) {
                totalReceber += c.getValor();
            } else {
                totalRecebido += c.getValor();
            }
        }

        if (tipo == TableModelContasReceber.A_RECEBER) {
            return totalReceber;
        }

        return totalRecebido;

    }
         
    public void limparFiltrados(){
        filtrados.clear();
        fireTableDataChanged();
    }
    
    public void AdicionarAosFiltrados(ContaReceber c){
        filtrados.add(c);
        fireTableDataChanged();
    }
           
    public TableModelContasReceber() {
        linhas = new ArrayList<ContaReceber>();
        filtrados = new ArrayList<ContaReceber>();
    }

    public TableModelContasReceber(List<ContaReceber> listaDeContaReceber) {
        linhas = new ArrayList<ContaReceber>(listaDeContaReceber);
          filtrados = new ArrayList<ContaReceber>();
        filtrar("");
    }
        
    
   public void filtrarData(Date dataInicial, Date dataFinal) {
        filtrados.clear();

        for (ContaReceber atual : linhas) {

            try {
                if ((atual.getVencimento().after(dataInicial) || Formatar.formatarData(atual.getVencimento()).equals(Formatar.formatarData(dataInicial))) && (atual.getVencimento().before(dataFinal) || Formatar.formatarData(atual.getVencimento()).equals(Formatar.formatarData(dataFinal)))) {
                    filtrados.add(atual);
                }
            } catch (Exception e) {
            }
        }

        
        fireTableDataChanged();
        JanContaReceber.setarValoresReceberRecebido();
    }
    
   //Nome-Cliente
    public void filtrar(String pesquisando) {
        filtrados.clear();
        if (pesquisando == null) {
            pesquisando = "";
        }

        pesquisando = pesquisando.toLowerCase();

        for (ContaReceber atual : linhas) {
            if (atual.getParceiro().isFisica()) {
                if (pesquisando.equals("")
                        || atual.getParceiro().getNome().toLowerCase().contains(pesquisando)) {
                    filtrados.add(atual);
                }
            } else {
                if (pesquisando.equals("")
                        || atual.getParceiro().getRazaoSocial().toLowerCase().contains(pesquisando)) {
                    filtrados.add(atual);
                }
            }

        }

        fireTableDataChanged();
        JanContaReceber.setarValoresReceberRecebido();
    }

    public void filtrarObs(String pesquisando) {
        filtrados.clear();
        if (pesquisando == null) {
            pesquisando = "";
        }

        pesquisando = pesquisando.toLowerCase();

        for (ContaReceber atual : linhas) {
            if (pesquisando.equals("")
                    || atual.getObs().toLowerCase().contains(pesquisando)) {
                filtrados.add(atual);
            }
        }

        fireTableDataChanged();
        JanContaReceber.setarValoresReceberRecebido();
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
        ContaReceber ContaReceber = filtrados.get(rowIndex);


        switch (columnIndex) {
            case 0:
            return ContaReceber.getId();
            case 1:
                if (ContaReceber.getParceiro().isFisica()) {
                    return ContaReceber.getParceiro().getNome();
                }
                return ContaReceber.getParceiro().getRazaoSocial();
            case 2:
                return Formatar.formatarData(ContaReceber.getData());

            case 3:
                return Formatar.formatarData(ContaReceber.getVencimento());
            case 4:
                return ContaReceber.getObs();
            case 5:
                return Formatar.formatarNumero(ContaReceber.getValor());
            case 6:
                if(ContaReceber.isRecebido())
                    return "SIM";
                return "NÃO";

            default:
                throw new IndexOutOfBoundsException("columnIndex out of bounds");
        }
    }

    @Override
    public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
        //nao preciso implementar!
    }

    ;

    public void setValueAt(ContaReceber aValue, int rowIndex) {
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

    public ContaReceber getContaReceber(int indiceLinha) {
        return filtrados.get(indiceLinha);
    }

    public void addContaReceber(ContaReceber m) {

        linhas.add(m);


        int ultimoIndice = getRowCount() - 1;

        fireTableRowsInserted(ultimoIndice, ultimoIndice);
        filtrar("");
    }

    public void removeContaReceber(ContaReceber c) {
        for (int i = 0; i < linhas.size(); i++) {
            if (linhas.get(i).getId() == c.getId()) {
                linhas.remove(i);
                break;
            }
        }

        fireTableDataChanged();
        filtrar("");
    }

    public void addListaDeContaReceber(List<ContaReceber> ContaReceber) {


        int tamanhoAntigo = getRowCount();

        linhas.addAll(ContaReceber);

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
