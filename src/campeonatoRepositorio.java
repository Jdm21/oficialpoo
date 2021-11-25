import java.sql.ResultSet;
import java.util.ArrayList;

import javax.swing.JOptionPane;

public class campeonatoRepositorio {
	private BD bd;
	public campeonatoRepositorio(BD bd) {
		this.bd = bd;
		
	}
     public void cadastrar(campeonato campeonato) {
    	 String query = "INSERT INTO " 
                      + "modalidades "
    			      + "(Nome, Categoria, Idade, Federacao, Peso, Nacionalidade) "
                      + "VALUES "
                      + "('" + campeonato.getNome() +  " ',  "
                      + "'" + campeonato.getCategoria()  + "', " 
                      + "'" + campeonato.getIdade()  +  "', " 
                      + "'" + campeonato.getFederacao()  +  "', "
                      + "'" + campeonato.getPeso()  +  "', "
                      + "'" + campeonato.getNacionalidade()	+  "'); ";		
    	 								
    	 this.bd.executeUpdate(query);
     }
     
     public campeonato obter(int id) {
    	 String query = "SELECT * from modalidades WHERE id = " + id + ";";
    	 ResultSet dados = this.bd.executeQuery(query);
    	 campeonato campeonato = new campeonato();
    			 try {
    				 dados.next();
    				 
    				 campeonato.setId(dados.getInt("id"));
    	             campeonato.setCategoria(dados.getString("Categoria"));
    	             campeonato.setNome(dados.getString("Nome"));
    	             campeonato.setIdade(dados.getString("Idade"));
    	             campeonato.setFederacao(dados.getString("Federacao"));
    	             campeonato.setPeso(dados.getString("Peso"));
    	             campeonato.setNacionalidade(dados.getString("Nacionalidade"));
    			 } catch (Exception e) { 
    			    	System.err.println(e.getMessage());        
    		        }
    			 return campeonato;
     }
     
    public ArrayList<campeonato> listar()  {
       String query = "SELECT * FROM modalidades;";
       this.bd.executeQuery(query);
       ResultSet dados = this.bd.executeQuery(query); 
       ArrayList<campeonato> modalidades = new ArrayList<>();	
        try {
       while(dados.next())  {   	   
             campeonato campeonato = new campeonato();
             campeonato.setId(dados.getInt("id"));
             campeonato.setCategoria(dados.getString("Categoria"));
             campeonato.setNome(dados.getString("Nome"));
             campeonato.setIdade(dados.getString("Idade"));
             campeonato.setFederacao(dados.getString("Federacao"));
             campeonato.setPeso(dados.getString("Peso"));
             campeonato.setNacionalidade(dados.getString("Nacionalidade"));
             
             modalidades.add(campeonato);
             
          	}              
         } catch(Exception e) { 
    	System.err.println(e.getMessage());        
        }
		return modalidades;
        
     }
     
     public void excluir (int id) {
    	 String query = "DELETE FROM modalidades WHERE id = " + id + ";";
    	 this.bd.executeQuery(query);
    	 
     }
	public void editar(campeonato campeonato) {
		String query =        "UPDATE modalidades SET "
							+ "Nome = '"+ campeonato.getNome() + "', "
							+ "Categoria = '" + campeonato.getCategoria() + "', "
							+ "Idade = '" + campeonato.getIdade() + "', "
							+ "Federacao = '" + campeonato.getFederacao() + "', "
							+ "Peso = '" + campeonato.getPeso() + "', "
							+ "Nacionalidade = '" + campeonato.getNacionalidade() + "' "
							+ "WHERE id = " + campeonato.getId() + ";";
		this.bd.executeQuery(query);
		
		
		
	}
}