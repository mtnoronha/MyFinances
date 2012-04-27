
package view.contas;

import Persistencia.contas.ContasService;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import model.Formatar;
import model.Mensagem;
import model.contas.CellRenderFluxoConta;
import model.contas.Lancamento;
import model.contas.TableModelLancamento;

public class JanFluxoConta extends javax.swing.JFrame {
    private static TableModelLancamento modelo;
    private CellRenderFluxoConta render;



    public JanFluxoConta(String conta) {
        super("..:: Fluxo de Conta ::..");
        initComponents();
        setLocationRelativeTo(null);
        
        modelo = new TableModelLancamento(conta);
        tabelaLancamentos.setModel(modelo);
        
        labelNomeConta.setText(JanPlanoContas.modelo.getPlanoContas(conta).getDescricao());


        try {
            ArrayList<Lancamento> lista = ContasService.preencherLancamento(conta);
            modelo.addListaDeLancamento(lista);
            modelo.filtrar("");
        } catch (ClassNotFoundException ex) {
            Mensagem.mensagemErroClassNotFound(this);
        } catch (SQLException ex) {
            Mensagem.mensagemErroSQLException(this);
            ex.printStackTrace();
        }
        
        campoDataInicial.setDate(new Date());
        campoDataFinal.setDate(new Date());
        
        render = new CellRenderFluxoConta();
        renderizar();
    }
    
    public void renderizar(){
            for(int i=0;i<tabelaLancamentos.getColumnCount();i++){
            tabelaLancamentos.getColumnModel().getColumn(i).setCellRenderer(render);
        }
    }

       public static void setarValores() {
           labelTotalCredito.setText(Formatar.formatarNumero(modelo.getTotal("Credito")));
           labelTotalDebito.setText(Formatar.formatarNumero(modelo.getTotal("Debito")));
           labelSaldo.setText(Formatar.formatarNumero((Double.parseDouble(labelTotalCredito.getText().replaceAll(",", ".")) - Double.parseDouble(labelTotalDebito.getText().replaceAll(",", ".")))));
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        campoDataInicial = new com.toedter.calendar.JDateChooser();
        jLabel9 = new javax.swing.JLabel();
        campoDataFinal = new com.toedter.calendar.JDateChooser();
        bFiltrarData = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabelaLancamentos = new javax.swing.JTable();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        labelTotalDebito = new javax.swing.JLabel();
        labelTotalCredito = new javax.swing.JLabel();
        labelSaldo = new javax.swing.JLabel();
        bNovoLancamento = new javax.swing.JButton();
        bFechar = new javax.swing.JButton();
        jLabel10 = new javax.swing.JLabel();
        labelNomeConta = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Filtrar"));

        jLabel7.setText("Filtrar por Data");

        jLabel8.setText("De");

        jLabel9.setText("até");

        bFiltrarData.setText("Filtrar");
        bFiltrarData.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bFiltrarDataActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel7)
                .addGap(18, 18, 18)
                .addComponent(jLabel8)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(campoDataInicial, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel9)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(campoDataFinal, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 168, Short.MAX_VALUE)
                .addComponent(bFiltrarData)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(bFiltrarData)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel8)
                            .addComponent(campoDataInicial, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel9)
                            .addComponent(campoDataFinal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jLabel7))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        tabelaLancamentos.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(tabelaLancamentos);

        jPanel2.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel1.setText("Total Debito:");

        jLabel2.setText("Total Credito:");

        jLabel3.setText("Saldo:");

        jLabel4.setText("R$");

        jLabel5.setText("R$");

        jLabel6.setText("R$");

        labelTotalDebito.setFont(new java.awt.Font("sansserif", 1, 12));
        labelTotalDebito.setText("jLabel7");

        labelTotalCredito.setFont(new java.awt.Font("sansserif", 1, 12));
        labelTotalCredito.setText("jLabel8");

        labelSaldo.setFont(new java.awt.Font("sansserif", 1, 12));
        labelSaldo.setText("jLabel9");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                            .addComponent(jLabel3)
                            .addGap(26, 26, 26)
                            .addComponent(jLabel6)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(labelSaldo))
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                            .addComponent(jLabel2)
                            .addGap(26, 26, 26)
                            .addComponent(jLabel5)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(labelTotalCredito)))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(30, 30, 30)
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(labelTotalDebito)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel4)
                    .addComponent(labelTotalDebito))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jLabel5)
                    .addComponent(labelTotalCredito))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jLabel6)
                    .addComponent(labelSaldo))
                .addContainerGap(12, Short.MAX_VALUE))
        );

        bNovoLancamento.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagem/novoLancamento.png"))); // NOI18N
        bNovoLancamento.setText("Novo Lançamento");
        bNovoLancamento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bNovoLancamentoActionPerformed(evt);
            }
        });

        bFechar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagem/fechar.png"))); // NOI18N
        bFechar.setText("Fechar");
        bFechar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bFecharActionPerformed(evt);
            }
        });

        jLabel10.setFont(new java.awt.Font("sansserif", 1, 18));
        jLabel10.setText("Fluxo de Conta");

        labelNomeConta.setFont(new java.awt.Font("sansserif", 1, 18));
        labelNomeConta.setText("jLabel11");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(bFechar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(bNovoLancamento))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 351, Short.MAX_VALUE)
                                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 693, Short.MAX_VALUE)
                            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(165, 165, 165)
                        .addComponent(jLabel10)
                        .addGap(18, 18, 18)
                        .addComponent(labelNomeConta)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(labelNomeConta))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 430, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(bNovoLancamento)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(bFechar))
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void bFecharActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bFecharActionPerformed
        // TODO add your handling code here:
        this.dispose();
    }//GEN-LAST:event_bFecharActionPerformed

    private void bNovoLancamentoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bNovoLancamentoActionPerformed
        // TODO add your handling code here:
        JanLancamento jan = new JanLancamento();
        jan.setVisible(true);
    }//GEN-LAST:event_bNovoLancamentoActionPerformed

    private void bFiltrarDataActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bFiltrarDataActionPerformed
        // TODO add your handling code here:
        if(verificarDadosFiltrarData()){
            modelo.filtrarData(campoDataInicial.getDate(), campoDataFinal.getDate());
        }
}//GEN-LAST:event_bFiltrarDataActionPerformed
private boolean verificarDadosFiltrarData() {
          
        try {
            java.sql.Date data = new java.sql.Date(campoDataInicial.getDate().getTime());

        } catch (Exception e) {
            Mensagem.mensagemErro(this, "Escolha a data inicial");
            campoDataInicial.requestFocus();
            return false;
        }

        try {
            java.sql.Date data = new java.sql.Date(campoDataFinal.getDate().getTime());
        } catch (Exception e) {
            Mensagem.mensagemErro(this, "Escolha a data final");
            campoDataFinal.requestFocus();
            return false;
        }
       
        return true;
    }
   
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bFechar;
    private javax.swing.JButton bFiltrarData;
    private javax.swing.JButton bNovoLancamento;
    private com.toedter.calendar.JDateChooser campoDataFinal;
    private com.toedter.calendar.JDateChooser campoDataInicial;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel labelNomeConta;
    private static javax.swing.JLabel labelSaldo;
    private static javax.swing.JLabel labelTotalCredito;
    private static javax.swing.JLabel labelTotalDebito;
    private javax.swing.JTable tabelaLancamentos;
    // End of variables declaration//GEN-END:variables
}
