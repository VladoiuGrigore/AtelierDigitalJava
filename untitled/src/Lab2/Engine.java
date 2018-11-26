package Lab2;

public abstract class Engine {
    private  int capacity;

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }
    @Override
    public String toString()
    {
        return "Engine capacity= "+capacity;
    }
    abstract public boolean start();
}
