/*
 * Autor______: Alexandre Stürmer Wolf
 * Utilidade__: Demostrar o processo de conexão com o banco de dados
 * Data_______: 14/05/2021
 * Dicas______: Lembrar de colocar o arquivo jar do conector JDBC junto ao projeto
 *              ou no caso do NetBeans -> clique direto sobre bibliotecas, adicionar
 *              postgres, mysql ... testando
 */
package aulaprojeto;

import java.sql.*;

/**
 *
 * @author wolfi
 */
public class Database {

    private static Connection conexao = null;
    
    public Database() {
        
    }

    public boolean conecta() {
        // ============== Exemplo com postgres ==========================
        String nomeDriver = "org.postgresql.Driver";
        String localBancoDados = "jdbc:postgresql://localhost:5432/postgres";
        String usuario = "postgres";
        String senha = "admin";

        // ============== Exemplo com mysql/mariadb =======================
        //String nomeDriver = "org.mariadb.jdbc.Driver";
        //String localBancoDados = "jdbc:mariadb://localhost:3306/bancodados";
        //String usuario = "root";
        //String senha = "admin";
        try {

            Class.forName(nomeDriver).newInstance();

            conexao = DriverManager.getConnection(localBancoDados, usuario, senha);

        } catch (Exception e) {
            e.printStackTrace();
        }

        return conexao != null;

    }
    
    public Connection getConexao() {
        return conexao;
    }

    public static void main(String[] args) {
        
        Database data = new Database();
        
        try {

            if (data.conecta()) {

                Statement st = conexao.createStatement();

                ResultSet rs = st.executeQuery("SELECT * FROM usuarios");
                
                //st.execute("UPDATE usuarios SET nome ='Juruna' WHERE codigo = 3")
                
                System.out.println();
                
                for (int i = 1; i <= rs.getMetaData().getColumnCount(); i++) {
                    System.out.print(rs.getMetaData().getColumnName(i) + "(" + rs.getMetaData().getColumnTypeName(i) + ")   ");
                }
                
                System.out.println();
                while (rs.next()) {
                    System.out.println(rs.getString(1) + "  " + rs.getString("nome") + "   " + rs.getString(3));
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
