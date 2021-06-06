import com.jayway.jsonpath.JsonPath;
import com.jayway.jsonpath.ReadContext;
import static java.lang.Math.round;

public class JsonPathAppNumbers {
    public static void main(String[] args) {
        String jsonNb = "{\"nombres\": [125, 250, 215, 30, 55]}";

        //Parse JSON
        ReadContext ctx2 = JsonPath.parse(jsonNb);

        //Nombres
        Double max = ctx2.read("$.nombres.max()");
        Double min = ctx2.read("$.nombres.min()");
        Double mean = ctx2.read("$.nombres.avg()");

        System.out.println("Maximum: " + round(max));
        System.out.println("Minimum: " + round(min));
        System.out.println("Moyenne: " + round(mean));
    }
}
