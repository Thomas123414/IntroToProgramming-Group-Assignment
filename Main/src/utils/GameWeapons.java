package src.utils;

public class GameWeapons {

    private String Weaponname;
    private String Description;
    private int Damage;
    private int Ammo;

    public GameWeapons(String Weaponname, String Description, int Damage, int Ammo) {
        this.Weaponname = Weaponname;
        this.Description = Description;
        this.Damage = Damage;
        this.Ammo = Ammo;
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

    public int getAmmo() {
        return Ammo;
    }

    public void setWeaponName(String Weaponname) {
        this.Weaponname = Weaponname;
    }

    public void getDescription(String Description) {
        this.Description = Description;
    }

    public void setDamage(int Damage) {
        this.Damage = Damage;
    }

    public void setAmmo(int Ammo) {
        this.Ammo = Ammo;
    }
}
