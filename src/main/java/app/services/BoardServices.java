package app.services;

import java.util.Queue;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import app.model.Board;
import app.model.Cell;

@Service
public class BoardServices {
	
	private Board board;

	@Autowired
	public BoardServices(Board board) {
		super();
		this.board = board;
	}
	
	public BoardServices() {
		super();
	}

	public Queue<Cell> getWalls() {
		return board.getWalls();
	}

	public void addStart(Cell start) {
		board.setStart(start);
	}
	
	public void setStart(Cell start) {
		board.setStart(start);
	}
	
	public void setEnd(Cell end) {
		board.setEnd(end);
	}
	
}
