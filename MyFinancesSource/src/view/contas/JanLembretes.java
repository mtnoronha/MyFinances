
package view.contas;


import view.contas.JanCadContaReceber;
import view.contas.JanContaReceber;
import view.contas.JanCadContaPagar;
import view.contas.JanContaPagar;
import java.util.Date;
import model.contas.ContaPagar;
import model.contas.ContaReceber;
import model.Formatar;
import model.Mensagem;


public class JanLembretes extends javax.swing.JFrame {

    private static JanLembretes jan;
    private boolean alterar;
    
    private JanLembretes(boolean alterar) {
        super("..:: Lembretes ::..");
        initComponents();
        setLocationRelativeTo(null);
        tabelaContaPagar.setModel(JanContaPagar.getInstance().modelo);
        tabelaContaReceber.setModel(JanContaReceber.getInstance().modelo);
        this.alterar = alterar;
    }
    
    private static void arrumar(){

        Date hj = new Date();

        JanContaPagar.getInstance().modelo.limparFiltrados();
        for (ContaPagar c : JanContaPagar.getInstance().modelo.getContas()) {
            if (Formatar.formatarData(c.getVencimento()).equals(Formatar.formatarData(hj)) && c.isPago() == false) {
                JanContaPagar.getInstance().modelo.AdicionarAosFiltrados(c);
            }
        }

        JanContaReceber.getInstance().modelo.limparFiltrados();
        for (ContaReceber c : JanContaReceber.getInstance().modelo.getContas()) {
            if (Formatar.formatarData(c.getVencimento()).equals(Formatar.formatarData(hj)) && c.isRecebido() == false) {
                JanContaReceber.getInstance().modelo.AdicionarAosFiltrados(c);
            }
        }
    }
    
    public static JanLembretes getInstance(boolean alterar){
        if(jan == null){
            jan = new JanLembretes(alterar);
        }
        arrumar();
               
        return jan;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tabelaContaReceber = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        bFechar = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        tabelaContaPagar = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Contas à Receber"));

        tabelaContaReceber.setModel(new javax.swing.table.DefaultTableModel(
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
        tabelaContaReceber.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabelaContaReceberMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tabelaContaReceber);

        jLabel1.setText("Selecione a conta com dublo clique para modificar seu estatus");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 563, Short.MAX_VALUE)
                    .addComponent(jLabel1))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        bFechar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagem/fechar.png"))); // NOI18N
        bFechar.setText("Fechar");
        bFechar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bFecharActionPerformed(evt);
            }
        });

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Contas à Pagar"));

        tabelaContaPagar.setModel(new javax.swing.table.DefaultTableModel(
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
        tabelaContaPagar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabelaContaPagarMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(tabelaContaPagar);

        jLabel2.setText("Selecione a conta com dublo clique para modificar seu estatus");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 563, Short.MAX_VALUE)
                    .addComponent(jLabel2))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(bFechar))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(bFechar)
                .addContainerGap(12, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void bFecharActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bFecharActionPerformed
        // TODO add your handling code here:
        this.dispose();
    }//GEN-LAST:event_bFecharActionPerformed

    private void tabelaContaReceberMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabelaContaReceberMouseClicked
        // TODO add your handling code here:
        if(alterar){
        if (evt.getClickCount() == 2) {
            this.setEnabled(false);
            JanCadContaReceber jan2 = new JanCadContaReceber(JanContaReceber.getInstance().modelo.getContaReceber(tabelaContaReceber.getSelectedRow()), "Lembrete");
            jan2.setVisible(true);
        }
        }else{
            Mensagem.mensagemErro(this, "Você não tem permissão para editar Conta!");
        }
    }//GEN-LAST:event_tabelaContaReceberMouseClicked

    private void tabelaContaPagarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabelaContaPagarMouseClicked
        // TODO add your handling code here:
        if(alterar){
        if (evt.getClickCount() == 2) {
            this.setEnabled(false);
            JanCadContaPagar jan2 = new JanCadContaPagar(JanContaPagar.getInstance().modelo.getContaPagar(tabelaContaPagar.getSelectedRow()), "Lembrete");
            jan2.setVisible(true);
        }
                }else{
            Mensagem.mensagemErro(this, "Você não tem permissão para editar Conta!");
        }
    }//GEN-LAST:event_tabelaContaPagarMouseClicked

  
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bFechar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTable tabelaContaPagar;
    private javax.swing.JTable tabelaContaReceber;
    // End of variables declaration//GEN-END:variables
}
