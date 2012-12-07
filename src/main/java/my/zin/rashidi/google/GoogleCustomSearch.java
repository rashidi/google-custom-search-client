/**
 * 
 */
package my.zin.rashidi.google;

import static com.google.common.base.CharMatcher.WHITESPACE;
import static com.google.common.base.Strings.isNullOrEmpty;
import static java.lang.String.format;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import my.zin.rashidi.google.customsearch.entity.Result;

import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;

import com.google.gson.Gson;

/**
 * @author Rashidi Zin
 * @version 1.0.0
 * @since 1.0.0
 */
public class GoogleCustomSearch {

	private String cx;
	private String apiKey;
	
	public GoogleCustomSearch(String cx, String apiKey) {
		if (isNullOrEmpty(cx) || isNullOrEmpty(apiKey)) { throw new IllegalArgumentException("CX and API Key are required"); }
		
		setCx(cx);
		setApiKey(apiKey);
	}

	private HttpResponse getResponse(String query) {
		String uri = format( "https://www.googleapis.com/customsearch/v1?key=%s&cx=%s&q=%s&alt=json", getApiKey(), getCx(), WHITESPACE.trimAndCollapseFrom(query, '+'));
		
		HttpClient client = new DefaultHttpClient();
		HttpGet request = new HttpGet(uri);
		request.addHeader("accept", "application/json");

		try {
			return client.execute(request);
		} catch (ClientProtocolException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return null;
	}
	
	private String getJson(HttpResponse response) {
		try {
			BufferedReader br = new BufferedReader(new InputStreamReader(response.getEntity().getContent()));
			String output;
			String json = "";
			
			while ((output = br.readLine()) != null) { json = json.concat(output); }

			return json;
		} catch (IllegalStateException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return null;
	}
	
	public Result execute(String query) {		
		HttpResponse response = getResponse(query);
		String json = getJson(response);
		
		return new Gson().fromJson(json, Result.class);
	}
	
	public String getCx() {
		return cx;
	}

	public void setCx(String cx) {
		this.cx = cx;
	}

	public String getApiKey() {
		return apiKey;
	}

	public void setApiKey(String apiKey) {
		this.apiKey = apiKey;
	}
	
}
