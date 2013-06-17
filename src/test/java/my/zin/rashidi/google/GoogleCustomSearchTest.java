/**
 * 
 */
package my.zin.rashidi.google;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import my.zin.rashidi.google.customsearch.entity.Result;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

/**
 * @author Rashidi Zin
 * @version 1.2.0
 * @since 1.0.0
 */
@RunWith(JUnit4.class)
public class GoogleCustomSearchTest {
	
	GoogleCustomSearch $;
	
	private final String cx = "014723624719242706501:ky6zn2teax4";
	private final String apiKey = "AIzaSyBFnKBQPESdi2sP1twKp59-3mBscTVw99k";
	
	@Before
	public void setUp() throws Exception {
		$ = new GoogleCustomSearch(cx, apiKey);
	}

	@Test(expected = IllegalArgumentException.class)
	public void testIllegalArgumentException() {
		new GoogleCustomSearch(null, null);
	}
	
	@Test
	public void testApiKeyAvailable() {
		assertNotNull($.getApiKey());
	}
	
	@Test
	public void testResultAvailable() {
		Result result = $.execute("Inferno");
		assertNotNull(result);
		assertTrue(Long.valueOf(result.getSearchInformation().getTotalResults()) > 0);
	}

    @Test
    public void testMultipleKeywords() {
        Result result = $.execute("bob marley");
        assertNotNull(result);
        assertTrue(Long.valueOf(result.getSearchInformation().getTotalResults()) > 0);
    }
	
	@Test
	public void testSearchTime() {
		Result result = $.execute("android");
		assertTrue(result.getSearchInformation().getSearchTime() > 0);
	}
	
	@Test
	public void testSetTotalResult() {
		int total = 15;
		GoogleCustomSearch search = new GoogleCustomSearch(cx, apiKey, total);
		Result result = search.execute("Android");
		assertEquals(total, result.getItems().size());
	}
	
	@Test
	public void testSetTotalResultLesserThanDefault() {
		int total = 7;
		GoogleCustomSearch search = new GoogleCustomSearch(cx, apiKey, total);
		Result result = search.execute("Android");
		assertEquals(total, result.getItems().size());
	}
}
