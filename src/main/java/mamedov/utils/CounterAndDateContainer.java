package mamedov.utils;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class CounterAndDateContainer {
    private int requestCounter = RequestCounter.get();
    private String currentDate = LocalDate.now().toString();
}
