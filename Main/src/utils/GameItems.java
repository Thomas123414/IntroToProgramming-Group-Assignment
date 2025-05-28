package src.utils;

public class GameItems {
    private String ItemName;
    private String Description;
    private int Value;
    private int Type;

    public GameItems(String ItemName, String Description, int Value, int Type) {
        this.ItemName = ItemName;
        this.Description = Description;
        this.Value = Value;
        this.Type = Type;
    }

    public String getItemName() {
        return ItemName;
    }

    public String getDescription() {
        return Description;
    }

    public int getValue() {
        return Value;
    }

    public int getType() {
        return Type;
    }

    public void setName(String ItemName) {
        this.ItemName = ItemName;
    }

    public void setDescription(String Description) {
        this.Description = Description;
    }

    public void setValue(int Value) {
        this.Value = Value;
    }

    public void setType(int Type) {
        this.Type = Type;
    }
}
