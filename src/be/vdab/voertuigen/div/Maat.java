package be.vdab.voertuigen.div;

public enum Maat {
    CENTIMETER(1), DECIMETER(1000), METER(1000000);
    private final long maatRatio;

    Maat(int maatRatio) {
        this.maatRatio = maatRatio;
    }

    public long getMaatRatio() {
        return maatRatio;
    }
}
