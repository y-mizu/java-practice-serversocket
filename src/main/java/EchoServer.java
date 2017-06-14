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
        //３　ソケットの登録(bind)

        //４　ソケット接続準備(listen)

        //<繰返>
        while (true) {
            try {
                //５ サーバーソケットに対する接続要求を待機して、それを受け取る(accept)
                socket = serverSocket.accept();

                //６ 入力Streamのインスタンスを作成
                InputStream is = socket.getInputStream();

                //７ 出力Streamのインスタンスを作成
                OutputStream os = socket.getOutputStream();

                //８ 入力StreamにKeyBoardか(telnet)ら打ち込んだものを読込ませる(readLine)
                DataInputStream dis = new DataInputStream(is);
                PrintStream ps = new PrintStream(os);

                //BufferedReader br = new BufferedReader(isr);

                // クライアントから文字列を受信し、標準出力に出力する

                String receive = dis.readLine();
                System.out.println(receive + "が入力されました.");

                //９ クライアントにメッセージを送る
                String send = "Received: \"" + receive + "\"";

                //１０ 出力Streamの中身を書出す(write)
                ps.println(send);

            } catch (IOException e1) {
                e1.printStackTrace();
            }

        }
    }
}