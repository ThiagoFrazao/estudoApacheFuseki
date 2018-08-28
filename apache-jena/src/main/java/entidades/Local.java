package entidades;

public class Local {
	
	private int id;
	private Bairro bairro;
	private Cidade cidade;
	private Estado estado;
	
	/*	Ainda não sei que tipo por aqui
	private latitude;
	private longitude;*/
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Bairro getBairro() {
		return bairro;
	}
	public void setBairro(Bairro bairro) {
		this.bairro = bairro;
	}
	public Cidade getCidade() {
		return cidade;
	}
	public void setCidade(Cidade cidade) {
		this.cidade = cidade;
	}
	public Estado getEstado() {
		return estado;
	}
	public void setEstado(Estado estado) {
		this.estado = estado;
	}
	


}
