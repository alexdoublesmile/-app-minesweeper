package view.util;

import config.PropertyConfig;
import lombok.experimental.UtilityClass;

@UtilityClass
public class ViewConstants {
    public static final String VIEW_TITLE = "Minesweeper Pro";
    public static final String GREETING_LABEL = "Welcome!";
    public static final String VERSION_MESSAGE_TITLE = "Minesweeper Pro version";

    public static final String VERSION = PropertyConfig.getProperty("version.number");
    public static final String VERSION_DATE = PropertyConfig.getProperty("version.date");
    public static final String PROGRAM_CREATOR = PropertyConfig.getProperty("creator");
    public static final String VERSION_MESSAGE_TEXT =
            String.format("<html>" +
                            "<p>Minesweeper Pro v.%s</p>" +
                            "<p>revision %s</p>" +
                            "<p style=\"color: red; text-align:center\">by %s</p>",
                    VERSION, VERSION_DATE, PROGRAM_CREATOR);
}
