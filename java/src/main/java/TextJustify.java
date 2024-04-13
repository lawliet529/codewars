import java.util.ArrayList;
import java.util.List;

public class TextJustify {
  public static String justify(String text, int width) {
    List<String> fullText = new ArrayList<>();
    String[] wordArray = text.split("\\s+");
    int lineLength = -1; // Starting at -1 since first word doesn't add a space
    List<String> line = new ArrayList<>();
    for (String word : wordArray) {
      if (lineLength + 1 + word.length() > width) { // Line width exceeded
        // Append line and continue
        if (line.size() > 1) {
          int offset = width - lineLength;
          int i = 0;
          while (offset-- > 0) {
            line.set(i, line.get(i) + " ");
            i = (i + 1) % (line.size() - 1);
          }
        }
        fullText.add(String.join(" ", line).strip());
        // New line
        line.clear();
        lineLength = -1;
      }
      line.add(word);
      lineLength += word.length() + 1;
    }
    fullText.add(String.join(" ", line)); // Add remaining words
    return String.join("\n", fullText);
  }
}
