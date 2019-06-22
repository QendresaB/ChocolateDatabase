package chocolatedb;

/**
 * Test class reflects the overall performance of the company based on their managers and employees
 * @author Qëndresa, Xhemil, Erblin
 */
public class Test {

    public static void main(String[] args) {

        Chocolate[] snickers = new Chocolate[100];
        Chocolate[] bounty = new Chocolate[100];
        Chocolate[] mars = new Chocolate[100];

        int j = 0;
        for (int i = 0; i < 100; i++) {
            snickers[i] = new Chocolate(new IntegerKey(j++), "Snickers", "Albi", "20/10/2018", "20/10/2019", 0.5);
            bounty[i] = new Chocolate(new IntegerKey(j++), "Bounty", "Albi", "20/10/2018", "20/10/2019", 0.8);
            mars[i] = new Chocolate(new IntegerKey(j++), "Mars", "Elkos", "02/06/2018", "20/10/2019", 0.4);

        }

        ChocolateDatabase DBC = new ChocolateDatabase(500);

        DBC.insertAmount(snickers, 100);
        DBC.insertAmount(bounty, 100);
        DBC.insertAmount(snickers, 100);
        DBC.insertAmount(mars, 30);
        DBC.insertAmount(mars, 80);

        Manager Q = new Manager(new StringKey("M0"), "Rita", "Gashi");
        Manager N = new Manager(new StringKey("M1"), "Art", "Maloku");
        Manager G = new Manager(new StringKey("M2"), "Gona", "Blakqori");

        ManagerDatabase DBM = new ManagerDatabase(10);

        DBM.insert(Q);
        DBM.insert(N);
        DBM.insert(G);

        SalesPeople E = new SalesPeople("Egzon", "Blakaj", Q, DBC);
        SalesPeople F = new SalesPeople("Dona", "Gegaj", Q, DBC);
        SalesPeople B = new SalesPeople("Veton", "Krasniqi", N, DBC);
        SalesPeople A = new SalesPeople("Albi", "Buleshkaj", N, DBC);

        B.sell("Snickers", 50, "11/06/2019");
        F.sell("Snickers", 50, "11/06/2019");
        E.sell("Snickers", 50, "11/06/2019");
        B.sell("Bounty", 100, "25/02/2019");
        A.sell("Mars", 25, "12/03/2019");

        Q.performance();
        B.performance();
        F.performance();
        A.performance();

        DBM.totalPerformance();
        DBM.fire(Q);
        B.fire();
        B.fire();

    }

}

