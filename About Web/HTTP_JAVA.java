package HTTP;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class HTTP_JAVA {


	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		int PORT =  8080; 
		
		ServerSocket serverSocket = new ServerSocket(PORT);
		System.out.println("서버가 시작됩니다. 포트번호: " + PORT);
		
		while (true) {
			Socket client = serverSocket.accept();
			System.out.println("클라이언트가 접속했습니다.");
			
			BufferedReader br = new BufferedReader(new InputStreamReader(client.getInputStream()));
			String request =br.readLine();
			System.out.println("클라이언트 request:" + request);
		
			BufferedWriter wr = new BufferedWriter(new OutputStreamWriter(client.getOutputStream()));
			
			if (request.startsWith("GET")) {
				String response = "HTTP/1.1 200 OK\r\n";
		            	response += "Content-Type: text/html; charset=utf-8\r\n\r\n"; // 인코딩 정보를 포함한 Content-Type 헤더
		                response += "<html><body><h1>GET방식으로 요청을 확인했습니다.</h1></body></html>"; // 응답으로 보낼 내용 (HTML 형식)
		                wr.write(response);
		                wr.flush();
			}else {
				String response ="HTTP/1.1  400 Bad Request\r\n\r\n";
				wr.write(response);
				wr.flush();
			}
			
			wr.close();
			br.close();
			client.close();
		}
		
	}

}
