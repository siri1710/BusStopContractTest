package com.example.contracttesting;

import groovy.ui.SystemOutputInterceptor;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.fluent.Request;
import org.apache.http.util.EntityUtils;
import org.json.JSONObject;

import java.io.IOException;


public class WhenComesTheBus {

    int port = 8017;

    WhenComesTheBus()
    {
        System.out.println("Default port" + port);
    }

    WhenComesTheBus(int port){
        this.port = port;
        System.out.println("Custome port"+ port);
    }

    public static void main (String[] agrs){
        Integer eta = new WhenComesTheBus().checkEta("Conolly","122");
        System.out.println("ETA : "+eta);
    }

    public Integer checkEta(String station, String num){
        try{
            String url = String.format("Http://localhost:%d/bus/%s/%s", port, station,num);
            System.out.println("Using url: "+url);
            HttpResponse r = Request.Get(url).execute().returnResponse();
            String json = EntityUtils.toString((r.getEntity()));
            System.out.println("Json ="+json);
            JSONObject jsonObject = new JSONObject(json);
            String eta = jsonObject.get("eta").toString();
            return new Integer(eta);
        } catch (Exception e) {
            System.out.println("Unable to get ETA :"+e);
            return null;
        }
    }
}
