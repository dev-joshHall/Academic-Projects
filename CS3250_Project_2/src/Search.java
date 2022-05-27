import java.io.IOException;
import java.net.URL;
import java.util.*;
import java.io.*;
import org.jsoup.Jsoup;
import org.jsoup.nodes.*;
import org.jsoup.parser.Parser;
import org.jsoup.select.*;

public class Search {
	public static void main(String args[]) throws IOException {
		List<String> words = new ArrayList<String>();
		URL url = new URL("https://en.wikipedia.org/wiki/Alice%27s_Adventures_in_Wonderland");
		Scanner sc = new Scanner(url.openStream());
		StringBuffer sb = new StringBuffer();
		while (sc.hasNext()) {
			sb.append(sc.next());
		}
		String htmlText = sb.toString();
		Document doc = Jsoup.parse(htmlText, "UTF_8");
		Element body = doc.select("html").first();
		Elements links = doc.select("a[href]");
		String bodyText = body.text();
	}
}
