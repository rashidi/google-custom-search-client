/**
 * 
 */
package my.zin.rashidi.google.customsearch.entity;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

/**
 * @author Rashidi Zin
 * @version 1.1.0
 * @since 1.1.0
 */
public class Meta {

	private String json;
	private Queries queries;
	
	public Meta(String json) {
		setJson(json);
		setQueries();
	}
	
	private String getJson() {
		return json;
	}
	
	private void setJson(String json) {
		this.json = json;
	}
	
	private JsonObject getJsonObject() {
		return new JsonParser().parse(getJson()).getAsJsonObject();
	}
	
	private void setQueries() {
		queries = new Gson().fromJson(getJsonObject().get("queries"), Queries.class);
	}
	
	public Queries getQueries() {
		return queries;
	}
}
