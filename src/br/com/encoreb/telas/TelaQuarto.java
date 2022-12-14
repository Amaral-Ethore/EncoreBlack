/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JInternalFrame.java to edit this template
 */
package br.com.encoreb.telas;


import Conector.ModuloConexao;
import br.com.encoreb.dao.FuncionarioDAO;
import br.com.encoreb.dao.QuartoDAO;
import br.com.encoreb.models.Funcionario;
import br.com.encoreb.models.Quarto;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Aluno
 */
public class TelaQuarto extends javax.swing.JInternalFrame {

   
    List<Quarto> quarto = new ArrayList<>();

    private DefaultTableModel modelo = new DefaultTableModel();
    List<Quarto> quartos = new ArrayList();
    Vector v = new Vector();
    
    public TelaQuarto(){
        initComponents();
      
        modelo.addColumn("Numero Quarto");
         modelo.addColumn("Tipo Quarto");
         modelo.addColumn("Ocupado");
         
         tabQuarto.setModel(modelo);
    }
    
    QuartoDAO quartodao = new QuartoDAO();
    
    private void criar(Quarto quarto) {
        
    QuartoDAO quartodao = new QuartoDAO();   
        try {
            quartodao.Insert(quarto);
            JOptionPane.showMessageDialog(null, "Criado com sucesso");
            limpar();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro!!!");
            System.out.println(e.getMessage());
        }
    }
    private void limpar(){
        txtNumQuarto.setText("");
        txtTipoQuarto.setText("");
        
        
        
    }
    private void editar(Quarto quarto) {
       
        try {
             QuartoDAO nome = new QuartoDAO();
            nome.Update(quarto);
            JOptionPane.showMessageDialog(null, "Alterado com sucesso");
            limpar();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro ao editar!");
            System.out.println(e.getMessage());
        }

    }
    

    private void limparformulario() {
        txtNumQuarto.setText("");
        txtTipoQuarto.setText("");
        chkOcupado.setEnabled(false);
        
     
    }
    

    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txtNumQuarto = new javax.swing.JTextField();
        txtTipoQuarto = new javax.swing.JTextField();
        chkOcupado = new javax.swing.JCheckBox();
        btnEditar = new javax.swing.JButton();
        btnPesquisar = new javax.swing.JButton();
        btnAdicionar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabQuarto = new javax.swing.JTable();

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setFrameIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/encoreb/icones/Client.png"))); // NOI18N
        setPreferredSize(new java.awt.Dimension(700, 500));
        setRequestFocusEnabled(false);

        jLabel2.setText("Numero Quarto");

        jLabel3.setText("Tipo do Quarto");

        chkOcupado.setText("OCUPADO");

        btnEditar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/encoreb/icones/do-utilizador.png"))); // NOI18N
        btnEditar.setToolTipText("Editar");
        btnEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditarActionPerformed(evt);
            }
        });

        btnPesquisar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/encoreb/icones/pesquisar-usuario.png"))); // NOI18N
        btnPesquisar.setToolTipText("Pesquisar");
        btnPesquisar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPesquisarActionPerformed(evt);
            }
        });

        btnAdicionar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/encoreb/icones/adicionar-usuario.png"))); // NOI18N
        btnAdicionar.setToolTipText("Adicionar");
        btnAdicionar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAdicionarActionPerformed(evt);
            }
        });

        tabQuarto = new javax.swing.JTable() {
            public boolean isCellEditable(int rowIndex, int colIndex) {
                return false;
            }
        };
        tabQuarto.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        tabQuarto.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabQuartoMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tabQuarto);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(41, 41, 41)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(jLabel3)
                            .addGap(18, 18, 18)
                            .addComponent(txtTipoQuarto, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(jLabel2)
                            .addGap(18, 18, 18)
                            .addComponent(txtNumQuarto, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(chkOcupado)
                        .addGap(106, 106, 106)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 379, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(291, 291, 291)
                .addComponent(btnEditar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 133, Short.MAX_VALUE)
                .addComponent(btnPesquisar)
                .addGap(66, 66, 66))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(61, 61, 61)
                    .addComponent(btnAdicionar)
                    .addContainerGap(526, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(86, 86, 86)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(txtNumQuarto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(33, 33, 33)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(txtTipoQuarto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(35, 35, 35)
                        .addComponent(chkOcupado))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 176, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 98, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnPesquisar, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btnEditar, javax.swing.GroupLayout.Alignment.TRAILING))
                .addGap(37, 37, 37))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                    .addContainerGap(360, Short.MAX_VALUE)
                    .addComponent(btnAdicionar)
                    .addGap(37, 37, 37)))
        );

        setBounds(0, 0, 700, 500);
    }// </editor-fold>//GEN-END:initComponents

    private void btnAdicionarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAdicionarActionPerformed
        Quarto quarto = new Quarto();
        quarto.setNumquarto((txtNumQuarto.getText()));
        quarto.setTipoQuarto(txtTipoQuarto.getText());
        quarto.setOcupado(chkOcupado.isSelected());
       
       if (!quarto.getNumquarto().isEmpty()) {
            this.criar(quarto);
        }
       else {
           JOptionPane.showMessageDialog(null, "Numero do Quarto Obrigatorio");
           txtNumQuarto.setFocusable(true);
       }  
    }//GEN-LAST:event_btnAdicionarActionPerformed

    private void btnEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditarActionPerformed
        
        Quarto quarto = new Quarto();
        quarto.setNumquarto((txtNumQuarto.getText()));
        quarto.setTipoQuarto(txtTipoQuarto.getText());
        quarto.setOcupado(chkOcupado.isSelected()); // checkbox tem q ser ISSELECTED
        
        if (!quarto.getNumquarto().isEmpty()) {
        this.editar(quarto);
        
        
        } 
    }//GEN-LAST:event_btnEditarActionPerformed

    private void btnPesquisarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPesquisarActionPerformed
        this.modelo.setNumRows(0);
        QuartoDAO dao = new QuartoDAO();
        
        try {
            quarto = dao.Pesquisar(btnPesquisar.getText());
        } catch (SQLException ex) {
            Logger.getLogger(TelaQuarto.class.getName()).log(Level.SEVERE, null, ex);    
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(TelaQuarto.class.getName()).log(Level.SEVERE, null, ex);
        }
       for (Quarto q : quarto) {
           this.modelo.addRow(new Object[]{q.getNumquarto(), q.getTipoQuarto(), q.getOcupado() ? "Ocupado" : "Vago"});
       }
       
    }//GEN-LAST:event_btnPesquisarActionPerformed

    private void tabQuartoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabQuartoMouseClicked
        int row = tabQuarto.getSelectedRow();
        Quarto quar = new Quarto();
        QuartoDAO quartos = new QuartoDAO();
        try {
            quar = quartos.SelectOne(quarto.get(row).getNumquarto());
            txtNumQuarto.setText(quar.getNumquarto());
            txtTipoQuarto.setText(quar.getTipoQuarto());
            chkOcupado.setSelected(quar.getOcupado());
            
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        
       
        
        
        
    }//GEN-LAST:event_tabQuartoMouseClicked
   

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAdicionar;
    private javax.swing.JButton btnEditar;
    private javax.swing.JButton btnPesquisar;
    private javax.swing.JCheckBox chkOcupado;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tabQuarto;
    private javax.swing.JTextField txtNumQuarto;
    private javax.swing.JTextField txtTipoQuarto;
    // End of variables declaration//GEN-END:variables

   
}
