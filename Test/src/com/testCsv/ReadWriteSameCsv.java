package com.testCsv;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVPrinter;
import org.apache.commons.csv.CSVRecord;

public class ReadWriteSameCsv {
	
	BufferedReader reader;
	CSVParser csvParser;
	BufferedWriter writer;
	CSVPrinter csvPrinter;
	public ArrayList<CSVRecord> temp = new ArrayList<CSVRecord>();
	
	public void operation() throws Exception
	{
		reader = new BufferedReader(new FileReader("./Sample.csv"));
		csvParser =  new CSVParser(reader, CSVFormat.DEFAULT
	               .withFirstRecordAsHeader()
	               .withIgnoreHeaderCase()
	               .withTrim());
		writer = new BufferedWriter(new FileWriter("./SampleOutput.csv"));
		csvPrinter =  new CSVPrinter(writer, CSVFormat.DEFAULT);
		csvPrinter.printRecord(csvParser.getHeaderNames());
		
		for(CSVRecord csvRecord : csvParser)
		{
//			if(csvRecord.get("Company Id").equals("10007018"))
//			{
				String[] s = toArray(csvRecord);

	            
	                s[6] = "Replacement Text";
	            
	            print(csvPrinter, s);
//			}
		}
		reader.close();
		csvParser.close();
		csvPrinter.flush();
		

	}
	
	public String[] toArray(CSVRecord rec) {
        String[] arr = new String[rec.size()];
        int i = 0;
        for (String str : rec) {
            arr[i++] = str;
        }
        return arr;
    }
	
	public static void print(CSVPrinter csvPrinter, String[] s) throws Exception {
        for (String val : s) {
        	csvPrinter.print(val != null ? String.valueOf(val) : "");
        }
        csvPrinter.println();
    }
	
	public static void main(String[] args) throws Exception
	{
		ReadWriteSameCsv obj = new ReadWriteSameCsv();
		obj.operation();
		System.out.println("Success");
	}

}
