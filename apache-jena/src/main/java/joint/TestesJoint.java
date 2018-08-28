package joint;

import java.util.ArrayList;
import java.util.List;

import br.ufal.ic.joint.RepositoryFacade;
import br.ufal.ic.joint.module.ontology.operations.OntologyCompiler;

public class TestesJoint{
	
	public static void main(String[] args) {
		// Caminho do arquivo jar que será gerado
		String ontologyPath = "C:/Users/thiag/Desktop/testeOntologia.jar";
		// URL da ontologia que deseja ser compilada
		String ontologyURL = "file:///C:/Modelo2.owl";
		List<String> lista = new ArrayList<String>();
		lista.add(ontologyURL);
		// Chama a fachada do JOINT
		RepositoryFacade fachada = new RepositoryFacade();
		OntologyCompiler compiler = fachada.getOntologyCompiler(ontologyPath, lista);
		compiler.compile();
	}
	

}
