import static org.junit.Assert.assertEquals;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
/*
 * Class: CMSC204
 * Instructor: Khandan Monshi
 * Description: Create a Junit test class that tests the methods of the TreeNode class.
 * Due: 04/20/24
 * Platform/compiler: Eclipse IDE
 * I pledge that I have completed the programming assignment
 * independently. I have not copied the code from a student or
 * any source. I have not given my code to any student.
 * Print your Name here: _Kevin Villegas_
 */
class TreeNode_STUDENT_Test {
	TreeNode<String> node1;
	TreeNode<String> node2;
	TreeNode<String> node3;

	@BeforeEach
	void setUp() throws Exception {
		node1 = new TreeNode<String>("a");
		node2 = new TreeNode<String>("b");
		node3 = new TreeNode<String>(node2);
	}

	@AfterEach
	void tearDown() throws Exception {
		node1 = node2 = node3 = null;
	}

	@Test
	void testGetData() {
		assertEquals("a", node1.getData());
		assertEquals("b", node2.getData());
		assertEquals("b", node3.getData());
	}

	@Test
	void testSetLeftChild() {
		assertEquals(null, node1.getLeftChild());
		node1.setLeftChild(node2);
		assertEquals(node2, node1.getLeftChild());
		node1.setLeftChild(node3);
		assertEquals(node3, node1.getLeftChild());
		node1.setLeftChild(null);
		assertEquals(null, node1.getLeftChild());
	}

	@Test
	void testSetRightChild() {
		assertEquals(null, node1.getRightChild());
		node1.setRightChild(node2);
		assertEquals(node2, node1.getRightChild());
		node1.setRightChild(node3);
		assertEquals(node3, node1.getRightChild());
		node1.setRightChild(null);
		assertEquals(null, node1.getRightChild());
	}

	@Test
	void testGetLeftChild() {
		assertEquals(null, node1.getLeftChild());
		node1.setLeftChild(node2);
		assertEquals(node2, node1.getLeftChild());
		node1.setLeftChild(node3);
		assertEquals(node3, node1.getLeftChild());
		node1.setLeftChild(null);
		assertEquals(null, node1.getLeftChild());
	}

	@Test
	void testGetRightChild() {
		assertEquals(null, node1.getRightChild());
		node1.setRightChild(node2);
		assertEquals(node2, node1.getRightChild());
		node1.setRightChild(node3);
		assertEquals(node3, node1.getRightChild());
		node1.setRightChild(null);
		assertEquals(null, node1.getRightChild());
	}

}
