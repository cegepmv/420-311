public class Question21 {
    public static void main(String [] args) {
        Question21 instance = new Question21();
                 instance.myMethod();
    }

    public void myMethod(){
        long [] tab1 = {6,8,9};
        long []tab2 = affectation(tab1);
        System.out.print(tab1[0] + tab1[1] + tab1[2] + " ");
        System.out.println(tab2[0] + tab2[1] + tab2[2]);
    }

    public long[] affectation(long[] tab3){
        tab3[1] = 7;
        return tab3;
    }
}
