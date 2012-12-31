/**
 * 
 */
package my.zin.rashidi.google.customsearch.entity;

import java.util.List;

/**
 * @author Rashidi Zin
 * @version 1.0.0
 * @since 1.0.0
 */
public class Result {

	private SearchInformation searchInformation;
	private List<Item> items;
	
	public Result() {
		
	}

	public List<Item> getItems() {
		return items;
	}

	public void setItems(List<Item> items) {
		this.items = items;
	}

	public SearchInformation getSearchInformation() {
		return searchInformation;
	}

	public void setSearchInformation(SearchInformation searchInformation) {
		this.searchInformation = searchInformation;
	}
	
}
