package game;

public class GameLoadException extends Exception {
    /** Class to declare the Exception.
     */
    private String reason;
    public GameLoadException(String reason){this.reason=reason; }
    public String getReason(){return reason;}
    public void setReason(String reason){this.reason=reason;}
}
