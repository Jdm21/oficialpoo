import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Toolkit;

public class TelaCampeonatoCadastro extends JFrame {

	private JPanel contentPane;
	private campeonatoRepositorio campRepo;
	private JTextField txtCategoria;
	private JTextField txtNome;
	private JTextField txtIdade;
	private JTextField txtFederacao;
	private JTextField txtPeso;
	private JTextField txtNacionalidade;
	

	/**
	 * Launch the application.
	 */
	
	

	/**
	 * Create the frame.
	 */
	public TelaCampeonatoCadastro(campeonatoRepositorio campRepo) {
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\KINHO\\Downloads\\WhatsApp Image 2021-11-22 at 15.27.47.jpeg"));
		this.campRepo = campRepo;
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 406, 319);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Fisiculturista");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(10, 11, 282, 14);
		contentPane.add(lblNewLabel);
		
		JLabel lblCategoria = new JLabel("Categoria:");
		lblCategoria.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblCategoria.setBounds(10, 36, 61, 14);
		contentPane.add(lblCategoria);
		
		JLabel lblNome = new JLabel("Nome:");
		lblNome.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNome.setBounds(10, 61, 51, 14);
		contentPane.add(lblNome);
		
		JLabel lblIdade = new JLabel("Idade:");
		lblIdade.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblIdade.setBounds(10, 86, 46, 14);
		contentPane.add(lblIdade);
		
		txtCategoria = new JTextField();
		txtCategoria.setBounds(81, 34, 206, 20);
		contentPane.add(txtCategoria);
		txtCategoria.setColumns(10);
		
		txtNome = new JTextField();
		txtNome.setBounds(71, 59, 206, 20);
		contentPane.add(txtNome);
		txtNome.setColumns(10);
		
		txtIdade = new JTextField();
		txtIdade.setBounds(66, 84, 33, 20);
		contentPane.add(txtIdade);
		txtIdade.setColumns(10);
		
		JButton btnLimpar = new JButton("Limpar Tela");
		btnLimpar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txtNome.setText("");
				txtCategoria.setText("");
				txtIdade.setText("");
				txtFederacao.setText("");
				txtPeso.setText("");
				txtNacionalidade.setText("");
			}
		});
		btnLimpar.setBounds(141, 246, 89, 23);
		contentPane.add(btnLimpar);
		
		JButton btnCadastrar = new JButton("Cadastrar");
		btnCadastrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
                campeonato campeonato = new campeonato();
                
				campeonato.setNome(txtNome.getText());
				campeonato.setCategoria(txtCategoria.getText());
				campeonato.setIdade(txtIdade.getText());
				campeonato.setFederacao(txtFederacao.getText());
				campeonato.setPeso(txtPeso.getText());
				campeonato.setNacionalidade(txtNacionalidade.getText());
				
				campRepo.cadastrar(campeonato);
				JOptionPane.showMessageDialog(btnCadastrar, "Fisiculturista Cadastrado com Sucesso");
				dispose();
				
				
				
			}
		});
		btnCadastrar.setBounds(256, 246, 104, 23);
		contentPane.add(btnCadastrar);
		
		JLabel lblFederacao = new JLabel("Federacao:");
		lblFederacao.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblFederacao.setBounds(10, 111, 65, 14);
		contentPane.add(lblFederacao);
		
		txtFederacao = new JTextField();
		txtFederacao.setBounds(88, 109, 86, 20);
		contentPane.add(txtFederacao);
		txtFederacao.setColumns(10);
		
		JLabel lblPeso = new JLabel("Peso:");
		lblPeso.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblPeso.setBounds(10, 139, 46, 14);
		contentPane.add(lblPeso);
		
		txtPeso = new JTextField();
		txtPeso.setBounds(51, 136, 86, 20);
		contentPane.add(txtPeso);
		txtPeso.setColumns(10);
		
		JLabel lblNacionalidade = new JLabel("Nacionalidade:");
		lblNacionalidade.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNacionalidade.setBounds(10, 167, 92, 14);
		contentPane.add(lblNacionalidade);
		
		txtNacionalidade = new JTextField();
		txtNacionalidade.setBounds(120, 165, 110, 20);
		contentPane.add(txtNacionalidade);
		txtNacionalidade.setColumns(10);
	}
}
