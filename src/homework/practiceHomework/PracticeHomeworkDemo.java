package homework.practiceHomework;

public class PracticeHomeworkDemo {
    public static void main(String[] args) {

        PracticeHomework practiceHomework=new PracticeHomework();
        System.out.println(practiceHomework.convert(10));
        System.out.println(practiceHomework.calcAge(2));
        System.out.println(practiceHomework.nextNumber(4210));
        System.out.println(practiceHomework.isSameNum(5, 6));
        System.out.println(practiceHomework.lessThanOrEqualToZero(-21));
        System.out.println(practiceHomework.reverseBool(false));

        int []array1={12,32,2,45,6};
        int []array2={1,12,2,75,32,23,6};
        System.out.println(practiceHomework.maxLength(array1, array2));


    }
}
