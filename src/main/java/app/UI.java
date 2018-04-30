package app;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Container;
import java.awt.GridLayout;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

import app.model.Board;
import app.model.Cell;

public class UI extends JFrame implements ActionListener {

	private enum Selection {
		START, END, WALLS
	}

	private Selection selectedButton = Selection.WALLS;
	private Board board = new Board(10);
	private JPanel topPanel = new JPanel(new GridLayout(1, 3));
	private JPanel centerPanel = new JPanel(new GridLayout(10, 10));
	private JPanel bottomPanel = new JPanel(new GridLayout(1, 1));

	@Override
	public void actionPerformed(ActionEvent e) {
		String actionCommand = e.getActionCommand();
		System.out.println(actionCommand);
		switch (actionCommand) {
		case "Add Start": {
			selectedButton = Selection.START;
			deselectOtherButtons("Add Start");
		}
			break;
		case "Add End": {
			selectedButton = Selection.END;
			deselectOtherButtons("Add End");
		}
			break;
		case "Add Walls": {
			selectedButton = Selection.WALLS;
			deselectOtherButtons("Add Walls");
		}
			break;
		case "Go!": {
			System.out.println("Go!!!");
		}
			break;
		default: {
			markCell((JButton) e.getSource());
		}
			break;

		}
	}

	private void markCell(JButton cell) {
		switch (selectedButton) {
		case START: {
			cell.setText("S");
		} break;
		case END: {
			cell.setText("E");
		} break;
		case WALLS: {
			cell.setText("X");
		} break;
		default:
			break;
		}
	}

	private void deselectOtherButtons(String txt) {
		Component[] components = topPanel.getComponents();
		for (Component component : components) {
			JRadioButton button = (JRadioButton) component;
			if (!button.getText().equals(txt)) {
				button.setSelected(false);
			}
		}
	}

	public UI() throws HeadlessException {
		super();

		addRadioButtonToTopPanel();
		add(topPanel, BorderLayout.NORTH);

		for (int i = 0; i < 100; i++) {
			JButton b = new JButton(Integer.toString(i));
			b.addActionListener(this);
			centerPanel.add(b);
		}
		add(centerPanel, BorderLayout.CENTER);

		JButton go = new JButton("Go!");
		go.addActionListener(this);
		bottomPanel.add(go);
		add(bottomPanel, BorderLayout.SOUTH);

		setSize(1000, 1000);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		pack();
		setVisible(true);
	}

	private void addRadioButtonToTopPanel() {
		JRadioButton startButton = new JRadioButton("Add Start");
		startButton.addActionListener(this);
		JRadioButton endButton = new JRadioButton("Add End");
		endButton.addActionListener(this);
		JRadioButton wallsButton = new JRadioButton("Add Walls");
		wallsButton.addActionListener(this);

		topPanel.add(startButton);
		topPanel.add(endButton);
		topPanel.add(wallsButton);
	}

	public static void main(String[] args) {
		UI ui = new UI();
	}

}
