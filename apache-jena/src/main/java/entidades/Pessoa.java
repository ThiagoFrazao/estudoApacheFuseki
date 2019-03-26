package entidades;

import java.lang.reflect.Field;
import java.util.List;

import org.apache.jena.query.QuerySolution;

public class Pessoa extends EntidadeRDF {
	
	private String id;
	private String nome;
	private String imagem;
	private String sexo;
	private String corOlhos;
	private String corPele;
	private String corCabelo;	
	private String tipoFisico;
	private String transtornoMental;
	private String dataNascimento;
	private String marcaCaracteristica;
	private String informacoes;
	private String fonte;
	private String boletimOcorrencia;	
	private String pesoAproximado;
	private String alturaAproximada;
	
	public Pessoa(){
		
	}
	
	public Pessoa(String id, String nome, String imagem, String sexo, String olhos, String corPele,  
			      String corCabelo,  String tipoFisico, String transtornoMental, String nascimento, 
			      String informacoes, String pesoAproximado, String alturaAproximada, 
			      String marcaCaracteristica, String fonte, String boletimOcorrencia){	
		this.id = id;
		this.nome = nome;
		this.imagem = imagem;
		this.sexo = sexo;
		this.corOlhos = olhos;
		this.corPele = corPele;
		this.corCabelo = corCabelo;
		this.tipoFisico = tipoFisico;
		this.transtornoMental = transtornoMental;
		this.dataNascimento = nascimento;
		this.informacoes = informacoes;
		this.pesoAproximado = pesoAproximado;
		this.alturaAproximada = alturaAproximada;
		this.marcaCaracteristica = marcaCaracteristica;
		this.fonte = fonte;
		this.boletimOcorrencia = boletimOcorrencia;		
	}
	
	public String namedIndividualForm(String nomeIndividuo) throws IllegalArgumentException, IllegalAccessException{		
		StringBuilder str = new StringBuilder();
		
		str.append("<owl:NamedIndividual rdf:about=\"http://ontologiarelembrar.github.io/ontologiarelembrar#"
		                   + nomeIndividuo  +"\">\n");
		str.append("<rdf:type rdf:resource=\"http://ontologiarelembrar.github.io/ontologiarelembrar#"
		                   + this.getClass().getSimpleName() +"\"/>\n");		
		
		for(Field field : this.getClass().getDeclaredFields()){			
			str.append("<"+field.getName()+">" + field.get(this) + "</"+field.getName()+">\n");			
		}		
		str.append("</owl:NamedIndividual>\n");	
		
		return str.toString();
	}
	
	@Override
	public String rdfForm(String rdfName) throws IllegalArgumentException, IllegalAccessException {
		StringBuilder str = new StringBuilder();
		
		//str.append("<"+ Ontologia.uriBaseOnt +":Pessoa rdf:about=\"http://ontologiarelembrar.github.io/ontologiarelembrar#"+ rdfName + "\">");
		str.append("<ontologiarelembrar:Pessoa rdf:about=\"http://ontologiarelembrar.github.io/ontologiarelembrar#"+ rdfName + "\">");
		for(Field field : this.getClass().getDeclaredFields()){
			str.append(" <ontologiarelembrar:"+field.getName()+">"+field.get(this)+"</ontologiarelembrar:"+field.getName()+">");
		}		
		str.append("<rdf:type rdf:resource=\"http://www.w3.org/2002/07/owl#NamedIndividual\"/>");
		str.append("</ontologiarelembrar:Pessoa>");
		return str.toString();
	}		
	
	@Override
	public Pessoa fromQueryList(List<QuerySolution> qsList){		
		Pessoa retorno = new Pessoa();
		
		retorno.setNome(qsList.get(0).getLiteral("objeto").toString());		
		retorno.setImagemBase64(qsList.get(1).getLiteral("objeto").toString());
		retorno.setAlturaAproximada(qsList.get(2).getLiteral("objeto").toString());
		retorno.setPesoAproximado(qsList.get(3).getLiteral("objeto").toString());
		retorno.setCorPele(qsList.get(4).getLiteral("objeto").toString());
		retorno.setCorCabelo(qsList.get(5).getLiteral("objeto").toString());
		retorno.setOlhos(qsList.get(6).getLiteral("objeto").toString());
		retorno.setSexo(qsList.get(7).getLiteral("objeto").toString());
		retorno.setTipoFisico(qsList.get(8).getLiteral("objeto").toString());
		retorno.setTranstornoMental(qsList.get(10).getLiteral("objeto").toString());
		retorno.setInformacoes(qsList.get(11).getLiteral("objeto").toString());
		retorno.setMarcaCaracteristica(qsList.get(12).getLiteral("objeto").toString());
		retorno.setNascimento(qsList.get(13).getLiteral("objeto").toString());			
		
		return retorno;
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
		return imagem;
	}
	public void setImagemBase64(String imagemBase64) {
		this.imagem = imagemBase64;
	}
	public String getSexo() {
		return sexo;
	}
	public void setSexo(String sexo) {
		this.sexo = sexo;
	}
	public String getOlhos() {
		return corOlhos;
	}
	public void setOlhos(String olhos) {
		this.corOlhos = olhos;
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
		return dataNascimento;
	}
	public void setNascimento(String nascimento) {
		this.dataNascimento = nascimento;
	}
	public String getMarcaCaracteristica() {
		return marcaCaracteristica;
	}
	public void setMarcaCaracteristica(String marcaCaracteristica) {
		this.marcaCaracteristica = marcaCaracteristica;
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
	
	@Override
	public String toString(){		
		StringBuilder str = new StringBuilder();
		
		str.append("Nome: "                  + this.getNome() + " \n");
		str.append("Imagem: "                + this.getImagemBase64() + " \n");
		str.append("Altura Aproximada: "      + this.getAlturaAproximada() + " \n");
		str.append("Peso Aproximado: "        + this.getPesoAproximado() + " \n");
		str.append("Cor Pele: "              + this.getCorPele() + " \n");
		str.append("Cor Cabelo: "            + this.getCorCabelo() + " \n");
		str.append("Cor Olhos: "             + this.getOlhos() + " \n");
		str.append("Sexo: "                  + this.getSexo() + " \n");
		str.append("Tipo Fisico: "           + this.getTipoFisico() + " \n");
		str.append("Transtorno Mental: "     + this.getTranstornoMental() + " \n");
		str.append("Informacoes: "           + this.getInformacoes() + " \n");
		str.append("Marca Caracteristicas: " + this.getMarcaCaracteristica() + " \n");
		str.append("Data de Nascimento: "    + this.getNascimento() + " \n");
		
		return str.toString();		
	}

	
}
