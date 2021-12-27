package me.com.main;
import java.io.*;
public class LoadFile {
	
	
	
	public static void main(String args[]) throws IOException {
		
	}
	
	public String searchName(String name) throws IOException{
		
		try { 
				String pathname = "src/me/com/main/Adatabase.txt"; 
				File filename = new File(pathname);
				InputStreamReader reader = new InputStreamReader(new FileInputStream(filename)); 
				BufferedReader br = new BufferedReader(reader); 
				String line = "";
				//line = br.readLine();
				while (line != null) {
					line = br.readLine();
					if(line == null) break;
					//System.out.println(line);
					String[] st = line.split(" ");
					if(name.equals(st[0])) {
						return line;
					}
				}
			} finally {

			}
		return null;
	}
	
	public void changeMoney(String name, int money) throws IOException {
		
		String path = "src/me/com/main/Adatabase.txt";//�����|
		FileReader fr= new FileReader(path);
		BufferedReader br = new BufferedReader(fr);
		StringBuffer sb = new StringBuffer();
		FileWriter fw = null;

		String line;
		String newContent = "";//�ΨӼȦs��ʫ᪺���e
		while((line = br.readLine()) != null)//�v��Ū���A�Ӧ檺���e�s�iline
		{
			String[] st = line.split(" ");
			if(st[0].equals(name)) {
				newContent = newContent + line.replace(st[3],Integer.toString(Integer.parseInt(st[3]) - money))+ "\n";//
			} else {
				newContent = newContent + line + "\n";
			}
			
		}

		fw = new FileWriter(path);//�إ߷s�ɮסA���|��path
		fw.write(newContent);//�N�Ȧs���e�g�i�ɮפ�
		fr.close();
		br.close();
		fw.close();
	}
	
	public int getMoney(String name) throws IOException {
		
		String path = "src/me/com/main/Adatabase.txt";//�����|
		FileReader fr= new FileReader(path);
		BufferedReader br = new BufferedReader(fr);
		StringBuffer sb = new StringBuffer();
		FileWriter fw = null;

		String line;
		String newContent = "";//�ΨӼȦs��ʫ᪺���e
		while((line = br.readLine()) != null)//�v��Ū���A�Ӧ檺���e�s�iline
		{
			String[] st = line.split(" ");
			if(st[0].equals(name)) {
				return Integer.parseInt(st[3]);
			}
			
		}

		fw = new FileWriter(path);//�إ߷s�ɮסA���|��path
		fw.write(newContent);//�N�Ȧs���e�g�i�ɮפ�
		fr.close();
		br.close();
		fw.close();
		
		return 0;
	}
	

}
	
