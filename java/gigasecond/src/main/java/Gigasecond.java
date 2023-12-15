import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.temporal.Temporal;

public class Gigasecond {

    Temporal moment;
    public Gigasecond(LocalDate moment) {
        this.moment = moment;
    }

    public Gigasecond(LocalDateTime moment) {
        this.moment = moment;
    }

    public LocalDateTime getDateTime() {
        Duration gigasecond = Duration.ofSeconds(1_000_000_000);

        if(moment instanceof LocalDate) {
            moment = ((LocalDate) moment).atStartOfDay().plus(gigasecond);
        }else{
            moment = ((LocalDateTime) moment).plus(gigasecond);
        }

        return (LocalDateTime) moment;
    }
}
