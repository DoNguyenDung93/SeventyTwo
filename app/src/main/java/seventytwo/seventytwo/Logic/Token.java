package seventytwo.seventytwo.Logic;

/**
 * Created by dongu on 10/12/2015.
 * This class handles tokens, which has 2 primary attributes: Color and Number.
 */
public class Token {

    // Attributes
    private Color _color;
    private Number _number;

    // Constructors
    public Token(Token token) {
        _color = token.getColor();
        _number = token.getNumber();
    }

    public Token(String color, String number) {
        _color = Color.valueOf(color);
        _number = Number.valueOf(number);
    }

    // Mutators
    public void setColor(Color color) {
        _color = color;
    }

    public void setNumber(Number number) {
        _number = number;
    }

    // Accessors
    public Color getColor() {
        return this._color;
    }

    public Number getNumber() {
        return this._number;
    }

    @Override
    public String toString() {
        String tokenDetails = "";
        String color = _color.toString();
        String number = _number.toString();
        tokenDetails = tokenDetails.concat(color).concat(", ").concat(number).concat("\n");
        return tokenDetails;
    }
}
