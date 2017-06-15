import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

// １ EchoServerクラスをつくる
public class EchoServer {
    public static void main(String[] args) {
        Socket socket;
        int PORT = 8080;

        //２ サーバーソケットのインスタンスを生成する
        ServerSocket serverSocket = null;
        try {
            serverSocket = new ServerSocket(PORT);
        } catch (IOException e) {
            e.printStackTrace();
        }

        //<繰返>
        while (true) {
            try {
                //３ サーバーソケットに対する接続要求を待機して、それを受け取る(accept)
                socket = serverSocket.accept();

                //４ InputStream型の変数isに通信ソケットから受信するバイトストリームを取得
                InputStream is = socket.getInputStream();

                //５ OutputStream型の変数osに通信ソケットに送信するバイトストリームを取得
                OutputStream os = socket.getOutputStream();

                //６ DataInputStreamのインスタンスの生成及びPrintStream型のインスタンスの生成
                DataInputStream dis = new DataInputStream(is);
                PrintStream ps = new PrintStream(os);

                //７ クライアントから文字列を受信し、標準出力に出力する
                String receive = dis.readLine();
                System.out.println(receive + "が入力されました。");

                //８ クライアント返すために、変数sendに標準出力receiveを代入
                String send = "Received:" +receive;

                //９ クライアントにメッセージを送る
                ps.println(send);

                //１０　ストリームやソケットを閉じる
                dis.close();
                ps.close();
                is.close();
                os.close();
                socket.close();

            } catch (IOException e1) {
                e1.printStackTrace();
            }

        }
    }
}