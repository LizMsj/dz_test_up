public class Yravnenie {

    public static Integer yravnenueDisk(Integer a, Integer b, Integer c) {
        return b * b - 4 * a * c;
    }

    public static  Integer yravnenieRad(Integer d) {
        if (d < 0)
            return 0;
        else if (d == 0)
            return 1;
        else
            return 2;
    }
}


