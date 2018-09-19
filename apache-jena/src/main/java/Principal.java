import org.apache.jena.rdf.model.Property;

import jena.Ontologia;

public class Principal {
	
	public static void main(String[] args) {
		
		Property teste = Ontologia.getPropPessoa("imagem");
		System.out.println(teste.getLocalName());
		System.out.println(teste.getNameSpace());
		System.out.println(teste.getURI());		
	}

}
