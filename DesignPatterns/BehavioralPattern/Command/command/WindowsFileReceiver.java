package command;

public class WindowsFileReceiver implements FileReceiver{
    @Override
    public void openFile() {
        System.out.println("Opening file in Windows OS.");
    }
}
