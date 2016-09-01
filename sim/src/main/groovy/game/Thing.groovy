package game

/**
 * Created by kallin on 2015-01-29.
 */
class Thing {

    Position currentPosition
    Position targetPosition
    Position unitVectorToTarget
    float speed // units per millisecond

    void calcSlopeToTarget(){

        float xDelta = targetPosition.x - currentPosition.x
        float yDelta = targetPosition.y - currentPosition.y

        float length = Position.distance(targetPosition, currentPosition)
        unitVectorToTarget = new Position(x: xDelta/length, y: yDelta/length)
    }


}
