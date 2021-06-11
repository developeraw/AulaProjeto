/*
 * Autor______: Alexandre Stürmer Wolf
 * Utilidade__: Executar consultas SQL
 * Data_______: 28/05/2021
 * Dicas______: So chamar
 */
package aulaprojeto;

import java.awt.Toolkit;
import java.sql.*;
import java.util.Vector;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author wolfi
 */
public class MinhaTela extends javax.swing.JFrame {

    public MinhaTela() {
        initComponents();

        setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("pessoas.jpg")));

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jFileChooser1 = new javax.swing.JFileChooser();
        tfConsultaSQL = new javax.swing.JTextField();
        spDadosConsulta = new javax.swing.JScrollPane();
        tbDadosConsulta = new javax.swing.JTable();
        btConsultar = new javax.swing.JButton();
        btFechar = new javax.swing.JButton();
        mbMenu = new javax.swing.JMenuBar();
        mmFile = new javax.swing.JMenu();
        miTelaCadastro = new javax.swing.JMenuItem();
        miCadastroBanco = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Consultador SQL");

        tbDadosConsulta.setModel(new javax.swing.table.DefaultTableModel(
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
        spDadosConsulta.setViewportView(tbDadosConsulta);

        btConsultar.setMnemonic('E');
        btConsultar.setText("Executar");
        btConsultar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btConsultarActionPerformed(evt);
            }
        });

        btFechar.setMnemonic('F');
        btFechar.setText("Fechar");
        btFechar.setToolTipText("Digite uma consulta SQL");
        btFechar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btFecharActionPerformed(evt);
            }
        });

        mmFile.setText("File");

        miTelaCadastro.setText("Tela Simula Cadastro Simples ");
        miTelaCadastro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                miTelaCadastroActionPerformed(evt);
            }
        });
        mmFile.add(miTelaCadastro);

        miCadastroBanco.setText("TelaCadastroBanco");
        miCadastroBanco.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                miCadastroBancoActionPerformed(evt);
            }
        });
        mmFile.add(miCadastroBanco);

        mbMenu.add(mmFile);

        jMenu2.setText("Edit");
        mbMenu.add(jMenu2);

        setJMenuBar(mbMenu);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(tfConsultaSQL)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btConsultar))
            .addGroup(layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(btFechar))
            .addComponent(spDadosConsulta, javax.swing.GroupLayout.DEFAULT_SIZE, 686, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tfConsultaSQL, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btConsultar))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(spDadosConsulta, javax.swing.GroupLayout.DEFAULT_SIZE, 390, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btFechar))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btFecharActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btFecharActionPerformed
        dispose();
    }//GEN-LAST:event_btFecharActionPerformed

    private void btConsultarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btConsultarActionPerformed

        /*
        String dados[][] = {
            {"1", "nabo", "10.00"},
            {"2", "rabanete", "20.00"},
            {"3", "linguica", "40.00"},
        };
        
        String cabecalho[] = { "Codigo", "Elemento", "Preço"};
        
        tbDadosConsulta.setModel(new DefaultTableModel(dados, cabecalho));
         */
 /*
        Vector cabecalho = new Vector();
        cabecalho.add("Codigo");
        cabecalho.add("Elemento");
        cabecalho.add("Preco");
        
        Vector linhas = new Vector();
        
        Vector colunas = new Vector();
        
        colunas.add("1");
        colunas.add("nabo");
        colunas.add("10.00");
        
        linhas.add(new Vector(colunas));
        
        colunas = new Vector();
        colunas.add("2");
        colunas.add("rabanete");
        colunas.add("40.00");
        
        linhas.add(new Vector(colunas));
        
        tbDadosConsulta.setModel(new DefaultTableModel(linhas, cabecalho));
         */
        Database data = new Database();
        if (data.conecta()) {
            try {

                Connection conexao = data.getConexao();
                Statement st = conexao.createStatement();

                if (tfConsultaSQL.getText().toUpperCase().startsWith("SELECT")) {

                    ResultSet rs = st.executeQuery(tfConsultaSQL.getText());
                    Vector cabecalho = new Vector();

                    for (int i = 1; i <= rs.getMetaData().getColumnCount(); i++) {
                        cabecalho.add(rs.getMetaData().getColumnName(i));
                    }

                    Vector linhas = new Vector();
                    while (rs.next()) {
                        Vector colunas = new Vector();
                        for (int i = 1; i <= rs.getMetaData().getColumnCount(); i++) {
                            colunas.add(rs.getString(i));
                        }
                        linhas.add(new Vector(colunas));
                    }
                    tbDadosConsulta.setModel(new DefaultTableModel(linhas, cabecalho));
                    
                } else {
                    st.execute(tfConsultaSQL.getText());
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

    }//GEN-LAST:event_btConsultarActionPerformed

    private void miTelaCadastroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_miTelaCadastroActionPerformed
        TelaSimulaCadastro tela = new TelaSimulaCadastro();
        tela.setVisible(true);
    }//GEN-LAST:event_miTelaCadastroActionPerformed

    private void miCadastroBancoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_miCadastroBancoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_miCadastroBancoActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btConsultar;
    private javax.swing.JButton btFechar;
    private javax.swing.JFileChooser jFileChooser1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuBar mbMenu;
    private javax.swing.JMenuItem miCadastroBanco;
    private javax.swing.JMenuItem miTelaCadastro;
    private javax.swing.JMenu mmFile;
    private javax.swing.JScrollPane spDadosConsulta;
    private javax.swing.JTable tbDadosConsulta;
    private javax.swing.JTextField tfConsultaSQL;
    // End of variables declaration//GEN-END:variables
}
