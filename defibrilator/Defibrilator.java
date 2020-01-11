import java.util.*;
import java.io.*;
import java.math.*;

/**
 * Defibrilator : find closest Defibrilator to position (x,y)
 **/
class Defibrilator {

    public static double lonA;
    public static double latA;

    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        String LON = in.next();
        String LAT = in.next();
        int N = in.nextInt();
        if (in.hasNextLine()) {
            in.nextLine();
        }
        // 0) Convert Degres in Radian
        lonA = ConvertDegresInRadian(LON);
        latA = ConvertDegresInRadian(LAT);
        
        double shortestDist = Double.MAX_VALUE;
        String outputNameDefibrilateur = "";
        for (int i = 0; i < N; i++) {
            String DEFIB = in.nextLine();
            // 1) Decode DEFIB and put it in an Object
            Defibrilateur defibrilateur = DecodeDefibrilateur(DEFIB);

            // 2) Calculate distance betweend Person and DEFIB
            double distance = CalcDistanceWithA(defibrilateur.getLongitude(), defibrilateur.getLatitude());

            // 3) Check if distance is shorter than previous DEFIB
            if(distance < shortestDist) {
                shortestDist = distance;
                outputNameDefibrilateur = defibrilateur.getName();
            }
        }

        System.out.println(outputNameDefibrilateur);
    }
    
    public static double ConvertDegresInRadian(String degres) {
        return Math.toRadians(Double.parseDouble(degres.replaceAll(",","\\.")));
    }
    
    public static Defibrilateur DecodeDefibrilateur(String defib) {
        Defibrilateur defibrilateur = new Defibrilateur();
        String[] splitedDefib = defib.split(";");           
        defibrilateur.setId(splitedDefib[0]);
        defibrilateur.setName(splitedDefib[1]);
        defibrilateur.setAdress(splitedDefib[2]);
        defibrilateur.setTel(splitedDefib[3]);
        defibrilateur.setLongitude(ConvertDegresInRadian(splitedDefib[4]));
        defibrilateur.setLatitude(ConvertDegresInRadian(splitedDefib[5]));
        
        return defibrilateur;
    }
    
    public static double CalcDistanceWithA(double lonB, double latB) {
        double x = (lonB - lonA)*(Math.cos(((latA+latB)/2)));
        double y = latB - latA;
        return (Math.sqrt((x*x)+(y*y))*6371);
    }
}

class Defibrilateur {
    private String id;
    private String name;
    private String adress;
    private String tel;
    private double longitude;
    private double latitude;
    
    public String getId() {
        return id;
    }
    
    public void setId(String id) {
        this.id = id;
    }
    
    public String getName() {
        return name;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    
    public String getAdress() {
        return adress;
    }
    
    public void setAdress(String adress) {
        this.adress = adress;
    }
    
    public String getTel() {
        return tel;
    }
    
    public void setTel(String tel) {
        this.tel = tel;
    }
    
    public double getLongitude() {
        return longitude;
    }
    
    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }
    
    public double getLatitude() {
        return latitude;
    }
    
    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }
}
