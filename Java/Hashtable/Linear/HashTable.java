public class HashTable {
    private static final int TABLE_SIZE=10;
    private HashItem[] hashTable;
    private int counter;

    public HashTable() {
        hashTable = new HashItem[TABLE_SIZE];
    }

    public int get(int key){
        int index=hash(key);
        while(hashTable[index]!= null && hashTable[index].getKey()!=key){
            System.out.println("Incrementing the index: "+index+" to get the value");
            index=(index+1)%TABLE_SIZE;
        }
        if(hashTable[index]==null) return -1;
        return hashTable[index].getValue();
    }

    public void put(int key, int value){
        if(counter>=TABLE_SIZE) return;
        int index=hash(key);
        while(hashTable[index]!= null){
            index=(index+1)%TABLE_SIZE;
            System.out.println("Incrementing the index: "+index);
        }
        System.out.println("We found the place to insert "+value+" in the key "+index);
        hashTable[index]=new HashItem(key, value);
        counter++;
    }

    private int hash(int key){
        return key%TABLE_SIZE;
    }
}
