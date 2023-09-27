package command;

public class OpenFileCommand implements Command{
    private final FileReceiver fileReceiver;

    public OpenFileCommand(FileReceiver fileReceiver) {
        this.fileReceiver = fileReceiver;
    }

    @Override
    public void execute() {
        this.fileReceiver.openFile();
    }
}
