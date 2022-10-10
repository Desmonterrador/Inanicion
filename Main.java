public class Main {
    private static Object bloqueo = new Object();
    public static void main(String[] args) {
        Thread h1 = new Thread(new Trabajador(ColorHilo.ANSI_RED), "prioridad 10");
        Thread h2 = new Thread(new Trabajador(ColorHilo.ANSI_BLUE), "prioridad 8");
        Thread h3 = new Thread(new Trabajador(ColorHilo.ANSI_GREEN), "prioridad 6");
        Thread h4 = new Thread(new Trabajador(ColorHilo.ANSI_CYAN), "prioridad 4");
        Thread h5 = new Thread(new Trabajador(ColorHilo.ANSI_PURPLE), "prioridad 2");
        h1.getPriority();
        h2.getPriority();
        h3.getPriority();
        h4.getPriority();
        h5.getPriority();
        h1.start();
        h2.start();
        h3.start();
        h4.start();
        h5.start();
    }
    private static class Trabajador implements Runnable{
        private int conteoEjecucion = 1;
        private String colorHilo;
        public Trabajador(String colorHilo){
            this.colorHilo = colorHilo;
        }
        @Override
        public void run() {
            for(int i = 0; i < 10; i++){
                synchronized (bloqueo){
                    System.out.format(colorHilo + "%s: conteoEjecucuion = %d\n", Thread.currentThread().getName(), conteoEjecucion++);
                }
            }
        }
    }
}
