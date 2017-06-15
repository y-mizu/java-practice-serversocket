import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

// 1 EchoServerクラスをつくる
public class EchoServer {
    public static final int PORT = 8080;
    public static void main(String[] args) throws IOException {

        try {
            //2 ServerSocketのインスタンスを生成　
            ServerSocket serverSocket = new ServerSocket(PORT);

            while (true) {
                //3 サーバーソケットに対する接続要求を待機して、それを受け取る(accept)
                Socket socket = serverSocket.accept();

                //4 InputStream型のインスタンスisに通信ソケットから受信するバイトストリームを取得
                InputStream is = socket.getInputStream();

                //5 OutputStream型のosに通信ソケットに送信するバイトストリームを取得
                OutputStream os = socket.getOutputStream();

                //6 BufferedReaderのインスタンスの生成及びPrintStream型のインスタンスの生成
                BufferedReader br = new BufferedReader(new InputStreamReader(is));
                PrintStream ps = new PrintStream(os);

                //7 クライアントから文字列を受信し、サーバーの標準出力に出力する
                String receive = br.readLine();
                System.out.println(receive + "が入力されました。");

                //8 クライアントにメッセージを送る
                ps.println(receive);

                //9　ストリームやソケットを閉じる
                serverSocket.close();
                socket.close();
                is.close();
                os.close();
                br.close();
                ps.close();
            }
        } catch (IOException e){
                e.printStackTrace();
        }
    }
}