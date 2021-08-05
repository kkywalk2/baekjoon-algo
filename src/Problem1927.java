import java.util.Scanner;

public class Problem1927 {
    static private int[] tree;
    static private int size = 0;

    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        int actionCount = sc.nextInt();
        int[] action = new int[actionCount];
        tree = new int[actionCount + 1];
        for (int i = 0; i < actionCount; i++) {
            action[i] = sc.nextInt();
        }
        for (int i = 0; i < actionCount; i++) {
            if (action[i] != 0) {
                add(action[i]);
            } else {
                System.out.println(remove());
            }
        }
        sc.close();
    }

    public static void add(int v) {
        if (size == 0) {
            tree[1] = v;
            size++;
            return;
        }

        int temp = size + 1;
        tree[temp] = v;

        while (temp != 1) {
            if (tree[temp / 2] > v) {
                int parent = tree[temp / 2];
                tree[temp / 2] = v;
                tree[temp] = parent;
            } else
                break;
            temp = temp / 2;
        }

        size++;
    }

    public static int remove() {
        if (size == 0)
            return 0;

        int result = tree[1];
        tree[1] = tree[size];
        size--;
        int temp = 1;
        while (temp != size) {
            int child = 0;

            if ((temp * 2 + 1) <= size && tree[temp * 2] > tree[temp * 2 + 1] && tree[temp * 2 + 1] < tree[temp]) {
                child = tree[temp * 2 + 1];
                tree[temp * 2 + 1] = tree[temp];
                tree[temp] = child;
                temp = temp * 2 + 1;
            } else if ((temp * 2) <= size && tree[temp * 2] < tree[temp]) {
                child = tree[temp * 2];
                tree[temp * 2] = tree[temp];
                tree[temp] = child;
                temp = temp * 2;
            } else {
                break;
            }
        }
        return result;
    }
}
