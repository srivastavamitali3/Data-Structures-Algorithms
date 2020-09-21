package airtel.prob2;

import airtel.prob2.service.StateMachineService;

public class StateMachine {

    public static void main(String[] args) {
        StateMachineService service = new StateMachineService(11);
        service.addDirectedEdge(1, 2);
        service.addDirectedEdge(1, 3);
        service.addDirectedEdge(2, 4);
        service.addDirectedEdge(2, 5);
        service.addDirectedEdge(2, 6);
        service.addDirectedEdge(3, 7);
        service.addDirectedEdge(3, 8);
        service.addDirectedEdge(4, 9);
        service.addDirectedEdge(5, 9);
        service.addDirectedEdge(7, 10);
        service.addDirectedEdge(8, 10);

        service.printAllPaths(1, 4);
        service.printAllPaths(2, 9);
        service.printAllPaths(3, 4);
    }
}
