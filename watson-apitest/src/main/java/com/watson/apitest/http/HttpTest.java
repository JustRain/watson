package com.watson.apitest.http;

import jodd.http.HttpRequest;
import jodd.http.HttpResponse;
import jodd.http.ProxyInfo;
import jodd.http.net.SocketHttpConnectionProvider;

import java.util.Map;

/**
 * @author chong.xu
 * @Description: TODO
 * @date 2019/4/155:47 PM
 */
public class HttpTest {


    private HttpTest(){}

    public static HttpTest getInstance(){
        return HttpRequestInner.httpRequestTest;
    }
    private static class HttpRequestInner{
        private final static HttpTest httpRequestTest =new HttpTest();
    }


    public  HttpRequest createHttpRequsest(){
        return new HttpRequest();
    }



    public  HttpResponse doGet(String url){
        return HttpRequest.get(url).send();
    }

    public  HttpResponse doGet(String url,String jsonParams){
        return HttpRequest.get(url).body(jsonParams).send();
    }
    /**
     * get方式
     * @return
     */
    public  HttpResponse doQuery(String url, Map<String, String> httpParams){
        HttpRequest httpRequest = HttpRequest.get(url);
        HttpResponse send = httpRequest.query(httpParams).send();
        return send;
    }

    public  HttpResponse doPost(String url){
        return HttpRequest.post(url).send();
    }

    public  HttpResponse doPost(String url,String jsonParams){
        return HttpRequest.post(url).body(jsonParams).send();
    }

    public  HttpResponse doPost(String url,Map<String,Object>httpParams){
        HttpRequest httpRequest=HttpRequest.post(url);
        HttpResponse send = httpRequest.form(httpParams).send();
        return send;
    }

    public  HttpResponse doPost(String url,Map<String,String> header,Map<String,Object>httpParams){
        HttpRequest httpRequest=HttpRequest.post(url);
        HttpResponse send = httpRequest.header(header).form(httpParams).send();
        return send;
    }

    public HttpResponse doGetProxy(String url,String proxyIp,int proxyPort){
        ProxyInfo proxyInfo = new ProxyInfo(ProxyInfo.ProxyType.HTTP,proxyIp,proxyPort,"","");
        SocketHttpConnectionProvider provider = new SocketHttpConnectionProvider();
        provider.useProxy(proxyInfo);
        HttpRequest request = HttpRequest.get(url);
        request.method("GET");
        request.charset("UTF-8");
        HttpResponse response = request.open(provider).send();
        return response;
    }



}
