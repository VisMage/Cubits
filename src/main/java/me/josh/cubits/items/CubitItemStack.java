package me.josh.cubits.items;

import me.josh.cubits.cubitdata.CubitDatabase;

import java.io.*;

public class CubitItemStack implements Serializable {

    private static final long serialVersionUID = 3;
    private transient ItemBase itemBase;
    private  int amount;

    public CubitItemStack(ItemBase itemBase, int amount){
        this.itemBase = itemBase;
        this.amount = amount;
    }

    // Serialization Methods
    @Serial
    private void writeObject(ObjectOutputStream oos) throws IOException {
        oos.defaultWriteObject();
        oos.writeUTF(itemBase.getIdentifier());
    }

    @Serial
    private void readObject(ObjectInputStream ois) throws IOException, ClassNotFoundException {
        ois.defaultReadObject();
        itemBase = CubitDatabase.getAllItem(ois.readUTF());
    }

    public ItemBase getItemBase() {
        return itemBase;
    }

    public void setItemBase(ItemBase itemBase) {
        this.itemBase = itemBase;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }
}
