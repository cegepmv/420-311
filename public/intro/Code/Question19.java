public class Question19 {
    public static int param1;
    public static int param2;
  
    public void add(int val1, int val2) {
      param1 = val1 + val2;
      param2 = param1 + val2;
    }
    
    public static void main(String[] args) {
        Question19 instance1 = new Question19 ();
        Question19 instance2 = new Question19 ();
        Question19 instance3 = new Question19 ();
        int abc = 2;		
        instance1.add(abc, abc-1);
        instance3.add(6, 6/abc);
        instance2.add(5, abc/2);
        System.out.println(instance1.param1);
        System.out.println(instance2.param2);
    }
}
