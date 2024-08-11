import javax.xml.crypto.Data;
import java.util.Date;

public class HourContract {
    private Date date;
    private Double valuePerHour;
    private Integer hour;

    public Double totalValue(){
        return valuePerHour * hour;
    }
}
