
public class Fisic {

	public static void main(String[] args) {
		BD bd = new BD();
				bd.conectar();
				
				campeonatoRepositorio campRepo = new campeonatoRepositorio(bd);
				
				
				
				
				TelaCampeonatoListagem telaCampeonatoListagem = new TelaCampeonatoListagem(campRepo);
				telaCampeonatoListagem.setVisible(true);
				
				
	}

}
