package exam01.client;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.util.Scanner;

public class UDPClient {

	public static void main(String[] args) {
		try {
			/*
			 * 1. 네트워크 통신을 위한 IP 주소 정보 설정
			 */
			// InetAddress ip = InetAddress.getByName("localhost");
			
			// byte[] addr = new byte[] {(byte)192, (byte)168, (byte)20, (byte)11};
			// InetAddress ip = InetAddress.getByAddress(addr);
			
			InetAddress clientIp = InetAddress.getLocalHost();
			int clientPort = 50000;
			
			byte[] addr = new byte[] {(byte)192, (byte)168, (byte)20, (byte)11};
			InetAddress serverIp = InetAddress.getByAddress(addr);
			int serverPort = 51000;
			
			/*
			 * 2. UDP 통신용 소켓 생성
			 */
			DatagramSocket udpSock = new DatagramSocket(clientPort, clientIp);
			
			/*
			 * 3. 서버에 데이터를 송신하기 위한 패킷 생성
			 *    (서버가 활성화 되어 있어야 한다.)
			 */
			Scanner sc = new Scanner(System.in);
			while(true) {
				String msg = sc.nextLine();
				byte[] data = msg.getBytes();
				DatagramPacket packet = new DatagramPacket(data, data.length, serverIp, serverPort);
				udpSock.send(packet);
			}
			
			/*
			 * 4. 데이터 송신을 완료하였으면 모든 자원 반납.
			 */
			// udpSock.close();
			
		} catch (UnknownHostException e) {
			e.printStackTrace();
		} catch (SocketException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
