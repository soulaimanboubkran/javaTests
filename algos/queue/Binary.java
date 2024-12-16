package algos.queue;

public class Binary {
    
    public String[] generateBinaryNumbers(int n){
        String[] res = new String[n];
        Queue<String> q = new Queue<>();

        q.enqueue("1");
        for(int i = 0 ; i<n;i++){
            res[i] = q.dequeue();
            q.enqueue(res[i] + "0");
            q.enqueue(res[i] + "1");
        }
        return res;
    }
    public static void main(String[] args) {
        Binary binary = new Binary();
        int n = 10; // Number of binary numbers to generate
        String[] binaryNumbers = binary.generateBinaryNumbers(n);

        System.out.println("First " + n + " binary numbers:");
        for (String binaryNumber : binaryNumbers) {
            System.out.print(binaryNumber + " ");
        }
    }
}
