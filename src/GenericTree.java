import java.util.*;

public class GenericTree {

    private static GenericTreeNode root;
    private static List<GenericTreeNode> hijos;

    public GenericTree() {
        super();
        hijos = new ArrayList<GenericTreeNode>();
    }

    public GenericTreeNode getRoot() {
        return this.root;
    }

    public void setRoot(GenericTreeNode root) {
        this.root = root;
    }

    public int getNumberOfNodes() {
        int numberOfNodes = 0;

        if(root != null) {
            numberOfNodes = auxiliaryGetNumberOfNodes(root) + 1; //1 for the root!
        }

        return numberOfNodes;
    }

    private int auxiliaryGetNumberOfNodes(GenericTreeNode node) {
        int numberOfNodes = node.getNumberOfChildren();

        for(GenericTreeNode child : node.getChildren()) {
            numberOfNodes += auxiliaryGetNumberOfNodes(child);
        }

        return numberOfNodes;
    }

    public boolean exists(Tipo dataToFind) {
        return (find(dataToFind) != null);
    }

    public GenericTreeNode find(Tipo dataToFind) {
        GenericTreeNode returnNode = null;

        if(root != null) {
            returnNode = auxiliaryFind(root, dataToFind);
        }

        return returnNode;
    }

    private GenericTreeNode auxiliaryFind(GenericTreeNode currentNode, Tipo dataToFind) {
        GenericTreeNode returnNode = null;
        int i = 0;

        if (currentNode.getData().equals(dataToFind)) {
            returnNode = currentNode;
        }

        else if(currentNode.hasChildren()) {
            i = 0;
            while(returnNode == null && i < currentNode.getNumberOfChildren()) {
                returnNode = auxiliaryFind(currentNode.getChildAt(i), dataToFind);
                i++;
            }
        }

        return returnNode;
    }

    public boolean isEmpty() {
        return (root == null);
    }

    public List<GenericTreeNode> build(GenericTreeTraversalOrderEnum traversalOrder) {
        List<GenericTreeNode> returnList = null;

        if(root != null) {
            returnList = build(root, traversalOrder);
        }
        hijos=returnList;

        return returnList;
    }

    public List<GenericTreeNode> build(GenericTreeNode node, GenericTreeTraversalOrderEnum traversalOrder) {
        List<GenericTreeNode> traversalResult = new ArrayList<GenericTreeNode>();

        if(traversalOrder == GenericTreeTraversalOrderEnum.PRE_ORDER) {
            buildPreOrder(node, traversalResult);
        }

        else if(traversalOrder == GenericTreeTraversalOrderEnum.POST_ORDER) {
            buildPostOrder(node, traversalResult);
        }
        hijos=traversalResult;

        return traversalResult;
    }

    private void buildPreOrder(GenericTreeNode node, List<GenericTreeNode> traversalResult) {
        traversalResult.add(node);
        hijos=traversalResult;
        for(GenericTreeNode child : node.getChildren()) {
            buildPreOrder(child, traversalResult);
        }
    }

    private void buildPostOrder(GenericTreeNode node, List<GenericTreeNode> traversalResult) {
        for(GenericTreeNode child : node.getChildren()) {
            buildPostOrder(child, traversalResult);
        }
        hijos=traversalResult;
        traversalResult.add(node);
    }

    public List<GenericTreeNode> buscar(Tipo dataToFind) {
        List<GenericTreeNode> nodos = new ArrayList<GenericTreeNode>();
        nodos = null;

        if(root != null) {
            nodos = buscarArreglo(root, dataToFind);
        }

        return nodos;
    }

    private List<GenericTreeNode> buscarArreglo(GenericTreeNode currentNode, Tipo dataToFind) {
        List<GenericTreeNode> nodos = new ArrayList<GenericTreeNode>();
        int i = 0;

        if (currentNode.getData().equals(dataToFind)) {
            nodos.add(currentNode);
        }

        if(currentNode.hasChildren()) {
            i = 0;
            while(i < currentNode.getNumberOfChildren()) {
                nodos.addAll(buscarArreglo(currentNode.getChildAt(i), dataToFind));
                i++;
            }
        }

        return nodos;
    }

    public Map<GenericTreeNode, Integer> buildWithDepth(GenericTreeTraversalOrderEnum traversalOrder) {
        Map<GenericTreeNode, Integer> returnMap = null;

        if(root != null) {
            returnMap = buildWithDepth(root, traversalOrder);
        }

        return returnMap;
    }

    public Map<GenericTreeNode, Integer> buildWithDepth(GenericTreeNode node, GenericTreeTraversalOrderEnum traversalOrder) {
        Map<GenericTreeNode, Integer> traversalResult = new LinkedHashMap<GenericTreeNode, Integer>();

        if(traversalOrder == GenericTreeTraversalOrderEnum.PRE_ORDER) {
            buildPreOrderWithDepth(node, traversalResult, 0);
        }

        else if(traversalOrder == GenericTreeTraversalOrderEnum.POST_ORDER) {
            buildPostOrderWithDepth(node, traversalResult, 0);
        }

        return traversalResult;
    }

    private void buildPreOrderWithDepth(GenericTreeNode node, Map<GenericTreeNode, Integer> traversalResult, int depth) {
        traversalResult.put(node, depth);

        for(GenericTreeNode child : node.getChildren()) {
            buildPreOrderWithDepth(child, traversalResult, depth + 1);
        }
    }

    private void buildPostOrderWithDepth(GenericTreeNode node, Map<GenericTreeNode, Integer> traversalResult, int depth) {
        for(GenericTreeNode child : node.getChildren()) {
            buildPostOrderWithDepth(child, traversalResult, depth + 1);
        }

        traversalResult.put(node, depth);
    }

    public String toString() {
        /*
        We're going to assume a pre-order traversal by default
         */

        String stringRepresentation = "";

        if(root != null) {
            stringRepresentation = build(GenericTreeTraversalOrderEnum.PRE_ORDER).toString();


        }

        return stringRepresentation;
    }

    public String toStringWithDepth() {
        /*
        We're going to assume a pre-order traversal by default
         */

        String stringRepresentation = "";

        if(root != null) {
            stringRepresentation = buildWithDepth(GenericTreeTraversalOrderEnum.PRE_ORDER).toString();
        }
        return stringRepresentation;
    }

    public List<GenericTreeNode> list(){
        hijos = build(GenericTreeTraversalOrderEnum.PRE_ORDER);
        return hijos;

    }
    public static String Imprimir(int x){
        String cadena = "";

        for (int i=0; i< hijos.get(x).getChildren().size();i++){

            cadena += hijos.get(x).getChildren().get(i).getData().getNombre() + " ";

        }

        return cadena;

    }

    public List<GenericTreeNode> buscar(String dataToFind) {
        List<GenericTreeNode> nodos;
        nodos = null;

        if(root != null) {
            nodos = buscarArreglo(root, dataToFind);
        }

        return nodos;
    }

    private List<GenericTreeNode> buscarArreglo(GenericTreeNode currentNode, String dataToFind) {
        List<GenericTreeNode> nodos = new ArrayList<GenericTreeNode>();
        int i = 0;

        if (currentNode.getData().getNombre().equals(dataToFind)) {
            nodos.add(currentNode);
        }

        if(currentNode.hasChildren()) {
            i = 0;
            while(i < currentNode.getNumberOfChildren()) {
                nodos.addAll(buscarArreglo(currentNode.getChildAt(i), dataToFind));
                i++;
            }
        }

        return nodos;
    }


}