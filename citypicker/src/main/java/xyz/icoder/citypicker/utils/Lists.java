package xyz.icoder.citypicker.utils;

import java.util.List;

public class Lists {
    public static <T> boolean notEmpty(List<T> list) {
        return list != null && list.size() > 0;
    }
}
