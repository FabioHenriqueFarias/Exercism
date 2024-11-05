import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

class RunLengthEncoding {

    String encode(String data) {

        StringBuilder sb = new StringBuilder();

        if (data == null || data.isEmpty()) return "";

        int count = 1; // Inicia a contagem

        for (int i = 1; i < data.length(); i++) {
            if (data.charAt(i) == data.charAt(i - 1)) {
                count++;
            } else {
                // Adiciona a contagem se maior que 1
                if (count > 1) {
                    sb.append(count);
                }
                sb.append(data.charAt(i - 1));
                count = 1;
            }
        }

        if (count > 1) {
            sb.append(count);
        }
        sb.append(data.charAt(data.length() - 1));

        return sb.toString();
    }


    public static String decode(String data) {
        if (data == null || data.isEmpty()) return "";

        StringBuilder sb = new StringBuilder();
        StringBuilder tempNumber = new StringBuilder();

        for (int i = 0; i < data.length(); i++) {
            char c = data.charAt(i);

            if (Character.isDigit(c)) {
                tempNumber.append(c);
            } else {
                if (!tempNumber.isEmpty()) {
                    int num = Integer.parseInt(tempNumber.toString());
                    tempNumber.setLength(0);

                    sb.append(String.valueOf(c).repeat(Math.max(0, num)));
                } else {
                    sb.append(c);
                }
            }
        }

        return sb.toString();
    }
}