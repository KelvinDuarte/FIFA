/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifnmg.kelvin.fifa.apresentacao;

import br.edu.ifnmg.kelvin.fifa.entidade.Times;
import br.edu.ifnmg.kelvin.fifa.negocio.TimesBO;
import java.awt.Dimension;
import java.beans.PropertyVetoException;
import java.sql.SQLException;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author KELVIN
 */
public class PesquisarTimesForm extends javax.swing.JInternalFrame {

    private List<Times> times;
    
    /**
     * Creates new form pesquisarTimesForm
     * @throws java.sql.SQLException
     */
    public PesquisarTimesForm() throws SQLException {
        this.prepararTela();
        
    }
    
    private void prepararTela() throws SQLException{
        initComponents();
        this.carregarTabelaTimes();
        this.carregarComboTimes();
    }
    
    public void setPosicao() {
        Dimension dimensao = this.getDesktopPane().getSize();
        this.setLocation((dimensao.width - this.getSize().width) / 2, (dimensao.height - this.getSize().height) / 2); 
    }
    public void carregarComboTimes(){
        TimesBO timesBO = new TimesBO();
        try {
            times = timesBO.buscarTodos();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro Desconhecido, Contate o Administrador do Sistema.");
        }
        cboNomeTime.removeAllItems();
        cboSiglaPais.removeAllItems();
        cboNomeTime.addItem("Selecionar");
        cboSiglaPais.addItem("Selecionar");
        for (Times time : times) {
            cboNomeTime.addItem(time.getNome());
            cboSiglaPais.addItem(time.getSigla());
        }
    }    
    public void cadastrarTime(){
        CadastroTimesForm cadastroTimesForm = new CadastroTimesForm();
        pnlDesktopTimes.add(cadastroTimesForm);
        cadastroTimesForm.setVisible(true);
        cadastroTimesForm.toFront();
        try {
            cadastroTimesForm.setMaximum(true);
        } catch (PropertyVetoException ex) {
            JOptionPane.showMessageDialog(null, "Error Desconhecido, Contate o Administrador do Sistema!");
        }        
    }
    
    public void excluirTime(){
        try
        {
            int linhaSelecionada= tblResultado.getSelectedRow();
            if(linhaSelecionada != 1)
            {
                Times timeSelecionado = times.get(linhaSelecionada);
                int resposta;
                String mensagem = "Deseja excluir o Time " +
                        timeSelecionado.getNome()+ " (ID: "+
                        timeSelecionado.getCodigo()+ ")?";
                        String titulo = "Exclusão de Times";
                        resposta = JOptionPane.showConfirmDialog(this, mensagem, titulo, JOptionPane.YES_NO_OPTION);
                if(resposta == JOptionPane.YES_OPTION)
                {
                    TimesBO timesBO = new TimesBO();
                    timesBO.excluirTime(timeSelecionado.getCodigo());
                    
                    String mensagemSucesso = "Time: "+ timeSelecionado.getNome()+" (ID:" +
                            timeSelecionado.getCodigo()+ ")"
                            + "excluido com sucesso!";
                    JOptionPane.showConfirmDialog(this, mensagem,"Exclusao de Time", JOptionPane.INFORMATION_MESSAGE);
                    this.carregarTabelaTimes();                      
                }
                else
                {
                    String mesnagem = "Nenhum Aparelho Selecionado.";
                    JOptionPane.showMessageDialog(this, mesnagem, "Exclusão de Aluno", JOptionPane.INFORMATION_MESSAGE);
                }
            }
        }catch (Exception e) {
            String mensagem = "Erro inesperado! Informe a mensagem de erro ao administrador do sistema.";
            mensagem += "\nMensagem de erro:\n" + e.getMessage();
            JOptionPane.showMessageDialog(this, mensagem, "Alunos Cadastrados", JOptionPane.ERROR_MESSAGE);
            this.dispose();   
        }            
            
    }
    
    public void carregarTabelaTimes() throws SQLException{
        TimesBO timesBO = new TimesBO();
        this.times = timesBO.buscarTodos();     
        ModeloTabelaTimes modeloTabelaTimes = new ModeloTabelaTimes() {};
        tblResultado.setModel(modeloTabelaTimes);
    }    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnlDesktopTimes = new javax.swing.JDesktopPane();
        pnlFiltro = new javax.swing.JPanel();
        lblCodigo = new javax.swing.JLabel();
        cboCodigoTime = new javax.swing.JComboBox<>();
        lblCodigo1 = new javax.swing.JLabel();
        cboNomeTime = new javax.swing.JComboBox<>();
        cboSiglaPais = new javax.swing.JComboBox<>();
        lblCodigo2 = new javax.swing.JLabel();
        btnPesquisar = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblResultado = new javax.swing.JTable();
        btnVisualizar = new javax.swing.JButton();
        btnNovo = new javax.swing.JButton();
        btnAtualizar = new javax.swing.JButton();
        btnEditar = new javax.swing.JButton();
        btnExcluir = new javax.swing.JButton();
        btnRelatorios = new javax.swing.JButton();

        setClosable(true);
        setTitle("Pesquisar - Times");
        setPreferredSize(new java.awt.Dimension(1360, 584));

        pnlDesktopTimes.setBackground(new java.awt.Color(240, 240, 240));

        pnlFiltro.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), "Filtro"));

        lblCodigo.setText("Código");

        lblCodigo1.setText("Nome do Time");

        lblCodigo2.setText("Sigla do País de Origem");

        btnPesquisar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/edu/ifnmg/kelvin/fifa/apresentacao/imagens/magnifying-glass11.png"))); // NOI18N
        btnPesquisar.setText("Pesquisar");

        javax.swing.GroupLayout pnlFiltroLayout = new javax.swing.GroupLayout(pnlFiltro);
        pnlFiltro.setLayout(pnlFiltroLayout);
        pnlFiltroLayout.setHorizontalGroup(
            pnlFiltroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlFiltroLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlFiltroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(cboNomeTime, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(cboSiglaPais, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(pnlFiltroLayout.createSequentialGroup()
                        .addGroup(pnlFiltroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(pnlFiltroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(lblCodigo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(lblCodigo1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(lblCodigo2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addComponent(btnPesquisar)
                            .addComponent(cboCodigoTime, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        pnlFiltroLayout.setVerticalGroup(
            pnlFiltroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlFiltroLayout.createSequentialGroup()
                .addComponent(lblCodigo)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cboCodigoTime, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblCodigo1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cboNomeTime, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblCodigo2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cboSiglaPais, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnPesquisar)
                .addGap(0, 10, Short.MAX_VALUE))
        );

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), "Resultado"));

        tblResultado.setModel(new javax.swing.table.DefaultTableModel(
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
        tblResultado.setSelectionBackground(new java.awt.Color(153, 255, 153));
        jScrollPane1.setViewportView(tblResultado);

        btnVisualizar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/edu/ifnmg/kelvin/fifa/apresentacao/imagens/view32.png"))); // NOI18N
        btnVisualizar.setText("Visualizar");

        btnNovo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/edu/ifnmg/kelvin/fifa/apresentacao/imagens/archive44.png"))); // NOI18N
        btnNovo.setText("Novo");
        btnNovo.setMaximumSize(new java.awt.Dimension(75, 23));
        btnNovo.setMinimumSize(new java.awt.Dimension(75, 23));
        btnNovo.setPreferredSize(new java.awt.Dimension(75, 23));
        btnNovo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNovoActionPerformed(evt);
            }
        });

        btnAtualizar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/edu/ifnmg/kelvin/fifa/apresentacao/imagens/refresh57.png"))); // NOI18N
        btnAtualizar.setText("Atualizar");
        btnAtualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAtualizarActionPerformed(evt);
            }
        });

        btnEditar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/edu/ifnmg/kelvin/fifa/apresentacao/imagens/write34.png"))); // NOI18N
        btnEditar.setText("Editar");
        btnEditar.setMaximumSize(new java.awt.Dimension(75, 23));
        btnEditar.setMinimumSize(new java.awt.Dimension(75, 23));
        btnEditar.setPreferredSize(new java.awt.Dimension(75, 23));
        btnEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditarActionPerformed(evt);
            }
        });

        btnExcluir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/edu/ifnmg/kelvin/fifa/apresentacao/imagens/rubbish7.png"))); // NOI18N
        btnExcluir.setText("Remover");
        btnExcluir.setMaximumSize(new java.awt.Dimension(75, 23));
        btnExcluir.setMinimumSize(new java.awt.Dimension(75, 23));
        btnExcluir.setPreferredSize(new java.awt.Dimension(75, 23));
        btnExcluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExcluirActionPerformed(evt);
            }
        });

        btnRelatorios.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/edu/ifnmg/kelvin/fifa/apresentacao/imagens/file148.png"))); // NOI18N
        btnRelatorios.setText("Relatórios");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnVisualizar, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnNovo, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnEditar, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnExcluir, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnAtualizar, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnRelatorios, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(72, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 339, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnVisualizar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnAtualizar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnNovo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnEditar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnExcluir, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnRelatorios, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pnlDesktopTimes.setLayer(pnlFiltro, javax.swing.JLayeredPane.DEFAULT_LAYER);
        pnlDesktopTimes.setLayer(jPanel1, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout pnlDesktopTimesLayout = new javax.swing.GroupLayout(pnlDesktopTimes);
        pnlDesktopTimes.setLayout(pnlDesktopTimesLayout);
        pnlDesktopTimesLayout.setHorizontalGroup(
            pnlDesktopTimesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlDesktopTimesLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlDesktopTimesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(pnlFiltro, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        pnlDesktopTimesLayout.setVerticalGroup(
            pnlDesktopTimesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlDesktopTimesLayout.createSequentialGroup()
                .addComponent(pnlFiltro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnlDesktopTimes, javax.swing.GroupLayout.Alignment.TRAILING)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnlDesktopTimes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnNovoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNovoActionPerformed
        this.cadastrarTime();
    }//GEN-LAST:event_btnNovoActionPerformed

    private void btnEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnEditarActionPerformed

    private void btnExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExcluirActionPerformed
        this.excluirTime();
    }//GEN-LAST:event_btnExcluirActionPerformed

    private void btnAtualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAtualizarActionPerformed
        try {
            this.carregarTabelaTimes();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro Desconhecido, Contate o Administrador do Sistema!");
        }
    }//GEN-LAST:event_btnAtualizarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAtualizar;
    private javax.swing.JButton btnEditar;
    private javax.swing.JButton btnExcluir;
    private javax.swing.JButton btnNovo;
    private javax.swing.JButton btnPesquisar;
    private javax.swing.JButton btnRelatorios;
    private javax.swing.JButton btnVisualizar;
    private javax.swing.JComboBox<String> cboCodigoTime;
    private javax.swing.JComboBox<String> cboNomeTime;
    private javax.swing.JComboBox<String> cboSiglaPais;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblCodigo;
    private javax.swing.JLabel lblCodigo1;
    private javax.swing.JLabel lblCodigo2;
    private javax.swing.JDesktopPane pnlDesktopTimes;
    private javax.swing.JPanel pnlFiltro;
    private javax.swing.JTable tblResultado;
    // End of variables declaration//GEN-END:variables
    private abstract class ModeloTabelaTimes extends AbstractTableModel{
        @Override
        public String getColumnName(int coluna) {
            if(coluna == 0){
                return "ID";
            }else if(coluna == 1){
                return "Nome";
            }else{
                return "Sigla do País";
            }
        }
 
        @Override
        public int getRowCount(){
            return times.size();
        }
        
        @Override
        public int getColumnCount(){
            return 3;
        }
        
        @Override
        public Object getValueAt(int rowIndex, int columnIndex) {
            Times time = times.get(rowIndex);
            if(columnIndex == 0){
                return time.getCodigo();
            }else if (columnIndex == 1) {
                return time.getNome();
            }else{
                return time.getSigla();
            }
        
        }
    }

}
