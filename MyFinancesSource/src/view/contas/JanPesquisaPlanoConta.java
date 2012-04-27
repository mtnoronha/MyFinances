package view.contas;

import model.Mensagem;
import model.contas.TableModelPlanoContas;

public class JanPesquisaPlanoConta extends javax.swing.JFrame {

    JanCadContaPagar janPagar;
    JanCadContaReceber janReceber;
    TableModelPlanoContas modelo;
    String tipo;
    JanLancamento janLan;

    public JanPesquisaPlanoConta(JanCadContaPagar jan) {
        super("..:: Pesquisar Conta ::..");
        initComponents();
        setLocationRelativeTo(null);
        this.janPagar = jan;

        modelo = JanPlanoContas.modelo;
        tabelaPlano.setModel(modelo);
        modelo.filtrar("");
    }

    public JanPesquisaPlanoConta(JanCadContaReceber jan) {
        super("..:: Pesquisar Conta ::..");
        initComponents();
        setLocationRelativeTo(null);
        this.janReceber = jan;
        modelo = JanPlanoContas.modelo;
        tabelaPlano.setModel(modelo);
        modelo.filtrar("");
    }

    public JanPesquisaPlanoConta(JanLancamento jan, String t) {
        super("..:: Pesquisar Conta ::..");
        initComponents();
        setLocationRelativeTo(null);
        this.janLan = jan;
        tipo = t;
        modelo = JanPlanoContas.modelo;
        tabelaPlano.setModel(modelo);
        modelo.filtrar("");
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        painelPesquisarPor = new javax.swing.JPanel();
        campoPesqPor = new javax.swing.JTextField();
        painelTabelaPesquisa = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabelaPlano = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        painelPesquisarPor.setBorder(javax.swing.BorderFactory.createTitledBorder("Pesquisar Conta"));

        campoPesqPor.addCaretListener(new javax.swing.event.CaretListener() {
            public void caretUpdate(javax.swing.event.CaretEvent evt) {
                campoPesqPorCaretUpdate(evt);
            }
        });

        javax.swing.GroupLayout painelPesquisarPorLayout = new javax.swing.GroupLayout(painelPesquisarPor);
        painelPesquisarPor.setLayout(painelPesquisarPorLayout);
        painelPesquisarPorLayout.setHorizontalGroup(
            painelPesquisarPorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, painelPesquisarPorLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(campoPesqPor, javax.swing.GroupLayout.DEFAULT_SIZE, 544, Short.MAX_VALUE)
                .addContainerGap())
        );
        painelPesquisarPorLayout.setVerticalGroup(
            painelPesquisarPorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painelPesquisarPorLayout.createSequentialGroup()
                .addComponent(campoPesqPor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        painelTabelaPesquisa.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        tabelaPlano.setModel(new javax.swing.table.DefaultTableModel(
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
        tabelaPlano.setToolTipText("Clique no Endereço para escolhê-lo");
        tabelaPlano.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabelaPlanoMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tabelaPlano);

        javax.swing.GroupLayout painelTabelaPesquisaLayout = new javax.swing.GroupLayout(painelTabelaPesquisa);
        painelTabelaPesquisa.setLayout(painelTabelaPesquisaLayout);
        painelTabelaPesquisaLayout.setHorizontalGroup(
            painelTabelaPesquisaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painelTabelaPesquisaLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 568, Short.MAX_VALUE)
                .addContainerGap())
        );
        painelTabelaPesquisaLayout.setVerticalGroup(
            painelTabelaPesquisaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painelTabelaPesquisaLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 243, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(painelPesquisarPor, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(painelTabelaPesquisa, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(painelPesquisarPor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(painelTabelaPesquisa, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void campoPesqPorCaretUpdate(javax.swing.event.CaretEvent evt) {//GEN-FIRST:event_campoPesqPorCaretUpdate
        // TODO add your handling code here:
        modelo.filtrarDescricao(campoPesqPor.getText());
}//GEN-LAST:event_campoPesqPorCaretUpdate

    private void tabelaPlanoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabelaPlanoMouseClicked
        // TODO add your handling code here:
        if (modelo.getPlanoContas(tabelaPlano.getSelectedRow()).getConta().length() != 12) {
            Mensagem.mensagemErro(this, "Selecione uma conta analítica!");
        } else {
            if (tipo == null) {
                if (janPagar != null) {
                    janPagar.arrumarConta(modelo.getPlanoContas(tabelaPlano.getSelectedRow()));
                    janPagar.requestFocus();
                    janPagar.setEnabled(true);
                    this.dispose();
                } else {
                    janReceber.arrumarConta(modelo.getPlanoContas(tabelaPlano.getSelectedRow()));
                    janReceber.requestFocus();
                    janReceber.setEnabled(true);
                    this.dispose();
                }
            } else {
                if (tipo.equals("Deb")) {
                    janLan.arrumarContaD(modelo.getPlanoContas(tabelaPlano.getSelectedRow()));

                } else {
                    janLan.arrumarContaC(modelo.getPlanoContas(tabelaPlano.getSelectedRow()));
                }
                janLan.setEnabled(true);
                janLan.requestFocus();

                this.dispose();
            }
        }
}//GEN-LAST:event_tabelaPlanoMouseClicked

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        // TODO add your handling code here:
        if (tipo == null) {
            if (janPagar != null) {
                janPagar.requestFocus();
                janPagar.setEnabled(true);
                this.dispose();
            } else {
                janReceber.requestFocus();
                janReceber.setEnabled(true);
                this.dispose();
            }
        } else {
            janLan.setEnabled(true);
            janLan.requestFocus();

            this.dispose();
        }
    }//GEN-LAST:event_formWindowClosing
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField campoPesqPor;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JPanel painelPesquisarPor;
    private javax.swing.JPanel painelTabelaPesquisa;
    private javax.swing.JTable tabelaPlano;
    // End of variables declaration//GEN-END:variables
}
