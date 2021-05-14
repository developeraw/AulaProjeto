/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aulaprojeto;

import javax.swing.JOptionPane;

/**
 *
 * @author wolfi
 */
public class Mess {

    /**
     * Permite mostrar mensagens na tela com dialogs
     *
     * @param titulo mensagem a ser exibida na barra de título
     * @param mensagem o que é para mostrar dentro da caixa de diálogo
     * @param tipo tipo de mensagem a ser exibida, usado o padrão JOptionPane.
     */
    private static void mens(String titulo, String mensagem, int tipo) {
        JOptionPane.showMessageDialog(null, mensagem, titulo, tipo);
    }

    /**
     * Permite exibir uma mensagem de erro na tela em um <b>dialog box</b>
     *
     * @param mensagem informação a ser exibida na tela
     */
    public static void error(String mensagem) {
        mens("Erro", mensagem, JOptionPane.ERROR_MESSAGE);
    }

    /**
     * Permite exibir uma mensagem de erro na tela em um <b>dialog box</b>
     *
     * @param mensagem informação a ser exibida na tela
     */
    public static void info(String mensagem) {
        mens("Informação", mensagem, JOptionPane.INFORMATION_MESSAGE);
    }

    /**
     * Permite exibir uma mensagem de erro na tela em um <b>dialog box</b>
     *
     * @param mensagem informação a ser exibida na tela
     */
    public static void aviso(String mensagem) {
        mens("Aviso", mensagem, JOptionPane.WARNING_MESSAGE);
    }

    /**
     * Permite solicitar ao usuário a confirmação de um processo (possui as
     * opções YES, NO)
     *
     * @param mensagem informação a ser exibida na tela
     * @return um valor verdadeiro ou um valor falso (boolean)
     */
    public static boolean confirma(String mensagem) {
        return JOptionPane.showConfirmDialog(null, mensagem, "Confirmar", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION;
    }
}
