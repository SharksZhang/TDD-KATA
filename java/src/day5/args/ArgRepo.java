package day5.args;

import java.util.HashMap;
import java.util.Map;

public class ArgRepo {
    Map<Character, Arg> repo = new HashMap<>();

    public void add(Arg arg) {
        repo.put(arg.name, arg);
    }

    public Arg get(Character flag) {
        return repo.get(flag);
    }
}
