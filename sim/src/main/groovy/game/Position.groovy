package game

/**
 * Created by kallin on 2015-01-29.
 */
class Position {

    float x,y

    static float distance(Position a, Position b){
        float xDelta = b.x - a.x
        float yDelta = b.y - a.y

        Math.sqrt((xDelta * xDelta) + (yDelta * yDelta))
    }
}
