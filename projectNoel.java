import java.util.ArrayList;
public class projectNoel {

    double[][] list ={
            {45.171112,5.695952},
            {45.183152,5.699386},
            {45.174115,5.711106},
            {45.176123,5.722083},
            {45.184301,5.719791},
            {45.184252,5.730698},
            {45.170588,5.716664},
            {45.193702,5.691028},
            {45.165641,5.739938},
            {45.178718,5.744940},
            {45.176857,5.762518},
            {45.188512,5.767172},
            {45.174017,5.706729},
            {45.174458,5.687902},
            {45.185110,5.733667},
            {45.185702,5.734507},
            {45.184726,5.734666},
            {45.184438,5.733735},
            {45.184902,5.735256},
            {45.174812,5.698095},
            {45.169851,5.695723},
            {45.180943,5.698965},
            {45.176205,5.692165},
            {45.171244,5.689872}
    };

//    double[] positionsData;
    double [][] distancesData;
    public static void main(String[] args) {

        System.out.println("hello");
        System.out.println(list[3][0]);
        distancesDataArrayCreate(list, distancesData);


    }

    public double  ne(double lat1, double lon1,
                            double lat2, double lon2)
    {
        // distance between latitudes and longitudes
        double dLat = Math.toRadians(lat2 - lat1);
        double dLon = Math.toRadians(lon2 - lon1);

        // convert to radians
        lat1 = Math.toRadians(lat1);
        lat2 = Math.toRadians(lat2);

        // apply formulae
        double a = Math.pow(Math.sin(dLat / 2), 2) +
                Math.pow(Math.sin(dLon / 2), 2) *
                        Math.cos(lat1) *
                        Math.cos(lat2);
        double rad = 6371;
        double c = 2 * Math.asin(Math.sqrt(a));
        return rad * c;
    }

    public void distancesDataArrayCreate (double [][] list, double [][]distancesArrayList) {

        for (int i=0; i<=list.length; i++ ) {
            for (int j = 0; j <= list.length; j++) {
                for (int k = 0; k <= 1; k++) {


                    distancesArrayList[i][j] = haversine(list[i][0], list[1][i], list[j][0], list[1][j]);
                    System.out.println(distancesArrayList[i][j]);

                }
            }
        }
    }









    // Driver Code

//        double lat1 = 51.5007;
//        double lon1 = 0.1246;
//        double lat2 = 40.6892;
//        double lon2 = 74.0445;
//        System.out.println(haversine(lat1, lon1, lat2, lon2) + " K.M.");

}



