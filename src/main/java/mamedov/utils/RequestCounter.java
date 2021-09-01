package mamedov.utils;

import lombok.Getter;
import lombok.Setter;

import java.util.concurrent.atomic.AtomicInteger;

@Getter
@Setter
public class RequestCounter {
    private static final AtomicInteger addInt = new AtomicInteger();

    public static int get() {
        return addInt.get();
    }

    public static void add() {
        addInt.incrementAndGet();
    }
}
