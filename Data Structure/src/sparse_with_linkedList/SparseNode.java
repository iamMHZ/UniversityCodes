package sparse_with_linkedList;

public class SparseNode {

	private int row;
	private int col;
	private int value;

	private SparseNode down;
	private SparseNode right;

	public SparseNode(int row, int col, int value) {
		this.row = row;
		this.col = col;
		this.value = value;
	}

	public SparseNode(SparseNode down, SparseNode right) {
		this.down = down;
		this.right = right;
	}

	public int getRow() {
		return row;
	}

	public void setRow(int row) {
		this.row = row;
	}

	public int getCol() {
		return col;
	}

	public void setCol(int col) {
		this.col = col;
	}

	public int getValue() {
		return value;
	}

	public void setValue(int value) {
		this.value = value;
	}

	public SparseNode getDown() {
		return down;
	}

	public void setDown(SparseNode down) {
		this.down = down;
	}

	public SparseNode getRight() {
		return right;
	}

	public void setRight(SparseNode right) {
		this.right = right;
	}

}
