public class GameMaster {

    public String describe(Character character){
        return String.format("You're a level %d %s with %d hit points.", character.getLevel(), character.getCharacterClass(), character.getHitPoints());

    }

    public String describe(Destination destination){
        return String.format("You've arrived at %s, which has %d inhabitants.", destination.getName(), destination.getInhabitants());
    }

    public String describe(TravelMethod method){

        String travelMethod = "";

        if(method.equals(TravelMethod.HORSEBACK)){
            travelMethod = "You're traveling to your destination on horseback.";
        };

        if(method.equals(TravelMethod.WALKING)){
            travelMethod = "You're traveling to your destination by walking.";
        }

        return travelMethod;
    }

    public String describe(Character character, Destination destination, TravelMethod method ){

        String Travelmethod = "";

        if(method.equals(TravelMethod.HORSEBACK)){
            Travelmethod = "horseback";
        }

        if(method.equals(TravelMethod.WALKING)){
            Travelmethod = "walking";
        }
        return String.format("You're a level %d %s with %d hit points. You're traveling to your destination on %s. You've arrived at %s, which has %d inhabitants.", character.getLevel(), character.getCharacterClass(), character.getHitPoints(), Travelmethod, destination.getName(), destination.getInhabitants());


    }

    public String describe(Character character, Destination destination){
        return String.format("You're a level %d %s with %d hit points. You're traveling to your destination by walking. You've arrived at %s, which has %d inhabitants.", character.getLevel(), character.getCharacterClass(), character.getHitPoints(), destination.getName(), destination.getInhabitants());
    }



}
