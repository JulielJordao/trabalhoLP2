package visao;

import javax.swing.JFrame;
import javax.swing.JTable;

import controle.BLLItemPedido;
import entidade.ItemPedido;

import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JScrollBar;

public class PainelAdministrativo extends JFrame {
	
	public PainelAdministrativo() {
		super("Painel Administrativo");
		getContentPane().setLayout(null);
		String[] colunas = { "Pedido", "Itens", "Código do Item" };
		ArrayList<ItemPedido> it = new ArrayList<>();
		BLLItemPedido obterPedidos = new BLLItemPedido();
		it = obterPedidos.listar();
		setSize(478,320);
		String[][] itens = new String[3][500];
		int coluna = 0;
		int linha = 0;
		for(ItemPedido item_pedido : it){
			if(coluna == 0){
			itens[coluna][linha] = item_pedido.getCod_pedido()+"";
			}else if(coluna == 1){
				itens[coluna][linha] = item_pedido.getTipo()+"";
			}
			
			
			else if(coluna == 2){
				itens[coluna][linha] = item_pedido.getCod_item()+"";
			}
						
		};
		
		JTable tabAdministrativo = new JTable();
		tabAdministrativo.setModel(new javax.swing.table.DefaultTableModel(itens,colunas));
	
		tabAdministrativo.setBounds(10, 68, 412, 96);
		getContentPane().add(tabAdministrativo);
		JButton btnModficarEntregues = new JButton("Modificar Entregues");
		btnModficarEntregues.setBounds(256, 233, 166, 23);
		getContentPane().add(btnModficarEntregues);
		
		JScrollBar scrollBar = new JScrollBar();
		scrollBar.setBounds(402, 68, 17, 91);
		getContentPane().add(scrollBar);
		
		JButton btnAtualizar = new JButton("Atualizar");
		btnAtualizar.setBounds(102, 233, 89, 23);
		getContentPane().add(btnAtualizar);
	}
	
	public static void main(String args[]){
		new PainelAdministrativo().setVisible(true);;
		
	}
}
