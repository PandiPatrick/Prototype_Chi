public class GameLoop implements Runnable {

    private boolean running;
    private final double updateRate = 1.0d/60.0d;

    private int nextStatTime;
    private int fps, ups;


    @Override
    public void run() {
        running = true;
        double accumulator = 0;
        long currentTime, lastUpdate = System.currentTimeMillis();

        

        while(running) {
            currentTime = System.currentTimeMillis();
            double lastRenderTimeInSeconds = (currentTime - lastUpdate) / 1000d;
            accumulator += lastRenderTimeInSeconds;
            lastUpdate = currentTime;

            while(accumulator > updateRate){
                update();
                accumulator -= updateRate;
            }
            render();
            printStats();
        }


    }

    private void printStats() {
    }

    private void update() {
    }

    private void render() {
    }
}
