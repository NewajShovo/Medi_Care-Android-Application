package teast.mub;

import java.io.IOException;
import java.io.BufferedWriter;
import java.io.FileWriter;
import org.jsoup.Jsoup;
import org.jsoup.Jsoup.*;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class WriteToFileExample1 {

	private static final String FILENAME = "generic.txt";

	public static void main(String[] args) throws IOException {

		
		FileWriter fw = new FileWriter(FILENAME,true);
		BufferedWriter bw = new BufferedWriter(fw);
		try {

			String content = null;

			fw = new FileWriter(FILENAME,true);
			bw = new BufferedWriter(fw);
			Document doc;
			doc=Jsoup.connect("http://mph-bd.com/index.php/generic-drugs/cns?view=alphagenerics&filter=B").get();
			Elements links =doc.getElementsByTag("tr");
			for(Element link:links){
				//String l=link.attr("class");
			String k=link.select("a").text();
			if(k.equals("Title")) continue;
			if(k.length()>20){
			if(k.substring(0,16).equals("About us Contact")) continue;
			}
			content=k;
		    System.out.println(content);
			bw.write(content);
			bw.newLine();
			
			
		    }
			System.out.println("Done");

		} catch (IOException e) {

			e.printStackTrace();

		} finally {

			try {

				if (bw != null)
					bw.close();

				if (fw != null)
					fw.close();

			} catch (IOException ex) {

				ex.printStackTrace();

			}

		}

	}

}