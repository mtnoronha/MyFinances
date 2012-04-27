package view.contas;

import Persistencia.contas.ContasService;
import java.sql.SQLException;
import java.util.ArrayList;
import model.Mensagem;
import model.contas.PlanoContas;
import model.contas.TableModelPlanoContas;
import view.contas.JanFluxoConta;


public class JanPlanoContas extends javax.swing.JFrame {

    private static JanPlanoContas jan;
    public static TableModelPlanoContas modelo;
    
    
    private JanPlanoContas() {
        super("..:: Plano de Contas ::..");
        initComponents();
        setLocationRelativeTo(null);
                modelo = new TableModelPlanoContas();
 try {
            ArrayList<PlanoContas> lista = ContasService.preencherPlanoContas();
            
            modelo.addListaDePlanoContas(lista);
            modelo.filtrar("");

        } catch (ClassNotFoundException ex) {
            Mensagem.mensagemErroClassNotFound(this);
        } catch (SQLException ex) {
            Mensagem.mensagemErroSQLException(this);
            ex.printStackTrace();
        }
 
             tabelaPlanoContas.setModel(modelo);
    }
    
    public static JanPlanoContas getInstance(){
        if(jan == null){
            jan = new JanPlanoContas();
        }
        
        modelo.filtrar("");
        
        return jan;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tabelaPlanoContas = new javax.swing.JTable();
        jPanel2 = new javax.swing.JPanel();
        bNovo = new javax.swing.JButton();
        bAlterar = new javax.swing.JButton();
        bFechar = new javax.swing.JButton();
        bFluxo = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        tabelaPlanoContas.setModel(new javax.swing.table.DefaultTableModel(
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
        tabelaPlanoContas.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabelaPlanoContasMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tabelaPlanoContas);

        jPanel2.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        bNovo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagem/novo.png"))); // NOI18N
        bNovo.setText("Novo");
        bNovo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bNovoActionPerformed(evt);
            }
        });

        bAlterar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagem/editar.png"))); // NOI18N
        bAlterar.setText("Alterar");
        bAlterar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bAlterarActionPerformed(evt);
            }
        });

        bFechar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagem/fechar.png"))); // NOI18N
        bFechar.setText("Fechar");
        bFechar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bFecharActionPerformed(evt);
            }
        });

        bFluxo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagem/Fluxo.png"))); // NOI18N
        bFluxo.setText("FLUXO");
        bFluxo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bFluxoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addComponent(bNovo)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(bAlterar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(bFluxo)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(bFechar)
                .addContainerGap(41, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(bNovo)
                    .addComponent(bAlterar)
                    .addComponent(bFechar)
                    .addComponent(bFluxo))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 476, Short.MAX_VALUE)
                    .addContainerGap()))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(374, Short.MAX_VALUE)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 362, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(72, Short.MAX_VALUE)))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tabelaPlanoContasMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabelaPlanoContasMouseClicked
        // TODO add your handling code here:
        if (evt.getClickCount() == 2) {
            try {
                JanCadPlanoContas jan = new JanCadPlanoContas(modelo.getPlanoContas(tabelaPlanoContas.getSelectedRow()));
                jan.setVisible(true);
                this.setEnabled(false);
            } catch (ArrayIndexOutOfBoundsException e) {
            }
        }
}//GEN-LAST:event_tabelaPlanoContasMouseClicked

    private void bNovoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bNovoActionPerformed
        // TODO add your handling code here:
        JanCadPlanoContas jan = new JanCadPlanoContas();
        jan.setVisible(true);
        this.setEnabled(false);
}//GEN-LAST:event_bNovoActionPerformed

    private void bAlterarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bAlterarActionPerformed
        // TODO add your handling code here:
            try {
                JanCadPlanoContas jan = new JanCadPlanoContas(modelo.getPlanoContas(tabelaPlanoContas.getSelectedRow()));
                jan.setVisible(true);
                this.setEnabled(false);
        } catch (ArrayIndexOutOfBoundsException e) {
            Mensagem.mensagemErro(this, "Selecione a Conta");
        }
}//GEN-LAST:event_bAlterarActionPerformed

    private void bFecharActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bFecharActionPerformed
        // TODO add your handling code here:
        this.dispose();
}//GEN-LAST:event_bFecharActionPerformed

    private void bFluxoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bFluxoActionPerformed
        // TODO add your handling code here:
        try {
            if (modelo.getPlanoContas(tabelaPlanoContas.getSelectedRow()).getConta().length() == 12) {
                JanFluxoConta j = new JanFluxoConta(modelo.getPlanoContas(tabelaPlanoContas.getSelectedRow()).getConta());
                j.setVisible(true);
            } else {
                Mensagem.mensagemErro(this, "Selecione uma conta analítica");
            }

        } catch (ArrayIndexOutOfBoundsException e) {
            Mensagem.mensagemErro(this, "Selecione a Conta");
        }
    }//GEN-LAST:event_bFluxoActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bAlterar;
    private javax.swing.JButton bFechar;
    private javax.swing.JButton bFluxo;
    private javax.swing.JButton bNovo;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tabelaPlanoContas;
    // End of variables declaration//GEN-END:variables
}
