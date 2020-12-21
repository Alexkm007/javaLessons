package homework8;

@MetaData( fileName = "./src/homework8/textTest.txt", methodName = "saveToTxtOne")
public class TextContainer {
    private String text;

    public TextContainer() {
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
