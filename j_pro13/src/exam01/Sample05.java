package exam01;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;

public class Sample05 {

	public static void main(String[] args) {
		/*
		 * FileWriter
		 *     - 문자 기반 스트림으로 문자 단위로 파일을 쓴다.
		 *     - 보통 텍스트 파일을 쓰기 위해 사용
		 */
		File f = new File("C:/Users/user2/file_test.txt");
		
		try (FileWriter fw = new FileWriter(f, true)) {
			
			fw.write(65);
			
			char[] cArr = new char[] {66, 67, 68, 69};
			fw.write(cArr);
			
			fw.write("\nFileOutputStream\n");
			
			fw.write("한글 쓰기");
			
			fw.flush();
		} catch (FileNotFoundException e) {
			System.out.println("해당 파일을 찾지 못하였습니다.");
			e.printStackTrace();
		} catch (IOException e) {
			System.out.println("파일 쓰기 작업중 문제가 발생하였습니다.");
			e.printStackTrace();
		}
	}

}
