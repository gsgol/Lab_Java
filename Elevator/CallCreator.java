import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.ThreadLocalRandom;

public class CallCreator implements Runnable
{
    private final ConcurrentLinkedQueue<Call> queue;
    private final int floorNum;
    private int callNum;
    private final long duration;
    private final long startTime;

    CallCreator(ConcurrentLinkedQueue<Call> queue, int floorNum, long duration)
    {
        this.queue = queue;
        this.floorNum = floorNum;
        this.duration = duration;
        this.startTime = System.currentTimeMillis();
    }

    public void run()
    {
        while(System.currentTimeMillis() - this.startTime < this.duration)
        {
            try
            {
                Thread.sleep((long)ThreadLocalRandom.current().nextInt(0, 501));
                int from = ThreadLocalRandom.current().nextInt(0, this.floorNum + 1);

                int to;
                for(to = ThreadLocalRandom.current().nextInt(0, this.floorNum + 1); from == to; to = ThreadLocalRandom.current().nextInt(0, this.floorNum + 1))
                {
                }

                this.queue.add(new Call(from, to, this.callNum));
                ++this.callNum;
            } catch (InterruptedException var3)
            {
            }
        }

    }
}
