package move;

import type.Direction;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class MyKeyListener extends KeyAdapter {
    private Move move;

    public MyKeyListener(Move move) {
        this.move = move;
    }

    @Override
    public void keyTyped(KeyEvent e) {
        if (e.getKeyChar() == KeyEvent.VK_W || e.getKeyChar() == KeyEvent.VK_UP) {
            if (move.getDirection() == Direction.DOWN) return;
            move.setDirection(Direction.UP);
        }
        if (e.getKeyChar() == KeyEvent.VK_S || e.getKeyChar() == KeyEvent.VK_DOWN) {
            if (move.getDirection() == Direction.UP) return;
            move.setDirection(Direction.DOWN);
        }
        if (e.getKeyChar() == KeyEvent.VK_A || e.getKeyChar() == KeyEvent.VK_LEFT) {
            if (move.getDirection() == Direction.RIGHT) return;
            move.setDirection(Direction.LEFT);
        }
        if (e.getKeyChar() == KeyEvent.VK_D || e.getKeyChar() == KeyEvent.VK_RIGHT) {
            if (move.getDirection() == Direction.LEFT) return;
            move.setDirection(Direction.RIGHT);
        }
        if (e.getKeyChar() == KeyEvent.VK_SPACE) {
            move.setRun(!move.getRun());
        }
    }
}
