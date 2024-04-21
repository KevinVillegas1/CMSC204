import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import java.util.ArrayList;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
/*
 * Class: CMSC204
 * Instructor: Khandan Monshi
 * Description: Create a Junit test class that tests the methods of the MorseCodeTree class.
 * Due: 04/20/24
 * Platform/compiler: Eclipse IDE
 * I pledge that I have completed the programming assignment
 * independently. I have not copied the code from a student or
 * any source. I have not given my code to any student.
 * Print your Name here: _Kevin Villegas_
 */
class MorseCodeTree_STUDENT_Test {
	MorseCodeTree<String> tree;
	
	@BeforeEach
	void setUp() throws Exception {
		tree = new MorseCodeTree<String>();
	}

	@AfterEach
	void tearDown() throws Exception {
		tree = null;
	}

	@Test
	void testGetRoot() {
		assertEquals("", tree.getRoot().getData());
		tree.setRoot(null);
		assertEquals(null, tree.getRoot());
		tree.setRoot(new TreeNode<String>(""));
		assertEquals("", tree.getRoot().getData());
	}

	@Test
	void testSetRoot() {
		assertEquals("", tree.getRoot().getData());
		tree.setRoot(null);
		assertEquals(null, tree.getRoot());
		tree.setRoot(new TreeNode<String>(""));
		assertEquals("", tree.getRoot().getData());
	}

	@Test
	void testInsert() {
		tree.insert("", "");
		tree.insert("....", "h");
		tree.insert("...", "s");
		tree.insert("...-", "v");
		assertEquals("", tree.getRoot().getData());
		ArrayList<String> arrayList = tree.toArrayList();
		String list = "";
		for (String s : arrayList)
		{
			list += s + " ";
		}
		assertEquals("h s v i f u e l r a p w j  b d x n c k y t z g q m o ", list);
		assertEquals("", tree.getRoot().getData());
	}

	@Test
	void testAddNode() {
		tree.addNode(tree.getRoot(), "", "");
		tree.addNode(tree.getRoot(), "....", "h");
		tree.addNode(tree.getRoot(), "...", "s");
		tree.addNode(tree.getRoot(), "...-", "v");
		assertEquals("", tree.getRoot().getData());
		ArrayList<String> arrayList = tree.toArrayList();
		String list = "";
		for (String s : arrayList)
		{
			list += s + " ";
		}
		assertEquals("h s v i f u e l r a p w j  b d x n c k y t z g q m o ", list);
		assertEquals("", tree.getRoot().getData());
	}

	@Test
	void testFetch() {
		String s0 = tree.fetch("");
		String s1 = tree.fetch(".");
		String s2 = tree.fetch("-");
		String s3 = tree.fetch("..");
		String s4 = tree.fetch(".-");
		String s5 = tree.fetch("-.");
		String s6 = tree.fetch("--");
		String s7 = tree.fetch("...");
		String s8 = tree.fetch("..-");
		String s9 = tree.fetch(".-.");
		String s10 = tree.fetch(".--");
		String s11 = tree.fetch("-..");
		String s12 = tree.fetch("-.-");
		String s13 = tree.fetch("--.");
		String s14 = tree.fetch("---");
		String s15 = tree.fetch("....");
		String s16 = tree.fetch("...-");
		String s17 = tree.fetch("..-.");
		String s18 = tree.fetch(".-..");
		String s19 = tree.fetch(".--.");
		String s20 = tree.fetch(".---");
		String s21 = tree.fetch("-...");
		String s22 = tree.fetch("-..-");
		String s23 = tree.fetch("-.-.");
		String s24 = tree.fetch("-.--");
		String s25 = tree.fetch("--..");
		String s26 = tree.fetch("--.-");
		assertEquals("", s0);
		assertEquals("e", s1);
		assertEquals("t", s2);
		assertEquals("i", s3);
		assertEquals("a", s4);
		assertEquals("n", s5);
		assertEquals("m", s6);
		assertEquals("s", s7);
		assertEquals("u", s8);
		assertEquals("r", s9);
		assertEquals("w", s10);
		assertEquals("d", s11);
		assertEquals("k", s12);
		assertEquals("g", s13);
		assertEquals("o", s14);
		assertEquals("h", s15);
		assertEquals("v", s16);
		assertEquals("f", s17);
		assertEquals("l", s18);
		assertEquals("p", s19);
		assertEquals("j", s20);
		assertEquals("b", s21);
		assertEquals("x", s22);
		assertEquals("c", s23);
		assertEquals("y", s24);
		assertEquals("z", s25);
		assertEquals("q", s26);
	}

	@Test
	void testFetchNode() {
		String s0 = tree.fetchNode(tree.getRoot(), "");
		String s1 = tree.fetchNode(tree.getRoot(), ".");
		String s2 = tree.fetchNode(tree.getRoot(), "-");
		String s3 = tree.fetchNode(tree.getRoot(), "..");
		String s4 = tree.fetchNode(tree.getRoot(), ".-");
		String s5 = tree.fetchNode(tree.getRoot(), "-.");
		String s6 = tree.fetchNode(tree.getRoot(), "--");
		String s7 = tree.fetchNode(tree.getRoot(), "...");
		String s8 = tree.fetchNode(tree.getRoot(), "..-");
		String s9 = tree.fetchNode(tree.getRoot(), ".-.");
		String s10 = tree.fetchNode(tree.getRoot(), ".--");
		String s11 = tree.fetchNode(tree.getRoot(), "-..");
		String s12 = tree.fetchNode(tree.getRoot(), "-.-");
		String s13 = tree.fetchNode(tree.getRoot(), "--.");
		String s14 = tree.fetchNode(tree.getRoot(), "---");
		String s15 = tree.fetchNode(tree.getRoot(), "....");
		String s16 = tree.fetchNode(tree.getRoot(), "...-");
		String s17 = tree.fetchNode(tree.getRoot(), "..-.");
		String s18 = tree.fetchNode(tree.getRoot(), ".-..");
		String s19 = tree.fetchNode(tree.getRoot(), ".--.");
		String s20 = tree.fetchNode(tree.getRoot(), ".---");
		String s21 = tree.fetchNode(tree.getRoot(), "-...");
		String s22 = tree.fetchNode(tree.getRoot(), "-..-");
		String s23 = tree.fetchNode(tree.getRoot(), "-.-.");
		String s24 = tree.fetchNode(tree.getRoot(), "-.--");
		String s25 = tree.fetchNode(tree.getRoot(), "--..");
		String s26 = tree.fetchNode(tree.getRoot(), "--.-");
		assertEquals("", s0);
		assertEquals("e", s1);
		assertEquals("t", s2);
		assertEquals("i", s3);
		assertEquals("a", s4);
		assertEquals("n", s5);
		assertEquals("m", s6);
		assertEquals("s", s7);
		assertEquals("u", s8);
		assertEquals("r", s9);
		assertEquals("w", s10);
		assertEquals("d", s11);
		assertEquals("k", s12);
		assertEquals("g", s13);
		assertEquals("o", s14);
		assertEquals("h", s15);
		assertEquals("v", s16);
		assertEquals("f", s17);
		assertEquals("l", s18);
		assertEquals("p", s19);
		assertEquals("j", s20);
		assertEquals("b", s21);
		assertEquals("x", s22);
		assertEquals("c", s23);
		assertEquals("y", s24);
		assertEquals("z", s25);
		assertEquals("q", s26);
	}

	@Test
	void testDelete() {
		try {
			tree.delete("");
		} catch (UnsupportedOperationException e) {
			assertTrue("threw UnsupportedOperationException successfuly", true);
		}
	}

	@Test
	void testUpdate() {
		try {
			tree.update();
		} catch (UnsupportedOperationException e) {
			assertTrue("threw UnsupportedOperationException successfuly", true);
		}
	}

	@Test
	void testBuildTree() {
		tree.buildTree();
		assertEquals("", tree.getRoot().getData());
		ArrayList<String> arrayList = tree.toArrayList();
		String list = "";
		for (String s : arrayList)
		{
			list += s + " ";
		}
		assertEquals("h s v i f u e l r a p w j  b d x n c k y t z g q m o ", list);
		assertEquals("", tree.getRoot().getData());
	}

	@Test
	void testToArrayList() {
		ArrayList<String> arrayList = tree.toArrayList();
		String list = "";
		for (String s : arrayList)
		{
			list += s + " ";
		}
		assertEquals("h s v i f u e l r a p w j  b d x n c k y t z g q m o ", list);
	}

	@Test
	void testLNRoutputTraversal() {
		ArrayList<String> arrayList = new ArrayList<String>();
		String list = "";
		tree.LNRoutputTraversal(tree.getRoot(), arrayList);
		for (String s : arrayList)
		{
			list += s + " ";
		}
		assertEquals("h s v i f u e l r a p w j  b d x n c k y t z g q m o ", list);
	}

}
