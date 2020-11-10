package com.capacitacion.excepciones.procesos;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ProcesarDatos {
	
	public int division(String numero1,String numero2) {
		int resultado = 0;
		
		resultado=Integer.valueOf(numero1)/Integer.valueOf(numero2);
		return resultado;
		
	}
	
	
	public void arreglo(String[] lista) {
		
		try {
			for(int i=0;i<=5;i++) {
				System.out.println(lista[i]);
			}
		} catch (Exception e) {
			System.out.println(e.getStackTrace());
			System.out.println(e.getCause());
			System.out.println(e.getMessage());
		}
		
		
	}
	
	public void fecha(String input) throws ParseException {
		
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");

		try {
			Date   date  = format.parse (input );
			date.toString();
		} catch (ParseException e) {
			throw e;
		}
	}
	
	public void escribir() {
		FileWriter file = null;
		FileReader input = null;
		try {
			input = new FileReader("C:\\Fabian\\TCS_admin\\faculty\\excepciones\\src\\main\\java\\com\\capacitacion\\excepciones\\datos\\data.txt");
			file = new FileWriter("C:\\Fabian\\TCS_admin\\faculty\\excepciones\\src\\main\\java\\com\\capacitacion\\excepciones\\datos\\data2.txt");
			BufferedReader br = new BufferedReader(input);
			String linea ;
			while ((linea=br.readLine())!=null) {
				String[] token=linea.split(";");
				file.write(token[0]+";"+token[2]+"\n");
			}
			
		} catch (IOException e) {
			try {
				file.close();
				input.close();
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			e.printStackTrace();
		}finally {
			try {
				file.close();
				input.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}


}
