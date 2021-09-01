package mamedov.utils;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserInfoContainer {
    private String name;
    private String date;
    private String city;

    public UserInfoContainer(String name, String date, String city) {
        this.name = name;
        this.date = date;
        this.city = city;
    }
}
