@SuppressWarnings("unchecked")
public class HashTable<Key, Value> {
    private Key[] keys;
    private Value[] values;
    private int numOfItems;
    private int capacity;

    public HashTable() {
        this.keys = (Key[]) new Object[Constants.TABLE_SIZE];
        this.values = (Value[]) new Object[Constants.TABLE_SIZE];
        this.capacity = Constants.TABLE_SIZE;
        this.numOfItems = 0;
    }

    public HashTable(int newCapacity) {
        this.keys = (Key[]) new Object[newCapacity];
        this.values = (Value[]) new Object[newCapacity];
        this.capacity = newCapacity;
        this.numOfItems = 0;
    }

    public int size(){
        return this.numOfItems;
    }

    public boolean isEmpty(){
        return this.numOfItems==0;
    }

    public void remove(Key key){
        if(key==null) return;
        int index = hash(key);
        while(!this.keys[index].equals(key)){
            index = (index+1) % this.capacity;
        }
        this.keys[index] = null;
        this.values[index] = null;
        this.numOfItems--;
        while(this.keys[index]!=null){
            Key tempKey = this.keys[index];
            Value tempValue = this.values[index];
            this.keys[index] = null;
            this.values[index] = null;
            this.numOfItems--;
            put(tempKey, tempValue);
            index = (index+1) % this.capacity;
        }
        if(this.numOfItems<=this.capacity/3){
            System.out.println("Resizing the table: halfing the size.");
            rezise(this.capacity/2);
        }
    }

    public void put(Key key, Value value){
        if(key==null||value==null) return;
        if(this.numOfItems>=this.capacity*0.75){
            System.out.println("Doubling the size of the table.");
            rezise(2*this.capacity);
        }
        int index = hash(key);
        while(this.keys[index]!=null){
            if(this.keys[index].equals(key)){
                this.values[index]=value;
                return;
            }
            index = (index+1) % this.capacity;
        }
        this.keys[index] = key;
        this.values[index] = value;
        this.numOfItems++;
    }

    private void rezise(int newCapacity){
        HashTable<Key, Value> newTable = new HashTable<>(newCapacity);
        for(int i=0; i<this.capacity;++i){
            if(this.keys[i]!=null)
                newTable.put(this.keys[i], this.values[i]);
        }
        this.keys = newTable.getKeys();
        this.values = newTable.getValues();
        this.capacity = newTable.getCapacity();
    }

    public Value get(Key key){
        if(key!=null){
            int index = hash(key);
            while(this.keys[index]!=null){
                if(this.keys[index].equals(key)){
                    return this.values[index];
                }
                index = (index+1) % this.capacity;
            }
        }
        return null;
    }

    private int hash(Key key){
        return key.hashCode() % this.capacity;
    }

    public Key[] getKeys(){
        return this.keys;
    }
    public void setKeys(Key[] keys){
        this.keys = keys;
    }

    public Value[] getValues(){
        return this.values;
    }
    public void setValues(Value[] values){
        this.values = values;
    }

    public int getNumOfItems(){
        return this.numOfItems;
    }
    public void setNumOfItems(int numOfItems){
        this.numOfItems = numOfItems;
    }

    public int getCapacity(){
        return this.capacity;
    }
    public void setCapacity(int capacity){
        this.capacity = capacity;
    }
}
