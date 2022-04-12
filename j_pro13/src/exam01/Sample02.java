package exam01;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Arrays;

public class Sample02 {

	public static void main(String[] args) {
		/*
		 * FileInputStream 클래스
		 *     - 바이트 기반 스트림으로 바이트 단위로 파일을 읽는다.
		 *     - 미디어, 이미지, 텍스트 파일 등 모든 종류의 파일 읽기 가능
		 */
		File f = new File("C:/Users/user2/file_test.txt");
		
		try {
			FileInputStream fis = new FileInputStream(f);
			
			/*
			while(true) {
				int i = fis.read();
				if(i == -1) {
					break;
				}
				System.out.print((char)i);
			}
			*/
			
			byte[] buffer = new byte[4];
			byte[] bytes = new byte[0];
			
			while(true) {
				int i = fis.read(buffer);
				if(i == -1) {
					break;
				}
				bytes = Arrays.copyOf(bytes, bytes.length + i);
				System.arraycopy(buffer, 0, bytes, bytes.length - i, i);
			}
			
			System.out.println(new String(bytes));
			
		} catch (FileNotFoundException e) {
			System.out.println("해당 파일을 찾지 못하였습니다.");
			e.printStackTrace();
		} catch (IOException e) {
			System.out.println("해당 파일을 읽는 과정에 문제가 발생하였습니다.");
			e.printStackTrace();
		}
	}

}
