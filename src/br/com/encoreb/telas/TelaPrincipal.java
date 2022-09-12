/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package br.com.encoreb.telas;

import Conector.ModuloConexao;
import br.com.encoreb.dao.ClienteDAO;
import java.text.DateFormat;
import java.util.Date;
import javax.swing.JOptionPane;
import java.sql.*;


/**
 *
 * @author Aluno
 */
public class TelaPrincipal extends javax.swing.JFrame {
Connection conexao = null;
    /**
     * Creates new form TelaPrincipal
     */
    public TelaPrincipal() {
        initComponents();
        try{
            conexao = ModuloConexao.getConnection();
        }
        catch(Exception e)
        {
            System.out.println("Error");
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jDesktopPane1 = new javax.swing.JDesktopPane();
        lblUsuario = new javax.swing.JLabel();
        lblData = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        menCad = new javax.swing.JMenu();
        menCadCli = new javax.swing.JMenuItem();
        menCadFun = new javax.swing.JMenuItem();
        menCadRes = new javax.swing.JMenuItem();
        menCadUser = new javax.swing.JMenuItem();
        jMenuItem1 = new javax.swing.JMenuItem();
        menRel = new javax.swing.JMenu();
        menRelCli = new javax.swing.JMenuItem();
        menRelRes = new javax.swing.JMenuItem();
        menOpc = new javax.swing.JMenu();
        menOpcAju = new javax.swing.JMenuItem();
        menOpcSair = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setPreferredSize(new java.awt.Dimension(915, 523));
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowActivated(java.awt.event.WindowEvent evt) {
                formWindowActivated(evt);
            }
        });

        javax.swing.GroupLayout jDesktopPane1Layout = new javax.swing.GroupLayout(jDesktopPane1);
        jDesktopPane1.setLayout(jDesktopPane1Layout);
        jDesktopPane1Layout.setHorizontalGroup(
            jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 770, Short.MAX_VALUE)
        );
        jDesktopPane1Layout.setVerticalGroup(
            jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        lblUsuario.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        lblUsuario.setText("Usuário");

        lblData.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        lblData.setText("Data");

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/encoreb/icones/nao-perturbe.png"))); // NOI18N

        menCad.setText("Cadastro");

        menCadCli.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_C, java.awt.event.InputEvent.ALT_DOWN_MASK));
        menCadCli.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/encoreb/icones/cliente3.png"))); // NOI18N
        menCadCli.setText("Cliente");
        menCad.add(menCadCli);

        menCadFun.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F, java.awt.event.InputEvent.ALT_DOWN_MASK));
        menCadFun.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/encoreb/icones/funcionarios (2).png"))); // NOI18N
        menCadFun.setText("Funcionários");
        menCad.add(menCadFun);

        menCadRes.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_R, java.awt.event.InputEvent.ALT_DOWN_MASK));
        menCadRes.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/encoreb/icones/reserva (1).png"))); // NOI18N
        menCadRes.setText("Reserva");
        menCad.add(menCadRes);

        menCadUser.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_U, java.awt.event.InputEvent.ALT_DOWN_MASK));
        menCadUser.setText("Usuário");
        menCad.add(menCadUser);

        jMenuItem1.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_Q, java.awt.event.InputEvent.ALT_DOWN_MASK));
        jMenuItem1.setText("Quarto");
        menCad.add(jMenuItem1);

        jMenuBar1.add(menCad);

        menRel.setText("Relatório");

        menRelCli.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_C, java.awt.event.InputEvent.SHIFT_DOWN_MASK));
        menRelCli.setText("clientes");
        menRel.add(menRelCli);

        menRelRes.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_R, java.awt.event.InputEvent.SHIFT_DOWN_MASK));
        menRelRes.setText("Reservas");
        menRel.add(menRelRes);

        jMenuBar1.add(menRel);

        menOpc.setText("Opções");

        menOpcAju.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_A, java.awt.event.InputEvent.ALT_DOWN_MASK));
        menOpcAju.setText("Ajuda");
        menOpc.add(menOpcAju);

        menOpcSair.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_S, java.awt.event.InputEvent.ALT_DOWN_MASK));
        menOpcSair.setText("Sair");
        menOpc.add(menOpcSair);

        jMenuBar1.add(menOpc);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jDesktopPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(44, 44, 44)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(lblUsuario, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lblData, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel4)))
                .addContainerGap(43, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(67, 67, 67)
                .addComponent(lblUsuario)
                .addGap(39, 39, 39)
                .addComponent(lblData)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 86, Short.MAX_VALUE)
                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 246, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(70, 70, 70))
            .addComponent(jDesktopPane1, javax.swing.GroupLayout.Alignment.TRAILING)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void formWindowActivated(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowActivated
        Date data = new Date();
        DateFormat formatador = DateFormat.getDateInstance(DateFormat.SHORT);
        lblData.setText(formatador.format(data));         // TODO add your handling code here:
    }//GEN-LAST:event_formWindowActivated

    /**
     * @param args the command line arguments
     */
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
            java.util.logging.Logger.getLogger(TelaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TelaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TelaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TelaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TelaPrincipal().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JDesktopPane jDesktopPane1;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JLabel lblData;
    public static javax.swing.JLabel lblUsuario;
    public static javax.swing.JMenu menCad;
    private javax.swing.JMenuItem menCadCli;
    private javax.swing.JMenuItem menCadFun;
    private javax.swing.JMenuItem menCadRes;
    public static javax.swing.JMenuItem menCadUser;
    public static javax.swing.JMenu menOpc;
    private javax.swing.JMenuItem menOpcAju;
    private javax.swing.JMenuItem menOpcSair;
    public static javax.swing.JMenu menRel;
    private javax.swing.JMenuItem menRelCli;
    private javax.swing.JMenuItem menRelRes;
    // End of variables declaration//GEN-END:variables
}