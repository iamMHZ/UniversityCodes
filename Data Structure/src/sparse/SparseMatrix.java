package sparse;

public class SparseMatrix {

	private SparseNode[] data;
	private int terms;
	private int rows;
	private int cols;

	public SparseMatrix(SparseNode[] data, int terms, int rows, int cols) {
		this.data = data;
		this.terms = terms;
		this.rows = rows;
		this.cols = cols;
	}

	public void add(SparseMatrix other) {

	}

	public void multi(SparseMatrix other) {
	}

	public void transpose() {

		SparseNode[] other = new SparseNode[terms];
		
		for(int i=0; i< data.length;i++) {
			
		}
	}
}
