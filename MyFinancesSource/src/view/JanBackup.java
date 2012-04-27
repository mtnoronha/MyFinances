
package view;

import java.io.File;
import java.io.IOException;
import java.util.Date;
import javax.swing.JFileChooser;
import model.Formatar;
import model.Mensagem;

public class JanBackup extends javax.swing.JFrame {

    public JanBackup() {
        super("..:: Backup ::..");
        initComponents();
        setLocationRelativeTo(null);
        campoNome.setText(Formatar.formatarDataHifem(new Date())+" - backup");
    }

    private void realizaBackup(String caminhoDoPg, String caminhoSalvar, String nomeArquivo) {
        try {
            ProcessBuilder pb;
            Process p;
            pb = new ProcessBuilder(caminhoDoPg + "pg_dump.exe", "-i", "-h", "localhost", "-p", "5432", "-U", "postgres", "-F", "c", "-b", "-v", "-f", caminhoSalvar + "" + nomeArquivo + ".backup", "ParceirosTst");
            pb.environment().put("PGPASSWORD", "tux@2pg");
            pb.redirectErrorStream(true);
            p = pb.start();
            labelStatus.setText("Concluído");
            Mensagem.mensagemSucesso(this, "O backup está sendo criado em segundo plano.");
            this.dispose();

        } catch (IOException ioe) {
            Mensagem.mensagemErro(null, "Erro ao realizar backup!");
            labelStatus.setText("Erro");
            ioe.printStackTrace();
        }

    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        campoPg = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        campoSalvar = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        campoNome = new javax.swing.JTextField();
        bProcurarPg = new javax.swing.JButton();
        bProcurarSalvar = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        labelStatus = new javax.swing.JLabel();
        bCriar = new javax.swing.JButton();
        bFechar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Configuração"));

        jLabel1.setText("Caminho do PgAdmin");

        campoPg.setText("C:\\Program Files\\pgAdmin III\\1.14\\");

            jLabel2.setText("Salvar em");

            campoSalvar.setText("C:\\backup\\");

                jLabel3.setText("Nome do Arquivo");

                bProcurarPg.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagem/procurarpasta.png"))); // NOI18N
                bProcurarPg.addActionListener(new java.awt.event.ActionListener() {
                    public void actionPerformed(java.awt.event.ActionEvent evt) {
                        bProcurarPgActionPerformed(evt);
                    }
                });

                bProcurarSalvar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagem/procurarpasta.png"))); // NOI18N
                bProcurarSalvar.addActionListener(new java.awt.event.ActionListener() {
                    public void actionPerformed(java.awt.event.ActionEvent evt) {
                        bProcurarSalvarActionPerformed(evt);
                    }
                });

                javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
                jPanel1.setLayout(jPanel1Layout);
                jPanel1Layout.setHorizontalGroup(
                    jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3)
                            .addComponent(campoNome, javax.swing.GroupLayout.DEFAULT_SIZE, 279, Short.MAX_VALUE)
                            .addComponent(campoSalvar, javax.swing.GroupLayout.DEFAULT_SIZE, 279, Short.MAX_VALUE)
                            .addComponent(campoPg, javax.swing.GroupLayout.DEFAULT_SIZE, 279, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(bProcurarSalvar)
                            .addComponent(bProcurarPg))
                        .addContainerGap())
                );
                jPanel1Layout.setVerticalGroup(
                    jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(bProcurarPg)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(campoPg, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(campoSalvar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(campoNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(bProcurarSalvar))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                );

                jPanel2.setBorder(javax.swing.BorderFactory.createEtchedBorder());

                labelStatus.setText("Pronto");

                javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
                jPanel2.setLayout(jPanel2Layout);
                jPanel2Layout.setHorizontalGroup(
                    jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(labelStatus)
                        .addContainerGap(323, Short.MAX_VALUE))
                );
                jPanel2Layout.setVerticalGroup(
                    jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addGap(9, 9, 9)
                        .addComponent(labelStatus)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                );

                bCriar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagem/criarBackup.png"))); // NOI18N
                bCriar.setText("Criar backup");
                bCriar.addActionListener(new java.awt.event.ActionListener() {
                    public void actionPerformed(java.awt.event.ActionEvent evt) {
                        bCriarActionPerformed(evt);
                    }
                });

                bFechar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagem/fechar.png"))); // NOI18N
                bFechar.setText("Fechar");
                bFechar.addActionListener(new java.awt.event.ActionListener() {
                    public void actionPerformed(java.awt.event.ActionEvent evt) {
                        bFecharActionPerformed(evt);
                    }
                });

                javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
                getContentPane().setLayout(layout);
                layout.setHorizontalGroup(
                    layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(bCriar)
                                .addGap(18, 18, 18)
                                .addComponent(bFechar, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                );
                layout.setVerticalGroup(
                    layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(bCriar)
                            .addComponent(bFechar))
                        .addGap(24, 24, 24)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(7, Short.MAX_VALUE))
                );

                pack();
            }// </editor-fold>//GEN-END:initComponents

    private void bFecharActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bFecharActionPerformed
        // TODO add your handling code here:
        this.dispose();
    }//GEN-LAST:event_bFecharActionPerformed

    private void bCriarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bCriarActionPerformed
        // TODO add your handling code here:
        if (verificarDados()) {
            labelStatus.setText("Criando backup...");
            realizaBackup(campoPg.getText(), campoSalvar.getText(), campoNome.getText());
        }
    }//GEN-LAST:event_bCriarActionPerformed

    private void bProcurarPgActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bProcurarPgActionPerformed
        // TODO add your handling code here:
         JFileChooser arquivo = new JFileChooser();
        arquivo.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
        File arq;

        if (arquivo.showOpenDialog(arquivo) == JFileChooser.APPROVE_OPTION) {
            arq = new File(arquivo.getSelectedFile().getPath());
            campoPg.setText(arq.getAbsolutePath()+"\\");
        } else {
            Mensagem.mensagemErro(this, "Escolha um diretório!");
        }
    }//GEN-LAST:event_bProcurarPgActionPerformed

    private void bProcurarSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bProcurarSalvarActionPerformed
        // TODO add your handling code here:
          JFileChooser arquivo = new JFileChooser();
        arquivo.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
        File arq;

        if (arquivo.showOpenDialog(arquivo) == JFileChooser.APPROVE_OPTION) {
            arq = new File(arquivo.getSelectedFile().getPath());
            campoSalvar.setText(arq.getAbsolutePath()+"\\");
        } else {
            Mensagem.mensagemErro(this, "Escolha um diretório!");
        }
    }//GEN-LAST:event_bProcurarSalvarActionPerformed

   
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bCriar;
    private javax.swing.JButton bFechar;
    private javax.swing.JButton bProcurarPg;
    private javax.swing.JButton bProcurarSalvar;
    private javax.swing.JTextField campoNome;
    private javax.swing.JTextField campoPg;
    private javax.swing.JTextField campoSalvar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JLabel labelStatus;
    // End of variables declaration//GEN-END:variables

    private boolean verificarDados() {
        if (campoNome.getText().equals("")) {
            Mensagem.mensagemErro(this, "Digite o nome");
            campoNome.requestFocus();
            return false;
        }
        if (campoPg.getText().equals("")) {
            Mensagem.mensagemErro(this, "Digite o caminho da pasta do Pg Admin");
            campoPg.requestFocus();
            return false;
        }

        if (campoSalvar.getText().equals("")) {
            Mensagem.mensagemErro(this, "Digite o diretório destino a salvar");
            campoSalvar.requestFocus();
            return false;
        }

        return true;
    }
}
