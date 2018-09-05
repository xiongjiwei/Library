package View;

public abstract class AbstractPage {

    private String displayName;

    public AbstractPage(String display) {
        this.displayName = display;
    }

    String getDisplayName() {
        return displayName;
    }

    public abstract void showPage();
}
