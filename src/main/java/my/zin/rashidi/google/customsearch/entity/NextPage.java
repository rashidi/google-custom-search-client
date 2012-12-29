/**
 * 
 */
package my.zin.rashidi.google.customsearch.entity;

/**
 * @author Rashidi Zin
 * @version 1.1.0
 * @since 1.1.0
 */
public class NextPage {

	private String title;
	private String totalResults;
	private String searchTerms;
	private int count;
	private int startIndex;
	
	public String getTitle() {
		return title;
	}
	
	public void setTitle(String title) {
		this.title = title;
	}
	
	public String getTotalResults() {
		return totalResults;
	}
	
	public void setTotalResults(String totalResults) {
		this.totalResults = totalResults;
	}
	
	public String getSearchTerms() {
		return searchTerms;
	}
	
	public void setSearchTerms(String searchTerms) {
		this.searchTerms = searchTerms;
	}
	
	public int getCount() {
		return count;
	}
	
	public void setCount(int count) {
		this.count = count;
	}
	
	public int getStartIndex() {
		return startIndex;
	}
	
	public void setStartIndex(int startIndex) {
		this.startIndex = startIndex;
	}
}
