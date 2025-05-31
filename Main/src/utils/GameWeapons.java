package src.utils;

public class GameWeapons {

    private String Weaponname;
    private String Description;
    private int Damage;

    public GameWeapons(String Weaponname, String Description, int Damage) {
        this.Weaponname = Weaponname;
        this.Description = Description;
        this.Damage = Damage;
    }

    public String getWeaponName() {
        return Weaponname;
    }

    public String getDescription() {
        return Description;
    }

    public int getDamage() {
        return Damage;
    }

    public void setWeaponName(String Weaponname) {
        this.Weaponname = Weaponname;
    }

    public void setDescription(String Description) {
        this.Description = Description;
    }

    public void setDamage(int Damage) {
        this.Damage = Damage;
    }
}
