package pattern.creational.singleton;


//      Java code to create singleton class by
//      Lazy Initialization
//      Synchronized
    public class Singleton
    {
        // public instance initialized when loading the class
        private static Singleton instance;

        // Private Constructor
        // class cannot be created directly by external class
        private Singleton() { }

        synchronized public static Singleton getInstance(){
            if(instance == null){
                instance = new Singleton();
            }
            return instance;
        }
    }


