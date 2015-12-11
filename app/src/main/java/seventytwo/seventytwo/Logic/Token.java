package seventytwo.seventytwo.Logic;

/**
 * Created by dongu on 10/12/2015.
 * This class handles tokens, which has 2 primary attributes: Color and Number.
 */
public class Token {

    // Attributes
    private Color _color;
    private int _number;

    // Constructors
    public Token(Token token) {
        _color = token.getColor();
        _number = token.getNumber();
    }

    public Token(String color, int number) {
        _color = Color.valueOf(color);
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
        tokenDetails = tokenDetails.concat(color).concat(number).concat("\n");
        return tokenDetails;
    }
}
