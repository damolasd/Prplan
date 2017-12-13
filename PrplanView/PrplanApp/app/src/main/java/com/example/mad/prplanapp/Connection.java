package com.example.mad.prplanapp;

/**
 * Created by M.A.D on 09/12/2017.
 */

import android.app.DatePickerDialog;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.StringReader;
import java.net.ProtocolException;
import java.net.URI;
import java.net.MalformedURLException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URISyntaxException;
import java.net.URL;

public class Connection {
    HttpURLConnection conn = null;
    static String baseUrlString = "http://localhost:3000";


    public static void main(String[] args) {
        HttpURLConnection conn = null;
        BufferedReader reader = null;

        try{
            URL baseURL = new URL(baseUrlString);
            conn = (HttpURLConnection)baseURL.openConnection();
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
        }  catch (IOException e) {
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

    public JSONObject getProjects() throws ProtocolException {
        String response = null;
        String ProjectsString = "/Projects";
        StringBuffer buffer = new StringBuffer();
        buffer.append(baseUrlString);
        buffer.append(ProjectsString);
        try {
            URL url = new URL(buffer.toString());
            conn.setRequestMethod("GET");
            conn.setRequestProperty("Content-Type", "application/json");
            conn = (HttpURLConnection) url.openConnection();
            // Read response
            InputStream inputStream = new BufferedInputStream(conn.getInputStream());
            BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
            StringBuilder stringBuilder = new StringBuilder();
            String line = "";
            while ((line = reader.readLine()) != null) {
                stringBuilder.append(line).append('\n');
            }
            inputStream.close();
            response = stringBuilder.toString();

        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        JSONObject jsonObject = null;
        if (response != null) {
            try {
                jsonObject = new JSONObject(response);
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }

        return jsonObject;
    }

    public void PostProject(String projectTitle, DatePickerDialog startDate, DatePickerDialog endDate) throws URISyntaxException, ProtocolException {
        String ProjectsString = "/Projects";
        StringBuffer buffer = new StringBuffer();
        buffer.append(baseUrlString);
        buffer.append(ProjectsString);
        try {
            URL url = new URL(buffer.toString());
            conn.setRequestMethod("POST");
            conn.setRequestProperty("Content-Type", "application/json");
            conn = (HttpURLConnection)url.openConnection();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }



}
