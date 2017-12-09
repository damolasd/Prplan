package com.example.mad.prplanapp;

/**
 * Created by M.A.D on 09/12/2017.
 */

import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.StringReader;
import java.net.URI;
import java.net.MalformedURLException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URISyntaxException;

public class Connection {
    HttpURLConnection conn = null;
    URI baseurl =  new URI("http://localhost:3000");
    public static void main(String[] args) {
        HttpURLConnection conn = null;
        BufferedReader reader = null;

        try{


            conn = (HttpURLConnection) baseurl.openConnection();
            conn.connect();

            InputStream stream = conn.getInputStream();

            reader = new BufferedReader(new InputStreamReader(stream));

            StringBuffer buffer = new StringBuffer();

            String line = "";
            while ((line = reader.readLine()) != null) {
                buffer.append(line);
            }
        }catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (URISyntaxException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            if (conn!=null) {
                conn.disconnect();
            }
            try {
                if (reader!=null) {
                    reader.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }


    }

    public JSONObject getProjects() {
        String getProjectsString = "Projects";
        try {
            URI url = new URI(getProjectsString);
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }
        conn.setRequestMehod("GET");
        conn.setRequestProperty("Content-Type", "application/json");

    }

    public PostProject() throws URISyntaxException {
        conn.setRequestMehod("POST");
        conn.setRequestProperty("Content-Type", "application/json");
    }



}
