package pattern.creational.singleton;


    // Java code to create singleton class by
    // Lazy Initialization
    public class Singleton
    {
        // public instance initialized when loading the class
        private static Singleton instance;

        private Singleton()
        {
            // private constructor
            // class cannot be created directly by external class
        }

        synchronized public static Singleton getInstance(){
            if(instance == null){
                instance = new Singleton();
            }
            return instance;
        }
    }


