package com.client;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;

public class RestJavaClientApplication {
	public static void main(String[] args) throws IOException {

		//POSTRequest();
		//UPDATERequest();
		//DELETERequest();
		MyGETRequest();
	}

	public static void MyGETRequest() throws IOException {
		URL urlForGetRequest = new URL("http://localhost:8080/staff/all");
		String readLine = null;
		HttpURLConnection conection = (HttpURLConnection) urlForGetRequest.openConnection();
		conection.setRequestMethod("GET");
		int responseCode = conection.getResponseCode();
		if (responseCode == HttpURLConnection.HTTP_OK) {
			BufferedReader in = new BufferedReader(
					new InputStreamReader(conection.getInputStream()));
			StringBuffer response = new StringBuffer();
			while ((readLine = in .readLine()) != null) {
				response.append(readLine);
			} in .close();
			System.out.println("JSON String Result " + response.toString());
		} else {
			System.out.println("GET NOT WORKED");
		}
	}

	public static void POSTRequest() throws IOException {
		final String POST_PARAMS = "{\n" + "\"name\": \"abc\",\r\n" +
				"    \"designation\": \"xyz\"\r\n}" ;
		System.out.println(POST_PARAMS);
		URL obj = new URL("http://localhost:8080/staff/add");
		HttpURLConnection postConnection = (HttpURLConnection) obj.openConnection();
		postConnection.setRequestMethod("POST");
		postConnection.setRequestProperty("Content-Type", "application/json");
		postConnection.setDoOutput(true);
		OutputStream os = postConnection.getOutputStream();
		os.write(POST_PARAMS.getBytes());
		os.flush();
		os.close();
		int responseCode = postConnection.getResponseCode();
		System.out.println("Response Code :  " + responseCode);
		System.out.println("Response Message : " + postConnection.getResponseMessage());
		if (responseCode == HttpURLConnection.HTTP_OK) { //success
			BufferedReader in = new BufferedReader(new InputStreamReader(
					postConnection.getInputStream()));
			String inputLine;
			StringBuffer response = new StringBuffer();
			while ((inputLine = in .readLine()) != null) {
				response.append(inputLine);
			} in .close();
			// print result
			System.out.println(response.toString());
		} else {
			System.out.println("POST NOT WORKED");
		}
	}

	public static void UPDATERequest() throws IOException {
		final String UPDATE_PARAMS = "{\n" + "\"id\": \"18\",\r\n"
				+ "\n" + "\"name\": \"PQR\",\r\n" +
				"    \"designation\": \"xyz\"\r\n}" ;
		System.out.println(UPDATE_PARAMS);
		URL obj = new URL("http://localhost:8080/staff/update");
		HttpURLConnection updateConnection = (HttpURLConnection) obj.openConnection();
		updateConnection.setRequestMethod("PUT");
		updateConnection.setRequestProperty("Content-Type", "application/json");
		updateConnection.setDoOutput(true);
		OutputStream os = updateConnection.getOutputStream();
		os.write(UPDATE_PARAMS.getBytes());
		os.flush();
		os.close();
		int responseCode = updateConnection.getResponseCode();
		System.out.println("Response Code :  " + responseCode);
		System.out.println("Response Message : " + updateConnection.getResponseMessage());
		if (responseCode == HttpURLConnection.HTTP_OK) { //success
			BufferedReader in = new BufferedReader(new InputStreamReader(
					updateConnection.getInputStream()));
			String inputLine;
			StringBuffer response = new StringBuffer();
			while ((inputLine = in .readLine()) != null) {
				response.append(inputLine);
			} in .close();
			System.out.println(response.toString());
		} else {
			System.out.println("UPDATE NOT WORKED");
		}
	}

	public static void DELETERequest() throws IOException {
		URL obj = new URL("http://localhost:8080/staff/18");
		HttpURLConnection deleteConnection = (HttpURLConnection) obj.openConnection();
		deleteConnection.setRequestMethod("DELETE");
		int responseCode = deleteConnection.getResponseCode();
		System.out.println("Response Code :  " + responseCode);
		System.out.println("Response Message : " + deleteConnection.getResponseMessage());
		if (responseCode == HttpURLConnection.HTTP_OK) { //success
			BufferedReader in = new BufferedReader(new InputStreamReader(
					deleteConnection.getInputStream()));
			String inputLine;
			StringBuffer response = new StringBuffer();
			while ((inputLine = in .readLine()) != null) {
				response.append(inputLine);
			} in .close();
			System.out.println(response.toString());
		} else {
			System.out.println("DELETE NOT WORKED");
		}
	}
}