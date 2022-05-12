import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Iterator;
public class Elevator
{
    private int currentFloor;
    private int destFloor;
    private final int num;
    private final int capacity;
    private int passengerNumber = 0;
    private final ArrayList<Call> tasks;

    public Elevator(int num, int capacity)
    {
        this.num = num;
        this.tasks = new ArrayList();
        this.capacity = capacity;
    }

    public int getCurrent()
    {
        return this.currentFloor;
    }

    public int getDest()
    {
        return this.destFloor;
    }

    public int getPassengerNumber()
    {
        return this.passengerNumber;
    }

    public boolean isEnoughSpace()
    {
        return this.passengerNumber < this.capacity;
    }

    public void addCall(Call call)
    {

        int callNum = call.getNum();
        System.out.println("Call " + callNum + " assigned to elevator " + this.num);
        if (this.currentFloor < this.destFloor)
        {
            if (call.getTo() > this.destFloor)
            {
                this.destFloor = call.getTo();
            }
        }
        else if (this.currentFloor > this.destFloor)
        {
            if (call.getTo() < this.destFloor)
            {
                this.destFloor = call.getTo();
            }
        }
        else
        {
            this.chooseFar();
        }

        this.tasks.add(call);
    }

    private void chooseFar()
    {
        int diff = 0;
        Iterator it2 = this.tasks.iterator();

        while(it2.hasNext())
        {
            Call call = (Call)it2.next();
            if (Math.abs(this.currentFloor - call.getTo()) > diff)
            {
                diff = Math.abs(this.currentFloor - call.getTo());
                this.destFloor = call.getTo();
            }
        }

    }

    public void tick()
    {
        for(int i = 0; i < this.tasks.size(); ++i)
        {

            int callFrom;
            if (((Call)this.tasks.get(i)).getFrom() == this.currentFloor && !((Call)this.tasks.get(i)).isTaken() && this.passengerNumber < this.capacity)
            {
                ++this.passengerNumber;
                this.tasks.set(i, ((Call)this.tasks.get(i)).take());
                callFrom = ((Call)this.tasks.get(i)).getFrom();
                System.out.println("Passenger taken on floor " + callFrom + " by elevator " + this.num + " | call " + ((Call)this.tasks.get(i)).getNum());
            }

            if (((Call)this.tasks.get(i)).getTo() == this.currentFloor && ((Call)this.tasks.get(i)).isTaken())
            {
                --this.passengerNumber;
                callFrom = ((Call)this.tasks.get(i)).getTo();
                System.out.println("Passenger delivered to floor " + callFrom + " by elevator " + this.num + " | call " + ((Call)this.tasks.get(i)).getNum());
                this.tasks.remove(i);
            }
        }

        if (this.currentFloor < this.destFloor)
        {
            ++this.currentFloor;
        }
        else if (this.currentFloor > this.destFloor)
        {
            --this.currentFloor;
        }
        else
        {
            this.chooseFar();
        }

    }
}
