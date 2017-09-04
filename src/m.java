import java.util.ArrayList;
import java.util.List;

class Node {
    private Integer id;
    private Integer parentId;
    private String name;
    private String link;

    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }
    public Integer getParentId() {
        return parentId;
    }
    public void setParentId(Integer parentId) {
        this.parentId = parentId;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getLink() {
        return link;
    }
    public void setLink(String link) {
        this.link = link;
    }
}

class Tree {
    private StringBuffer html = new StringBuffer();
    private List<Node> nodes;

    public Tree(List<Node> nodes){
        this.nodes = nodes;
    }

    public String buildTree(){
        html.append("<ul>");
        for (Node node : nodes) {
            Integer id = node.getId();
            if (node.getParentId() == null) {
                html.append("\r\n<li id='" + id + "'>" + node.getName()+ "</li>");
                build(node);
            }
        }
        html.append("\r\n</ul>");
        return html.toString();
    }

    private void build(Node node){
        List<Node> children = getChildren(node);
        if (!children.isEmpty()) {
            html.append("\r\n<ul>");
            for (Node child : children) {
                Integer id = child.getId();
                html.append("\r\n<li id='" + id + "'>" + child.getName()+ "</li>");
                build(child);
            }
            html.append("\r\n</ul>");
        }
    }

    private List<Node> getChildren(Node node){
        List<Node> children = new ArrayList<Node>();
        Integer id = node.getId();
        for (Node child : nodes) {
            if (id.equals(child.getParentId())) {
                children.add(child);
            }
        }
        return children;
    }
}


public class m {
    public static void main(String[] args) {
        List<Node> nodes = new ArrayList<Node>();

        Node node1 = new Node();
        node1.setId(1);
        node1.setName("node1");
        node1.setParentId(null);
        node1.setLink(null);
        nodes.add(node1);

        Node node11 = new Node();
        node11.setId(11);
        node11.setName("node11");
        node11.setParentId(1);
        node11.setLink(null);
        nodes.add(node11);

        Node node111 = new Node();
        node111.setId(111);
        node111.setName("node111");
        node111.setParentId(11);
        node111.setLink(null);
        nodes.add(node111);

        Node node12 = new Node();
        node12.setId(12);
        node12.setName("node12");
        node12.setParentId(1);
        node12.setLink(null);
        nodes.add(node12);

        Node node2 = new Node();
        node2.setId(2);
        node2.setName("node2");
        node2.setParentId(null);
        node2.setLink(null);
        nodes.add(node2);

        Node node21 = new Node();
        node21.setId(21);
        node21.setName("node21");
        node21.setParentId(2);
        node21.setLink(null);
        nodes.add(node21);

        Node node3 = new Node();
        node3.setId(3);
        node3.setName("node3");
        node3.setParentId(null);
        node3.setLink(null);
        nodes.add(node3);

        Tree tree = new Tree(nodes);
        System.out.println(tree.buildTree());
    }
}
