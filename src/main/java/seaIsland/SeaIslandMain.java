package seaIsland;

public class SeaIslandMain {
    public static void main(String[] args) {

        int[][] worldMap = new int[][]{
                {0, 1, 0, 0},
                {1, 1, 1, 0},
                {0, 1, 0, 0},
                {1, 1, 0, 0}
        };

        IslandPerimeter island = new IslandPerimeter(worldMap);
        System.out.println("Island perimeter = " + island.getPerimeter());
    }
}
