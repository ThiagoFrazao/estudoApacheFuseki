package entidades;

import jena.Ontologia;

public class Pessoa extends EntidadeRDF {
	
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
	
	public Pessoa(){
		
	}
	
	public Pessoa(int id, String nome, String imagem, String sexo, String olhos, String corPele,  
			      String corCabelo,  String tipoFisico, String transtornoMental, String nascimento, 
			      String status, String informacoes, String pesoAproximado, String alturaAproximada, 
			      String marcaCaracteristica, String fonte, String boletimOcorrencia){
		
		this.nome = nome;
		this.imagemBase64 = imagem;
		this.sexo = sexo;
		this.olhos = olhos;
		this.corPele = corPele;
		this.corCabelo = corCabelo;
		this.tipoFisico = tipoFisico;
		this.transtornoMental = transtornoMental;
		this.nascimento = nascimento;
		this.status = status;
		this.informacoes = informacoes;
		this.pesoAproximado = pesoAproximado;
		this.alturaAproximada = alturaAproximada;
		this.marcaCaracteristica = marcaCaracteristica;
		this.fonte = fonte;
		this.boletimOcorrencia = boletimOcorrencia;
		
	}
	
	@Override
	public String rdfForm(){		
		StringBuilder str = new StringBuilder();
		
		String uri = Ontologia.uriBaseOnt + "Pessoa-ID" + this.getId() + ">";
		System.out.println(this.getNome());
		str.append(uri + " remember:nome \""             	  + this.getNome() + "\" . ");
		str.append(uri + " remember:imagem \""           	  + this.getImagemBase64() + "\" . ");
		str.append(uri + " remember:alturaAproximada \"" 	  + this.getAlturaAproximada() + "\" . ");
		str.append(uri + " remember:pesoAproximado \"" 	      + this.getPesoAproximado() + "\" . ");
		str.append(uri + " remember:corPele \"" 			  + this.getCorPele() + "\" . ");
		str.append(uri + " remember:corCabelo \""             + this.getCorCabelo() + "\" . ");
		str.append(uri + " remember:corOlhos \""              + this.getOlhos() + "\" . ");
		str.append(uri + " remember:sexo \""                  + this.getSexo() + "\" . ");
		str.append(uri + " remember:tipoFisico \""            + this.getTipoFisico() + "\" . ");
		str.append(uri + " remember:status \""                + this.getStatus() + "\" . ");
		str.append(uri + " remember:transtornoMental \""      + this.getTranstornoMental() + "\" . ");
		str.append(uri + " remember:informacoes \""           + this.getInformacoes() + "\" . ");
		str.append(uri + " remember:marcaCaracteristica \""   + this.getMarcaCaracteristica() + "\" . ");
		str.append(uri + " remember:dataNascimento \"" 	      + this.getNascimento() + "\" . ");	
				
		return str.toString();
	}
	
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
	
	
}
