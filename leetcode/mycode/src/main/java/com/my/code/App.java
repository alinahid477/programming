package com.my.code;

/**
 * Hello world!
 */
public final class App {
    private App() {
    }

    /**
     * Says hello to the world.
     * 
     * @param args The arguments of the program.
     */
    public static void main(String[] args) {
        // MinCostOfTickets ls = new MinCostOfTickets();
        // ls.callSolution(new int[] { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 30, 31 }, new
        // int[] { 2, 7, 15 });
        // System.out.println("Hello World!");

        ShiftArraySearch prob = new ShiftArraySearch();
        prob.callSolution(new int[] { 5, 1, 2, 3, 4 }, 4);
    }
}
