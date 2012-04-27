package view.parceiro;

import model.parceiro.TableModelParceiros;
import Persistencia.parceiro.ParceirosService;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.ListSelectionModel;
import model.Mensagem;
import model.parceiro.ParceiroComercial;

public class JanParceirosComerciais extends javax.swing.JFrame {

    private static JanParceirosComerciais jan;
    public  static TableModelParceiros modelo;

    private JanParceirosComerciais() {
        super("..:: Parceiros Comerciais ::..");

        
        initComponents();

        setLocationRelativeTo(null);
        tabelaParceiros.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

        modelo = new TableModelParceiros();

        tabelaParceiros.setModel(modelo);
        try {
            ArrayList<ParceiroComercial> lista = ParceirosService.preencherParceiros();
            for(ParceiroComercial atual : lista){
                modelo.addParceiroComercial(atual);
            }            
        } catch (ClassNotFoundException ex) {
            Mensagem.mensagemErroClassNotFound(this);
        } catch (SQLException ex) {
            Mensagem.mensagemErroSQLException(this);
            ex.printStackTrace();
        } 
    }

    public static JanParceirosComerciais getInstance() {

        if (jan == null) {

            jan = new JanParceirosComerciais();
        }
        modelo.filtrar("","All");
        return jan;
    }


     
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        grupoParceiros = new javax.swing.ButtonGroup();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabelaParceiros = new javax.swing.JTable();
        jPanel1 = new javax.swing.JPanel();
        campoPesquisa = new javax.swing.JTextField();
        opNome = new javax.swing.JRadioButton();
        opCNPJ = new javax.swing.JRadioButton();
        jPanel2 = new javax.swing.JPanel();
        bNovo = new javax.swing.JButton();
        bAlterar = new javax.swing.JButton();
        bExcluir = new javax.swing.JButton();
        bFechar = new javax.swing.JButton();
        bContatos = new javax.swing.JButton();
        bEndereco = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        tabelaParceiros.setModel(new javax.swing.table.DefaultTableModel(
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
        tabelaParceiros.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabelaParceirosMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tabelaParceiros);

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Filtrar"));

        campoPesquisa.addCaretListener(new javax.swing.event.CaretListener() {
            public void caretUpdate(javax.swing.event.CaretEvent evt) {
                campoPesquisaCaretUpdate(evt);
            }
        });

        grupoParceiros.add(opNome);
        opNome.setSelected(true);
        opNome.setText("Nome / Razao");

        grupoParceiros.add(opCNPJ);
        opCNPJ.setText("CNPJ / CPF");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(campoPesquisa, javax.swing.GroupLayout.DEFAULT_SIZE, 432, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addComponent(opNome)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(opCNPJ)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(campoPesquisa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(opNome)
                    .addComponent(opCNPJ))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

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

        bExcluir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagem/excluir.png"))); // NOI18N
        bExcluir.setText("Excluir");
        bExcluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bExcluirActionPerformed(evt);
            }
        });

        bFechar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagem/fechar.png"))); // NOI18N
        bFechar.setText("Fechar");
        bFechar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bFecharActionPerformed(evt);
            }
        });

        bContatos.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagem/Contatos.png"))); // NOI18N
        bContatos.setText("Contatos");
        bContatos.setToolTipText("Selecione um Parceiro e clique aqui para visualizar seus Contatos");
        bContatos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bContatosActionPerformed(evt);
            }
        });

        bEndereco.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagem/endereco.png"))); // NOI18N
        bEndereco.setText("Endereços");
        bEndereco.setToolTipText("Selecione um Parceiro e clique aqui para visualizar seus Endereços");
        bEndereco.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bEnderecoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(bNovo)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(bAlterar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(bExcluir)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(bContatos)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(bEndereco)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(bFechar)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(bNovo)
                    .addComponent(bFechar)
                    .addComponent(bAlterar)
                    .addComponent(bExcluir)
                    .addComponent(bContatos)
                    .addComponent(bEndereco))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addGap(12, 12, 12)
                        .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addGap(12, 12, 12)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 677, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 274, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

     private void bNovoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bNovoActionPerformed
         // TODO add your handling code here:
         JanCadParceirosComerciais jan = new JanCadParceirosComerciais();
         jan.setVisible(true);
         this.setEnabled(false);

     }//GEN-LAST:event_bNovoActionPerformed

     private void bFecharActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bFecharActionPerformed
         // TODO add your handling code here:
         this.dispose();
     }//GEN-LAST:event_bFecharActionPerformed

     private void bContatosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bContatosActionPerformed
         // TODO add your handling code here:
         try {
             JanContatos jan = new JanContatos(modelo.getParceiroComercial(tabelaParceiros.getSelectedRow()));
             jan.setVisible(true);
             this.setEnabled(false);
         } catch (ArrayIndexOutOfBoundsException e) {
                          Mensagem.mensagemErro(jan, "Selecione um Parceiro!");
         }
     }//GEN-LAST:event_bContatosActionPerformed

     private void bEnderecoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bEnderecoActionPerformed
         // TODO add your handling code here:
         try {
             JanEnderecos jan = new JanEnderecos(modelo.getParceiroComercial(tabelaParceiros.getSelectedRow()));
             jan.setVisible(true);
             this.setEnabled(false);
         } catch (ArrayIndexOutOfBoundsException e) {
                          Mensagem.mensagemErro(jan, "Selecione um Parceiro!");
         }
     }//GEN-LAST:event_bEnderecoActionPerformed

     private void tabelaParceirosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabelaParceirosMouseClicked
         // TODO add your handling code here:
         try{
         if (evt.getClickCount() == 2) {
             JanCadParceirosComerciais jan = new JanCadParceirosComerciais(modelo.getParceiroComercial(tabelaParceiros.getSelectedRow()));
             jan.setVisible(true);
             this.setEnabled(false);
         }
         }catch(Exception e){}
     }//GEN-LAST:event_tabelaParceirosMouseClicked

     private void bAlterarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bAlterarActionPerformed
         // TODO add your handling code here:
         try {
             JanCadParceirosComerciais jan = new JanCadParceirosComerciais(modelo.getParceiroComercial(tabelaParceiros.getSelectedRow()));
             jan.setVisible(true);
             this.setEnabled(false);
         } catch (ArrayIndexOutOfBoundsException e) {
             Mensagem.mensagemErro(jan, "Selecione um Parceiro!");
         }
     }//GEN-LAST:event_bAlterarActionPerformed

     private void campoPesquisaCaretUpdate(javax.swing.event.CaretEvent evt) {//GEN-FIRST:event_campoPesquisaCaretUpdate
         // TODO add your handling code here:
         if(opCNPJ.isSelected()){
             modelo.filtrarCPF(campoPesquisa.getText());
         }else{
             modelo.filtrar(campoPesquisa.getText(),"All");
         }
     }//GEN-LAST:event_campoPesquisaCaretUpdate

     private void bExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bExcluirActionPerformed
         // TODO add your handling code here:
int s = Mensagem.mensagemYesNo(jan, "Tem certeza que deseja excluir este Parceiro?");
if(s==0){
         try {
             ParceiroComercial novo = modelo.getParceiroComercial(tabelaParceiros.getSelectedRow());
             novo.setDeletado(true);
             ParceirosService.atualizarParceiro(novo);
             modelo.filtrar("","All");
         } catch (ArrayIndexOutOfBoundsException e) {
         } catch (ClassNotFoundException ex) {
             Mensagem.mensagemErroClassNotFound(this);
         } catch (SQLException ex) {
             Mensagem.mensagemErroSQLException(this);
             ex.printStackTrace();
         }
}

     }//GEN-LAST:event_bExcluirActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bAlterar;
    private javax.swing.JButton bContatos;
    private javax.swing.JButton bEndereco;
    private javax.swing.JButton bExcluir;
    private javax.swing.JButton bFechar;
    private javax.swing.JButton bNovo;
    private javax.swing.JTextField campoPesquisa;
    private javax.swing.ButtonGroup grupoParceiros;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JRadioButton opCNPJ;
    private javax.swing.JRadioButton opNome;
    private javax.swing.JTable tabelaParceiros;
    // End of variables declaration//GEN-END:variables

    public void setarPermissoes(boolean alterar, boolean deletar, boolean inserir) {
                if(!alterar){
            bAlterar.setEnabled(false);
            tabelaParceiros.setEnabled(false);
        }
        
        if(!deletar){
            bExcluir.setEnabled(false);
        }
        
        if(!inserir){
            bNovo.setEnabled(false);
        }
    }
}
