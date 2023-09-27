package command;
//3. we should create the classes that implement a Command interface that we have created:
public class OpenText implements Command
{
    private Text Text;

    public OpenText(Text sublimeText)
    {
        this.Text = sublimeText;
    }

    @Override
    public void execute()
    {
        Text.open();
    }
}
