package entidades;

public class Pessoa {
	
	private String id;
	private String nome;
	private String imagemBase64;
	private String sexo;
	private String olhos;
	private String corPele;
	private String corCabelo;	
	private String tipoFisico;
	private String transtornoMental;
	private String nascimento;
	private String marcaCaracteristica;
	private String status;
	private String informacoes;
	private String fonte;
	private String boletimOcorrencia;	
	private String pesoAproximado;
	private String alturaAproximada;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getImagemBase64() {
		return imagemBase64;
	}
	public void setImagemBase64(String imagemBase64) {
		this.imagemBase64 = imagemBase64;
	}
	public String getSexo() {
		return sexo;
	}
	public void setSexo(String sexo) {
		this.sexo = sexo;
	}
	public String getOlhos() {
		return olhos;
	}
	public void setOlhos(String olhos) {
		this.olhos = olhos;
	}
	public String getCorPele() {
		return corPele;
	}
	public void setCorPele(String corPele) {
		this.corPele = corPele;
	}
	public String getCorCabelo() {
		return corCabelo;
	}
	public void setCorCabelo(String corCabelo) {
		this.corCabelo = corCabelo;
	}
	public String getTipoFisico() {
		return tipoFisico;
	}
	public void setTipoFisico(String tipoFisico) {
		this.tipoFisico = tipoFisico;
	}
	public String getTranstornoMental() {
		return transtornoMental;
	}
	public void setTranstornoMental(String transtornoMental) {
		this.transtornoMental = transtornoMental;
	}
	public String getNascimento() {
		return nascimento;
	}
	public void setNascimento(String nascimento) {
		this.nascimento = nascimento;
	}
	public String getMarcaCaracteristica() {
		return marcaCaracteristica;
	}
	public void setMarcaCaracteristica(String marcaCaracteristica) {
		this.marcaCaracteristica = marcaCaracteristica;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getInformacoes() {
		return informacoes;
	}
	public void setInformacoes(String informacoes) {
		this.informacoes = informacoes;
	}
	public String getFonte() {
		return fonte;
	}
	public void setFonte(String fonte) {
		this.fonte = fonte;
	}
	public String getBoletimOcorrencia() {
		return boletimOcorrencia;
	}
	public void setBoletimOcorrencia(String boletimOcorrencia) {
		this.boletimOcorrencia = boletimOcorrencia;
	}
	public String getPesoAproximado() {
		return pesoAproximado;
	}
	public void setPesoAproximado(String pesoAproximado) {
		this.pesoAproximado = pesoAproximado;
	}
	public String getAlturaAproximada() {
		return alturaAproximada;
	}
	public void setAlturaAproximada(String alturaAproximada) {
		this.alturaAproximada = alturaAproximada;
	}

/*	public static void main(String[] args) throws FileNotFoundException, SQLException 
	{

	    String nomeArquivo = "D.owl";
		File file = new File(nomeArquivo);
		FileReader reader = new FileReader(file);
		OntModel model = ModelFactory.createOntologyModel();
		model.read(reader,null);
		model.write(System.out, "RDF/XML-ABBREV");
		
		
		//Fazendo conexao com o postgre e pegando todos os atributos de pessoa do banco
		Connection con = null;
	      try {
	         Class.forName("org.postgresql.Driver");
	         con = DriverManager
	            .getConnection("jdbc:postgresql://localhost:5432/postgres",
	            "postgres", "20071992");
	      } catch (Exception e) {
	         e.printStackTrace();
	         System.err.println(e.getClass().getName()+": "+e.getMessage());
	         System.exit(0);
	      }
	      
	      System.out.println("Abri o banco");
	      
	      String query = "select * from myosotis";
	      ResultSet set = con.createStatement().executeQuery(query);
	      Pessoa p = new Pessoa();
	      
	      while(set.next())
	      {
	       
	    	p.id = set.getString("identificador");
	        p.nome = set.getString("nome");
	        p.imagemBase64 = set.getString("imagem");
	        p.sexo = set.getString("sexo");
	        p.olhos = set.getString("olhos");
	        p.corPele = set.getString("cor_da_pele");
	        p.corCabelo = set.getString("cabelo");	
	        p.tipoFisico = set.getString("peso_aproximado");
	        p.transtornoMental = set.getString("altura_aproximada");
	        p.nascimento = set.getString("tipo_fisico");
	        p.marcaCaracteristica = set.getString("transtorno_mental");
	        p.status = set.getString("status");
	        p.informacoes = set.getString("informacoes");
	        p.fonte = set.getString("fonte");
	        p.boletimOcorrencia = set.getString("boletim_ocorrencia");	
	        p.pesoAproximado = set.getString("peso_aproximado");
	        p.alturaAproximada = set.getString("altura_aproximada");
	        
	        
			// Pegando URI da classe pessoa
			String uriPessoa = "http://www.projeto-myosotis.com.br/pessoasdesaparecidas/ontologiaremember#Pessoa";
			
			Iterator iter = model.getProperty(uriPessoa).listProperties();
			
			
			Resource r = model.createResource(uriPessoa).addProperty(,p.nome).
					addProperty("", p.imagemBase64).
					addProperty("", p.sexo).
					addProperty("", p.olhos).
					addProperty("", p.corPele).
					addProperty("", p.corCabelo).
					addProperty("", p.tipoFisico).
					addProperty("", p.transtornoMental).
					addProperty("", p.nascimento).
					addProperty("", p.marcaCaracteristica).
					addProperty("", p.status).
					addProperty("", p.informacoes).
					addProperty("", p.fonte).
					addProperty("", p.boletimOcorrencia).
					addProperty("", p.pesoAproximado).
					addProperty("", p.alturaAproximada);		
			
	      }
	      
	      //model.write(System.out);
		
	}*/
}
