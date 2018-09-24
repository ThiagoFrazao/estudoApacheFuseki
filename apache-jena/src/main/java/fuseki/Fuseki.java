package fuseki;


import java.util.ArrayList;
import java.util.List;

import org.apache.jena.query.QueryExecution;
import org.apache.jena.query.QueryExecutionFactory;
import org.apache.jena.query.QuerySolution;
import org.apache.jena.query.ResultSet;
import org.apache.jena.query.ResultSetFormatter;
import org.apache.jena.rdf.model.Literal;
import org.apache.jena.rdf.model.RDFNode;
import org.apache.jena.rdf.model.Resource;
import org.apache.jena.rdfconnection.RDFConnection;
import org.apache.jena.rdfconnection.RDFConnectionFactory;
import org.apache.jena.update.UpdateExecutionFactory;
import org.apache.jena.update.UpdateFactory;
import org.apache.jena.update.UpdateProcessor;
import org.apache.jena.update.UpdateRequest;

import entidades.EntidadeRDF;
import entidades.Pessoa;
import erros.RdfQueryException;
import jena.Ontologia;

public class Fuseki {
	
	private static final String URI = "http://localhost:3030/estudando";
	
	public static void adicionarEntidade(EntidadeRDF entidade){
		String queryUpdate;
		queryUpdate = "PREFIX remember: "+ Ontologia.uriBaseOnt +"> INSERT DATA "
				+ "{ " + entidade.rdfForm() + " }";
		
		System.out.println(queryUpdate);
		
		UpdateRequest up = UpdateFactory.create(queryUpdate);
		UpdateProcessor  upQ = UpdateExecutionFactory.createRemote(up,URI);
		upQ.execute();		
	}	
	
	public static Pessoa recuperarPessoa(String uriPessoa) throws RdfQueryException{
		Pessoa retorno = new Pessoa();
		List<QuerySolution> qsList;
		String query = "SELECT ?objeto  WHERE { "+ uriPessoa  +" ?predicado ?objeto }";
		
		QueryExecution q = QueryExecutionFactory.sparqlService(URI,query);
		ResultSet results = q.execSelect();
		
		System.out.println(results.toString());

		//ResultSetFormatter.out(System.out, results);
		if(results.hasNext()){
			qsList = ResultSetFormatter.toList(results);
			
			retorno.setNome(qsList.get(0).getLiteral("objeto").toString());		
			retorno.setImagemBase64(qsList.get(1).getLiteral("objeto").toString());
			retorno.setAlturaAproximada(qsList.get(2).getLiteral("objeto").toString());
			retorno.setPesoAproximado(qsList.get(3).getLiteral("objeto").toString());
			retorno.setCorPele(qsList.get(4).getLiteral("objeto").toString());
			retorno.setCorCabelo(qsList.get(5).getLiteral("objeto").toString());
			retorno.setOlhos(qsList.get(6).getLiteral("objeto").toString());
			retorno.setSexo(qsList.get(7).getLiteral("objeto").toString());
			retorno.setTipoFisico(qsList.get(8).getLiteral("objeto").toString());
			retorno.setStatus(qsList.get(9).getLiteral("objeto").toString());
			retorno.setTranstornoMental(qsList.get(10).getLiteral("objeto").toString());
			retorno.setInformacoes(qsList.get(11).getLiteral("objeto").toString());
			retorno.setMarcaCaracteristica(qsList.get(12).getLiteral("objeto").toString());
			retorno.setNascimento(qsList.get(13).getLiteral("objeto").toString());		
		}
		else{
			throw new RdfQueryException();
		}		
		
		return retorno;
	}
	
	public static void main(String[] args) throws RdfQueryException {
		/*Pessoa pessoa = new Pessoa(0, "Jose da Silva","imagem","sexo","olhos","corPele","corCabelo","tipoFisico","transtornoMental","nascimento","status","informacoes","pesoAproximado","alturaAproximada","marcaCaracteristica","fonte","boletimOcorrencia");
		Fuseki.adicionarEntidade(pessoa);*/
		String uriPessoa = "<http://www.projeto-myosotis.com.br/pessoasdesaparecidas/ontologiaremember#PessoaJosedaSilva>";
		Pessoa teste = Fuseki.recuperarPessoa(uriPessoa);
		System.out.println(teste.toString());
	}

}
