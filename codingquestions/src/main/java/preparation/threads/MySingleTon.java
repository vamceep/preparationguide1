package preparation.threads;

public class MySingleTon {
    /**
     * thread safe singleton class
     */
    private static MySingleTon mySingleTon= null;
    static Object lock = new Object();
    private MySingleTon() {
    }

    public static MySingleTon getInstance() {
        if(mySingleTon == null) {       //t1 t2 both gets null
            synchronized (MySingleTon.class) {      // assum. t1 gets the lock
                if (mySingleTon == null) {  // <- this make sure t2 doesn't re instanticate.
                    mySingleTon = new MySingleTon();
                }
            }
        }
        return mySingleTon;
    }

    public static void main(String[] args) {

    }
}
