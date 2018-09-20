package jena;

import java.util.HashMap;
import java.util.List;

import org.apache.jena.ontology.OntModel;
import org.apache.jena.ontology.OntProperty;
import org.apache.jena.rdf.model.Model;
import org.apache.jena.rdf.model.ModelFactory;
import org.apache.jena.rdf.model.Property;

public class Ontologia{
	
	//Path Mayara 
	//private static final String PATH = "/home/mmrosa/MEGA/MEGAsync/Faculdade/TCC/OntologiaMyosotis/modelos/remember.owl";	
	//Path Thiago Casa
	//private static final String PATH = "C:/Users/thiag/Documents/Faculdade/TCC/remember.owl";	
	//Path Thiago Estagio
	private static final String PATH   = "C:/Users/E514189/Documents/Anotações/TCC/remember.owl";
	
	public static Model modelOnt;	
	public static final String uriBaseOnt = "<http://www.projeto-myosotis.com.br/pessoasdesaparecidas/ontologiaremember#";	
	
	private static HashMap<String, Property> pessoaProp = new HashMap<String, Property>();	
	private static HashMap<String, Property> localProp  = new HashMap<String, Property>();
	private static HashMap<String, Property> bairroProp  = new HashMap<String, Property>();
	private static HashMap<String, Property> cidadeProp = new HashMap<String, Property>();
	private static HashMap<String, Property> ufProp  = new HashMap<String, Property>();
	private static HashMap<String, Property> desaparecimentoProp  = new HashMap<String, Property>();
	
	static{
		OntModel ontologia = ModelFactory.createOntologyModel();
		ontologia.read(PATH);		
		modelOnt = ontologia.getBaseModel();
		List<OntProperty> propriedades = ontologia.listAllOntProperties().toList();
		
		for(OntProperty prop : propriedades){
			
			if(prop.getDomain() != null && prop.getDomain().toString().contains("Pessoa")){		
				pessoaProp.put(prop.getLocalName(), prop);
			}
			else if(prop.getDomain() != null && prop.getDomain().toString().contains("Local")){
				localProp.put(prop.getLocalName(), prop);
			}
			else if(prop.getDomain() != null && prop.getDomain().toString().contains("Bairro")){
				bairroProp.put(prop.getLocalName(), prop);
			}
			else if(prop.getDomain() != null && prop.getDomain().toString().contains("Cidade")){
				cidadeProp.put(prop.getLocalName(), prop);
			}
			else if(prop.getDomain() != null && prop.getDomain().toString().contains("UF")){
				System.out.println(prop.getLocalName());
				System.out.println(prop.getURI() + "\n");
				ufProp.put(prop.getLocalName(), prop);
			}
			else if(prop.getDomain() != null && prop.getDomain().toString().contains("Desaparecimento")){
				
				desaparecimentoProp.put(prop.getLocalName(), prop);
			}			
		}
	}	
	
	public static Property getPropPessoa(String propriedade){
		return pessoaProp.get(propriedade);
	}
	
	public static Property getPropLocal(String propriedade){
		return localProp.get(propriedade);
	}
	
	public static Property getPropBairro(String propriedade){
		return bairroProp.get(propriedade);
	}
	
	public static Property getPropCidade(String propriedade){
		return cidadeProp.get(propriedade);
	}
	
	public static Property getPropUF(String propriedade){
		return ufProp.get(propriedade);
	}
	
	public static Property getPropDesaparecimento(String propriedade){
		return desaparecimentoProp.get(propriedade);
	}
	
	public static void main(String[] args) {
		Ontologia ont = new Ontologia();
	}
}
