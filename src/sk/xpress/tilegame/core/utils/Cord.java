package sk.xpress.tilegame.core.utils;

import sk.xpress.tilegame.core.tiles.Chunk;

public class Cord {

    public static Double getLocationFromChunk(Cord.Int cord) {
        return getLocationFromChunk(cord.getX(), cord.getY());
    }

    public static <x, y> Double getLocationFromChunk(int x, int y) {
        return new Double<x, y>(x * Chunk.CHUNK_SIZE, y * Chunk.CHUNK_SIZE);
    }

    public static Int getChunkFromLocation(Cord.Double cord) {
        return getChunkFromLocation(cord.getX(), cord.getY());
    }

    public static <x, y> Int getChunkFromLocation(double x, double y) {
        return new Int<x, y>( (int) (x / Chunk.CHUNK_SIZE), (int) (y / Chunk.CHUNK_SIZE));
    }

    public static class Float<X, Y> {
        private float X;
        private float Y;

        public Float(float x, float y) {
            X = x;
            Y = y;
        }

        public float getX() {
            return X;
        }

        public void setX(float x) {
            X = x;
        }

        public float getY() {
            return Y;
        }

        public void setY(float y) {
            Y = y;
        }

        @Override
        public String toString() {
            return "Float{" +
                    "X=" + X +
                    ", Y=" + Y +
                    '}';
        }
    }



    public static class Int<X, Y> {
        private int X;
        private int Y;

        public Int(int x, int y) {
            X = x;
            Y = y;
        }

        public Int(Y x, Y y) {
        }

        public int getX() {
            return X;
        }

        public void setX(int x) {
            X = x;
        }

        public int getY() {
            return Y;
        }

        public void setY(int y) {
            Y = y;
        }

        @Override
        public String toString() {
            return "Int{" +
                    "X=" + X +
                    ", Y=" + Y +
                    '}';
        }
    }

    public static class Double<X, Y> {
        private double X;
        private double Y;

        public Double(double x, double y) {
            X = x;
            Y = y;
        }

        public double getX() {
            return X;
        }

        public void setX(double x) {
            X = x;
        }

        public double getY() {
            return Y;
        }

        public void setY(double y) {
            Y = y;
        }

        @Override
        public String toString() {
            return "Double{" +
                    "X=" + X +
                    ", Y=" + Y +
                    '}';
        }
    }

}
