package homework.collection;


import java.util.*;

public class CollectionExample {

    public static void main(String[] args) {
        String[] spaceArray = {"poxos", "petros", "martiros", "komitas", "poxos", "petros", "martiros"};
        List<String> list = new ArrayList<>();
        list.addAll(arrayToList(spaceArray));

        Integer[] intArray = {3, 43, 23, 53, 2};
        List<Integer> intList = new ArrayList<>();
        intList.addAll(Arrays.asList(intArray));

        System.out.println(arrayToList(spaceArray));
        System.out.println(removeById(list, 1));
        System.out.println(listToSet(arrayToList(spaceArray)));
        System.out.println(listToLinkedList(intList));

        printFirstFive(Arrays.asList(spaceArray));
        System.out.println();
        System.out.println(sizeOfList(Arrays.asList(spaceArray)));

    }

    //մեթոդը գրել այնպես, որ կանչենք, ու իրան ստրինգների մասիվ տանք, ինքը վերադարձնի նույն էլեմենտներով ArrayList
    static List<String> arrayToList(String[] values) {
        List<String> arrayList = new ArrayList<>();
        arrayList.addAll(Arrays.asList(values));
        return arrayList;
    }

    //մեթոդը գրել այնպես, որ կանչենք ու տանք ինչ որ լիստ, ու ինդեքս, ինքը ջնջե էդ ինդեքսի տակ գտնվող էլեմենտը, ու վերադարձնե նույն լիստը, առանց էդ էլեմենտի։
    static List<String> removeById(List<String> list, int index) {
        list.remove(index);
        return list;
    }

    // մեթոդը գրել այնպես, որ ընդունի ցանկացած String-ների լիստ, վերադարձնի նույն արժեքներով HashSet
    static Set<String> listToSet(List<String> list) {
        HashSet<String> hashSet = new HashSet<>();
        hashSet.addAll(list);
        return hashSet;
    }

    // մեթոդը գրել այնպես, որ ընդունի ցանկացած Integer-ների լիստ, վերադարձնի նույն արժեքներով LinkedList-ի օբյեկտ։
    static LinkedList<Integer> listToLinkedList(List<Integer> list) {
        LinkedList<Integer> linkedList = new LinkedList<>();
        linkedList.addAll(list);
        return linkedList;
    }

    // մեթոդը գրել այնպես, որ ընդունի ցանկացած Integer-ների լիստ, վերադարձնի նոր լիստ, որի մեջ էլեմենտները կլինեն հակառակ հերթականությամբ։
    static List<Integer> reverseNumbers(List<Integer> list) {
        LinkedList<Integer> linkedList = new LinkedList<>();
        linkedList.addAll(list);


        return linkedList;
    }

    // մեթոդը գրել այնպես, որ ինչ մեծությամբ լիստ էլ տանք էս մեթոդին, ինքը տպե մենակ սկզբի 5 հատը։
    static void printFirstFive(List<String> list) {
        LinkedList<String> linkedList = new LinkedList<>();
        linkedList.addAll(list);
        int count = 0;
        for (String string : linkedList) {
            while (count < 5) {
                System.out.print(string + ", ");
                count++;
                break;
            }
        }
    }

    // մեթոդը գրել այնպես, որ ինչ list տանք վերադարձնի թե քանի էլեմենտ կա էդ լիստ-ի մեջ
    static int sizeOfList(List<String> list) {
        LinkedList<String> linkedList = new LinkedList<>();
        linkedList.addAll(list);
        int size = 0;
        for (String s : linkedList) {
            size++;
        }
        return size;
    }

}
