public class VolumeOfEarth {
    public static void main(String[] args) {
        double r=6378;
        double sphere =(4/3) * 3.14 * r*r*r;
        double incubic = sphere *1.6;
        System.out.printf("The volume of earth in cubic kilometers is %.1fkm and cubic miles is %.1fmiles", sphere, incubic);
    }
}
