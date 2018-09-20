package entidades;

import jena.Ontologia;

public class Local extends EntidadeRDF {
	
	private int id;
	private Bairro bairro;
	private Cidade cidade;
	private Estado estado;	

	private String latitude;
	private String longitude;
	
	@Override
	public String rdfForm() {
		
		StringBuilder str = new StringBuilder();
		
		String uri = Ontologia.uriBaseOnt + "Local-ID" + this.getId() + ">";
		String uriBairro  = Ontologia.uriBaseOnt + "Bairro-ID" + this.getBairro().getId() + ">";
		String uriCidade  = Ontologia.uriBaseOnt + "Cidade-ID" + this.getCidade().getId() + ">";
		String uriEstado  = Ontologia.uriBaseOnt + "Estado-ID" + this.getEstado().getId() + ">";
		
		str.append(uri + " remember:latitude \""      + this.getLatitude() + "\" . ");
		str.append(uri + " remember:longitude \""     + this.getLongitude() + "\" . ");
		str.append(uri + " remember:estaAssociado \"" + uriBairro + "\" . ");
		str.append(uri + " remember:estaAssociado \"" + uriCidade + "\" . ");
		str.append(uri + " remember:estaAssociado \"" + uriEstado + "\" . ");
				
		return str.toString();
	}
	
	
	public String getLatitude() {
		return latitude;
	}
	
	public void setLatitude(String latitude) {
		this.latitude = latitude;
	}
	
	public String getLongitude() {
		return longitude;
	}
	
	public void setLongitude(String longitude) {
		this.longitude = longitude;
	}


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
