package db;

public class PessoaDB {
	
	
	
	
	
	
/*	
	public List<Pessoa> recuperarPessoas(){
		Pessoa pessoa;
		List<Pessoa> pessoas = new ArrayList<Pessoa>();
		String sql = "select * from PESSOA";		
		
		try {
			Connection con = ConnectionFactory.gerarConexao();
			PreparedStatement stmt = con.prepareStatement(sql);
			ResultSet rs = stmt.executeQuery();
			
			while(rs.next()){
				pessoa = new Pessoa();
				pessoa.setId(rs.getString(1));
				pessoa.setNome(rs.getString(2));
				pessoa.setImagemBase64(rs.getString(3));
				pessoa.setSexo(rs.getString(4));
				pessoa.setOlhos(rs.getString(5));
				pessoa.setCorPele(rs.getString(6));
				pessoa.setCorCabelo(rs.getString(7));	
				pessoa.setPesoAproximado(rs.getString(8));
				pessoa.setAlturaAproximada(rs.getString(9));
				pessoa.setTipoFisico(rs.getString(10));
				pessoa.setTranstornoMental(rs.getString(11));
		        pessoa.setStatus(rs.getString(12));
		        pessoa.setInformacoes(rs.getString(13));
		        pessoa.setFonte(rs.getString(14));
		        pessoa.setBoletimOcorrencia(rs.getString(15));	
		        pessoa.setPesoAproximado(rs.getString(16));
		        pessoa.setAlturaAproximada(rs.getString(17));
			}
			rs.close();
			stmt.close();			
			con.close();			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
		return pessoas;
	}
	*/

}
