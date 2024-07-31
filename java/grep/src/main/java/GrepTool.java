import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

class GrepTool {

    String grep(String pattern, List<String> flags, List<String> files) {

        StringBuilder result = new StringBuilder();

        files.forEach(file -> {

            boolean ignoreCase = flags.contains("-i");
            boolean showLineNum = flags.contains("-n");
            boolean showFileName = flags.contains("-l");
            boolean invertMatch = flags.contains("-v");
            boolean exactMatch = flags.contains("-x");

            result.append(processing(file,files, pattern, ignoreCase, showLineNum, showFileName, invertMatch, exactMatch));

        });

        return result.toString().trim();
    }

    private StringBuilder processing(String file, List<String> files, String pattern, boolean ignoreCase, boolean showLineNum, boolean showFileName, boolean invertMatch, boolean exactMatch) {
        StringBuilder result = new StringBuilder();
        int lineNum = 1;
        boolean fileMatched = false;

        try(Scanner sc = new Scanner(new File(file))){

            while(sc.hasNextLine()) {
                String line = sc.nextLine();
                boolean match;

                if (exactMatch) {
                    match = ignoreCase ? line.equalsIgnoreCase(pattern) : line.equals(pattern);
                } else {
                    match = ignoreCase ? line.toLowerCase().contains(pattern.toLowerCase()) : line.contains(pattern);
                }

                if (invertMatch) {
                    match = !match;
                }



                if (match) {
                    if(showLineNum && showFileName){
                        if (!fileMatched) {
                            result.append(file).append("\n");
                            fileMatched = true;
                        }
                    }
                    else if (showLineNum) {
                        if (files.size() > 1) {
                            result.append(file).append(":");
                        }
                        result.append(lineNum).append(":").append(line).append("\n");
                    } else if (showFileName) {
                        if (!fileMatched) {
                            result.append(file).append("\n");
                            fileMatched = true;
                        }
                    }
                    else {
                        if (files.size() > 1) {
                            result.append(file).append(":");
                        }
                        result.append(line).append("\n");
                    }

                }
                lineNum++;
            }
        }catch (FileNotFoundException error) {
            throw new RuntimeException(error);
        }

            return result;
    }

}