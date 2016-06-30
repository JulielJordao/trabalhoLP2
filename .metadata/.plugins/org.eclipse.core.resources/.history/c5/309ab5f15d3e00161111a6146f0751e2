package visao;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import util.Conexao;
import controle.BLLAcompanhamento;
import controle.BLLBebida;
import controle.BLLItemPedido;
import controle.BLLLanche;
import controle.BLLPedido;
import entidade.Acompanhamento;
import entidade.Bebida;
import entidade.ItemPedido;
import entidade.Lanche;
import entidade.Pedido;

public class TelaCompra extends JFrame {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	JTable pedido = new JTable();
	JTextField valor = new JTextField();
	ImageIcon image = new ImageIcon();
	ArrayList<ItemPedido> ip = new ArrayList<ItemPedido>();
	ArrayList<Bebida> bebida = new ArrayList<Bebida>();
	ArrayList<Lanche> lanche = new ArrayList<Lanche>();
	ArrayList<Acompanhamento> acomp = new ArrayList<Acompanhamento>();
	String temp = "";
	BLLBebida b = new BLLBebida();
	BLLLanche l = new BLLLanche();
	BLLAcompanhamento a = new BLLAcompanhamento();
	BLLPedido gerarPedido = new BLLPedido();
	BLLItemPedido itemPedido = new BLLItemPedido();
	Pedido ped = new Pedido();
	int contBebida = 1;
	int contLanche = 1;
	int contAcomp = 1;
	int numPedido;
	private JTextField ValorConta;
	protected int cont = 0;
	String text;
	JMenuBar menuBar;
	JMenuItem sair;
	JMenu opcoes;
	JMenuItem sobre;
	private JTable table;

	public TelaCompra() {

		super("Lanchone BBurger");

		getContentPane().setLayout(null);
		setSize(715, 502);
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(660, 403, 2, -400);
		getContentPane().add(scrollPane);

		
	}

	public static void main(String args[]) {
		new Principal();
	}
	
	
}
