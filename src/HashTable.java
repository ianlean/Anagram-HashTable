public class HashTable {
    private final int SIZE = 200000;
    public int amount = 0;
    private final Anagram[] table = new Anagram[SIZE];
    private int collisions = 0;
    public HashTable() {}

    public int hashCode(String s) {
        int hash = 0;
        for (int i = 0; i < s.length(); i++) {
            hash += s.charAt(i);
        }
        return hash;
    }

    public void add(String s) {
        int index = hashCode(s);
        Anagram word = new Anagram(s);
        if (table[index] == null) {
            table[index] = word;
        } else if (Anagram.findAnagram(s).equals(table[index].getKey())) {
            table[index].addToList(s);
        } else {
            this.collisions++;
            int newIndex = index;
            int count = 1;
            while(table[newIndex] != null) {
                newIndex = (newIndex + count) % SIZE;
                if (table[newIndex] != null) {
                    if (table[newIndex].getKey().equals(word.getKey())) {
                        table[newIndex].addToList(s);
                        return;
                    }
                }
            }
            table[newIndex] = word;
        }
        amount++;
    }

    public int search(String s) {
        int index = hashCode(s);
        Anagram word = new Anagram(s);
        if (table[index] == null) {
            return index;
        } else if (Anagram.findAnagram(s).equals(table[index].getKey())) {
            return index;
        } else {
            this.collisions++;
            int newIndex = index;
            int count = 1;
            while(table[newIndex] != null) {
                newIndex = (newIndex + count) % SIZE;
                if (table[newIndex] != null) {
                    if (table[newIndex].getKey().equals(word.getKey())) {
                        return newIndex;
                    }
                }
            }
            return newIndex;
        }
    }

//    public int search(String s) {
//        int index = hashCode(s);
//        int newIndex = index;
//        Anagram word = new Anagram(s);
//        if (table[index] == null ||
//                Anagram.findAnagram(s).equals(table[index].getKey())) {
//            return index;
//        } else {
//            int count = 1;
//            while (table[newIndex] != null &&
//                    !table[newIndex].getKey().equals(Anagram.findAnagram(s))) {
//                newIndex = index;
//                newIndex = (index + count*count) % SIZE;
//                count++;
//            }
//            return newIndex;
//        }
//    }

    @Override
    public String toString() {
        int occur = 0;
        StringBuilder s = new StringBuilder();
        for (Anagram a : table) {
            if (a != null) {
                s.append(a).append(", ");
                //return Arrays.toString(table);
            }
        }
        return s.toString();
    }

    public Anagram[] getTable() {
        return table;
    }
}
