public class Main{
    public static void main(String[] args) {
        var z = array1();
        var x = array2();
        var z1 = array3(z, x);
        printArr(z1);
        System.out.println(0.0 / 0.0);
        System.out.println(1 / 0.0);
        System.out.println(1 / 0);

    }
    public static short[] array1() {
        short[] arr = new short[11];
        int index = 0;
        for (short i = 23; i >= 3; i--) {
            if (i % 2 != 0) {
                arr[index++] = i;
            }
        }
        return arr;
    }
    public static float[] array2() {
        float[] arr = new float[19];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (float) (-15.0 + Math.random() * 30);
        }
        return arr;
    }
    public static double[][] array3(short[] z , float[] x) {
        double[][] arr = new double[11][19];
        for (int i = 0; i < 11; i++) {
            for (int j = 0; j < 19; j++) {
                arr[i][j] = add(z[i], x[j]);
            }
        }
        return arr;
    }
    public static double add(short z, float x) {
        if (z == 9) {
            return Math.sin(Math.pow(Math.pow(x, (1.0 - x) / 3.0), 1.0 / 3.0));
        } else if (z == 3 || z == 11 || z == 13 || z == 19 || z == 23) {
            return Math.asin(Math.pow((x / 3.0) * Math.E + 1.0, 2.0));
        } else {
            return Math.pow(Math.E, Math.pow(Math.asin(Math.pow(Math.E, -Math.abs(x))) / 2.0, 2.0));
        }
    }
    public static void printArr(double[][] z1) {
        for (int i = 0; i < 11; i++) {
            for (int j = 0; j < 19; j++) {
                System.out.printf("%7.3f", z1[i][j]);
            }
            System.out.println("\n");
        }
    }
}