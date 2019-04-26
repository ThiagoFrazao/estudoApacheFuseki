# -*- coding: utf-8 -*-
"""
Created on Sun Apr  7 12:01:51 2019

@author: thiag
"""

import time
import random as rand
from geradorDeConexoes import GeradorConexoes

class GeradorLocais:
    urlBairro1     = "https://viacep.com.br/ws/siglaUF/cidade/ave/json/"
    urlBairro2     = "https://viacep.com.br/ws/siglaUF/cidade/rua/json/"
    urlEstados    = "https://servicodados.ibge.gov.br/api/v1/localidades/estados"
    urlCidades = "https://servicodados.ibge.gov.br/api/v1/localidades/estados/UF/municipios"
    conexoes = GeradorConexoes()
    sessao = conexoes.getSession()

    
    def getEstados(self):
        return self.conexoes.getUrl(self.sessao,self.urlEstados)      
        
    def getCidadesUF(self,idEstado):
        return self.conexoes.getUrl(self.sessao,self.urlCidades.replace("UF",str(idEstado)))
        
    
    def getBairros(self,siglaEstado,nomeCidade):
        urlGetBairro = self.urlBairro1.replace("siglaUF/cidade",siglaEstado+"/"+nomeCidade)
        bairros = self.conexoes.getUrl(self.sessao,urlGetBairro)
        if len(bairros) > 1:
            return bairros
        else:
            bairros = None
            urlGetBairro = self.urlBairro2.replace("siglaUF/cidade",siglaEstado+"/"+nomeCidade)
            bairros = self.conexoes.getUrl(self.sessao,urlGetBairro)
        return bairros
    
    def gerarInfoCidadeBairro(self,estado):
        stop = False
        retorno = {}
        tentativa = 0
        cidades = self.getCidadesUF(estado["id"])
        while not stop:            
            print("tentativa = " + str(tentativa))
            cidadeEscolhida = cidades.pop(rand.randint(0,len(cidades)-1))
            bairros = self.getBairros(estado["sigla"],cidadeEscolhida["nome"])
            tentativa += 1
            if len(bairros) > 1:
                bairroEscolhido = bairros[(rand.randint(0,len(bairros))-1)]
                retorno.update({"cidade":cidadeEscolhida})
                retorno.update({"bairro":bairroEscolhido})
                stop = True
            else:
                time.sleep(3)
        return retorno