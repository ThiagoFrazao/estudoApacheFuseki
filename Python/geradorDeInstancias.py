# -*- coding: utf-8 -*-

import owlready2 as owl
from random import uniform
from random import randint
from geradorDeLocais import GeradorLocais
from geradorDePessoas import GeradorDePessoas

def gerarUltimaHoraVista():
    hora = str(randint(0,24))
    minuto = str(randint(0,60))
    if len(hora) <= 1:
        hora = "0" + hora
    if len(minuto) <= 1:
        minuto =  "0" + minuto 
        
    return hora + ":" + minuto

def getBairroInstancia(nomeCidade,nomeBairroAtual,instanciasBairro):
    bairrosDaCidade = instanciasBairro.get(nomeCidade)
    if bairrosDaCidade == None:
        return 0
    else:
        bairros = bairrosDaCidade.get(nomeBairroAtual)
        if bairros == None:
            return 1
        else:
            return bairros


def main():
    nomes = open("nomes.txt","r",encoding="utf8")
    onto = owl.get_ontology("ontologiarelembrar.owl").load()
    geraLocais = GeradorLocais()
    geraPessoas = GeradorDePessoas()
    
    estados = geraLocais.getEstados()
    instanciasEstado = {}
    instanciasCidades = {}
    instanciasBairros = {}
    
    count = 0
    countPessoa = 0
    countLocal = 0
    countBairro = 0
    countCidade = 0
    countEstado = 0
    countDesaparecimento = 0
    print("Comecando:")
    while count < 100:
        pessoa = None
        estado = None
        cidade = None
        bairro = None
        desaparecimento = None
        
        infoPessoa = geraPessoas.gerarInfoPessoa()
        pessoa = onto.Pessoa("pessoa"+str(countPessoa))
        pessoa.nome.append(nomes.readline())
        pessoa.dataNascimento.append(infoPessoa["dataNascimento"])
        pessoa.tipoFisico.append(infoPessoa["tipoFisico"])
        pessoa.sexo.append(infoPessoa["sexo"])
        pessoa.alturaAproximada.append(infoPessoa["alturaAproximada"])
        pessoa.pesoAproximado.append(infoPessoa["pesoAproximado"])
        pessoa.corCabelo.append(infoPessoa["corCabelo"])
        pessoa.corOlhos.append(infoPessoa["corOlhos"])
        pessoa.corPele.append(infoPessoa["corPele"])
        pessoa.transtornoMental.append(infoPessoa["transtornoMental"])
        pessoa.imagem.append("N/A")
        pessoa.marcaCaracteristica.append(infoPessoa["marcaCaracteristica"])
        countPessoa += 1
        
        desaparecimento = onto.Desaparecimento("desaparecimento"+str(countDesaparecimento))
        desaparecimento.fonte.append("geradoAleatoriamente.com.br")
        desaparecimento.ultimaHoraVista.append(gerarUltimaHoraVista())
        desaparecimento.dataDesaparecimento.append(infoPessoa["dataDesaparecimento"])
        desaparecimento.informacoes.append("N/A")
        countDesaparecimento += 1     
        
        estadoAtual = estados[randint(0,len(estados)-1)]
        instanciaEstado = instanciasEstado.get(estadoAtual["sigla"])
        if instanciaEstado == None:
            identificadorEstado = "uf" + str(countEstado)
            estado = onto.UF(identificadorEstado)
            estado.sigla.append(estadoAtual["sigla"])
            conteudo = {estadoAtual["sigla"]:{"identificadorEstado":identificadorEstado,"instancia":estado}}
            instanciasEstado.update(conteudo)
            countEstado += 1
        else:
            estado = instanciaEstado["instancia"]
            identificadorEstado = instanciaEstado["identificadorEstado"]
        
        infoBairroCidade = geraLocais.gerarInfoCidadeBairro(estadoAtual)
        
        cidadeAtual = infoBairroCidade["cidade"]
        instanciaCidade = instanciasCidades.get(cidadeAtual["nome"])
        if instanciaCidade == None:
            identificadorCidade = "cidade"+str(countCidade)
            cidade = onto.Cidade(identificadorCidade)
            cidade.nomeCidade.append(cidadeAtual["nome"])
            conteudo = {cidadeAtual["nome"]:{"identificadorCidade":identificadorCidade,"instancia":cidade}}
            instanciasCidades.update(conteudo)
            countCidade += 1
        else:
            cidade = instanciaCidade["instancia"]
            identificadorCidade = instanciaCidade["identificadorCidade"]        
        
        bairroAtual = infoBairroCidade["bairro"]
        instanciaBairro = getBairroInstancia(cidadeAtual["nome"],bairroAtual["bairro"],instanciasBairros)
        if instanciaBairro == 0:
            identificadorBairro = "bairro"+str(countBairro)
            bairro = onto.Bairro(identificadorBairro)
            bairro.nomeBairro.append(bairroAtual["bairro"])
            conteudo = {cidadeAtual["nome"]:
                          {bairroAtual["bairro"]:{"identificadorBairro":identificadorBairro,"instancia":bairro}}}
            instanciasBairros.update(conteudo)
            countBairro += 1
        elif instanciaBairro == 1:
            bairrosCidade = instanciasBairros.get(cidadeAtual["nome"])
            bairro = onto.Bairro(identificadorBairro)
            bairro.nomeBairro.append(bairroAtual["bairro"])
            conteudo = {bairroAtual["bairro"]:{"identificadorBairro":identificadorBairro,"instancia":bairro}}
            bairrosCidade.update(conteudo)
            countBairro += 1
        else:
            bairro = instanciaBairro["instancia"]
            identificadorBairro = instanciaBairro["identificadorBairro"]  
        
        desaparecimento.estaAssociado = [pessoa]
        cidade.eCidadeDe = [estado]
        bairro.eBairroDe = [cidade]
        print(count)
        count += 1
            
            
            
        
    
    onto.save(file = "instancias5.owl", format = "rdfxml")
        
        

        
if __name__ == "__main__":
    main()
