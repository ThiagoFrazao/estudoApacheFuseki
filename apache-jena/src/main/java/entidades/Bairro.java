package entidades;

import jena.Ontologia;

public class Bairro extends EntidadeRDF{
	private int id;
	private Cidade cidade;
	private String nome;
	
	@Override
	public String rdfForm() {
		StringBuilder str = new StringBuilder();
		
		String uri = Ontologia.uriBaseOnt + "Bairro-ID" + this.getId() + ">";		
		String uriCidade  = Ontologia.uriBaseOnt + "Cidade-ID" + this.getCidade().getId() + ">";
		
		str.append(uri + " remember:nomeBairro \""      + this.getNome() + "\" . ");
		str.append(uri + " remember:estaAssociado \"" + uriCidade + "\" . ");
				
		return str.toString();
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Cidade getCidade() {
		return cidade;
	}
	public void setCidade(Cidade cidade) {
		this.cidade = cidade;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	
}
