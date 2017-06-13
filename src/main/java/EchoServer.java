import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.io.IOException;

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
                InputStreamReader isr = new InputStreamReader(System.in);

                //７ 出力Streamのインスタンスを作成
                OutputStream os = socket.getOutputStream();

                //８ 入力StreamにKeyBoardから打ち込んだものを読込ませる(readLine)
                BufferedReader br = new BufferedReader(isr);

                String str = br.readLine();

                //９ 入力Streamで得たものを出力Streamに渡す
                byte[] echo = str.getBytes();

                //１０ 出力Streamの中身を書出す(write)
                os.write(echo);

            } catch (IOException e1) {
                e1.printStackTrace();
            }

        }
    }
}