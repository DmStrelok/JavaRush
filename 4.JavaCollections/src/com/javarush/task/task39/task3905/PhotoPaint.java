package com.javarush.task.task39.task3905;

public class PhotoPaint {
    private Color color = null;

    public boolean paintFill(Color[][] image, int r, int c, Color desiredColor) {
        if (c < 0 || c >= image.length || r < 0 || r >= image[0].length || image[c][r].equals(desiredColor)) return false;
        if (color == null) color = image[c][r];
        if (!image[c][r].equals(color)) return false;
        image[c][r] = desiredColor;
        paintFill(image, r - 1, c, desiredColor);
        paintFill(image, r + 1, c, desiredColor);
        paintFill(image, r, c - 1, desiredColor);
        paintFill(image, r, c + 1, desiredColor);
        return true;
    }
}
