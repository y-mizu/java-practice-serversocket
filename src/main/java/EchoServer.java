import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

// １ EchoServerクラスをつくる
public class EchoServer {
    public static final int PORT = 8080;
    public static void main(String[] args) {
        // ２ ServerSocket型の変数serverSocketを初期化　
        ServerSocket serverSocket = null;

        while (true) {
            try {
                //３ serverSocketのインスタンスを生成　
                serverSocket = new ServerSocket(PORT);
                //４ サーバーソケットに対する接続要求を待機して、それを受け取る(accept)
                Socket socket = serverSocket.accept();

                //５ InputStream型の変数isに通信ソケットから受信するバイトストリームを取得
                InputStream is = socket.getInputStream();

                //６ OutputStream型の変数osに通信ソケットに送信するバイトストリームを取得
                OutputStream os = socket.getOutputStream();

                //７ BufferedReaderのインスタンスの生成及びPrintStream型のインスタンスの生成
                BufferedReader br = new BufferedReader(new InputStreamReader(is));
                PrintStream ps = new PrintStream(os);

                //８ クライアントから文字列を受信し、サーバーの標準出力に出力する
                String receive = br.readLine();
                System.out.println(receive + "が入力されました。");

                //９ クライアントにメッセージを送る
                ps.println(receive);

                //１０　ストリームやソケットを閉じる
                socket.close();
                serverSocket.close();
                is.close();
                os.close();
                br.close();
                ps.close();

            } catch (IOException e1) {
                e1.printStackTrace();
            }
        }
    }
}