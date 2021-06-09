package pattern.creational.abstractFactory;

public interface IComputer
{
    public void showConfig();
    public void shutDown();
    public void powerOn();
    public void restart();
    public ComputerType getType();

}
