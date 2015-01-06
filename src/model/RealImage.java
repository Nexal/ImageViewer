package model;

public class RealImage extends Image{
    
    BitMap bitMap;

    public RealImage(BitMap bitMap) {
        this.bitMap = bitMap;
    }

    @Override
    public BitMap getBitMap() {
        return bitMap;
    }

}
