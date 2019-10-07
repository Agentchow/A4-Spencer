package a4;

public class MutablePixelArrayPicture implements Picture {

    private int width;
    private int height;
    private Pixel pixel;
    private Pixel[][] mutablePixelArray;

    // Creates new object using values provided by pixel_array, matching in size.
    public MutablePixelArrayPicture(Pixel[][] pixel_array) {
        if (pixel_array == null) {
            throw new IllegalArgumentException("");
        }
        this.width = pixel_array.length;
        this.height = pixel_array[0].length;
        this.mutablePixelArray = new Pixel[this.width][this.height];
        for (int i = 0; i < pixel_array.length; i++) {
            for (int j = 0; j < pixel_array[i].length; j++) {
                this.mutablePixelArray[i][j] = pixel_array[i][j];
            }
        }
    }

    // Creates new object by providing geometry of picture and an initial value for
    // all pixels.
    public MutablePixelArrayPicture(int width, int height, Pixel initial_value) {
        this.width = width;
        this.height = height;
        for (int i = 0; i < width; i++) {
            for (int j = 0; j < height; j++) {
                this.mutablePixelArray[i][j] = initial_value;
            }
        }
    }
    
 // Creates new object by providing geometry of picture. 
 // Initial value of all pixels should be medium gray (i.e., a grayscale pixel with intensity 0.5)
    public MutablePixelArrayPicture(int width, int height) {
    	this.width=width;
    	this.height=height;
    	Pixel pixel = new GrayPixel(0.5);
    	for (int i=0;i<width; i++) {
            for(int j=0;j<height;j++) {
                this.mutablePixelArray[i][j]=pixel;
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
        if (x<0 || y<0 || pixel == null || x>= this.width || y>= this.width) {
            throw new IllegalArgumentException("");
        }

        return this.mutablePixelArray[x][y];
    }

    @Override
    public Picture paint(int x, int y, Pixel p) {
        Picture picObject = new MutablePixelArrayPicture(x, y, p);
        return picObject;
    }

    @Override
    public Picture paint(int x, int y, Pixel p, double factor) {
        if (x<0 || y<0 || pixel == null || factor<0 || factor>1) {
            throw new IllegalArgumentException("");
        }

        return new MutablePixelArrayPicture(x, y, p.blend(p, factor));
    }

    @Override
    public Picture paint(int ax, int ay, int bx, int by, Pixel p) {
  

        Pixel[][] pixel=new Pixel[ax-bx][ay-by];
        for(int i=ax; i<bx; i++) {
            for(int a=ay; a<by; a++) {
                pixel[i][a]=p;
            }
        }
        return new MutablePixelArrayPicture(pixel);
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
