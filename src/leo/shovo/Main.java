package leo.shovo;
import java.io.IOException;

import org.jsoup.Jsoup;
import org.jsoup.Jsoup.*;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
public class Main {
public static void main(String args[]) throws IOException
{
	
	Document doc;
	doc=doc=Jsoup.connect("http://mph-bd.com/index.php/generic-drugs/cns/473-hypnotics-and-anxiolytics/hypnotics/benzodiazepines/478-diazepam").get();
	Elements links =doc.getElementsByTag("td");
	int cnt=0;
	int p=0;
	String k;
    for(Element link:links){
    k=link.select("strong a").text();
    k.replaceAll("\\s+","");
    if(k.equals("ATC Classification")) {
    	cnt=1;
    	continue;
    }
    if (cnt==0) continue;
    if(k.equals("About us Contact us Terms of use Privacy policy")) continue;
    System.out.println(k);
    p++;
    	}
    System.out.println(p);
    }
}

