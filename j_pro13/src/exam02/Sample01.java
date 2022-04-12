package exam02;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.Random;
import java.util.StringTokenizer;

public class Sample01 {

	public static void main(String[] args) {
		/*
		 * 프로그램에서 사용한 데이터 타입 값을 파일로 쓰거나 읽기
		 */
		
		// 정수 배열에 저장된 1 ~ 100 사이의 값을 파일로 저장
		Random rand = new Random();
		int[] iArr = new int[6];
		
		for(int i = 0; i < iArr.length; i++) {
			iArr[i] = rand.nextInt(100) + 1;
		}
		
		System.out.println(Arrays.toString(iArr));
		
		File f = new File("C:/Users/user2/data_write");
		
		String[] sArr = new String[iArr.length];
		
		for(int i = 0; i < iArr.length; i++) {
			sArr[i] = Integer.valueOf(iArr[i]).toString();
		}
		
		try (FileWriter fw = new FileWriter(f)) {
			fw.write(String.join(" ", sArr));
			fw.flush();
		} catch (FileNotFoundException e) {
			System.out.println("해당 파일이 존재하지 않습니다.");
			e.printStackTrace();
		} catch (IOException e) {
			System.out.println("파일 쓰기 작업중 문제가 발생하였습니다.");
			e.printStackTrace();
		}
		
		
		try (FileReader fr = new FileReader(f)) {
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
			
			StringTokenizer st = new StringTokenizer(new String(data), " ");
			int[] iArr2 = new int[st.countTokens()];
			int i = 0;
			
			while(st.hasMoreTokens()) {
				iArr2[i++] = Integer.parseInt(st.nextToken());
			}
			
			System.out.println(Arrays.toString(iArr2));
			
		} catch (FileNotFoundException e) {
			System.out.println("해당 파일이 존재하지 않습니다.");
			e.printStackTrace();
		} catch (IOException e) {
			System.out.println("파일 쓰기 작업중 문제가 발생하였습니다.");
			e.printStackTrace();
		}
	}

}
