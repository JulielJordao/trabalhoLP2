package visao;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Date;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import controle.BLLCadastroCompra;
import entidade.CadastroCompra;

public class TelaFecharPedido extends JFrame {
	private JTextField tfMesa;
	private JTextField tfTelefone;
	private JTextField tfCod;
	private String mensagem;
	private int codCompra = 0;
	private BLLCadastroCompra  cadCompra = new BLLCadastroCompra();
	private CadastroCompra cadastroCompra = new CadastroCompra();
	TelaFecharPedido() {
		super("Informa��es finais");
		setSize(388, 230);
		getContentPane().setLayout(null);
		
		tfMesa = new JTextField();
		tfMesa.setBounds(137, 30, 70, 20);
		getContentPane().add(tfMesa);
		tfMesa.setColumns(10);
		
		tfTelefone = new JTextField();
		tfTelefone.setBounds(23, 79, 184, 20);
		getContentPane().add(tfTelefone);
		tfTelefone.setColumns(10);
		
		tfCod = new JTextField();
		tfCod.setBounds(23, 30, 86, 20);
		getContentPane().add(tfCod);
		tfCod.setColumns(10);
		
		JLabel lblCdigo = new JLabel("C\u00F3digo");
		lblCdigo.setBounds(23, 11, 46, 14);
		getContentPane().add(lblCdigo);
		
		JLabel lblinsiraOCdigo = new JLabel("*Insira o c\u00F3digo gerado de pedidos anteriores ou insira");
		lblinsiraOCdigo.setBounds(22, 110, 362, 14);
		getContentPane().add(lblinsiraOCdigo);
		
		JLabel lblMesa = new JLabel("Mesa");
		lblMesa.setBounds(137, 11, 46, 14);
		getContentPane().add(lblMesa);
		
		JLabel lblTelefone = new JLabel("Telefone*");
		lblTelefone.setBounds(23, 61, 75, 14);
		getContentPane().add(lblTelefone);
		
		JButton btnConfirmarDados = new JButton("Confirmar Dados");
		btnConfirmarDados.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				setVisible(false);
				JOptionPane.showMessageDialog(null, mensagem);
				
				cadastroCompra.setCod_esp(gerarCodAleatorio());
				System.out.println(cadastroCompra.getCod_esp());
				cadastroCompra.setTelefone(Long.parseLong(tfTelefone.getText()));
				System.out.println("O c�digo do seu pedido �:"+codCompra);
				cadastroCompra.setMesa(Integer.parseInt(tfMesa.getText()));
				cadastroCompra.setDatPedido(new Date(System.currentTimeMillis()));
				cadCompra.salvar(cadastroCompra);
			}
		});
		btnConfirmarDados.setBounds(197, 152, 159, 23);
		getContentPane().add(btnConfirmarDados);
		
		JLabel lblCompraOuCadastre = new JLabel("um novo telefone para se gerar um novo c\u00F3digo de cadastro!");
		lblCompraOuCadastre.setBounds(23, 127, 344, 14);
		getContentPane().add(lblCompraOuCadastre);
		
		JButton btnGerarPorCodigo = new JButton("Gerar por C\u00F3digo");
		btnGerarPorCodigo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnGerarPorCodigo.setBounds(23, 152, 160, 23);
		getContentPane().add(btnGerarPorCodigo);
			
	}
	
	protected long g() {
		// TODO Auto-generated method stub
		return 0;
	}

	public void setMensagem(String msg){
		mensagem = msg;
	}
	
	public String gerarCodAleatorio(){
		double valor = 0;
		valor = Math.random()*500000;
		long vlr = (long)(valor + 10000);
		System.out.println(valor);
		System.out.println(vlr);
		String codigo = Long.toHexString(vlr);
		return codigo;
	}
	
	public void setCodCompra(int codigo){
		codCompra = codigo;
	}
	
	
}