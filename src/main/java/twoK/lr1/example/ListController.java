package twoK.lr1.example;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.*;

@RestController
public class ListController {

    private final List<String> arrayList = new ArrayList<>();
    private final HashMap<Integer, String> hashMap = new HashMap<>();

    @GetMapping("/update-array")
    public void updateArrayList(@RequestParam(value = "value",
            defaultValue = "") String value) {
        if (!Objects.equals(value, "")) {
            arrayList.add(value);
        }
    }

    @GetMapping("/show-array")
    public String showArrayList() {
        return String.join(", ", arrayList);
    }

    @GetMapping("/update-map")
    public void updateHashMap(@RequestParam(value = "value",
            defaultValue = "") String value) {
        int key = hashMap.size();
        hashMap.put(key, value);
    }

    @GetMapping("/show-map")
    public String showHashMap() {
        StringBuilder total = new StringBuilder();
        for (HashMap.Entry<Integer, String> entry : hashMap.entrySet()) {
            int key = entry.getKey();
            String value = entry.getValue();
            String current = String.valueOf(key) + ": " + value + "; ";
            total.append(current);
        }
        return total.toString();
    }

    @GetMapping("/show-all-lenght")
    public String showAllLenght() {
        return "ArrayList: " + String.valueOf(arrayList.size()) + "; HashMap: " + String.valueOf(hashMap.size());
    }
}




