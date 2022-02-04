/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.mavenproject1.restClient;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpDelete;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpPut;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

/**
 *
 * @author Hernan_Restrepo
 */
public class Util {

    public String get(String urlBase, Long id) throws Exception {

        String string = null;
        try {
            HttpGet getRequest = new HttpGet(
                    urlBase + (id != null ? "/" + id : ""));
            getRequest.addHeader("content-type", "application/json");

            try (CloseableHttpClient httpclient = HttpClients.createDefault();
                    CloseableHttpResponse response = httpclient.execute(getRequest)) {
                if (response.getStatusLine().getStatusCode() != 200) {
                    throw new RuntimeException("Failed : HTTP error code :"
                            + response.getStatusLine().getStatusCode());
                }

                HttpEntity httpEntity = response.getEntity();
                string = EntityUtils.toString(httpEntity);
            }

            return string;
        } catch (IOException ex) {
            Logger.getLogger(Util.class.getName()).log(Level.SEVERE, null, ex);
        }

        return string;
    }

    public String post(String urlBase, String body) throws Exception {
        String string = null;
        try {
            HttpPost postRequest = new HttpPost(urlBase);

            postRequest.addHeader("content-type", "application/json");

            StringEntity userEntity = new StringEntity(body);
            postRequest.setEntity(userEntity);

            try (CloseableHttpClient httpclient = HttpClients.createDefault();
                    CloseableHttpResponse response = httpclient.execute(postRequest)) {

                //verify the valid error code first
                int statusCode = response.getStatusLine().getStatusCode();
                if (statusCode != 201) {
                    throw new RuntimeException("Failed with HTTP error code : " + statusCode);
                }

                HttpEntity httpEntity = response.getEntity();

                string = EntityUtils.toString(httpEntity);
            }

            return string;
        } catch (IOException ex) {
            Logger.getLogger(Util.class.getName()).log(Level.SEVERE, null, ex);
        }
        return string;
    }

    public String put(String urlBase, String body, Long id) throws Exception {
        String string = null;
        try {
            HttpPut putRequest = new HttpPut(urlBase + "/" + id);

            putRequest.addHeader("content-type", "application/json");

            StringEntity userEntity = new StringEntity(body);
            putRequest.setEntity(userEntity);

            try (CloseableHttpClient httpclient = HttpClients.createDefault();
                    CloseableHttpResponse response = httpclient.execute(putRequest)) {

                //verify the valid error code first
                int statusCode = response.getStatusLine().getStatusCode();
                if (statusCode != 201) {
                    throw new RuntimeException("Failed with HTTP error code : " + statusCode);
                }

                HttpEntity httpEntity = response.getEntity();

                string = EntityUtils.toString(httpEntity);
            }

            return string;
        } catch (IOException ex) {
            Logger.getLogger(Util.class.getName()).log(Level.SEVERE, null, ex);
        }
        return string;
    }

    public void delete(String urlBase, Long id) throws Exception {
        try {
            HttpDelete deleteRequest = new HttpDelete(urlBase + "/" + id);

            deleteRequest.addHeader("content-type", "application/json");

            try (CloseableHttpClient httpclient = HttpClients.createDefault();
                    CloseableHttpResponse response = httpclient.execute(deleteRequest)) {

                //verify the valid error code first
                int statusCode = response.getStatusLine().getStatusCode();
                if (statusCode != 200) {
                    throw new RuntimeException("Failed with HTTP error code : " + statusCode);
                }
            }
        } catch (IOException ex) {
            Logger.getLogger(Util.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
