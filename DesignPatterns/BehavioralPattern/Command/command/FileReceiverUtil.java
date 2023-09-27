package command;
// return a new instance of the WindowsFileReceiver
public class FileReceiverUtil {
    public static FileReceiver getInstance() {
        return  new WindowsFileReceiver();
    }
}
