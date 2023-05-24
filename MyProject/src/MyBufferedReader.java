import java.io.*;

// класс,  чтобы показать работу AutoClosable
public class MyBufferedReader extends BufferedReader {

    public MyBufferedReader(Reader reader) {
        super(reader);
    }

    @Override
    public void close() throws IOException {
        super.close();
        System.out.println("AutoCloseable: закрываем MyBufferedReader");
    }
}