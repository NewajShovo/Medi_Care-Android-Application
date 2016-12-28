package leo.shovo;

import java.io.IOException;

import org.jsoup.Jsoup;
import org.jsoup.Jsoup.*;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class Process {
public static void main(String[] args) throws IOException
{ 
Document doc;
doc=Jsoup.connect("http://mph-bd.com/index.php/browse-drugs?view=alphagenerics&filter=Z").get();
Elements links =doc.getElementsByTag("tr");
for(Element link:links){
	//String l=link.attr("class");
String k=link.select("a").text();
if(k.equals("Title")) continue;
if(k.length()>20){
if(k.substring(0,16).equals("About us Contact")) continue;
}
System.out.println(k);
	}
}
}

