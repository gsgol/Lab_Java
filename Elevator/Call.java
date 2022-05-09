public class Call
{
    private final int from;
    private final int to;
    private final int num;
    private boolean taken;

    public Call(int from, int to, int num)
    {
        this.from = from;
        this.to = to;
        this.num = num;
        this.taken = false;
    }

    public int getFrom()
    {
        return this.from;
    }

    public int getTo()
    {
        return this.to;
    }

    public int getNum()
    {
        return this.num;
    }

    public Call take()
    {
        this.taken = true;
        return this;
    }

    public boolean isTaken()
    {
        return this.taken;
    }

}
