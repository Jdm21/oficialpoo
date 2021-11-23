import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.ListSelectionModel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import java.awt.Color;
import javax.swing.ImageIcon;
import java.awt.Toolkit;

public class TelaCampeonatoListagem extends JFrame {

	private JPanel contentPane;
	private campeonatoRepositorio campRepo;
	private JTable tblFisic;

	
	public TelaCampeonatoListagem(campeonatoRepositorio campRepo) {
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\KINHO\\Downloads\\WhatsApp Image 2021-11-22 at 15.27.47.jpeg"));
		this.campRepo = campRepo;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 861, 385);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnTelaCadastro = new JButton("Cadastrar Fisiculturista");
		btnTelaCadastro.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TelaCampeonatoCadastro telaCampeonatoCadastro = new TelaCampeonatoCadastro(campRepo);
				telaCampeonatoCadastro.addWindowListener(new WindowAdapter() {
					@Override
					public void windowClosed(WindowEvent e) {
						listarCamp();
					}
				});
				telaCampeonatoCadastro.setVisible(true);
			}
		});
		btnTelaCadastro.setBounds(643, 80, 174, 37);
		contentPane.add(btnTelaCadastro);
		
		JScrollPane scrFisic = new JScrollPane();
		scrFisic.setBounds(10, 20, 591, 315);
		contentPane.add(scrFisic);
		
		tblFisic = new JTable();
		tblFisic.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		tblFisic.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"ID", "Categoria", "Nome", "Idade", "Federacao", "Peso", "Nacionalidade"
			}
		));
		tblFisic.getColumnModel().getColumn(6).setPreferredWidth(76);
		scrFisic.setViewportView(tblFisic);
		
		JButton btnExcluir = new JButton("Excluir Fisiculturista");
		btnExcluir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int id = (int) tblFisic.getModel().getValueAt(tblFisic.getSelectedRow(), 0);
				//JOptionPane.showMessageDialog(btnExcluir, "Deseja Excluir?");
				
				campRepo.excluir(id);
				listarCamp();
				
				
				
			}
		});
		btnExcluir.setBounds(643, 20, 174, 37);
		contentPane.add(btnExcluir);
	
		JButton btnTelaEdicao = new JButton("Editar Fisiculturista");
		btnTelaEdicao.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int id = (int) tblFisic.getModel().getValueAt(tblFisic.getSelectedRow(), 0);
				TelaCampeonatoEdicao telaCampeonatoEdicao = new TelaCampeonatoEdicao(campRepo, id);
				telaCampeonatoEdicao.addWindowListener(new WindowAdapter() {
					@Override
					public void windowClosed(WindowEvent e) {
						listarCamp();
					}
				});
				telaCampeonatoEdicao.setVisible(true);
			}
		});	
		btnTelaEdicao.setBounds(643, 139, 174, 37);
		contentPane.add(btnTelaEdicao);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\KINHO\\Downloads\\WhatsApp Image 2021-11-22 at 15.18.19 (1).jpeg"));
		lblNewLabel.setBounds(643, 187, 174, 148);
		contentPane.add(lblNewLabel);
		
		
		
		this.listarCamp();
		
	
	}
	
	public void listarCamp() {
		ArrayList<campeonato> modalidades = this.campRepo.listar();
		DefaultTableModel model = (DefaultTableModel) tblFisic.getModel();
		model.setRowCount(0);
		for(campeonato campeonato: modalidades) {
				model.addRow(new Object[] {
						campeonato.getId(),
						campeonato.getCategoria(),
						campeonato.getNome(),
						campeonato.getIdade(),
						campeonato.getFederacao(),
						campeonato.getPeso(),
						campeonato.getNacionalidade()
				});
		}
	}
}
