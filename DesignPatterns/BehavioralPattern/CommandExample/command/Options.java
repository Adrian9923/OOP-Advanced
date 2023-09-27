package command;
//4. We will also need an Options class for our two commands.
//
//We will create an Options() method with holding parameters.
public class Options {
    private Command openSublimeText;
    private Command closeSublimeText;

    public Options(Command open, Command close) {
        this.openSublimeText = open;
        this.closeSublimeText = close;
    }

    public void pressOpen() {
        openSublimeText.execute();
    }


    public void pressClose() {
        closeSublimeText.execute();
    }
}