package game.db;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Database {
	
	private File file;
	private String[] rowData;
	
	public Database() {
		this.file = new File("C:/Users/user2/data_write");
		this._load();
	}
	
	public Database(File file) {
		this.file = file;
	}
	
	public boolean isExists(String name) {
		return _findIndex(name) == -1 ? false : true;
	}
	
	public int[] getRecord(String name) {
		int[] res = new int[3];
		int idx = _findIndex(name);
		
		if(idx == -1) {
			return res;
		}
		
		String[] temp = rowData[idx].split(" ");
		for(int i = 0; i < res.length; i++) {
			res[i] = Integer.parseInt(temp[i + 1]);
		}
		
		return res;
	}
	
	private int _findIndex(String name) {
		for(int i = 0; i < rowData.length; i++) {
			if(rowData[i].contains(name)) {
				return i;
			}
		}
		return -1;
	}
	
	private void _rowParser(String data) {
		StringTokenizer st = new StringTokenizer(new String(data), "\r\n");
		rowData = new String[st.countTokens()];
		int i = 0;
		
		while(st.hasMoreTokens()) {
			rowData[i++] = st.nextToken();
		}
	}
	
	private void _load() {
		try (FileReader fr = new FileReader(file)) {
			char[] buff = new char[16];
			char[] data = new char[0];
			
			while(true) {
				int rSize = fr.read(buff);
				
				if(rSize == -1) {
					break;
				}
				
				data = Arrays.copyOf(data, data.length + rSize);
				System.arraycopy(buff, 0, data, data.length - rSize, rSize);
			}
			
			_rowParser(new String(data));
			
		} catch (FileNotFoundException e) {
			System.out.println("해당 파일이 존재하지 않습니다.");
			e.printStackTrace();
		} catch (IOException e) {
			System.out.println("파일 쓰기 작업중 문제가 발생하였습니다.");
			e.printStackTrace();
		}
	}
	
	public void save(String name, int[] record) {
		// 정수 배열을 파일로 저장
		String[] sArr = new String[record.length];
		
		for(int i = 0; i < record.length; i++) {
			sArr[i] = Integer.valueOf(record[i]).toString();
		}
		
		int idx = _findIndex(name);
		if(idx == -1) {
			rowData = Arrays.copyOf(rowData, rowData.length + 1);
			rowData[rowData.length - 1] = name + " " + String.join(" ", sArr);
		} else {
			rowData[idx] = name + " " + String.join(" ", sArr);
		}
		
		try (FileWriter fw = new FileWriter(file)) {
			for(int i = 0; i < rowData.length; i++) {
				fw.write(rowData[i] + "\r\n");
			}
			fw.flush();
		} catch (FileNotFoundException e) {
			System.out.println("해당 파일이 존재하지 않습니다.");
			e.printStackTrace();
		} catch (IOException e) {
			System.out.println("파일 쓰기 작업중 문제가 발생하였습니다.");
			e.printStackTrace();
		}
	}
}
