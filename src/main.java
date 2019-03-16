public class main {

    public static void main(String[] args)
    {
        Repo repo = new Repo();
        Ctrl ctrl = new Ctrl(repo);
        Ui ui = new Ui(ctrl);
        ui.run();

    }
}
