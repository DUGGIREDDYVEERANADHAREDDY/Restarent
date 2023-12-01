package com.imageinfo.filereader;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;
public class Imageinfofilereader {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the path");
		String path = sc.nextLine();
		FileReader filereader = null;
		BufferedReader bufferReader;
		long count = 0;
		try {
			filereader = new FileReader(path);
			bufferReader = new BufferedReader(filereader);
			String readLine = bufferReader.readLine();
			System.out.println("enter you wnat to enter letter");
			String string=sc.next();
			LocalDateTime currentDateTime = LocalDateTime.now();
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
            String formattedDateTime = currentDateTime.format(formatter);
            System.out.println("Current Date and Time: " + formattedDateTime);
			while(readLine != null) {
				///home/administrator/Downloads/Assignment_SampleFile.txt
				///home/administrator/Desktop/simple.txt
//				System.out.println("enter you wnat to enter letter");
//				String string=sc.next();
				System.out.println(readLine);
				if(readLine.toLowerCase().concat(string) != null) {
					count = count + 1;
					
				}
				readLine = bufferReader.readLine();
			}
			
			System.out.println("total number of words k:-"+count);
			LocalDateTime currentDateTime1 = LocalDateTime.now();
            DateTimeFormatter formatter1 = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
            String formattedDateTime1 = currentDateTime1.format(formatter1);
            System.out.println("Current Date and Time: " + formattedDateTime1);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
