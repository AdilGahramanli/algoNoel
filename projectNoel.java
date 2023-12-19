public class projectNoel {

    static double[][] list = {
            {45.171112, 5.695952},
            {45.183152, 5.699386},
            {45.174115, 5.711106},
            {45.176123, 5.722083},
            {45.184301, 5.719791},
            {45.184252, 5.730698},
            {45.170588, 5.716664},
            {45.193702, 5.691028},
            {45.165641, 5.739938},
            {45.178718, 5.744940},
            {45.176857, 5.762518},
            {45.188512, 5.767172},
            {45.174017, 5.706729},
            {45.174458, 5.687902},
            {45.185110, 5.733667},
            {45.185702, 5.734507},
            {45.184726, 5.734666},
            {45.184438, 5.733735},
            {45.184902, 5.735256},
            {45.174812, 5.698095},
            {45.169851, 5.695723},
            {45.180943, 5.698965},
            {45.176205, 5.692165},
            {45.171244, 5.689872}
    };

    //    double[] positionsData;
    static double[][] distancesData = new double[24][24];
    static boolean[] visited = new boolean[24];
    static int vc;
    static int [] cheminCourtTab = new int[24];

    static double totalDistance;



    public static void main(String[] args) {

        System.out.println("hello");
        System.out.println("test Haversine method  " + haversine(list[2][0], list[2][1], list[1][0], list[1][1]));

        distancesDataArrayCreate(list);

        System.out.println("**********Chemin le plus court**********");
        visited[vc]=true;
        booleanInitiateFalse(visited);
        totalDistance = 0;
        vc = 2;

        for(int i=0; i<visited.length; i++) {

                vc =  plusCourtNonVisited(vc);
                cheminCourtTab[i] = vc;
                System.out.println(cheminCourtTab[i]);

        }

        for(int i=0; i< 24; i++) {
            pathSize(cheminCourtTab, totalDistance);
        }

    }

    public static double haversine(double lat1, double lon1,
                                   double lat2, double lon2) {
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

    public static void distancesDataArrayCreate(double[][] list) {

        for (int i = 0; i < distancesData.length; i++) {
            for (int j = 0; j < distancesData.length; j++) {

                distancesData[i][j] = haversine(list[i][0], list[i][1], list[j][0], list[j][1]);
                System.out.println(distancesData[i][j]);


            }
        }
    }

    public static int plusCourtNonVisited(int vc) {
        double pp = 10000;
        visited[vc] = true;
        int ipp = 0;

        for (int i = 0; i < distancesData.length; i++) {


            if (visited[i]==false) {
                if (distancesData[vc][i] < pp) {
                    pp = distancesData[vc][i];
                    ipp = i;

                }

            }
        }
        return ipp;
    }


    public static void booleanInitiateFalse(boolean[] booleanTab) {
        for (int i = 0; i < booleanTab.length; i++) {
            booleanTab[i] = false;
        }
    }

    public static void pathSize(int[] cheminCourtTab, double totalDistance) {
        totalDistance = 0;
        for(int i= 0; i<cheminCourtTab.length; i++) {
            totalDistance = totalDistance + distancesData[cheminCourtTab[i]][0];

        }
    }


}