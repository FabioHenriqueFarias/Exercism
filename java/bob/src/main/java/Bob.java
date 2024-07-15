import java.util.List;

class Bob {

    String hey(String input) {

        List<String> phrases = List.of("Sure.", "Whoa, chill out!", "Calm down, I know what I'm doing!","Fine. Be that way!" ,"Whatever.");

        if(input.trim().isEmpty()){
            return phrases.get(3);
        }

        if(input.trim().charAt(input.trim().length() -1) == '?' && input.trim().equals(input.toUpperCase()) && !input.trim().equals(input.toLowerCase())){
            return phrases.get(2);
        }

        if(input.trim().charAt(input.trim().length() -1) == '?'){
            return phrases.get(0);
        }

        if(input.equals(input.toUpperCase()) && !input.equals(input.toLowerCase())){
            return phrases.get(1);
        }

        return phrases.get(4);
    }
}



