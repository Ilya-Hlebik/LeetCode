package Interview_prepare;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Task {

    String name;
    public static void main(String[] args) {
        List<Task> tasks = dependsOn();
        tasks.stream().map(task -> task.name)
                .collect(Collectors.toList());
    }

  static   List<Task> dependsOn(){
        return new ArrayList<>();
    }
}
