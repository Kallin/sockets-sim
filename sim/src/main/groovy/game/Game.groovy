package game

class Game {

    public static Thing thing

    void begin() {

        Position currentPosition = new Position(x: 5, y: 5)
        Position targetPositon = new Position(x: 0, y: 0)
        thing = new Thing(currentPosition: currentPosition, targetPosition: targetPositon, speed: 0.001)
        thing.calcSlopeToTarget()

        Random random = new Random()
        long oldTime = System.currentTimeMillis()
        //todo: max time between game logic updates?
        //todo: let's start by logging updates per second
        while (true) {
            long newTime = System.currentTimeMillis()
            long deltaTime = newTime - oldTime
            oldTime = newTime
            float newX = thing.currentPosition.x + (thing.unitVectorToTarget.x * (thing.speed * deltaTime))
            float newY = thing.currentPosition.y + (thing.unitVectorToTarget.y * (thing.speed * deltaTime))

            def newPosition = new Position(x: newX, y: newY)
            thing.currentPosition = newPosition
            if (Position.distance(newPosition, thing.targetPosition) < 0.1) {
                //close enough, pick a new position!
                int newTargetx = random.nextInt(10)
                int newTargety = random.nextInt(10)
                def newTarget = new Position(x: newTargetx, y: newTargety)
                thing.targetPosition = newTarget
                thing.calcSlopeToTarget()
            }

//            println "${thing.currentPosition.x} / ${thing.currentPosition.y}"


        }

    }


}
