class ResistorColor {
    int colorCode(String color) {

        for(Color enumColor : Color.values()) {
            if(enumColor.name().equals(color)){
                return enumColor.ordinal();
            }
        }

        return 0;

    }

    String[] colors() {

        String[] colors = new String[Color.values().length];

        for(Color enumColor : Color.values()){
            colors[enumColor.ordinal()] = enumColor.name();
        }

        return colors;
    }
}

enum Color {
    black, brown, red, orange, yellow, green, blue, violet, grey, white
}