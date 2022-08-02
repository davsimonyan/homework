package homework.collection;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MapExample {


    public static void main(String[] args) {
        List<FootballTeamMember> footballTeamMembers = new ArrayList<>();
        for (int i = 1; i < 10; i++) {
            FootballTeamMember footballTeamMember = new FootballTeamMember(i, "Neymar ");
            footballTeamMembers.add(footballTeamMember);
        }
        System.out.println(createFootballTeam(footballTeamMembers));

        Map<Integer, String> map = new HashMap<>();
        map.put(6, "poxos");
        map.put(7, "martiros");
        map.put(2, "komitas");
        System.out.println(removeFromMap(map, 6));
        System.out.println(map);

        printAllMemberNames(map);
        printAllMembers(map);
    }

    //Ունենք FootballTeamMember-ի լիստ, պետք է ստանանք HashMap որտեղ կեյ-ը կլինի խաղացողի համարը, իսկ վելյուն իրա անունը։
    static Map<Integer, String> createFootballTeam(List<FootballTeamMember> members) {
        Map<Integer, String> hashMap = new HashMap();
        for (FootballTeamMember member : members) {
            hashMap.put(member.getNumber(), member.getName());
        }
        return hashMap;
    }

    //Մեթոդի մեջ պետք է տրված մապ-ից ջնջենք removedNumber համարը եթե կա, ու վերադարձնենք true, եթե չկա վերադարձնենք false
    static boolean removeFromMap(Map<Integer, String> memberMap, Integer removedNumber) {
        if (memberMap.get(removedNumber) != null) {
            memberMap.remove(removedNumber);
            return true;
        } else return false;

    }

    //Մեթոդով տպելու ենք միայն անունները
    static void printAllMemberNames(Map<Integer, String> memberMap) {
        System.out.println(memberMap.values());
    }

    //Մեթոդով տպելու ենք թե համարը, թե խաղացողի անունը հետյալ ձև՝
    // 11 - Poxos Poxosyan
    // 12 - Petros Petrosyan
    static void printAllMembers(Map<Integer, String> memberMap) {
        System.out.println(memberMap.entrySet());

    }


    static class FootballTeamMember {
        private int number;
        private String name;

        public FootballTeamMember(int number, String name) {
            this.number = number;
            this.name = name;
        }

        public int getNumber() {
            return number;
        }

        public void setNumber(int number) {
            this.number = number;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }
}
