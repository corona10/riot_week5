package univ.lecture.riotapi.calc;

import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;
import java.util.regex.Pattern;

/**
 * Created by KimDongha on 2017-04-03.
 */
public class Utility {

    private Utility() {
    }

    public static boolean isNumber(String s) {
        String numRegex = "-?\\d+(\\.\\d*)?|\\.\\d+";
        Pattern p = Pattern.compile(numRegex);
        return p.matcher(s).matches();
    }

    public static String deleteUrlLastEqual(String url) {
        char last = url.charAt(url.length() - 1);
        if (last == '=')
            return url.substring(0, url.length() - 1);
        return url;
    }

    public static String[] tokenize(String str) {
        StringTokenizer tokenizer = new StringTokenizer(str, "+-*/() ", true);
        List<String> list = new LinkedList<>();


        while (tokenizer.hasMoreTokens()) {
            String token = tokenizer.nextToken();
            if (" ".equals(token)) {
                continue;
            }
            list.add(token);
        }

        return list.toArray(new String[list.size()]);
    }


}
