package entidades;

import java.util.List;

import org.apache.jena.query.QuerySolution;

import jena.Ontologia;

public class Desaparecimento extends EntidadeRDF {
	
	private int id;
	private String fonte;
	private String dataDesaparecimento;
	private Pessoa pessoa;
	private Local localDesaparecimento;
	
	@Override
	public String rdfForm() {
		
		StringBuilder str = new StringBuilder();
		
		String uri = Ontologia.uriBaseOnt + "Desaparecimento-ID" + this.getId() + ">";
		String uriPessoa = Ontologia.uriBaseOnt + "Pessoa-ID" + this.getPessoa().getId() + ">";
		String uriLocal  = Ontologia.uriBaseOnt + "Local-ID" + this.getLocalDesaparecimento().getId() + ">";
		
		str.append(uri + " remember:dataDesaparecimento \"" + this.getLocalDesaparecimento() + "\" . ");
		str.append(uri + " remember:fonte \""               + this.getFonte() + "\" . ");
		str.append(uri + " remember:estaAssociado \""       + uriPessoa + "\" . ");
		str.append(uri + " remember:estaAssociado \""       + uriLocal + "\" . ");
				
		return str.toString();
	}
	
	@Override
	public EntidadeRDF fromQueryList(List<QuerySolution> qsList) {
		// TODO Auto-generated method stub
		return null;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getFonte() {
		return fonte;
	}
	public void setFonte(String fonte) {
		this.fonte = fonte;
	}
	public String getDataDesaparecimento() {
		return dataDesaparecimento;
	}
	public void setDataDesaparecimento(String dataDesaparecimento) {
		this.dataDesaparecimento = dataDesaparecimento;
	}
	public Pessoa getPessoa() {
		return pessoa;
	}
	public void setPessoa(Pessoa pessoa) {
		this.pessoa = pessoa;
	}
	public Local getLocalDesaparecimento() {
		return localDesaparecimento;
	}
	public void setLocalDesaparecimento(Local localDesaparecimento) {
		this.localDesaparecimento = localDesaparecimento;
	}
}
