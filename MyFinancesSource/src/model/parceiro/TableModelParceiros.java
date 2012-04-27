package model.parceiro;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;
import model.Mensagem;


public class TableModelParceiros extends AbstractTableModel {

    private static final long serialVersionUID = 1L;
    private List<ParceiroComercial> linhas;
    private List<ParceiroComercial> filtrados;
    private String[] colunas = new String[]{
        "Nome / Razao", "CPF / CNPJ", "Tipo"};

    public void limparFiltrados(){
        filtrados.clear();
        fireTableDataChanged();
    }
    
    public void addAosFiltrados(ParceiroComercial c){
        filtrados.add(c);
        fireTableDataChanged();
    }

    public TableModelParceiros() {
        linhas = new ArrayList<ParceiroComercial>();
        filtrados = new ArrayList<ParceiroComercial>();
        filtrar("","All");
    }

    public TableModelParceiros(List<ParceiroComercial> listaDeParceiroComercial) {
        linhas = new ArrayList<ParceiroComercial>(listaDeParceiroComercial);
          filtrados = new ArrayList<ParceiroComercial>();
        filtrar("","All");
    }
    /*
    public void filtrarClientes() {
        filtrados.clear();
        for (ParceiroComercial atual : linhas) {
            if (atual.isCliente() && atual.isDeletado() == false) {
                filtrados.add(atual);
            }
        }

        fireTableDataChanged();
    }

        public void filtrarFuncionarios() {
        filtrados.clear();
        for (ParceiroComercial atual : linhas) {
            if (atual.isFuncionario() && atual.isDeletado() == false) {
                filtrados.add(atual);
            }
        }

        fireTableDataChanged();
    }
     
        
        public void filtrarFuncionariosFornecedores() {
        filtrados.clear();
        for (ParceiroComercial atual : linhas) {
            if ((atual.isFuncionario() || atual.isFornecedor()) && atual.isDeletado() == false) {
                filtrados.add(atual);
            }
        }

        fireTableDataChanged();
    }
     * 
     */
        
        
    public void filtrar(String pesquisando,String tipo) {
        filtrados.clear();
        if (pesquisando == null) {
            pesquisando = "";
        }

        pesquisando = pesquisando.toLowerCase();

        for (ParceiroComercial atual : linhas) {
            if (tipo.equals("Cliente")) {
                if (atual.isFisica()) {
                    if ((pesquisando.equals("")
                            || atual.getNome().toLowerCase().contains(pesquisando)) && atual.isDeletado() == false && atual.isCliente()) {
                        filtrados.add(atual);
                    }
                } else {
                    if ((pesquisando.equals("")
                            || atual.getRazaoSocial().toLowerCase().contains(pesquisando)) && atual.isDeletado() == false && atual.isCliente()) {
                        filtrados.add(atual);
                    }
                }
            } else if (tipo.equals("Funcionario")) {

                if (atual.isFisica()) {
                    if ((pesquisando.equals("")
                            || atual.getNome().toLowerCase().contains(pesquisando)) && atual.isDeletado() == false && atual.isFuncionario()) {
                        filtrados.add(atual);
                    }
                } else {
                    if ((pesquisando.equals("")
                            || atual.getRazaoSocial().toLowerCase().contains(pesquisando)) && atual.isDeletado() == false && atual.isFuncionario()) {
                        filtrados.add(atual);
                    }
                }


            } else if (tipo.equals("Ambos")){
                                if (atual.isFisica()) {
                    if ((pesquisando.equals("")
                            || atual.getNome().toLowerCase().contains(pesquisando)) && atual.isDeletado() == false && (atual.isFuncionario() || atual.isFornecedor())) {
                        filtrados.add(atual);
                    }
                } else {
                    if ((pesquisando.equals("")
                            || atual.getRazaoSocial().toLowerCase().contains(pesquisando)) && atual.isDeletado() == false && (atual.isFuncionario() || atual.isFornecedor())) {
                        filtrados.add(atual);
                    }
                }
            } else if(tipo.equals("All")){
                                                if (atual.isFisica()) {
                    if ((pesquisando.equals("")
                            || atual.getNome().toLowerCase().contains(pesquisando)) && atual.isDeletado() == false) {
                        filtrados.add(atual);
                    }
                } else {
                    if ((pesquisando.equals("")
                            || atual.getRazaoSocial().toLowerCase().contains(pesquisando)) && atual.isDeletado() == false) {
                        filtrados.add(atual);
                    }
                }
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

            if (atual.isFisica()) {
                if ((pesquisando.equals("")
                        || atual.getCpf().toLowerCase().contains(pesquisando)) && atual.isDeletado() == false) {
                    filtrados.add(atual);
                }

            } else {
                if ((pesquisando.equals("")
                        || atual.getCnpj().toLowerCase().contains(pesquisando)) && atual.isDeletado() == false) {
                    filtrados.add(atual);
                }

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
                return ParceiroComercial.getRazaoSocial();

            case 1:
                if (ParceiroComercial.isFisica()) {
                    return ParceiroComercial.getCpf();
                }
                return ParceiroComercial.getCnpj();


            case 2:
                if (ParceiroComercial.isCliente() && ParceiroComercial.isFornecedor() && ParceiroComercial.isFuncionario()) {
                    return "Cli - For - Fun";
                }
                if (ParceiroComercial.isCliente() && ParceiroComercial.isFornecedor() && !(ParceiroComercial.isFuncionario())) {
                    return "Cli - For";
                }
                if (ParceiroComercial.isCliente() && !(ParceiroComercial.isFornecedor()) && ParceiroComercial.isFuncionario()) {
                    return "Cli - Fun";
                }
                if (!(ParceiroComercial.isCliente()) && ParceiroComercial.isFornecedor() && ParceiroComercial.isFuncionario()) {
                    return "For - Fun";
                }
                if (ParceiroComercial.isCliente()) {
                    return "Cli";
                }
                if (ParceiroComercial.isFornecedor()) {
                    return "For";
                }
                if (ParceiroComercial.isFuncionario()) {
                    return "Fun";
                }


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
        filtrar("","All");
    }

    ;


    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        return false;
    }

    public ParceiroComercial getParceiroComercial(int indiceLinha) {
        return filtrados.get(indiceLinha);
    }
   
    public ParceiroComercial getParceiroComercialId(int id) {
        ParceiroComercial achei = null;
        for (ParceiroComercial a : linhas) {
            if (a.getId() == id) {
                achei = a;
                break;
            }

        }
        return achei;
    }
    
    public ParceiroComercial getParceiroCnpjRgCpf(ParceiroComercial antigo){
        ParceiroComercial novo = null;

        for (ParceiroComercial a : linhas) {
            try {
                if (((!a.getCnpj().equals("  .   .   /    -  ")) && a.getCnpj().equals(antigo.getCnpj()))) {
                    novo = a;
                    break;
                }
            } catch (NullPointerException e) {
            }

            try {
                if ((!a.getRg().equals("  -  .   .   ") && a.getRg().equals(antigo.getRg()))) {
                    novo = a;
                    break;
                }
            } catch (NullPointerException e) {
            }

            try {
                if ((!a.getCpf().equals("   .   .   -  ") && a.getCpf().equals(antigo.getCpf()))) {
                    novo = a;
                    break;
                }
            } catch (NullPointerException e) {
            }

        }

        return novo;
    }

    
    
    public void addParceiroComercial(ParceiroComercial m) {

        linhas.add(m);


        int ultimoIndice = getRowCount() - 1;

        fireTableRowsInserted(ultimoIndice, ultimoIndice);
        filtrar("","All");
    }

    public void removeParceiroComercial(ParceiroComercial c) {
        for (int i = 0; i < linhas.size(); i++) {
            if (linhas.get(i).getId() == c.getId()) {
                linhas.remove(i);
                break;
            }
        }

        fireTableDataChanged();
        filtrar("","All");
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
