package entidades;

public class Desaparecimento {
	
	private int id;
	private String informacoes;
	private String fonte;
	private String dataDesaparecimento;
	private Pessoa pessoa;
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
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
	private Local localDesaparecimento;
	

}
