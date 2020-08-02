package testObject;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.time.LocalTime;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

public class DownloadByJSoup {
	
	
	public static void main(String[] args) throws IOException
	{
		final long startTime = System.nanoTime();
		InputStream in = new URL("http://192.168.210.22/cs/get_mail_files/?mailid=raghib.khan@naukri.com&password=balbasaur%2305&filename=job_site_date&date=2020-05-05&mailbox=inbox&subject=Easy+Apply+Data+Job+Wise+Site+Wise").openStream();
		Files.copy(in, Paths.get("./abcd.csv"), StandardCopyOption.REPLACE_EXISTING);
		System.out.println("done");
		final long duration = System.nanoTime() - startTime;
		System.out.println("Completed in " + (duration/1000000000) / 60 + "minutes and " + (duration/1000000000) % 60 + "seconds");
		
		
		
		//Jsoup.connect("http://192.168.210.22/cs/get_mail_files/?mailid=raghib.khan@naukri.com&password=balbasaur%2305&filename=job_site_date&date=2020-05-05&mailbox=inbox&subject=Easy+Apply+Data+Job+Wise+Site+Wise");
	}
//	Document doc = (Document) Jsoup.connect("");

}
