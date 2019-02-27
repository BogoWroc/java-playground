package pl.zebek.kata;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegExp {

    public static void main(String[] args) {
        String pattern = "\\b"+"tree fiddy"+"\\b";
        Pattern p=Pattern.compile(pattern);
        Matcher m=p.matcher("Your girlscout cookies are ready to ship. Your total comes to tree fiddy");
        System.out.println(m.find());

        System.out.println("Your girlscout cookies are ready to ship. Your total comes to tree fiddy".matches(pattern));
    }
}
