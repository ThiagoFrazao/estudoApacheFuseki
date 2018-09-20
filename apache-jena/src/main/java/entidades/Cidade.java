package entidades;

import jena.Ontologia;

public class Cidade extends EntidadeRDF {
	
	private int id;
	private Estado estado;
	
	@Override
	public String rdfForm() {
		StringBuilder str = new StringBuilder();
		
		String uri = Ontologia.uriBaseOnt + "Cidade-ID" + this.getId() + ">";		
		String uriEstado  = Ontologia.uriBaseOnt + "Estado-ID" + this.getEstado().getId() + ">";
		
		str.append(uri + " remember:nomeCidade \""    + this.getNome() + "\" . ");
		str.append(uri + " remember:estaAssociado \"" + uriEstado + "\" . ");
				
		return str.toString();
	}
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Estado getEstado() {
		return estado;
	}
	public void setEstado(Estado estado) {
		this.estado = estado;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	private String nome;

}
