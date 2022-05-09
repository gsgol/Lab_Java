import java.util.concurrent.ConcurrentLinkedQueue;

public class Main
{

    public static void main(String[] args)
    {
        ConcurrentLinkedQueue<Call> queue = new ConcurrentLinkedQueue();
        int nTicks = 200;
        int nFloors = 10;
        int nElevators = 10;
        House myHome = new House(nTicks, nFloors, nElevators);
        CallCreator sender = new CallCreator(queue, myHome.getnFloors(), (long)(myHome.getnTicks() * 500));
        ElevatorManager receiver = new ElevatorManager(queue, myHome.getnElevators(), (long)(myHome.getnTicks() * 500));
        (new Thread(sender)).start();
        (new Thread(receiver)).start();
    }
}
