package util;

/**
 * Created by jason on 3/6/17.
 */
public class MBinarySearchTree<T extends Comparable<T>> {

    protected BSTNode<T> root;

    public MBinarySearchTree(){
        root = null;
    }

    public boolean search(T x){
        BSTNode<T> p;
        for (p = root; p != null; ){
            if (x.compareTo(p.info) > 0){
                p = p.right;
            } else if (x.compareTo(p.info) < 0){
                p = p.left;
            } else {
                return true;
            }
        }
        return false;
    }

    public void BFS(){
        System.out.print("BFS: ");
        if (root == null){
            System.out.println();
            return;
        }
        MQueue<BSTNode<T>> mQueue = new MQueue<>();
        mQueue.enqueue(root);
        while (!mQueue.isEmpty()){
            BSTNode<T> tmp = mQueue.dequeue();
            System.out.print(tmp.info + " ");

            // left to right
            if (tmp.left != null){
                mQueue.enqueue(tmp.left);
            }
            if (tmp.right != null){
                mQueue.enqueue(tmp.right);
            }

        }
        System.out.println();
    }

    public void preorder(BSTNode<T> p){
        if (p != null){
            System.out.print(p.info + " ");
            preorder(p.left);
            preorder(p.right);
        }
    }

    public void iterativePreorder(){
        System.out.print("Iterative preorder: ");
        if (root == null){
            System.out.println();
            return;
        }
        MStack<BSTNode<T>> mStack = new MStack<>();
        mStack.push(root);
        while (!mStack.isEmpty()){
            BSTNode<T> tmp = mStack.pop();
            System.out.print(tmp.info + " ");
            if (tmp.right != null){
                mStack.push(tmp.right);
            }
            if (tmp.left != null){
                mStack.push(tmp.left);
            }
        }
        System.out.println();
    }

    public void inorder(BSTNode<T> p){
        if (p != null){
            inorder(p.left);
            System.out.print(p.info + " ");
            inorder(p.right);
        }
    }

    public void iterativeInorder(){
        System.out.print("Iterative inorder: ");
        BSTNode<T> p = root;
        MStack<BSTNode<T>> mStack = new MStack<>();
        while (p != null){
            while (p != null){
                if (p.right != null){
                    mStack.push(p.right);
                }
                mStack.push(p);
                p = p.left;
            }

            p = mStack.pop();
            while (p.right == null && !mStack.isEmpty()){
                System.out.print(p.info + " ");
                p = mStack.pop();
            }

            System.out.print(p.info + " ");
            if (!mStack.isEmpty()){
                p = mStack.pop();
            } else{
                System.out.println();
                return;
            }
        }
        System.out.println();
    }

    public void postorder(BSTNode<T> p){
        if (p != null){
            postorder(p.left);
            postorder(p.right);
            System.out.print(p.info + " ");
        }
    }


    /**
     * unfinished
     */
    public void iterativePostorder(){
        System.out.print("Iterative postorder: ");
        // LRV   VRL
        MStack<BSTNode<T>> mStack1 = new MStack<>();
        MStack<BSTNode<T>> mStack2 = new MStack<>();

        mStack1.push(root);
        while (!mStack1.isEmpty()){
            BSTNode<T> tmp = mStack1.pop();
            mStack2.push(tmp);
            if (tmp.right != null){
                mStack1.push(tmp.right);
                mStack2.push(tmp.right);
            }
            if (tmp.left != null){
                mStack1.push(tmp.left);
                mStack2.push(tmp.left);
            }

            while (!mStack2.isEmpty()){
                BSTNode<T> tmp2 = mStack2.pop();
                System.out.print(tmp2.info + " ");
            }
        }

        System.out.println();
    }

    public void insert(T x){
        if (root == null){
            root = new BSTNode<T>(x);
            return;
        }

        BSTNode<T> p = root, prev;
        while (p != null){
            prev = p;
            if (x.compareTo(p.info) > 0){
                p = p.right;
            } else{
                p = p.left;
            }

            if (x.compareTo(prev.info) > 0){
                prev.right = new BSTNode<T>(x);
            } else{
                prev.left = new BSTNode<T>(x);
            }
        }
    }

    public void deleteByMerging(){

    }

    public void deleteByCopying(){

    }

    public static void main(String[] args){
        MBinarySearchTree<Integer> tree = new MBinarySearchTree<>();
        tree.root = new BSTNode<Integer>(13,
                new BSTNode<Integer>(10,
                        new BSTNode<Integer>(2), new BSTNode<Integer>(12)),
                new BSTNode<Integer>(25,
                        new BSTNode<Integer>(20), new BSTNode<Integer>(31, new BSTNode<Integer>(29), null)));

        System.out.println(tree.search(32));
        tree.BFS();
        tree.preorder(tree.root);
        System.out.println();
        tree.iterativePreorder();
        tree.inorder(tree.root);
        System.out.println();
        tree.iterativeInorder();
        tree.postorder(tree.root);
        System.out.println();
        tree.iterativePostorder();

    }

}

class BSTNode<T>{
    protected T info;
    protected BSTNode<T> left;
    protected BSTNode<T> right;

    public BSTNode(){
        left = right = null;
    }

    public BSTNode(T info){
        this(info, null, null);
    }

    public BSTNode(T info, BSTNode<T> left, BSTNode<T> right){
        this.info = info;
        this.left = left;
        this.right = right;
    }
}
