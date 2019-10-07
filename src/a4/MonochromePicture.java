package a4;

public class MonochromePicture implements Picture {

    private int width;
    private int height;
    private Pixel[][] monochromeArray;

    public MonochromePicture(int width, int height, Pixel value) {
        this.width = width;
        this.height = height;
        for (int i = 0; i < width; i++) {
            for (int j = 0; j < height; j++) {
                this.monochromeArray[i][j] = value;
            }
        }
    }

    @Override
    public int getWidth() {
        return this.width;
    }

    @Override
    public int getHeight() {
        return this.height;
    }

    @Override
    public Pixel getPixel(int x, int y) {
        return monochromeArray[x][y];
    }

    @Override
    public Picture paint(int x, int y, Pixel p) {
        return new MonochromePicture(x, y, p);   
    }

    @Override
    public Picture paint(int x, int y, Pixel p, double factor) {
        return null;
    }

    @Override
    public Picture paint(int ax, int ay, int bx, int by, Pixel p) {
        return null;
    }

    @Override
    public Picture paint(int ax, int ay, int bx, int by, Pixel p, double factor) {
        return null;
    }

    @Override
    public Picture paint(int cx, int cy, double radius, Pixel p) {
        return null;
    }

    @Override
    public Picture paint(int cx, int cy, double radius, Pixel p, double factor) {
        return null;
    }
}
