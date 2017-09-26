import java.io.IOException;
import java.net.URL;
import java.util.Scanner;
/**
 * Retrieve contents from a URL and return them as a string.
 *
 * @param url url to retrieve contents from
 * @return the contents from the url as a string, or an empty string on error
 */

public class Lab3 {
    public static String urlToString(final String url) {
        Scanner urlScanner;
        try {
            urlScanner = new Scanner(new URL(url).openStream(), "UTF-8");
        } catch (IOException e) {
            return "";
        }
        String contents = urlScanner.useDelimiter("\\A").next();
        urlScanner.close();
        return contents;
    }
    public static void main(String[] args) {
        System.out.print("Please enter an URL here: ");
        String url = TextIO.getln();
        if(urlToString(url) == "") {
            System.out.println("Invalid URL");
            System.exit(1);
        }
        System.out.print("What word do you want to search for? ");
        String interestedWord = TextIO.getln();
        long totalNum = count(interestedWord, urlToString(url));
        System.out.println("The number of " + interestedWord + " in the given website is " + totalNum);
    }

    public static long count(final String word, final String text) {
        long numberOfWord = 0;
        for(int i = 0; i < (text.length() - word.length()); i++) {
            if(text.substring(i, i + word.length()).equalsIgnoreCase(word)){
                numberOfWord++;
            }
        }
        return numberOfWord;
    }
}
