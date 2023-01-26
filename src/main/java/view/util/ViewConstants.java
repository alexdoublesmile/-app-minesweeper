package view.util;

import util.PropertyHelper;

public final class ViewConstants {
    public static final String VIEW_TITLE = "Minesweeper Pro";
    public static final String GREETING_LABEL = "Welcome!";
    public static final String VERSION_MESSAGE_TITLE = "Minesweeper Pro version";

    public static final String VERSION = PropertyHelper.getProperty("version.number");
    public static final String VERSION_DATE = PropertyHelper.getProperty("version.date");
    public static final String PROGRAM_CREATOR = PropertyHelper.getProperty("creator");
    public static final String VERSION_MESSAGE_TEXT =
            String.format("<html>" +
                            "<p>Minesweeper Pro v.%s</p>" +
                            "<p>revision %s</p>" +
                            "<p style=\"color: red; text-align:center\">by %s</p>",
                    VERSION, VERSION_DATE, PROGRAM_CREATOR);
}
