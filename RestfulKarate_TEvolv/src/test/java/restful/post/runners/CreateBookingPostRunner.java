package restful.post.runners;

import com.intuit.karate.junit5.Karate;

public class CreateBookingPostRunner {
    @Karate.Test
    Karate createBookingPost(){
        return Karate.run("../create_booking_post").tags("~@ForGetOnly","~@CreateE2E").relativeTo(getClass());
    }
}
