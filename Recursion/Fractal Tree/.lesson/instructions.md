# Instructions  

Read the code for the drawTree method so that you understand what it's doing.
Modify the program so the tree looks more realistic. Try using some Math.random statments to help you make it look more natural. You can also try adding additional recursive calls.
```
(int)(Math.random() * range) + shift
```
Feel free to change the following and the code in the drawTree method.
```python
this.setSize(600, 500);               // line 10

drawTree(g2D, 300, 500, -90, 6, 5);   // line 17

```

```python
private void drawTree(Graphics2D g, int x1, int y1, double angle, int length, int width) {
    if (length == 0) {
        return;
    }

    if (width < 1) {
        width = 1;
    }
    g.setStroke(new BasicStroke(width, BasicStroke.CAP_ROUND, BasicStroke.JOIN_ROUND));

    int red = (int) (Math.random() * 256);
    int grn = (int) (Math.random() * 256);
    int blu = (int) (Math.random() * 256);
    g.setColor(new Color(red, grn, blu));

    int x2 = x1 + (int) (Math.cos(Math.toRadians(angle)) * length * 16.0);
    int y2 = y1 + (int) (Math.sin(Math.toRadians(angle)) * length * 16.0);

    g.drawLine(x1, y1, x2, y2);

    drawTree(g, x2, y2, angle - 30, length - 1, width);
    drawTree(g, x2, y2, angle + 30, length - 1, width);

}
```