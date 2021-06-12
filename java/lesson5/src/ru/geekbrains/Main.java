package ru.geekbrains;

public class Main {

    public static void main(String[] args) {
	Worker[] workerArray = new Worker[5];
	workerArray[0] = new Worker("Ivanov Ivan", "Engineer", "ivivan@mailbox.com", "892312311", 30000, 18);
	workerArray[1] = new Worker("Ivanov Sergey", "Engineer", "ivivan2@mailbox.com", "892312312", 30000, 30);
	workerArray[2] = new Worker("Ivanov Dima", "Manager", "ivivan3@mailbox.com", "892312313", 30000, 33);
	workerArray[3] = new Worker("Ivanov Oleg", "Cleaner", "ivivan4@mailbox.com", "892312314", 30000, 45);
	workerArray[4] = new Worker("Ivanov Boris", "Director", "ivivan5@mailbox.com", "892312315", 30000, 60);
	int ageWorkerMore40 = 40;


        for (int i = 0; i < workerArray.length; i++) {
            if(workerArray[i].getAge() > ageWorkerMore40){
                System.out.println(workerArray[i].infoWorker());
            }
        }
    }

}
