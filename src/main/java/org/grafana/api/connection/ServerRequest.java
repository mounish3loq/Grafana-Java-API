/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.grafana.api.connection;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonElement;
import com.google.gson.stream.JsonReader;
import org.grafana.api.GrafanaAPI;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author jh
 */
public class ServerRequest {

    private final GrafanaAPI grafanaApi;

    /**
     *
     * @param grafanaApi
     */
    public ServerRequest(GrafanaAPI grafanaApi) {
        this.grafanaApi = grafanaApi;
    }

    /**
     *
     * @param path
     * @param methode
     * @param authorization
     * @return
     */
    public JsonElement createServerRequest(
            String path,
            String methode,
            String authorization
    ){
        return createServerRequestExtented(path, methode, "", authorization);
    }

    /**
     *
     * @param path
     * @param methode
     * @param body
     * @param authorization
     * @return
     */
    public JsonElement createServerRequest(
            String path,
            String methode,
            String body,
            String authorization
    ){
        return createServerRequestExtented(path, methode, body, authorization);
    }

    /**
     *
     * @param path
     * @param methode
     * @param body
     * @param authorization
     * @return
     */
    private JsonElement createServerRequestExtented(
            String path,
            String methode,
            String body,
            String authorization) {

        JsonElement jsonResult = null;
        int returnCode = 0;
        try {

            URL serverURL = new URL(grafanaApi.getServerURL());
            URL fullURL = new URL(serverURL, path);
            System.out.println(fullURL);
            HttpURLConnection conn;
            try {
                conn = (HttpURLConnection) fullURL.openConnection();
                conn.setDoOutput(true);
                conn.setDoInput(true);
                conn.setUseCaches(false);
                try {
                    System.out.println("Method used" + methode);
                    conn.setRequestMethod(methode);
                } catch (ProtocolException ex) {
                    Logger.getLogger(ServerRequest.class.getName()).log(Level.SEVERE, null, ex);
                }
                conn.addRequestProperty("Accept", "application/json");
                conn.addRequestProperty("Authorization", authorization);
                conn.setRequestProperty("Content-Type", "application/json");

                if (!body.isEmpty()) {
                    OutputStream os = conn.getOutputStream();
                    try (OutputStreamWriter osw = new OutputStreamWriter(os, "UTF-8")) {
                        osw.write(body);
                        osw.flush();
                        osw.close();
                    }
                }
                try{
                    System.out.println(conn.getResponseCode());
                    InputStream stream = conn.getInputStream();
                    try (JsonReader jReader = new JsonReader(new InputStreamReader(stream))) {
                        Gson gson = new GsonBuilder().create();
                        jsonResult = gson.fromJson(jReader, JsonElement.class);
                        jReader.close();
                    }
                    stream.close();
                    conn.disconnect();
                    return jsonResult;
                }catch(IOException ex){
                    //Logger.getLogger(ServerRequest.class.getName()).log(Level.SEVERE, null, ex);
                    conn.disconnect();
                    return null;
                }
            } catch (IOException ex) {
                //Logger.getLogger(ServerRequest.class.getName()).log(Level.SEVERE, null, ex);
            }

            /*
             try (JsonReader jReader = new JsonReader(new InputStreamReader(
             (conn.getInputStream())))) {
             Gson gson = new GsonBuilder().create();
             jsonResult = gson.fromJson(jReader, JsonElement.class);
             jReader.close();
             }
             */
            //conn.getResponseCode()
        } catch (MalformedURLException e) {
            //e.printStackTrace(System.out);
            return null;
        }
        /*
         catch (IOException e) {
         e.printStackTrace(System.out);
         }
         */
        /*if(jsonResult.isJsonObject()){
         jsonResult.getAsJsonObject().addProperty("SuccesCode", returnCode);
         }
         */
        /* & ToDo
         return also the result code
         */
        //List returnlist =
        return null;
    }
}
