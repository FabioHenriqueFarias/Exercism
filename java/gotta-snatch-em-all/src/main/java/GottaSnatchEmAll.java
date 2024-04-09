    import java.util.List;
    import java.util.Set;
    import java.util.*;


    class GottaSnatchEmAll {

        static Set<String> newCollection(List<String> cards) {
            return new HashSet<>(cards);
        }

        static boolean addCard(String card, Set<String> collection) {
           return collection.add(card);
        }

        static boolean canTrade(Set<String> myCollection, Set<String> theirCollection) {

            if(myCollection.isEmpty() || theirCollection.isEmpty()){
                return false;
            }

            if (myCollection.containsAll(theirCollection)) {
                return false;
            }

            if (theirCollection.containsAll(myCollection)) {
                return true;
            }

            return true;
        }

        static Set<String> commonCards(List<Set<String>> collections) {
            Set<String> commonCards = new HashSet<>(collections.get(0));
               for (Set<String> collection : collections) {
                    commonCards.retainAll(collection);
                }
                return commonCards;
        }

        static Set<String> allCards(List<Set<String>> collections) {
            Set<String> allCards = new HashSet<>(collections.get(0));

            for (Set<String> collection : collections) {
                allCards.addAll(collection);
            }
            return allCards;
        }
    }
