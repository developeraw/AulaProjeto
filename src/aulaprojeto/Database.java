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

    public static boolean conecta() {
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

    public static void main(String[] args) {
        try {

            if (conecta()) {
                Statement st = conexao.createStatement();
                ResultSet rs = st.executeQuery("SELECT * FROM usuarios");
                
                System.out.println();
                for (int i = 1; i <= rs.getMetaData().getColumnCount(); i++) {
                    System.out.print(rs.getMetaData().getColumnName(i) + "(" + rs.getMetaData().getColumnClassName(i) + ")   ");
                }
                System.out.println();
                while(rs.next()){
                    System.out.println(rs.getString(1) + "  " + rs.getString("nome"));
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
   
}
