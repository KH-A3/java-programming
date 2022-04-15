package exam02.client;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class TCPClient {

	public static void main(String[] args) {
		try {
			/*
			 * 1. 네트워크 통신을 위한 IP 주소 정보 설정
			 */
			byte[] addr = new byte[] {(byte)192, (byte)168, (byte)20, (byte)11};
			InetAddress serverIp = InetAddress.getByAddress(addr);
			int serverPort = 50000;
			
			/*
			 * 2. 클라이언트용 소켓 생성
			 */
			Socket sock = new Socket(serverIp, serverPort);
			
			/*
			 * 3. 통신용 입출력 스트림 생성
			 */
			BufferedReader sIn = new BufferedReader(new InputStreamReader(sock.getInputStream()));
			BufferedWriter sOut = new BufferedWriter(new OutputStreamWriter(sock.getOutputStream()));
			
			Scanner sc = new Scanner(System.in);
			while(true) {
				String msg = sc.nextLine();
				sOut.write(msg);
				sOut.newLine();
				sOut.flush();
			}
			
			/*
			 * 4. 데이터 송신을 완료하였으면 모든 자원 반납.
			 */
			// sIn.close();
			// sOut.close();
			// sock.close();
			
		} catch (UnknownHostException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
