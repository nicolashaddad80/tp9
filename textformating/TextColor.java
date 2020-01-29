package fr.cnam.tp9.textformating;

public enum TextColor {

    Highlight( fr.cnam.tp9.textformating.ANSIColorCode.ANSI_WHITE_BACKGROUND ),
    DEFAULT( fr.cnam.tp9.textformating.ANSIColorCode.ANSI_RESET ),
    RED( fr.cnam.tp9.textformating.ANSIColorCode.ANSI_RED ),
    BLUE( fr.cnam.tp9.textformating.ANSIColorCode.ANSI_BLUE ),
    GREEN( fr.cnam.tp9.textformating.ANSIColorCode.ANSI_GREEN ),
    BLACK( ANSIColorCode.ANSI_BLACK );

    public final String set;

    TextColor(String label) {
        this.set = label;
    }
}
