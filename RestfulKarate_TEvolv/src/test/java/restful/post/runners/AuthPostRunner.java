package restful.post.runners;

import com.intuit.karate.junit5.Karate;

public class AuthPostRunner {
    @Karate.Test
    Karate authPost () {
        return Karate.run("../auth_post").relativeTo(getClass());
    }
}
