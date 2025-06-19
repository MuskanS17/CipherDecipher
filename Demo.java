import java.util.*;

public class Demo {

    public static void main(String[] args) {


    }


    public static String removeSpace(String s) {
        String str="";
        for(int i=0;i<s.length();i++) {
            if(s.charAt(i)!=' ')
                str+=s.charAt(i);
        }
        return str;
    }
}
