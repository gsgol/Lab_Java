public class House
{
    private final int nTicks;
    private final int nFloors;
    private final int nElevators;

    public House(int nTicks, int nFloors, int nElevators)
    {
        this.nElevators = nElevators;
        this.nFloors = nFloors;
        this.nTicks = nTicks;
    }

    public int getnElevators()
    {
        return this.nElevators;
    }

    public int getnTicks()
    {
        return this.nTicks;
    }

    public int getnFloors()
    {
        return this.nFloors;
    }
}
