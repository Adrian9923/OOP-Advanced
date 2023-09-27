package command;
//3.
public class CloseText implements Command {
    private Text text;

    public CloseText(Text sublimeText) {
        this.text = sublimeText;
    }

    @Override
    public void execute() {
        text.close();
    }
}