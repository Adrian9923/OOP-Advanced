package command;

public class Main {
    public static void main(String[] args) {
        //1. we have to create the Receiver object and attach it to the command
        //2. create an Invoker object and attach the command object to the invoker in order to perform the action
        FileReceiver fileReceiver = FileReceiverUtil.getInstance();
        Command openFileCommand = new OpenFileCommand(fileReceiver);
        FileInvoker fileInvoker = new FileInvoker(openFileCommand);
        fileInvoker.execute();
    }
}
