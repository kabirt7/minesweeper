package minesweeper;

public class Cell {
	
	private boolean is_mine;
	private boolean has_been_revealed;
	private int mines_in_vicinity;
	
	public Cell() {
		this.is_mine = false;
		this.has_been_revealed = false;
		this.mines_in_vicinity = 0;
	}
	
	public void printCell() {
		if (!this.has_been_revealed) {
			System.out.print(" o ");
		}
		if (this.has_been_revealed && this.is_mine) {
			System.out.print(" X ");
		}
		if (this.has_been_revealed && !this.is_mine) {
			if (this.mines_in_vicinity == 0) {
				System.out.print(" + ");
			} else {
				System.out.print(String.format(" %s ", this.mines_in_vicinity));
			}
		}
	}

	// if hbr false print O
	// if hbr true and is mine print X
	// if hbr true and is mine false print +
	
	public boolean checkIfMine() {
		return this.is_mine;
	}
	
	public boolean checkRevealed() {
		return has_been_revealed;
	}

	public void revealCell() {
		this.has_been_revealed = true;
	}

	public void makeMine() {
		this.is_mine = true;
	}

	public void setMinesInVicinity(int total) {
		this.mines_in_vicinity += total;
	}
	
	public int getMinesInVicinity() {
		return this.mines_in_vicinity;
	}
}
