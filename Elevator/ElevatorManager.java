import java.util.concurrent.ConcurrentLinkedQueue;

public class ElevatorManager implements Runnable
{
    private final ConcurrentLinkedQueue<Call> queue;
    private int tick;
    private final long duration;
    private final long startTime;
    private final Elevator[] elevators;

    ElevatorManager(ConcurrentLinkedQueue<Call> queue, int elevatorsNum, long liveTime)
    {
        this.queue = queue;
        this.duration = liveTime;
        this.startTime = System.currentTimeMillis();
        this.elevators = new Elevator[elevatorsNum];

        for(int i = 0; i < elevatorsNum; ++i)
        {
            this.elevators[i] = new Elevator(i, 10);
        }

    }

    private int chooseElevator(Elevator[] elevators, Call call)
    {
        int scheduleTo = 0;
        int priority = -1000;
        ElevatorManager.ElevatorDirection callDirection = call.getFrom() - call.getTo() > 0 ? ElevatorManager.ElevatorDirection.DOWN : ElevatorManager.ElevatorDirection.UP;

        for(int i = 0; i < elevators.length; ++i)
        {
            ElevatorManager.ElevatorDirection elevatorDirection = elevators[i].getCurrent() - elevators[i].getDest() > 0 ? ElevatorManager.ElevatorDirection.DOWN : ElevatorManager.ElevatorDirection.UP;
            boolean isSameDirection = callDirection == elevatorDirection;
            int priorityRate = 0;
            if (isSameDirection)
            {
                if (call.getFrom() == elevators[i].getCurrent() && elevators[i].isEnoughSpace())
                {
                    return i;
                }

                priorityRate = priorityRate - elevators[i].getPassengerNumber();
                priorityRate -= Math.abs(call.getFrom() - elevators[i].getCurrent());
                priorityRate += Math.abs(elevators[i].getCurrent() - elevators[i].getDest());
                priorityRate += 10;
            }
            else
            {
                priorityRate = priorityRate - elevators[i].getPassengerNumber();
                priorityRate -= Math.abs(elevators[i].getCurrent() - elevators[i].getDest());
                priorityRate -= Math.abs(call.getFrom() - elevators[i].getDest());
            }

            if (priorityRate > priority)
            {
                priority = priorityRate;
                scheduleTo = i;
            }
        }

        return scheduleTo;
    }

    public void run()
    {
        int stillProcessing = 0;

        while(System.currentTimeMillis() - this.startTime < this.duration || stillProcessing > 0)
        {
            stillProcessing = 0;

            try
            {
                Thread.sleep(500L);
                System.out.println("\nTick " + this.tick + "\n");
                ++this.tick;

                while(this.queue.peek() != null)
                {
                    Call call = (Call)this.queue.poll();
                    this.elevators[this.chooseElevator(this.elevators, call)].addCall(call);
                }

                Elevator[] var7 = this.elevators;
                int var3 = var7.length;

                for(int var4 = 0; var4 < var3; ++var4)
                {
                    Elevator elevator = var7[var4];
                    elevator.tick();
                    stillProcessing += 5;
                }
            }
            catch (InterruptedException var6)
            {
            }
        }

    }

    public static enum ElevatorDirection
    {
        UP,
        DOWN;

        private ElevatorDirection()
        {
        }
    }
}
