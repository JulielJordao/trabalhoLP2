package visao;

import java.awt.GridLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

/**
 * @author Rosicléia Frasson
 */
public class TabelaPedido extends JFrame {
	JPanel painelFundo;
	JTable tabela;
	JTable tabela2;
	JScrollPane barraRolagem;

	Object[][] dados;

	String[] colunas = { "Pedido", "Itens", "Hora do pedido" };

	public TabelaPedido() {
		super("Pedido");
		tabela = new JTable(dados, colunas);
	}

	public void criaJanela() {
		
		painelFundo = new JPanel();
		painelFundo.setLayout(new GridLayout(1, 1));
		tabela = new JTable(dados, colunas);
		barraRolagem = new JScrollPane(tabela);
		painelFundo.add(barraRolagem);

		getContentPane().add(painelFundo);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setSize(500, 120);
		painelFundo.add(tabela);
		setVisible(true);
	}

	public static void main(String[] args) {
		TabelaPedido lc = new TabelaPedido();
		lc.criaJanela();
	}
}