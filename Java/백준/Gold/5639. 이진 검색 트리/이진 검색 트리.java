import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {

	static StringBuilder sb;
	static Node root = null;
	
	static class Node {
		int data;
		Node left, right;
		
		Node(int data){
			this.data = data;
			this.left = null;
			this.right = null;
		}
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		sb = new StringBuilder();
		
		String input;
		while((input=br.readLine()) != null && !input.isEmpty()) {
			int value = Integer.parseInt(input);
			root = insertNode(root, value);
		}
		
		postOrder(root);
		
		bw.write(sb.toString());
		bw.flush();
		bw.close();
		br.close();

	}
	
	static Node insertNode(Node node, int value) {
		if(node == null) {
			return new Node(value);
		}
		
		if(value <= node.data) {
			node.left = insertNode(node.left, value);
		} else {
			node.right = insertNode(node.right, value);
		}
		
		return node;
	}
	
	static void postOrder(Node node) {
		if(node == null) return;
		
		postOrder(node.left);
		postOrder(node.right);
		sb.append(node.data).append("\n");
		
	}

}
