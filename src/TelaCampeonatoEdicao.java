import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Toolkit;

public class TelaCampeonatoEdicao extends JFrame {

	private JPanel contentPane;
	private campeonatoRepositorio campRepo;
	private JTextField txtCategoria;
	private JTextField txtNome;
	private JTextField txtIdade;
	
	private int id;
	private campeonato campeonato;
	private JTextField txtFederacao;
	private JTextField txtPeso;
	private JTextField txtNacionalidade;
	

	/**
	 * Launch the application.
	 */
	
	

	/**
	 * Create the frame.
	 */
	public TelaCampeonatoEdicao(campeonatoRepositorio campRepo, int id) {
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\KINHO\\Downloads\\WhatsApp Image 2021-11-22 at 15.27.47.jpeg"));
		this.campRepo = campRepo;
		this.id = id;
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 454, 333);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Edicao de Fisiculturista");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(20, 11, 282, 14);
		contentPane.add(lblNewLabel);
		
		JLabel lblCategoria = new JLabel("Categoria:");
		lblCategoria.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblCategoria.setBounds(10, 47, 61, 14);
		contentPane.add(lblCategoria);
		
		JLabel lblNome = new JLabel("Nome:");
		lblNome.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNome.setBounds(10, 71, 51, 14);
		contentPane.add(lblNome);
		
		JLabel lblIdade = new JLabel("Idade:");
		lblIdade.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblIdade.setBounds(10, 96, 46, 14);
		contentPane.add(lblIdade);
		
		txtCategoria = new JTextField();
		txtCategoria.setBounds(77, 44, 206, 20);
		contentPane.add(txtCategoria);
		txtCategoria.setColumns(10);
		
		txtNome = new JTextField();
		txtNome.setBounds(77, 69, 206, 20);
		contentPane.add(txtNome);
		txtNome.setColumns(10);
		
		txtIdade = new JTextField();
		txtIdade.setBounds(77, 94, 33, 20);
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
		btnLimpar.setBounds(194, 260, 89, 23);
		contentPane.add(btnLimpar);
		
		JButton btnEditar = new JButton("Editar");
		btnEditar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {			
                campeonato.setNome(txtNome.getText());
                campeonato.setCategoria(txtCategoria.getText());
                campeonato.setIdade(txtIdade.getText());
                campeonato.setFederacao(txtFederacao.getText());
                campeonato.setPeso(txtPeso.getText());
                campeonato.setNacionalidade(txtNacionalidade.getText());
                
                campRepo.editar(campeonato); 
				JOptionPane.showMessageDialog(btnEditar, "Fisiculturista Editado com Sucesso");
				dispose();
				
				
				
			}
		});
		btnEditar.setBounds(303, 260, 104, 23);
		contentPane.add(btnEditar);
		
		this.campeonato = this.campRepo.obter(this.id);
		txtNome.setText(this.campeonato.getNome());
		txtCategoria.setText(this.campeonato.getCategoria());
		txtIdade.setText(this.campeonato.getIdade());
		
		
		
		
		
		txtFederacao = new JTextField();
		txtFederacao.setBounds(76, 125, 86, 20);
		contentPane.add(txtFederacao);
		txtFederacao.setColumns(10);
		
		txtPeso = new JTextField();
		txtPeso.setBounds(77, 156, 86, 20);
		contentPane.add(txtPeso);
		txtPeso.setColumns(10);
		
		JLabel lblFederacao = new JLabel("Federacao");
		lblFederacao.setBounds(10, 128, 61, 14);
		contentPane.add(lblFederacao);
		
		JLabel lblPeso = new JLabel("Peso:");
		lblPeso.setBounds(10, 159, 46, 14);
		contentPane.add(lblPeso);
		
		txtNacionalidade = new JTextField();
		txtNacionalidade.setBounds(96, 187, 86, 20);
		contentPane.add(txtNacionalidade);
		txtNacionalidade.setColumns(10);
		
		JLabel lblNacionalidade = new JLabel("Nacionalidade:");
		lblNacionalidade.setBounds(10, 190, 76, 14);
		contentPane.add(lblNacionalidade);
		
		
		
	}
}
