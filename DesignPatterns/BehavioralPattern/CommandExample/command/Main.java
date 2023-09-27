package command;

public class Main {
    public static void main(String[] args ) {
        Text sublimeText = new Text();
        Command openSublimeText = new OpenText(sublimeText);
        Command closeSublimeText = new CloseText(sublimeText);
        Options option = new Options(openSublimeText,closeSublimeText);
        option.pressOpen();
        option.pressClose();
    }
}
