package Action.Options;

import Data.Response;

public abstract class OptionFactory {
    private String option;

    OptionFactory(String option) {
        this.option = option;
    }

    public String getOption() {
        return option;
    }

    public abstract Response doAction(String action);
}
