/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JInternalFrame.java to edit this template
 */
package br.com.encoreb.telas;

import Conector.ModuloConexao;
import br.com.encoreb.dao.ClienteDAO;
import br.com.encoreb.models.Cliente;
import java.sql.*;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import net.proteanit.sql.DbUtils;

/**
 *
 * @author Aluno
 */
public class TelaCliente extends javax.swing.JInternalFrame {

    Connection conexao = null;
    PreparedStatement pst = null;
    ResultSet rs = null;

    public TelaCliente() {
        initComponents();
    }

    public void cliente() {
        initComponents();
        try {
            conexao = ModuloConexao.getConnection();
        } catch (Exception e) {
            System.out.println("Erro de conexão." + e);
        }
    }

//    public void Adicionar() {
//        String sql = "insert into clientes(nome, sexo, nascimento, RG, CPF, telefone, email, endereco) values(?, ?, ?, ?, ?, ?, ?, ?)";
//
//        try {
//
//            pst = conexao.prepareStatement(sql);
//            pst.setString(1, txtCliNome.getText());
//            pst.setString(2, txtCliSexo.getText());
//            pst.setString(3, txtCliNas.getText());
//            pst.setString(4, txtCliRg.getText());
//            pst.setString(5, txtCliCpf.getText());
//            pst.setString(6, txtCliTel.getText());
//            pst.setString(7, txtCliEma.getText());
//            pst.setString(8, txtCliEnd.getText());
//
//            if ((txtCliNome.getText().isEmpty()) || (txtCliCpf.getText().isEmpty())) {
//                JOptionPane.showMessageDialog(null, "Preencha todos os campos obrigatórios");
//            } else {
//                // a linha abaixo atualiza a tabela clientes com os dados do formulario
//                // a estrutura abaixo e usada pára confirmar a insercao dos dados na tabela
//                int adicionado = pst.executeUpdate();
//                System.out.println(adicionado);
//
//                if (adicionado > 0) {
//                    JOptionPane.showMessageDialog(null, "Cliente adicionado com sucesso");
//                    // a linha abaixo é para a função de "limpar" os campos
//                    limpar();
//
//                }
//            }
//        } catch (Exception e) {
//            JOptionPane.showMessageDialog(null, e);
//        }
//    }
//
//    private void limpar() {
//        txtCliId.setText(null);
//        txtCliNome.setText(null);
//        txtCliSexo.setText(null);
//        txtCliNas.setText(null);
//        txtCliRg.setText(null);
//        txtCliCpf.setText(null);
//        txtCliEnd.setText(null);
//        txtCliTel.setText(null);
//        txtCliEma.setText(null);
//        txtCliEnd.setText(null);
//        ((DefaultTableModel) tblClientes.getModel()).setRowCount(0);
//    }
//
//    private void pesquisar() {
//        String sql = "select idcli as Id, nomecli  as Nome, endcli as Endereço, fonecli as Fone, emailcli as Email from tbclientes where nomecli like ?";
//        try {
//            pst = conexao.prepareStatement(sql);
//            //passando o conteudo da caixa de pesquisa para o ?
//            //atenção ao "%" - continuação da String sql
//            pst.setString(1, txtCliNome.getText() + "%");
//            rs = pst.executeQuery();
//            // a linha abaixo usa a biblioteca rs2ml.jar para preencher a tabela
//            tblClientes.setModel(DbUtils.resultSetToTableModel(rs));
//        } catch (Exception e) {
//            JOptionPane.showMessageDialog(null, e);
//        }
//    }
//
//    public void setar_campos() {
//        int setar = tblClientes.getSelectedRow();
//        txtCliId.setText(tblClientes.getModel().getValueAt(setar, 0).toString());
//        txtCliNome.setText(tblClientes.getModel().getValueAt(setar, 1).toString());
//        txtCliSexo.setText(tblClientes.getModel().getValueAt(setar, 2).toString());
//        txtCliNas.setText(tblClientes.getModel().getValueAt(setar, 3).toString());
//        txtCliRg.setText(tblClientes.getModel().getValueAt(setar, 4).toString());
//        txtCliCpf.setText(tblClientes.getModel().getValueAt(setar, 5).toString());
//        txtCliTel.setText(tblClientes.getModel().getValueAt(setar, 6).toString());
//        txtCliEma.setText(tblClientes.getModel().getValueAt(setar, 7).toString());
//        txtCliEnd.setText(tblClientes.getModel().getValueAt(setar, 8).toString());
//
//        // alinha abaixo desabilita o botao adicionar
//        btnAdicionar.setEnabled(false);
//    }
//
//    private void alterar() {
//        String sql = "update clientes set nome=?, sexo=?, nascimento=?, RG=?, CPF=?, telefone=?, email=?, endereco=? where idcli=?";
//        try {
//            pst = conexao.prepareStatement(sql);
//            pst.setString(1, txtCliNome.getText());
//            pst.setString(2, txtCliSexo.getText());
//            pst.setString(3, txtCliNas.getText());
//            pst.setString(4, txtCliRg.getText());
//            pst.setString(5, txtCliCpf.getText());
//            pst.setString(6, txtCliTel.getText());
//            pst.setString(7, txtCliEma.getText());
//            pst.setString(8, txtCliEnd.getText());
//            pst.setString(9, txtCliId.getText());
//
//            //validação dos campos obrigatórios
//            if ((txtCliNome.getText().isEmpty()) || (txtCliCpf.getText().isEmpty())) {
//                JOptionPane.showMessageDialog(null, "Preencha todos os campos obrigatórios");
//            } else {
//                // a linha abaixo atualiza a tabela clientes com os dados do formulario
//                // a estrutura abaixo e usada pára confirmar a insercao dos dados na tabela
//                int adicionado = pst.executeUpdate();
//
//                if (adicionado > 0) {
//                    JOptionPane.showMessageDialog(null, "Dados do Cliente alterados com sucesso");
//                    // as linhas  abaixo "limpam" os campos
//                    limpar();
//                    btnAdicionar.setEnabled(true);
//                }
//            }
//        } catch (Exception e) {
//            JOptionPane.showMessageDialog(null, e);
//        }
//    }

//    private void remover(){
//        // a estrutura abaixo confirma a remoção
//        int confirm = JOptionPane.showConfirmDialog(null, "Tem certeza que deseja remover esse cliente", "Atenção", JOptionPane.YES_NO_OPTION);
//        
//        if (confirm == JOptionPane.YES_OPTION){
//            String sql = "delete from tbclientes where idcli=?";
//            try{
//                pst = conexao.prepareStatement(sql);
//                pst.setString(1, txtCliId.getText());
//                int apagado = pst.executeUpdate();
//                if (apagado > 0) {
//                    JOptionPane.showMessageDialog(null, "Cliente removido com sucesso");
//                    
//                    // as linhas abaixo "limpam" os campos
//                    limpar();
//                    btnAdicionar.setEnabled(true);
//                    
//                }
//            } catch (Exception e) {
//                JOptionPane.showMessageDialog(null, e);
//            }
//        }
//    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnAdicionar = new javax.swing.JButton();
        btnEditar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblClientes = new javax.swing.JTable();
        txtCliCpf = new javax.swing.JFormattedTextField();
        txtCliTel = new javax.swing.JFormattedTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        btnPesquisar = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        txtCliId = new javax.swing.JTextField();
        txtCliNome = new javax.swing.JTextField();
        txtCliSexo = new javax.swing.JTextField();
        txtCliNas = new javax.swing.JTextField();
        txtCliRg = new javax.swing.JTextField();
        txtCliEma = new javax.swing.JTextField();
        txtCliEnd = new javax.swing.JTextField();

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setPreferredSize(new java.awt.Dimension(1024, 768));

        btnAdicionar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/encoreb/icones/adicionar-usuario.png"))); // NOI18N
        btnAdicionar.setBorder(new javax.swing.border.MatteBorder(null));
        btnAdicionar.setBorderPainted(false);
        btnAdicionar.setPreferredSize(new java.awt.Dimension(90, 90));
        btnAdicionar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAdicionarActionPerformed(evt);
            }
        });

        btnEditar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/encoreb/icones/do-utilizador.png"))); // NOI18N
        btnEditar.setBorder(new javax.swing.border.MatteBorder(null));
        btnEditar.setBorderPainted(false);
        btnEditar.setPreferredSize(new java.awt.Dimension(90, 90));
        btnEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditarActionPerformed(evt);
            }
        });

        tblClientes.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "ID", "Nome", "Sexo", "Nascimento", "RG", "CPF", "Telefone", "Email", "Endereço"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tblClientes);

        try {
            txtCliCpf.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("###.###.###-##")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }

        try {
            txtCliTel.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("(##) # ####-####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }

        jLabel1.setFont(new java.awt.Font("Ebrima", 1, 12)); // NOI18N
        jLabel1.setText("ID:");

        jLabel10.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel10.setText("Pesquisar");

        jLabel2.setFont(new java.awt.Font("Ebrima", 1, 12)); // NOI18N
        jLabel2.setText("Nome:");

        jLabel11.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel11.setText("Editar");

        jLabel3.setFont(new java.awt.Font("Ebrima", 1, 12)); // NOI18N
        jLabel3.setText("Sexo:");

        jLabel12.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel12.setText("Adicionar");

        jLabel4.setFont(new java.awt.Font("Ebrima", 1, 12)); // NOI18N
        jLabel4.setText("Nascimento:");

        btnPesquisar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/encoreb/icones/pesquisar-usuario.png"))); // NOI18N
        btnPesquisar.setBorder(new javax.swing.border.MatteBorder(null));
        btnPesquisar.setBorderPainted(false);
        btnPesquisar.setPreferredSize(new java.awt.Dimension(90, 90));
        btnPesquisar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPesquisarActionPerformed(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Ebrima", 1, 12)); // NOI18N
        jLabel5.setText("RG:");

        jLabel6.setFont(new java.awt.Font("Ebrima", 1, 12)); // NOI18N
        jLabel6.setText("CPF:");

        jLabel7.setFont(new java.awt.Font("Ebrima", 1, 12)); // NOI18N
        jLabel7.setText("Telefone:");

        jLabel8.setFont(new java.awt.Font("Ebrima", 1, 12)); // NOI18N
        jLabel8.setText("Email:");

        jLabel9.setFont(new java.awt.Font("Ebrima", 1, 12)); // NOI18N
        jLabel9.setText("Endereço:");

        txtCliId.setEditable(false);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(24, 24, 24)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel9)
                                    .addComponent(jLabel8)
                                    .addComponent(jLabel7)
                                    .addComponent(jLabel6)
                                    .addComponent(jLabel5)
                                    .addComponent(jLabel4)
                                    .addComponent(jLabel3)
                                    .addComponent(jLabel2)
                                    .addComponent(jLabel1))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(txtCliNome, javax.swing.GroupLayout.DEFAULT_SIZE, 231, Short.MAX_VALUE)
                                        .addComponent(txtCliId, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(txtCliNas, javax.swing.GroupLayout.DEFAULT_SIZE, 231, Short.MAX_VALUE)
                                        .addComponent(txtCliSexo)
                                        .addComponent(txtCliRg, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(txtCliEma)
                                        .addComponent(txtCliEnd))
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                        .addComponent(txtCliTel, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 100, Short.MAX_VALUE)
                                        .addComponent(txtCliCpf, javax.swing.GroupLayout.Alignment.LEADING)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 652, Short.MAX_VALUE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btnAdicionar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btnEditar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(347, 347, 347)
                                .addComponent(btnPesquisar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(31, 31, 31)
                        .addComponent(jLabel12)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel11)
                        .addGap(354, 354, 354)
                        .addComponent(jLabel10)
                        .addGap(14, 14, 14)))
                .addGap(16, 16, 16))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 360, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(txtCliId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(txtCliNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(txtCliSexo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(txtCliNas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(txtCliRg, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6)
                            .addComponent(txtCliCpf, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel7)
                            .addComponent(txtCliTel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel8)
                            .addComponent(txtCliEma, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel9)
                            .addComponent(txtCliEnd, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 103, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnEditar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnAdicionar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnPesquisar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(82, 82, 82)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(jLabel11)
                    .addComponent(jLabel12))
                .addGap(81, 81, 81))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnAdicionarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAdicionarActionPerformed
        Cliente cli = new Cliente();
        ClienteDAO cd = new ClienteDAO();
        
        cli.setNome(txtCliNome.getText());
        cli.setSexo(txtCliSexo.getText());
        cli.setNascimento(txtCliNas.getTime());
        cli.setRg(txtCliRg.getText());
        cli.setCpf(txtCliCpf.getText());
        cli.setTelefone(txtCliTel.getText());
        cli.setEmail(txtCliEma.getText());
        cli.setEndereco(txtCliEnd.getText());
        
        cd.Insert(cli);
        
        
    }//GEN-LAST:event_btnAdicionarActionPerformed

    private void btnEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditarActionPerformed
//        alterar();
    }//GEN-LAST:event_btnEditarActionPerformed

    private void btnPesquisarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPesquisarActionPerformed
//        pesquisar();
    }//GEN-LAST:event_btnPesquisarActionPerformed

    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(TelaCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TelaCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TelaCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TelaCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TelaCliente().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAdicionar;
    private javax.swing.JButton btnEditar;
    private javax.swing.JButton btnPesquisar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblClientes;
    private javax.swing.JFormattedTextField txtCliCpf;
    private javax.swing.JTextField txtCliEma;
    private javax.swing.JTextField txtCliEnd;
    private javax.swing.JTextField txtCliId;
    private javax.swing.JTextField txtCliNas;
    private javax.swing.JTextField txtCliNome;
    private javax.swing.JTextField txtCliRg;
    private javax.swing.JTextField txtCliSexo;
    private javax.swing.JFormattedTextField txtCliTel;
    // End of variables declaration//GEN-END:variables
}
