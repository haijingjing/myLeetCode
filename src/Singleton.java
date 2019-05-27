public class Singleton {
    private static Singleton s = null;
    private Singleton(){}
    public static Singleton getSingleton(){
        if(s == null){
            synchronized (Singleton.class){ // -->B线程，等着A解锁才让进去
                if(s == null){
                    // -->A线程
                    s =  new Singleton();
                }
            }
        }
        return s;
    }
}
