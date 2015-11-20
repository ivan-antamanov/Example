package Tests.web_test.socket;

/**
 * Created by iantaman on 13.11.2015.
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * —лушает указанный в первом параметре порт и выводит все приход€щие на него
 * сообщени€ на консоль.
 */
public class TcpServer {

    public static void main(String[] args) {
      /* ≈сли аргументы отсутствуют, порт принимае значение поумолчанию */
        int port = DEFAULT_PORT;
        if (args.length > 0) {
            port = Integer.parseInt(args[0]);
        }
      /* —оздаем серверный сокет на полученном порту */
        ServerSocket serverSocket = null;
        try {
            serverSocket = new ServerSocket(port);
        } catch (IOException e) {
            System.out.println("ѕорт зан€т: " + port);
            System.exit(-1);
        }
      /*
       * ≈сли порт был свободен и сокет был успешно создан, можно переходить к
       * следующему шагу - ожиданию клинта
       */
        Socket clientSocket = null;
        try {
            clientSocket = serverSocket.accept();
        } catch (IOException e) {
            System.out.println("ќшибка при подключении к порту: " + port);
            System.exit(-1);
        }
      /*
       * “еперь можно получить поток ввода, в который помещаютс€ сообщени€ от
       * клиента
       */
        InputStream in = null;
        try {
            in = clientSocket.getInputStream();
        } catch (IOException e) {
            System.out.println("Ќе удалось получить поток ввода.");
            System.exit(-1);
        }
      /*
       * ¬ этой реализации сервер будет без конца читать поток и выводить его
       * содержимое на консоль
       */
        BufferedReader reader = new BufferedReader(new InputStreamReader(in));
        String ln = null;
        try {
            while ((ln = reader.readLine()) != null) {
                System.out.println(ln);
                System.out.flush();
            }
        } catch (IOException e) {
            System.out.println("ќшибка при чтении сообщени€.");
            System.exit(-1);
        }
    }

    private static final int DEFAULT_PORT = 9999;


}
