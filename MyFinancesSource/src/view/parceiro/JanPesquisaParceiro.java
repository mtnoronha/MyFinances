package view.parceiro;

import view.controleAcesso.JanCadControleAcesso;
import view.contas.JanCadContaReceber;
import view.contas.JanCadContaPagar;
import model.parceiro.TableModelParceiros;

public class JanPesquisaParceiro extends javax.swing.JFrame {

    JanCadContaReceber janRec;
    JanCadContaPagar janPag;
    JanCadControleAcesso janCon;
    TableModelParceiros modelo;
    String tipo;
    

    public JanPesquisaParceiro(JanCadContaReceber aThis, String tipo) {
        super("..:: Pesquisar Parceiro ::..");
        initComponents();
        this.janRec = aThis;

        modelo = JanParceirosComerciais.modelo;
        tabelaCliente.setModel(modelo);

        setLocationRelativeTo(null);

        modelo.filtrar("", tipo);
        this.tipo = tipo;


    }

    public JanPesquisaParceiro(JanCadContaPagar aThis) {
        super("..:: Pesquisar Parceiro ::..");
        initComponents();
        this.janPag = aThis;

        modelo = JanParceirosComerciais.modelo;
        tabelaCliente.setModel(modelo);
        modelo.filtrar("", "Ambos");
        this.tipo = "Ambos";

        setLocationRelativeTo(null);

    }

      public JanPesquisaParceiro(JanCadControleAcesso jan, String tipo) {
        super("..:: Pesquisar Parceiro ::..");
        initComponents();
        this.janCon = jan;

        modelo = JanParceirosComerciais.modelo;
        tabelaCliente.setModel(modelo);

        setLocationRelativeTo(null);

        modelo.filtrar("", tipo);
        this.tipo = tipo;
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        painelPesquisarPor = new javax.swing.JPanel();
        rotPesquisarPor = new javax.swing.JLabel();
        campoPesq = new javax.swing.JComboBox();
        campoPesqPor = new javax.swing.JTextField();
        painelTabelaPesquisa = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabelaCliente = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        painelPesquisarPor.setBorder(javax.swing.BorderFactory.createTitledBorder("Pesquisar Parceiro"));

        rotPesquisarPor.setText("Pesquisar Por:");

        campoPesq.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Nome", "CPF" }));

        campoPesqPor.addCaretListener(new javax.swing.event.CaretListener() {
            public void caretUpdate(javax.swing.event.CaretEvent evt) {
                campoPesqPorCaretUpdate(evt);
            }
        });

        javax.swing.GroupLayout painelPesquisarPorLayout = new javax.swing.GroupLayout(painelPesquisarPor);
        painelPesquisarPor.setLayout(painelPesquisarPorLayout);
        painelPesquisarPorLayout.setHorizontalGroup(
            painelPesquisarPorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painelPesquisarPorLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(rotPesquisarPor)
                .addGap(18, 18, 18)
                .addComponent(campoPesq, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(campoPesqPor, javax.swing.GroupLayout.DEFAULT_SIZE, 360, Short.MAX_VALUE)
                .addContainerGap())
        );
        painelPesquisarPorLayout.setVerticalGroup(
            painelPesquisarPorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painelPesquisarPorLayout.createSequentialGroup()
                .addGroup(painelPesquisarPorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(rotPesquisarPor)
                    .addComponent(campoPesq, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(campoPesqPor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        painelTabelaPesquisa.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        tabelaCliente.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tabelaCliente.setToolTipText("Clique no Parceiro para escolhê-lo");
        tabelaCliente.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabelaClienteMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tabelaCliente);

        javax.swing.GroupLayout painelTabelaPesquisaLayout = new javax.swing.GroupLayout(painelTabelaPesquisa);
        painelTabelaPesquisa.setLayout(painelTabelaPesquisaLayout);
        painelTabelaPesquisaLayout.setHorizontalGroup(
            painelTabelaPesquisaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painelTabelaPesquisaLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 586, Short.MAX_VALUE)
                .addContainerGap())
        );
        painelTabelaPesquisaLayout.setVerticalGroup(
            painelTabelaPesquisaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painelTabelaPesquisaLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 166, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(painelTabelaPesquisa, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(painelPesquisarPor, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(painelPesquisarPor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(painelTabelaPesquisa, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tabelaClienteMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabelaClienteMouseClicked
        // TODO add your handling code here:
        if (janRec != null) {
            janRec.arrumarCliente(modelo.getParceiroComercial(tabelaCliente.getSelectedRow()));
            janRec.requestFocus();
            janRec.setEnabled(true);
            this.dispose();
        } else if (janPag != null){
            janPag.arrumarCliente(modelo.getParceiroComercial(tabelaCliente.getSelectedRow()));
            janPag.requestFocus();
            janPag.setEnabled(true);
            this.dispose();
        }else{
            janCon.arrumarFuncionario(modelo.getParceiroComercial(tabelaCliente.getSelectedRow()));
            janCon.requestFocus();
            janCon.setEnabled(true);
            this.dispose();
        }
    }//GEN-LAST:event_tabelaClienteMouseClicked

    private void campoPesqPorCaretUpdate(javax.swing.event.CaretEvent evt) {//GEN-FIRST:event_campoPesqPorCaretUpdate
        // TODO add your handling code here:
        if (campoPesq.getSelectedItem().equals("Nome")) {
            modelo.filtrar(campoPesqPor.getText(),tipo);
        }

    }//GEN-LAST:event_campoPesqPorCaretUpdate

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        // TODO add your handling code here:
        if (janRec != null) {
            janRec.requestFocus();
            janRec.setEnabled(true);
        } else if (janPag != null){
            janPag.requestFocus();
            janPag.setEnabled(true);
        }else{
            janCon.requestFocus();
            janCon.setEnabled(true);
        }
    }//GEN-LAST:event_formWindowClosing

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox campoPesq;
    private javax.swing.JTextField campoPesqPor;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JPanel painelPesquisarPor;
    private javax.swing.JPanel painelTabelaPesquisa;
    private javax.swing.JLabel rotPesquisarPor;
    private javax.swing.JTable tabelaCliente;
    // End of variables declaration//GEN-END:variables
}
