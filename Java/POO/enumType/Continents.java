package enumType;
public enum Continents {
    Africa(54),
    Europe(50),
    Asia(48),
    America(35),
    Australia(14),
    Antarctica(0);

    private final int countries;

    private Continents(int countries){
        this.countries=countries;
    }

    public int getCountries(){
        return this.countries;
    }
}