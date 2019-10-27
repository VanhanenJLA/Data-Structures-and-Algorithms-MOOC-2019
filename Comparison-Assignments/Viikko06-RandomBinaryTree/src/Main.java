
import java.util.ArrayList;
import java.util.Collections;

public class Main {
    
    public static void main(String[] args) {
        
        BinaryTree bt = new BinaryTree();
        
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < 1E7; i++) {
            list.add(i);
        }
        Collections.shuffle(list);
        
        list.forEach((integer) -> {
            bt.add(integer);
        });
        
        System.out.println("Height: " + bt.getHeight(bt.root, 0));
        
    }
    
}
