package Interview_prepare;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class ComparatorForMultiplyConditions implements Comparator<Task2>{
    public static void main(String[] args) {

        ComparatorForMultiplyConditions sol = new ComparatorForMultiplyConditions();
        Task2 task1 = new Task2();
        task1.name = "d";
        task1.number = 4;
        Task2 task2 = new Task2();
        task2.name = "d";
        task2.number = 5;
        Task2 task3 = new Task2();
        task3.name = "a";
        task3.number = 1;
        List<Task2> tasks = Arrays.asList(task1, task2, task3);
        tasks.sort(sol);
        System.out.println(tasks);


    }

    @Override
    public int compare(Task2 o1, Task2 o2) {
        int com1 = o1.name.compareTo(o2.name);
        if(com1 !=0){
            return com1;
        }
        return o1.number.compareTo(o2.number);
    }




}
class Task2{
    public String name;
    public Integer number;

    @Override
    public String toString(){
        return "name :" +name + " number :" + number;
    }

}
