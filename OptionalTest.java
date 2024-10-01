import java.time.Clock;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Locale;
import java.util.Optional;

public class OptionalTest {

    public static void main(String args[]) {

        String avu = "avuu";
        Optional<String> name = Optional.of(avu);
        //name = Optional.ofNullable("avu");
        name.ifPresent(s -> System.out.println(s.length()));


        Clock clock = Clock.system(ZoneId.systemDefault());
        System.out.println(clock.instant());

        LocalDateTime localDateTime = LocalDateTime.now();
        System.out.println(localDateTime);
    }
}
