package model.contas;


import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.swing.table.AbstractTableModel;
import model.Formatar;
import view.contas.JanContaPagar;


public class TableModelContasPagar extends AbstractTableModel {
    
    private static final long serialVersionUID = 1L;
    private List<ContaPagar> linhas;
    private List<ContaPagar> filtrados;
    private String[] colunas = new String[]{
          "ID","Cliente","Data","Vencimento","Observação","Valor","Pago"};
    public static final int A_PAGAR  = 0;
    public static final int PAGO  = 1;

    public List<ContaPagar> getContas() {
        return linhas;
    }

    
    public TableModelContasPagar() {
        linhas = new ArrayList<ContaPagar>();
        filtrados = new ArrayList<ContaPagar>();
    }

    public TableModelContasPagar(List<ContaPagar> listaDeContaPagar) {
        linhas = new ArrayList<ContaPagar>(listaDeContaPagar);
          filtrados = new ArrayList<ContaPagar>();
        filtrar("");
    }
        
    public void limparFiltrados(){
        filtrados.clear();
        fireTableDataChanged();
    }
    
    public void AdicionarAosFiltrados(ContaPagar c){
        filtrados.add(c);
        fireTableDataChanged();
    }
    
    public void filtrarData(Date dataInicial, Date dataFinal) {
        filtrados.clear();

        for (ContaPagar atual : linhas) {
            try {
                if ((atual.getVencimento().after(dataInicial) || Formatar.formatarData(atual.getVencimento()).equals(Formatar.formatarData(dataInicial))) && (atual.getVencimento().before(dataFinal) || Formatar.formatarData(atual.getVencimento()).equals(Formatar.formatarData(dataFinal)))) {
                    filtrados.add(atual);
                }
            } catch (Exception e) {
            }
        }

        fireTableDataChanged();
        JanContaPagar.setarValoresPagarPago();
    }
    
   //Nome-Cliente
    public void filtrar(String pesquisando) {
        filtrados.clear();
        if (pesquisando == null) {
            pesquisando = "";
        }

        pesquisando = pesquisando.toLowerCase();

        for (ContaPagar atual : linhas) {
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
        JanContaPagar.setarValoresPagarPago();
    }

    public double somar(int tipo){
        double totalPagar = 0;
        double totalPago = 0;
        

        for(ContaPagar c : filtrados){
            if(!c.isPago()){
                totalPagar+=c.getValor();
            }else{
                totalPago+=c.getValor();
            }
        }

        if (tipo == TableModelContasPagar.A_PAGAR) {
            return totalPagar;
        }

        return totalPago;
        
    }

    
    
    
    
    public void filtrarObs(String pesquisando) {
        filtrados.clear();
        if (pesquisando == null) {
            pesquisando = "";
        }

        pesquisando = pesquisando.toLowerCase();

        for (ContaPagar atual : linhas) {
            if (pesquisando.equals("")
                    || atual.getObs().toLowerCase().contains(pesquisando)) {
                filtrados.add(atual);
            }
        }

        fireTableDataChanged();
                JanContaPagar.setarValoresPagarPago();
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
        ContaPagar ContaPagar = filtrados.get(rowIndex);


        switch (columnIndex) {
            //          "ID","Cliente","Data","Vencimento","Observação","Valor","Pago"};
            case 0:
            return ContaPagar.getId();
            case 1:
                if (ContaPagar.getParceiro().isFisica()) {
                    return ContaPagar.getParceiro().getNome();
                }
                return ContaPagar.getParceiro().getRazaoSocial();
            case 2:
                return Formatar.formatarData(ContaPagar.getData());

            case 3:
                return Formatar.formatarData(ContaPagar.getVencimento());
            case 4:
                return ContaPagar.getObs();
            case 5:
                return Formatar.formatarNumero(ContaPagar.getValor());
            case 6:
                if(ContaPagar.isPago())
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

    public void setValueAt(ContaPagar aValue, int rowIndex) {
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

    public ContaPagar getContaPagar(int indiceLinha) {
        return filtrados.get(indiceLinha);
    }

    public void addContaPagar(ContaPagar m) {

        linhas.add(m);


        int ultimoIndice = getRowCount() - 1;

        fireTableRowsInserted(ultimoIndice, ultimoIndice);
        filtrar("");
    }

    public void removeContaPagar(ContaPagar c) {
        for (int i = 0; i < linhas.size(); i++) {
            if (linhas.get(i).getId() == c.getId()) {
                linhas.remove(i);
                break;
            }
        }

        fireTableDataChanged();
        filtrar("");
    }

    public void addListaDeContaPagar(List<ContaPagar> ContaPagar) {


        int tamanhoAntigo = getRowCount();

        linhas.addAll(ContaPagar);

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
