package balls;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.stream.Collectors;

public class Board {
	
	private Queue<Cell> walls = new LinkedList<Cell>();
	private Queue<Cell> paths = new LinkedList<Cell>();
	private Queue<Cell> workingQueue = new LinkedList<Cell>();
	private int size;


	public Board(int size) {
		super();
		this.size = size;
		createWalls();
	}
	
	private void createWalls() {
		for (int i = 0; i < size; i++) {
			for (int j = 0; j < size; j++) {
				Cell c = new Cell(i, j);
				if (c.isWall()) {
					walls.offer(c);
				}
			}
		}
	}

	private boolean isWall(Cell cell) {
		return walls.stream().anyMatch(c -> c.getX() == cell.getX() && c.getY() == cell.getY());
	}

	public void addWall(int x, int y) {
		Cell cell = new Cell(x, y);
		walls.offer(cell);
	}
	
	public Queue<Cell> getWalls() {
		return walls;
	}

	public boolean isAlreadyInPath(Cell cell) {
		return paths.stream().anyMatch(c -> c.getX() == cell.getX() && c.getY() == cell.getY() && c.getDistance() <= cell.getDistance());
	}

	public List<Cell> findPaths(Cell start, Cell end) {
		
		end.setDistance(0);		
		paths.offer(end);
		workingQueue.offer(end);
		
		while (!workingQueue.isEmpty()) {
			
			Cell cell = workingQueue.poll();
			
			Queue<Cell> adjacentCells = cell.getAdjacent();
			
			for (Cell adjacent : adjacentCells) {
				if (!isWall(adjacent) && !isAlreadyInPath(adjacent)) {
					workingQueue.offer(adjacent);
				}
			}
			
			if (!isAlreadyInPath(cell)) {
				paths.offer(cell);
			}
			
			if (cell.getX() == start.getX() && cell.getY() == start.getY()) {
				break;
			}
		}
		
		return paths.stream().sorted().collect(Collectors.toList());
	}

	public List<Cell> getShortestPath(Cell start, Cell end) {
		
		List<Cell> path = new LinkedList<>();
		
		Cell last = null; 
		for (Cell cell : findPaths(start, end)) {
			if (last == null) {
				path.add(cell);
				last = cell;
			} else if (cell.getDistance() < last.getDistance() && cell.isAdjacentTo(last)) {
				path.add(cell);
				last = cell;
			}
			
			if (last.getX() == end.getX() && last.getY() == end.getY())
				break;
			
		}
		
		return path; 
	}
	
	

}
