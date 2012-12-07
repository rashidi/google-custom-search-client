/**
 * 
 */
package my.zin.rashidi.google.customsearch.entity;

/**
 * @author Rashidi Zin
 * @version 1.0.0
 * @since 1.0.0
 */
public class Item {

	private String title;
	private String link;
	private String snippet;
	
	public Item() {
		
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getLink() {
		return link;
	}

	public void setLink(String link) {
		this.link = link;
	}

	public String getSnippet() {
		return snippet;
	}

	public void setSnippet(String snippet) {
		this.snippet = snippet;
	}	
	
}
