package my.homeprojects.springms;

import java.util.*;

public class MainTest {

    public static void main(String[] args) {
        List<Integer> list1 = new ArrayList<>(Arrays.asList(2, -4, -5, 9, 5, 8,8));
        List<Integer> list2 = new ArrayList<>(Arrays.asList(3, -4, 31, 2, 9, 5, 8, 7, 22, 87,8,9,9,8));
        list1.retainAll(list2);

        System.out.println("Common items in both lists " + list1);

//        Set mixSet = new HashSet();
//        Integer count;
//        HashMap<Integer, Integer> result = new HashMap<Integer, Integer>();
//        for (Integer i : list1) {
//            mixSet.add(i);
//        }
//
//        for (Integer o : list2) {
//            count = result.containsKey(o) ? result.get(o) : 0;
//            //Integer count = result.getOrDefault(o, 0);
//            if (mixSet.contains(o)) {
//                result.put(o, count+1);
//            }
//        }
//        result.forEach((key, value) -> System.out.println(key + " : " + value));


    }
}
