package restful.get.runners;

import com.intuit.karate.junit5.Karate;

public class GetBookingRuuner {
    @Karate.Test
    Karate getBooking(){
        return Karate.run("../get_booking").tags("~@GettingE2E").relativeTo(getClass());
    }
}
