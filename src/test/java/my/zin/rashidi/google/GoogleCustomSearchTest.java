/**
 * 
 */
package my.zin.rashidi.google;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import my.zin.rashidi.google.customsearch.entity.Result;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

/**
 * @author Rashidi Zin
 * @version 1.0.0
 * @since 1.0.0
 */
@RunWith(JUnit4.class)
public class GoogleCustomSearchTest {
	
	GoogleCustomSearch $;
	
	@Before
	public void setUp() throws Exception {
		final String cx = "354574352034.apps.googleusercontent.com";
		final String apiKey = "AIzaSyBtlU8cnCuyx85hoGCISCxU-b7XSWGnSpI";

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
		Result result = $.execute("rashidi zin");
		assertNotNull(result);
	}
	
	@Test
	public void testSearchTime() {
		Result result = $.execute("android");
		assertTrue(result.getSearchInformation().getSearchTime() > 0);
	}
}
