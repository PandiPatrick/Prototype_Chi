package game;

public class GameLoop implements Runnable {

    //region FIELDS

    public static final int UPDATES_PER_SECOND = 60;

    private Game game;

    private boolean running;
    private final double updateRate = 1.0d/UPDATES_PER_SECOND;

    private long nextStatTime;
    private int fps, ups;

    //endregion

    //region GameLoop Constructor

    public GameLoop(Game game) {
        this.game = game;
    }

    //endregion

    //region RUN

    @Override
    public void run() {
        running = true;
        double accumulator = 0;
        long currentTime, lastUpdate = System.currentTimeMillis();
        nextStatTime = System.currentTimeMillis() + 1000;

        while(running) {
            // Rises accumulator by milliseconds passed from last while pass-through
            currentTime = System.currentTimeMillis();
            double lastRenderTimeInSeconds = (currentTime - lastUpdate) / 1000d;
            accumulator += lastRenderTimeInSeconds;
            lastUpdate = currentTime;

            // If the accumulator reached the updateRate(60 UPS) then it
            // updates & renders and reduces the accumulator counter
            if(accumulator >= updateRate) {
                update();
                render();
                accumulator -= updateRate;
            }
            //printStats();
        }
    }

    //endregion

    //region PrintStats

    // Method for printing FPS & UPS
    private void printStats() {
        if(System.currentTimeMillis() > nextStatTime) {
            System.out.println(String.format("FPS: %d, UPS: %d", fps, ups));
            fps = 0;
            ups = 0;
            nextStatTime = System.currentTimeMillis() + 1000;
        }
    }

    //endregion

    //region Update & Render

    // Updates the state of the game | Used in Thread GameLoop's run method
    private void update() {
        game.update();
        ups++;
    }

    // Renders the display | Used in Thread GameLoop's run method
    private void render() {
        game.render();
        fps++;
    }

    //endregion
}
