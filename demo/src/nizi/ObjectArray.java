package nizi;

public class ObjectArray {

	public static void main(String[] args) {

		Account obj[] = new Account[2];

		Account prv = new Account(1, 2);
		Account vtor = new Account(3, 4);

		obj[0] = prv;
		obj[1] = vtor;

		System.out.println(obj[0].toString());
		System.out.println(obj[1].toString());

		// niza od tip akaunt i e dolga so 2 objekti, parametri 6:55
		Account niza[] = new Account[2];
		
		// go instancirame prviot objekt i go stavame vo nizata na prvoto mesto
		niza[0] = new Account();
		// go instancirame vtoriot objekt i go stavame vo nizata na vtoroto mesto
		niza[1] = new Account();
		
		// zadavame parametri na prviot objekt
		niza[0].setData(5, 6);
		// zadavame parametri na vtoriot objekt
		niza[1].setData(7, 8);
		
		niza[0].showData();
		niza[1].showData();

	}

}
