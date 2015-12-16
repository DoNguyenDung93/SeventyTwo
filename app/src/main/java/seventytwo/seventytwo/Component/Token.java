package seventytwo.seventytwo.Component;

import java.util.logging.Level;
import java.util.logging.Logger;

import seventytwo.seventytwo.Logger.GlobalLogger;

/**
 * Created by dongu on 10/12/2015.
 * This class handles tokens, which has 2 primary attributes: Color and Number.
 */
public class Token {

    // Attributes
    private Color _color;
    private int _number;

    private static Logger _logger = GlobalLogger.getInstance().getLogger();

    // Constructors
    public Token(Token token) {
        _color = token.getColor();
        _number = token.getNumber();
    }

    public Token(Color color, int number) {
        _color = color;
        _number = number;
    }

    // Mutators
    public void setColor(Color color) {
        _color = color;
    }

    public void setNumber(int number) {
        _number = number;
    }

    // Accessors
    public Color getColor() {
        return this._color;
    }

    public int getNumber() {
        return this._number;
    }

    @Override
    public String toString() {
        String tokenDetails = "";
        String color = _color.toString().substring(0,1).toUpperCase();
        String number = Integer.toString(_number);
        tokenDetails = tokenDetails.concat(color).concat(number).concat(" ");
        return tokenDetails;
    }

    public static Token fromString(String tokenString) {
        Color color;
        switch (tokenString.substring(0,1)) {
            case "R": color = Color.RED;
                break;
            case "B": color = Color.BLUE;
                break;
            case "G": color = Color.GREEN;
                break;
            case "Y": color = Color.YELLOW;
                break;
            case "C": color = Color.CYAN;
                break;
            case "P": color = Color.PINK;
                break;
            default: color = null;
        }

        int number = Integer.parseInt(tokenString.substring(1));
        Token token = new Token(color, number);
        _logger.log(Level.INFO, "Convert string into token information.");
        return token;
    }
}
