package classes;

public class Coordinate {

    public int x;
    public int y;
    private boolean claimedMoreThanOnce, isInfinite, isBoarder, isPuzzleInputCoordinate;
    private Coordinate claimedBy;

    public Coordinate(int x, int y){
        this.x = x;
        this.y = y;
        claimedMoreThanOnce = false;
        isInfinite = false;
        isBoarder  =false;
        isPuzzleInputCoordinate = false;
    }

    public Coordinate(int x, int y, boolean b){
        this.x = x;
        this.y = y;
        claimedMoreThanOnce = false;
        isInfinite = false;
        isBoarder  =false;
        isPuzzleInputCoordinate = b;
    }

    public boolean isBoarder() {
        return isBoarder;
    }

    public void setBoarder() {
        isBoarder = true;
    }

    public void setInfinite() {
        isInfinite = true;
    }

    public boolean isInfinite() {
        return isInfinite;
    }

    public void setClaimedMoreThanOnce(boolean b) {
        claimedMoreThanOnce = b;
    }

    public boolean isClaimedMoreThanOnce() {
        return claimedMoreThanOnce;
    }

    public Coordinate getClaimedBy() {
        return claimedBy;
    }

    public void setClaimedBy(Coordinate claimedBy) {
        this.claimedBy = claimedBy;
    }

    public int distance(Coordinate coordinateB){
        return Math.abs(x - coordinateB.x) + Math.abs(y - coordinateB.y);
    }

    @Override
    public String toString(){
        if(isPuzzleInputCoordinate){
            return "#" + x + "," + y;
        }else if(isBoarder){
            return "##";
        }else if(claimedMoreThanOnce) {
            return ".";
        }else{
            return claimedBy.x + "," + claimedBy.y;
        }

    }
}
