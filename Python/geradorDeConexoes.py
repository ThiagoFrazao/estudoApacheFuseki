# -*- coding: utf-8 -*-
"""
Created on Tue Apr 23 14:24:52 2019

@author: thiag
"""
import ssl
import json
import requests as req
from requests.adapters import HTTPAdapter

class GeradorConexoes(HTTPAdapter):
    
    CIPHERS = (
    'ECDH+AESGCM:DH+AESGCM:ECDH+AES256:DH+AES256:ECDH+AES128:DH+AES:ECDH+HIGH:'
    'DH+HIGH:ECDH+3DES:DH+3DES:RSA+AESGCM:RSA+AES:RSA+HIGH:RSA+3DES:!aNULL:'
    '!eNULL:!MD5'
    )
    
    headers = {'User-Agent': 'Mozilla/5.0 (Macintosh; Intel Mac OS X 10_11_6) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/61.0.3163.100 Safari/537.36'}
    
    def getSSLContext(self):
        defaultCont = ssl.create_default_context()
        defaultCont.options |= ssl.OP_NO_TLSv1_2
        defaultCont.options |= ssl.OP_NO_TLSv1_1
        defaultCont.set_ciphers( self.CIPHERS )
        return defaultCont
    
    def init_poolmanager(self, *args, **kwargs):
        kwargs['ssl_context'] = self.getSSLContext()
        return super(GeradorConexoes, self).init_poolmanager(*args, **kwargs)

    def proxy_manager_for(self, *args, **kwargs):
        kwargs['ssl_context'] = self.getSSLContext()
        return super(GeradorConexoes, self).proxy_manager_for(*args, **kwargs)
    
    def getSession(self):
        session = req.session()
        session.mount("https://",GeradorConexoes())
        return session
    
    def getUrl(self,session,url):   
        return json.loads(session.get(url,timeout=100,headers=self.headers,proxies={}).content)
        

def main():
    teste = GeradorConexoes()
    sessao = teste.getSession()
    print(teste.getUrl(sessao,"https://servicodados.ibge.gov.br/api/v1/localidades/estados"))
    
if __name__ == "__main__":
    main()
    


        