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

public class ReadWriteSame2 {
	
	BufferedReader reader;
	CSVParser csvParser;
	BufferedWriter writer;
	CSVPrinter csvPrinter;
	public ArrayList<String[]> temp = new ArrayList<String[]>();
	
	public void readData() throws Exception
	{
		reader = new BufferedReader(new FileReader("./SampleOutput.csv"));
		csvParser =  new CSVParser(reader, CSVFormat.DEFAULT
	               .withFirstRecordAsHeader()
	               .withIgnoreHeaderCase()
	               .withTrim());
		
		for(CSVRecord csvRecord : csvParser)
		{
			String[] s = toArray(csvRecord);	            
            s[6] = "khan";
            temp.add(s);
		}
		reader.close();
		csvParser.close();
//		csvPrinter.flush();

	}
	//converting to array of string to make changes to particular cell
	public String[] toArray(CSVRecord rec) {
        String[] arr = new String[rec.size()];
        int i = 0;
        for (String str : rec) {
            arr[i++] = str;
        }
        return arr;
    }
	
	public void print() throws Exception {
		writer = new BufferedWriter(new FileWriter("./SampleOutput.csv")); //write same name if want to replace original data
		csvPrinter =  new CSVPrinter(writer, CSVFormat.DEFAULT);
		csvPrinter.printRecord(csvParser.getHeaderNames());
		for(String[] item : temp)
		{
			for (String val : item) {
	        	csvPrinter.print(val != null ? String.valueOf(val) : "");
	        }
	        csvPrinter.println();
		}
        csvPrinter.flush();
    }	
	public static void main(String[] args) throws Exception
	{
		ReadWriteSame2 obj = new ReadWriteSame2();
		obj.readData();
		obj.print();
		System.out.println("Success");
	}

}
