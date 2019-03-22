package entidades;

import java.util.List;

import org.apache.jena.query.QuerySolution;

import jena.Ontologia;

public class Estado extends EntidadeRDF {
	
	private int id;
	private String sigla;
	
	@Override
	public String rdfForm() {
		StringBuilder str = new StringBuilder();
		
		String uri = Ontologia.uriBaseOnt + "Cidade-ID" + this.getId() + ">";		
		
		str.append(uri + " remember:sigla \""    + this.getSigla() + "\" . ");
				
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
	public String getSigla() {
		return sigla;
	}
	public void setSigla(String sigla) {
		this.sigla = sigla;
	}
}
