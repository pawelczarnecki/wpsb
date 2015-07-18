package tab1;

import java.awt.event.MouseEvent;

public class DrawBuildingListener extends AbstractMouseAndMotionListener {
    private DrawingPane drawingPane;
    private Building building;

//    public DrawBuildingListener(DrawingPane drawingPane) {
//        this.drawingPane = drawingPane;
//    }
//
//    @Override
//    public void mousePressed(MouseEvent e) {
//        building = new Building(e.getX(), e.getY());
//        drawingPane.add(building);
//    }
//
//    @Override
//    public void mouseDragged(MouseEvent e) {
//        building.setEnd(e.getX(), e.getY());
//        drawingPane.repaint();
//    }
//
//    @Override
//    public void mouseReleased(MouseEvent released) {
//        building.setEnd(released.getX(), released.getY());
//        drawingPane.repaint();
//        building = null;
//    }
}