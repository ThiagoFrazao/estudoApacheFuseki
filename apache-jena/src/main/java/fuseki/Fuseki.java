package fuseki;


import java.util.List;

import org.apache.jena.query.QueryExecution;
import org.apache.jena.query.QueryExecutionFactory;
import org.apache.jena.query.QuerySolution;
import org.apache.jena.query.ResultSet;
import org.apache.jena.query.ResultSetFormatter;
import org.apache.jena.update.UpdateExecutionFactory;
import org.apache.jena.update.UpdateFactory;
import org.apache.jena.update.UpdateProcessor;
import org.apache.jena.update.UpdateRequest;

import entidades.EntidadeRDF;
import entidades.Pessoa;
import erros.RdfQueryException;
import jena.Ontologia;

public class Fuseki {
	
	private static final String URI = "http://localhost:3030/tcc1";
	
	public static void adicionarEntidade(EntidadeRDF entidade, String nomeIndividuo){		
		try {
			String queryUpdate = "PREFIX remember: "+ Ontologia.uriBaseOnt +"> INSERT DATA "
					+ "{ " + entidade.namedIndividualForm(nomeIndividuo) + " }";
			
			UpdateRequest up = UpdateFactory.create(queryUpdate);
			UpdateProcessor  upQ = UpdateExecutionFactory.createRemote(up,URI);
			upQ.execute();		
		} catch (IllegalArgumentException | IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
	}	
	
	public static EntidadeRDF recuperarEntidade(String uriEntidade, EntidadeRDF entidade) throws RdfQueryException{
		EntidadeRDF retorno;
		List<QuerySolution> qsList;
		String query = "SELECT ?objeto  WHERE { "+ uriEntidade  +" ?predicado ?objeto }";
		
		QueryExecution q = QueryExecutionFactory.sparqlService(URI,query);
		ResultSet results = q.execSelect();	

		if(results.hasNext()){
			qsList = ResultSetFormatter.toList(results);						
			retorno = entidade.fromQueryList(qsList);
		}
		else{
			throw new RdfQueryException();
		}				
		return retorno;
	}
	
	public static void main(String[] args) throws RdfQueryException {
		Pessoa pessoa = new Pessoa("0", "Jose da Silva","imagem","sexo","olhos","corPele","corCabelo","tipoFisico","transtornoMental","nascimento","status","informacoes","pesoAproximado","alturaAproximada","marcaCaracteristica","fonte","boletimOcorrencia");
		Fuseki.adicionarEntidade(pessoa,"Jose Testando da Silva");
		/*String uriPessoa = "<http://www.projeto-myosotis.com.br/pessoasdesaparecidas/ontologiaremember#PessoaJosedaSilva>";
		Pessoa teste = (Pessoa) Fuseki.recuperarEntidade(uriPessoa, new Pessoa());
		System.out.println(teste.toString());*/
	}

}
